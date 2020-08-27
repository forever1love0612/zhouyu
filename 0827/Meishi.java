//美式
public class Meishi extends Coffee {
    public Meishi(String spec) {
        this.description = "美式";
        this.coffeeSpec = spec;
    }

    public double cost() {
        if(coffeeSpec.equals("1")){
        return 19 ;}
        else if(coffeeSpec.equals("2")){
        return 23 ;}
        else {
        return 27 ;}
    }
}