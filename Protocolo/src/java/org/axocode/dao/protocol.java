package org.axocode.dao;
public class protocol {
    private int IUserNum;
    private String IUser;
    private String IPass;
    
    public protocol() {}
    public protocol( String IUser, String IPass) {
        this.IUser = IUser;
        this.IPass = IPass;
        
    }
    
    public String getIPass() {
        return IPass;
    }

    public void setIPass(String IPass) {
        this.IPass = IPass;
    }

    public int getIUserNum() {
        return IUserNum;
    }

    public void setIUserNum(int IUserNum) {
        this.IUserNum = IUserNum;
    }

    public String getIUser() {
        return IUser;
    }

    public void setIUser(String IUser) {
        this.IUser = IUser;
    }

    
}
