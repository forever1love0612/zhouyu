import com.sun.org.apache.xpath.internal.operations.And;

import java.util.Scanner;

// 测试类
public class TestSearch{
    public static void main(String args[]) {
        int addedConditionNum = 0;
        String willContinue = "1" ;
        String sqlCondition = "SELECT * FROM DATABASE WHERE";
        do {
            Scanner scanner = new Scanner(System.in);
            String connection = null;
            MixedCondition relation;

            if(addedConditionNum != 0){
                System.out.println("请选择要添加的查找条件与已有条件之间的关系： 1. and  2. or ");

                connection = scanner.nextLine();





            }


            System.out.println("请选择要添加的查找项：1.company name 2. contact name 3.age 4.city 5.phone ");

            String key = scanner.nextLine();
            if (key.equals("1")) {
                System.out.println("请选择查找逻辑：1.等于 2.不等于 ");
                key = "companyname";
            } else if (key.equals("2")) {
                System.out.println("请选择查找逻辑：1.等于 2.不等于 ");
                key = "contactname";
            } else if (key.equals("3")){
                System.out.println("请选择查找逻辑：1.等于 2.不等于 3.在区间内");
                key = "age";
            }else if (key.equals("4")){
                System.out.println("请选择查找逻辑：1.等于 2.不等于 ");
                key = "city";
            }else {
                System.out.println("请选择查找逻辑：1.等于 2.不等于 3.包含");
                key = "phone";
            }


            String searchLogic;

            searchLogic = scanner.nextLine();
            if (searchLogic.equals("1")) {
                System.out.println("请输入指定的取值(等于)：");
            } else if (searchLogic.equals("2")) {
                System.out.println("请输入指定的取值（不等于）：");
            } else if(key.equals("age") && searchLogic.equals("3")){
                System.out.println("请输入指定的取值区间（返回区间内结果，如输入：20,30，返回开区间结果）：");
            }else {
                System.out.println("请输入包含的数字：");
            }

            String value = scanner.nextLine();

            Condition basicCondition;
            if (searchLogic.equals("1")) {
                basicCondition = new EqualCondition(key, value);
            } else if (searchLogic.equals("2")) {
                basicCondition = new NotEqualCondition(key, value);
            } else if(key.equals("age") && searchLogic.equals("3")){
                basicCondition = new BetweenCondition(key, value);
            }else {
                basicCondition = new ContainCondition(key, value);
            }

            if(connection != null){

                if (connection.equals("1")) {
                    relation = new AndCondition(basicCondition.toSql());
                } else  {
                    relation = new OrCondition(basicCondition.toSql());
                }

                sqlCondition = sqlCondition + relation.toSql();


            } else{
                sqlCondition = sqlCondition + basicCondition.toSql();
            }
            System.out.println("请选择后续操作：1.继续添加筛选条件 2. 获取sql语句");
            willContinue = scanner.nextLine();

            addedConditionNum++;
        }while(willContinue.equals("1"));

        System.out.println("生成的sql语句如下：");
        System.out.println(sqlCondition);




    }
}


