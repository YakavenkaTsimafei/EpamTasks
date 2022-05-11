package by.epam.lab;

public enum MaterialEnum {
    STEEL("steel", 7850), COPPER("copper", 8500);

    private String name;
    private double density;

    MaterialEnum(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return name + ";" + density;
    }
}
