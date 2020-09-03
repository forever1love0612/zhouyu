import com.htsc.dao.IUserDao;
import com.htsc.domain.AccountUser;
import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoCrudTests {
    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
        userDao = session.getMapper(IUserDao.class);
    }



    @Test
    public void testFindOne()
    { //
        // 6.执行操作
        User user = userDao.findById(41);
        System.out.println(user);
        assert user.getUserName().equals("张三"); }


    @Test
    public void testFindAll() { //
        // 6.执行操作
        List<User> users = userDao.findAll();
        for(User user:users){

            System.out.println(user.toString());
        }


    }
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("华泰");
        user.setUserAddress("南京市建邺区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        // 1.执行保存方法
        int id = userDao.saveUser(user);
        // 2. 验证保存结果
        User savedUser = userDao.findById(user.getUserId());
        assert user.getUserName().equals("华泰");
        Assert.assertEquals("华泰", savedUser.getUserName());

    }

    @Test
    public void testUpdateUser() {

        int id = 41;
        //1.根据id查询
        User user = userDao.findById(id);
        //2.更新操作
        user.setUserAddress("北京市顺义区");
        int res = userDao.updateUser(user);
        // 3. 验证保存结果
        User savedUser = userDao.findById(user.getUserId());
        assert savedUser.getUserAddress().equals("北京市顺义区");

        System.out.println(user.getRefAddress());
        System.out.println(savedUser.getRefAddress());
    }
    @Test
    public void testDeleteUser() {
        // 1.执行操作
        int res = userDao.deleteUser(58);
        assert res == 1;
    }

    @Test
    public void testFindByName() {
        // 1.执行查询一个方法
        List<User> users = userDao.findByName("%王%");
        assert users.size() == 2;
        for(User user : users) { System.out.println(user); }
    }

    @Test
    public void testCount() {
        int res = userDao.count();
        System.out.println(res);
    }
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        vo.setUsername("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.findByVo(vo);
        Assert.assertEquals(1, users.size());
        System.out.println(users);


        session.rollback();
    }

    @Test public void testQueryByVo() {
        QueryVo vo = new QueryVo();
        vo.setUsername("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.findByVo(vo);
        System.out.println(users);
        assert users.size() == 1;
    }

    @Test public void testQueryByVo_withoutAddress() {
        QueryVo vo = new QueryVo();
        vo.setUsername("%王%");
        vo.setAddress(null);
        List<User> users = userDao.findByVo(vo);
        assert users.size() == 2;

    }


    @Test public void testFindInIds() {
        QueryVoIds voIds = new QueryVoIds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41); ids.add(42); ids.add(45); ids.add(46);
        voIds.setIds(ids);
        List<User> users = userDao.findInIds(voIds);
        assert users.size() == 4;
    }


        @After
    public void tearDown() throws IOException {
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }




}
