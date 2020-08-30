public class AndCondition extends MixedCondition {

    public AndCondition(String basicCondition) {
        super(basicCondition);
    }

    @Override
    public String toSql() {
        return " " + "AND" + basicCondition;
    }
}