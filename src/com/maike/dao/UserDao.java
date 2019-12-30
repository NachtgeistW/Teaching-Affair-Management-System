package com.maike.dao;

import com.maike.model.User;

public interface UserDao {
    //
    int insert(String userName, String userPwd, String userIdentity);

    User selectByName(String userName);

}
