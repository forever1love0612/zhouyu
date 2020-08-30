
import java.util.Map;

public class NotEqualCondition implements Condition {

    String key;

    Object value;

    public NotEqualCondition(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toSql() {
        return " " + key + " != " + "\'" + value + "\'" ;
    }

}