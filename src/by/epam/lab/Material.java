package by.epam.lab;

public enum Material {
    STEEL(7850), COPPER(8500);

    private final double density;

    Material(double density) {

        this.density = density;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return getName() + ";" + density;
    }
}
