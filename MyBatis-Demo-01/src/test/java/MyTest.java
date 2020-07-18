import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import com.feng.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public  void  testgetUserList()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        //方法一
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //方法二
        List<User> userList1=sqlSession.selectList("com.feng.mapper.UserMapper.getUserList");
        for (User user : userList1) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public  void  testgetUserById()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserListById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public  void  testgetUserByMP()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> stringObjectMap = new HashMap<String, Object>();
        stringObjectMap.put("name","张三");
        stringObjectMap.put("pwd","abcdef");
        List<User> userList = userMapper.getUserListByMap(stringObjectMap);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public  void  testgetUserByNP()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserListByNP("王五","123456");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public  void  testinsertUser()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(7, "赵四", "123456");
        int i = userMapper.addUser(user1);
            System.out.println(i);
            sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void  testupdateUser()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(5, "赵四1", "123456");
        int i = userMapper.updateUser(user1);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void  testdeleteUser()
    {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(5);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
