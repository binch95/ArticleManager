package org.koreait.Article.entity;

public class Member{
    private int idNumber;
    private String name;
    private String regDate;
    private String loginId;
    private String loginpw;

    public Member(int idNumber, String regDate, String loginId, String loginPw, String name){
        this.idNumber = idNumber;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginpw = loginPw;
        this.name = name;

    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginpw() {
        return loginpw;
    }

    public void setLoginpw(String loginpw) {
        this.loginpw = loginpw;
    }


}