
import java.util.Map;

public class ContainCondition implements Condition {

    String key;

    String targetString;



    public ContainCondition(String key, String targetString) {
        this.key = key;
        this.targetString = targetString;
    }

    @Override
    public String toSql() {
        return " " + key + " LIKE " + "\'%" + targetString + "%\'" ;

    }

}