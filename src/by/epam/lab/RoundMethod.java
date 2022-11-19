package by.epam.lab;

public enum RoundMethod {
    FLOOR {
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND {
        double roundFunction(double d) {
            return Math.round(d);
        }
    },
    CEIL {
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    };

    abstract double roundFunction(double value);

    private final static int[] TEN_POW = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    public int round(double roundedValue, int d) {
        return (int) roundFunction(roundedValue / TEN_POW[d]) * TEN_POW[d];
    }
}

