package commands.exceptions;

/**
 * Commands throw this exception if their arguments are wrong to stop the execution
 */

public class CommandArgumentException extends RuntimeException {
    private final String message;

    public CommandArgumentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "\033[0;91m" + message + "\033[0m";      // red
    }
}
