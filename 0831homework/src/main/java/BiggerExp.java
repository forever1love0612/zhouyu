public class BiggerExp extends    Expression{

    String key;
    Object value;

    public BiggerExp(String key, Object value){
        this.key = key;
        this.value = value;
    }


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
        return "(" + key + " > " + value + ")" ;
    }
}
