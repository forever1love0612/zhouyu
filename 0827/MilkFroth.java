public class MilkFroth extends CondimentDecorator {
    public MilkFroth(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() +  ", 添加 奶泡 *1  " ;
    }

    @Override
    public double cost() {
        return coffee.cost() + 3;
    }


}