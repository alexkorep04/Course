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

    private static class Fib implements ByteCodeAppender {

        @Override
        @SuppressWarnings("MagicNumber")
        public Size apply(MethodVisitor mv, Implementation.@NotNull Context context, @NotNull MethodDescription md) {
            Label label = new Label();
            int stackSize = 5;
            int localVarsAmount = 2;
            mv.visitCode();

            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_2);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, label);

            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.I2L);
            mv.visitInsn(Opcodes.LRETURN);

            mv.visitLabel(label);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitInsn(Opcodes.ISUB);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                md.getDeclaringType().getTypeName(),
                md.getName(),
                md.getDescriptor(),
                false
            );
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitInsn(Opcodes.ICONST_2);
            mv.visitInsn(Opcodes.ISUB);
            mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                md.getDeclaringType().getTypeName(),
                md.getName(),
                md.getDescriptor(),
                false
            );
            mv.visitInsn(Opcodes.LADD);
            mv.visitInsn(Opcodes.LRETURN);
            mv.visitEnd();
            return new ByteCodeAppender.Size(stackSize, localVarsAmount);
        }
    }
}
