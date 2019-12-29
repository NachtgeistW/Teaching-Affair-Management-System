package com.maike.model;

public class User {
    
    
    private String userName;
    
    private String userPwd;
    
    private String userIdentity;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User [ userName=" + userName + ", userPwd=" + userPwd + ",userIdentity=" + userIdentity + "]";
    }

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

}
