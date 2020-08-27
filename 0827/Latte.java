//拿铁
public class Latte extends Coffee {
    public Latte(String spec) {
        this.description = "拿铁";
        this.coffeeSpec = spec;
    }

    public double cost() {
        if(coffeeSpec.equals("1")){
            return 23 ;}
        else if(coffeeSpec.equals("2")){
            return 27 ;}
        else {
            return 31 ;}
    }
}