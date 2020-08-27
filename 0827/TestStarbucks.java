import java.util.Scanner;

// 测试类
public class TestStarbucks {
    public static void main(String args[]) {
        String beverageType;
        System.out.println("请选择饮料品种：1.拿铁 2.摩卡 3.美式");
        Scanner scanner = new Scanner(System.in);
        beverageType = scanner.nextLine();

        String coffeeSpec;

        System.out.println("请选择饮料规格：1.中杯 2.大杯 3.超大杯");
        coffeeSpec = scanner.nextLine();

        String temperature;

        System.out.println("请选择饮料温度：1.冰 2.常温 3.热");
        temperature = scanner.nextLine();


        Coffee coffee;

         if (beverageType.equals("1")) {
             coffee = new Meishi(coffeeSpec);
         }
         else if(beverageType.equals("2")) {
             coffee = new Moka(coffeeSpec);
             }
         else{
             coffee = new Meishi(coffeeSpec);
            }



        System.out.println("请选择需要添加的装饰：1.奶泡 2.饼干粒");
        System.out.println("重复输入数字可叠加,输入 0 退出添加");
        String add = scanner.nextLine();
        while(!add.equals("0")){
            switch(beverageType) {
                case "1":
                    coffee = new MilkFroth(coffee);
                    break;
                case "2":
                    coffee = new Biscuits(coffee);
                    break;
            }
            add = scanner.nextLine();
        }

        if (beverageType.equals("1")) {
            beverageType = "中杯";
        }
        else if(beverageType.equals("2")) {
            beverageType = "大杯";
        }
        else{
            beverageType = "超大杯";
        }

        if (temperature.equals("1")) {
            temperature = "冰";
        }
        else if(temperature.equals("2")) {
            temperature = "常温";
        }
        else{
            temperature = "热";
        }

        System.out.println( "您点了一杯 " + beverageType + coffee.getDescription() + " 温度：" + temperature);
        System.out.println("合计 " +  coffee.cost() + " 元");


    }
}


