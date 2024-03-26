package com.nhom1.bookstore.apis;

public class AccountResponse {
    private String userID;
    private boolean isAdmin;

    public AccountResponse(String userID, boolean isAdmin) {
        this.userID = userID;
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}