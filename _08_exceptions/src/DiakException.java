public class DiakException extends Exception{
    public DiakException() {
    }

    public DiakException(String message) {
        super(message);
    }

    public DiakException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiakException(Throwable cause) {
        super(cause);
    }

    public DiakException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
