package com.poliyguus.profound.rest.events;

public class ApiErrorEvent {

    /**
     * The resulting throwable error
     */
    private static Throwable mThrowable;

    /**
     * Constructor
     * @param throwable
     */
    public ApiErrorEvent(Throwable throwable) {
        mThrowable = throwable;
    }

    /**
     * Gets the throwable object resulting from the error
     * @return throwable
     */
    public Throwable getError() {
        return mThrowable;
    }

    /**
     * Gets the error message
     * @return error message
     */
    public String getMessage() {
        return mThrowable.getMessage();
    }

    /**
     * Gets the stack trace object
     * @return stack trace
     */
    public StackTraceElement[] getStackTrace() {
        return mThrowable.getStackTrace();
    }
}
