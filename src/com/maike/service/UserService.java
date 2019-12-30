package com.maike.service;

public interface UserService {

    int insertUser(String userName, String userPwd, String userRePwd, String userIdentity);

    int judgeLogin(String userName, String userPwd);

}
