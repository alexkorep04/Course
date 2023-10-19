package edu.hw2.forth;

public class CallingInfoTools {
    private CallingInfoTools() {
    }

    public static CallingInfo callingInfo() {
        var callerInfo = new Throwable().getStackTrace()[1];
        return new CallingInfo(callerInfo.getClassName(), callerInfo.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
