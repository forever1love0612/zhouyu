
import java.util.Map;

public class EqualCondition implements Condition {

    String key;

    Object value;

    public EqualCondition(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toSql() {
        return " " + key + " = " + "\'" + value + "\'";
    }

}