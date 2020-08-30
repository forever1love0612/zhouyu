
import java.util.Map;

public class BetweenCondition implements Condition {

    String key;

    String minTomax;



    public BetweenCondition(String key, String minTomax) {
        this.key = key;
        this.minTomax = minTomax;
    }

    @Override
    public String toSql() {
        return " " + key + " > " + minTomax.split(",")[0] + " AND " + key + " < " + minTomax.split(",")[1] ;
    }

}