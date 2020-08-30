
public class OrCondition extends MixedCondition {

    public OrCondition(String basicCondition) {
        super(basicCondition);
    }

    @Override
    public String toSql() {
        return " " + "OR" + basicCondition;
    }
}