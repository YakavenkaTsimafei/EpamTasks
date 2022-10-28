package by.epam.lab.exception;

public class NegativeArgumentException extends NonPositiveArgumentException {
    public NegativeArgumentException(String message) {
        super(message);
    }
}
