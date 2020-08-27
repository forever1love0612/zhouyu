public abstract class Coffee {
    String coffeeSpec = "";
    String description = "";
    public String getDescription() {
        return description;
    }

    public String getCoffeeSpec() {
        return coffeeSpec;
    }


    public abstract double cost();
}