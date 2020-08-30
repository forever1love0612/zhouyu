
import java.util.ArrayList;
import java.util.List;

/**
 * 复合判断
 * */
public abstract class MixedCondition implements Condition {

    protected String basicCondition;

    public MixedCondition(String basicCondition) {
        this.basicCondition = basicCondition;
    }



}