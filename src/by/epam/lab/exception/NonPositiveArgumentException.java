package by.epam.lab.exception;

public class NonPositiveArgumentException extends IllegalArgumentException {
    public NonPositiveArgumentException(String message) {
        super(message);
    }
}
