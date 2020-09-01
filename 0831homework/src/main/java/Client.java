import com.sun.org.apache.bcel.internal.ExceptionConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Client {

    public static String generateSql(String input) {

        String sqlString = new String();
        sqlString = "select * from database where ";

        input = input.replace("("," ( ");
        input = input.replace(")"," ) ");
        String[] inputStringArray = input.split(" ");

        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<Expression> stack3 = new Stack<Expression>();
        Expression resultExp = null;

        for (int i = 0; i < inputStringArray.length; i++) {
            if (inputStringArray[i].equals("(")) stack1.push(inputStringArray[i]);
            else if (inputStringArray[i].equals(")")) {
                //如果是右括号')' 则一次弹出s1栈顶的运算符，并压入s2 直到遇到左括号位置,然后将这一对括号丢弃
                while (!stack1.empty() && !(stack1. peek().equals("("))) {
                    stack2.push(stack1.pop());
                }
                if(!stack1.empty()) {
                    stack1.pop(); //将 ( 弹出s1栈 消除小括号
                }
            } else stack1.push(inputStringArray[i]);
        }

        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }

        for(int i=0 ; i<stack2.size(); i++){

            if (!(stack2.get(i).equals(""))){
//                System.out.println("1" +stack2.get(i)+"1");
                if(stack2.get(i).contains("==")){
                    Expression equalExpression = new Equal(stack2.get(i).split("==")[0], stack2.get(i).split("==")[1]);
                    stack3.push(equalExpression);
                }else if(stack2.get(i).contains("!=")){
                    Expression notEqualExpression = new NotEqual(stack2.get(i).split("!=")[0], stack2.get(i).split("!=")[1]);
                    stack3.push(notEqualExpression);
                }else if(stack2.get(i).contains("<")){
                    Expression smallerExpression = new SmallerExp(stack2.get(i).split("<")[0], stack2.get(i).split("<")[1]);
                    stack3.push(smallerExpression);
                }else if(stack2.get(i).contains(">")) {
                    Expression biggerExpression = new BiggerExp(stack2.get(i).split(">")[0], stack2.get(i).split(">")[1]);
                    stack3.push(biggerExpression);
                }else if(stack2.get(i).equals("&&") && !stack3.empty() ) {
                    Expression rightExp = stack3.pop();
                    Expression leftExp = stack3.pop();
                    Expression andExp = new And(leftExp, rightExp);
                    stack3.push(andExp);

                }else if(stack2.get(i).equals("||") && !stack3.empty() ) {
                    Expression rightExp = stack3.pop();
                    Expression leftExp = stack3.pop();
                    Expression orExp = new Or(leftExp, rightExp);
                    stack3.push(orExp);

                }else if(stack2.get(i).equals("!") && !stack3.empty()){
                    Expression notExp = stack3.pop();

                    notExp = new Not(notExp);
                    stack3.push(notExp);

                }else{
                    throw new IllegalArgumentException("not valid operator");
                }

            };
        }
        resultExp = stack3.pop();
        String querySql = resultExp.generateSql();
        if (querySql.charAt(0) == '(' ){
            querySql = querySql.substring(1, querySql.length()-1);
        }
        sqlString = sqlString + querySql;
        return sqlString;


    }
}

//        for(int i=0;i<input.length();i++)
//        {
//            char ch = input.charAt(i);
//            if(ch==('(')){
//                charStack.push(ch);
//            }else if (ch==')') {
//                String leftCondition = new String();
//                String rightCondition = new String();
//
//
//
//                Expression leftExpression;
//                Expression rightExpression;
//
//                if(basicConditionString.contains("&&")){
//                    leftCondition = basicConditionString.split("&&")[0];
//                    rightCondition = basicConditionString.split("&&")[1];
//
//                    if(leftCondition.contains("==")){
//                        String key = leftCondition.split("==")[0];
//                        String value = leftCondition.split("==")[1];
//                        leftExpression = new Equal(key, value);
//                    }else{
//                        String key = leftCondition.split("!=")[0];
//                        String value = leftCondition.split("!=")[1];
//                        leftExpression = new NotEqual(key, value);
//                    }
//
//
//                    if(rightCondition.contains("==")){
//                        String key = rightCondition.split("==")[0];
//                        String value = rightCondition.split("==")[1];
//                        rightExpression = new Equal(key, value);
//                    }else{
//                        String key = rightCondition.split("!=")[0];
//                        String value = rightCondition.split("!=")[1];
//                        rightExpression = new NotEqual(key, value);
//                    }
//                    Expression andExp = new And(leftExpression, rightExpression);
//                } else if(basicConditionString.contains("||")){
//                    if(leftCondition.contains("==")){
//                        String key = leftCondition.split("==")[0];
//                        String value = leftCondition.split("==")[1];
//                        leftExpression = new Equal(key, value);
//                    }else{
//                        String key = leftCondition.split("!=")[0];
//                        String value = leftCondition.split("!=")[1];
//                        leftExpression = new NotEqual(key, value);
//                    }
//
//
//                    if(rightCondition.contains("==")){
//                        String key = rightCondition.split("==")[0];
//                        String value = rightCondition.split("==")[1];
//                        rightExpression = new Equal(key, value);
//                    }else{
//                        String key = rightCondition.split("!=")[0];
//                        String value = rightCondition.split("!=")[1];
//                        rightExpression = new NotEqual(key, value);
//                    }
//                    Expression andExp = new And(leftExpression, rightExpression);
//                }
//
//                basicCondition = basicCondition + ch ;
//            }


//        }
//        String addSqlString =
//        sqlString = sqlString + addSqlString;
//
//
//        return sqlString;








//    public Expression generateAST(String simpleExpression) {
//
//            Stack<String> stack = new Stack<>();
//
//            Stack<String> postStack = new Stack<>();
//
//
//
//            List<String> simpleExpressionSplits = Stream.of(simpleExpression.split(" "))
//
//                    .flatMap(exp -> {
//
//                        List<String> brackets = new ArrayList<>();
//
//                        if (Pattern.matches("[(|)]+", exp)) {
//
//                            for (int i = 0; i < exp.length(); i++) {
//
//                                brackets.add(String.valueOf(exp.charAt(i)));
//
//                            }
//
//                        } else {
//
//                            brackets.add(exp);
//
//                        }
//
//                        return brackets.stream();
//
//                    })
//
//                    .collect(Collectors.toList());
//
//
//
//
//
//
//
//            for (int i = 0; i < simpleExpressionSplits.size(); i++) {
//
//                String s = simpleExpressionSplits.get(i);
//
//                if (isOperator(s)) {
//
//                    while (stack.size() != 0) {
//
//                        if (priority(stack.peek()) > priority(s)) {
//
//                            postStack.push(stack.pop());
//
//                        } else {
//
//                            break;
//
//                        }
//
//                    }
//
//                    stack.push(s);
//
//                } else if (isBracket(s)) {
//
//                    if (s.equals("(")) {
//
//                        stack.push(s);
//
//                    } else {
//
//                        while (stack.size() != 0 && !stack.peek().equals("(")) {
//
//                            postStack.push(stack.pop());
//
//                        }
//
//                        if (stack.size() != 0) {
//
//                            stack.pop();
//
//                        }
//
//                    }
//
//                } else {
//
//                    postStack.push(s);
//
//                }
//
//            }
//
//
//
//            while (stack.size() != 0) {
//
//                postStack.push(stack.pop());
//
//            }
//
//
//
//            Stack<Expression> expressions = new Stack<>();
//
//            for (String s : postStack) {
//
//                if (!isOperator(s) && !isBracket(s)) {
//
//                    if (s.equals("null")) {
//
//                        expressions.push(new NullExpression(null));
//
//                    } else {
//
//                        expressions.push(new TermialExpression(s));
//
//                    }
//
//                } else {
//
//                    if (s.equals("!")) {
//
//                        expressions.push(new NotExpression(expressions.pop()));
//
//                    } else {
//
//                        Expression right = expressions.pop();
//
//                        Expression left = expressions.pop();
//
//                        if (s.equals("==")) {
//
//                            if (right instanceof NullExpression) {
//
//                                expressions.push(Restrictions.isNull(left));
//
//                            } else {
//
//                                expressions.push(Restrictions.eq(left, right));
//
//                            }
//
//                        } else if (s.equals("!=")) {
//
//                            if (right instanceof NullExpression) {
//
//                                expressions.push(Restrictions.isNotNull(left));
//
//                            } else {
//
//                                expressions.push(Restrictions.ne(left, right));
//
//                            }
//
//                        } else if (s.equals("&&")) {
//
//                            expressions.push(Restrictions.and(left, right));
//
//                        } else if (s.equals("||")) {
//
//                            expressions.push(Restrictions.or(left, right));
//
//                        } else if (s.equals("<")) {
//
//                            expressions.push(Restrictions.lt(left, right));
//
//                        } else if (s.equals("<=")) {
//
//                            expressions.push(Restrictions.le(left, right));
//
//                        } else if (s.equals(">")) {
//
//                            expressions.push(Restrictions.gt(left, right));
//
//                        } else if (s.equals(">=")) {
//
//                            expressions.push(Restrictions.ge(left, right));
//
//                        } else {
//
//                            throw new RuntimeException("抽象语法树解析失败!");
//
//                        }
//
//                    }
//
//                }
//
//            }
//
//
//
//            if (expressions.size() != 1) {
//
//                throw new RuntimeException("抽象语法树解析失败!");
//
//            }
//
//
//
//            return expressions.peek();
//
//        }



//        private boolean isOperator(String s) {
//
//            return Pattern.matches("(!|==|!=|&&|\\|\\||<|<=|>|>=)", s);
//
//        }
//
//
//
//        private boolean isBracket(String s) {
//
//            return s.equals("(") || s.equals(")");
//
//        }
//
//
//
//        private int priority(String opt) {
//
//            if (opt.equals("!")) {
//
//                return 3;
//
//            }
//
//            if (Pattern.matches("(==|!=|<|<=|>|>=)", opt)) {
//
//                return 2;
//
//            }
//
//            if (Pattern.matches("(&&|\\|\\|)", opt)) {
//
//                return 1;
//
//            }
//
//            return 0;
//
//        }


