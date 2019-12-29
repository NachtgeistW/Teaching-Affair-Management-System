package com.maike.service;
import com.maike.dao.UserDao;
import com.maike.dao.UserDaoImpl;
import com.maike.model.User;
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * insertUser: 实现注册功能.<br/>
     */
    @Override
    public int insertUser(String userName, String userPwd, String userRePwd,String userIdentity) {
        // TODO Auto-generated method stub
        int k = 0;
        if(userName == "" || userName == null || userPwd == "" || userRePwd == null) {
            return k;
        }
        if(!userPwd.equals(userRePwd)) {
            return k;
        }
        k = userDao.insert(userName,userPwd,userIdentity);
        return k;
    }
    /**
     * judgeLogin:登录判断 .<br/>
     */
    @Override
    public int judgeLogin(String userName, String userPwd) {
        // TODO Auto-generated method stub
        int k = 0;
        if(userName == "" || userName == null || userPwd == ""|| userPwd == null) {
            return k;
        }
        User user = userDao.selectByName(userName);
        if(!userPwd.equals(user.getUserPwd())) {
            k = 0;
        }else {
            switch(user.getUserIdentity()) {
            case "1":k = 1;break;
            case "2" :k = 2;break;
            case "3" :k = 3;break;
           
            }
        }
        return k;
    }
   
}