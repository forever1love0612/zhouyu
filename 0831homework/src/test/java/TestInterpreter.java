
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TestInterpreter {

    @Test
    public void testMostSimple(){
        Assert.assertEquals("select * from database where companyName = 'HTSC'",
                Client.generateSql("companyName=='HTSC'"));
    }

    @Test
    public void testSecondSimple(){
        Assert.assertEquals("select * from database where (age < 30) AND (sex != 'Male')",
                Client.generateSql(" (age<30) && (sex!='Male') "));
    }

    @Test
    public void testRelativelySimple(){
        Assert.assertEquals("select * from database where (companyName = 'HTSC') OR ((age < 30) AND (sex != 'Male'))",
                Client.generateSql("(companyName=='HTSC') || ((age<30) && (sex!='Male'))"));
    }

    @Test
    public void testMiddle(){
        Assert.assertEquals("select * from database where (((companyName = 'HTSC') AND (title = 'model')) OR ((age < 30) AND (sex != 'Male'))) AND (home = 'Nanjing')",
                Client.generateSql("(((companyName=='HTSC')&&(title=='model'))||((age<30)&&(sex!='Male')))&&(home=='Nanjing')"));
    }

    @Test
    public void testNotSimple(){
        Assert.assertEquals("select * from database where (!(companyName = 'HTSC')) OR ((!(age < 30)) AND (sex != 'Male'))",
                Client.generateSql("(!(companyName=='HTSC'))||(!(age<30))&&(sex!='Male'))"));
    }

    @Test
    public void testHard(){
        Assert.assertEquals("select * from database where (((!(companyName = 'HTSC')) AND (title = 'model')) OR ((!(age < 30)) AND (sex != 'Male'))) AND (home = 'Nanjing')",
                Client.generateSql("(((!(companyName=='HTSC'))&&(title=='model'))||(!(age<30))&&(sex!='Male')))&&(home=='Nanjing')"));
    }









}
