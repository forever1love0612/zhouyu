public class NotEqual extends Expression  {

    String key;

    Object value;

    public NotEqual(String key, Object value) {
        this.key = key;
        this.value = value;
    }

//    @Override
//    public String toSql() {
//        return " " + key + " != " + "\'" + value + "\'" ;
//    }



    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return null;
    }

    public String generateSql() {
        return "(" + key + " != " + value + ")" ;
    }
}