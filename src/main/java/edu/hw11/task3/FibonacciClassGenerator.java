package edu.hw11.task3;

import java.lang.reflect.Modifier;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public class FibonacciClassGenerator {
    private FibonacciClassGenerator() {
    }

    public static Class<?> createClass() {
        ByteCodeAppender fib = new Fib();
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .name("Fibonacci")
            .defineMethod("calculateFibonacci", long.class, Modifier.PUBLIC)
            .withParameter(int.class, "num")
            .intercept(new Implementation.Simple(fib))
            .make()
            .load(FibonacciClassGenerator.class.getClassLoader())
            .getLoaded();
        return dynamicType;
    }

    public static class Fib implements ByteCodeAppender {
        private final Label label;
        int stackSize;
        int localVarsAmount;

        public Fib() {
            this.label = new Label();
            this.stackSize = 7;
            this.localVarsAmount = 3;
        }

        @Override
        public Size apply(MethodVisitor mv, Implementation.@NotNull Context context, @NotNull MethodDescription md) {
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_2);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, label);
            returnValue(mv);
            mv.visitLabel(label);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            subIConst(mv, Opcodes.ICONST_2);
            invoke(mv, md);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            subIConst(mv, Opcodes.ICONST_1);
            invoke(mv, md);
            mv.visitInsn(Opcodes.LADD);
            mv.visitInsn(Opcodes.LRETURN);
            mv.visitMaxs(stackSize, localVarsAmount);
            mv.visitEnd();
            return new ByteCodeAppender.Size(stackSize, localVarsAmount);
        }

        private void returnValue(MethodVisitor mv) {
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.I2L);
            mv.visitInsn(Opcodes.LRETURN);
        }

        private void invoke(MethodVisitor mv, MethodDescription md) {
            mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                md.getDeclaringType().getTypeName(),
                md.getName(),
                md.getDescriptor(),
                false
            );
        }

        private void subIConst(MethodVisitor mv, int opcode) {
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(opcode);
            mv.visitInsn(Opcodes.ISUB);
        }
    }
}
