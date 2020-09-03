import com.htsc.dao.IRoleDao;
import com.htsc.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTests {
    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void setUp() throws Exception {
        // 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象
        factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        session = factory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }
    @Test
    public void testFindAll() { 
        List<Role> roles = roleDao.findAll();
        Assert.assertEquals(3, roles.size());
        for(Role role : roles){ 
            System.out.println("---每个角色的信息----");
            System.out.println(role);
            }
    }


    @After
    public void tearDown() throws IOException {
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }




}
