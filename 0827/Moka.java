//摩卡
public class Moka extends Coffee {
    public Moka(String spec) {
        this.description = "摩卡";
        this.coffeeSpec = spec;
    }

    public double cost() {
        if(coffeeSpec.equals("1")){
            return 21 ;}
        else if(coffeeSpec.equals("2")){
            return 25 ;}
        else {
            return 29 ;}
    }
}