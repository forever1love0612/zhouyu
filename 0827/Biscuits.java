public class Biscuits extends CondimentDecorator {
    public Biscuits(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() +  ", 添加 饼干粒 *1  " ;
    }

    @Override
    public double cost() {
        return coffee.cost() + 2;
    }


}