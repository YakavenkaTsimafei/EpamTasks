package by.epam.lab.exception;

import by.epam.lab.Constants;

public class CsvLineException extends Exception {
    private final String csvLine;
    private final Exception exception;

    public CsvLineException(String csvLine, Exception exception) {
        this.csvLine = csvLine;
        this.exception = exception;
    }

    public String getMessage() {
        return csvLine + Constants.SEPARATOR + exception.getMessage();
    }
}
