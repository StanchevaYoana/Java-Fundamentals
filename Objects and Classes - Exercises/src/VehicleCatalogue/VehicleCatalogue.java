package VehicleCatalogue;

public class VehicleCatalogue {
    String type;
    String model;
    String colour;
    int horsepower;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public VehicleCatalogue(String type, String model, String colour, int horsepower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format
                ("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d",
                this.type,
                this.model,
                this.colour,
                this.horsepower);
    }
}
