package com.springapp.mvc.pojo;

public class User {
    private Integer id;

    private Integer userrank;

    private String userimage;

    private String username;

    private String userpassword;

    private String useremail;

    private String userlastlogin;

    private String usertel;

    private String userlandtel;

    private String userjob;

    private String usercompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserrank() {
        return userrank;
    }

    public void setUserrank(Integer userrank) {
        this.userrank = userrank;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage == null ? null : userimage.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserlastlogin() {
        return userlastlogin;
    }

    public void setUserlastlogin(String userlastlogin) {
        this.userlastlogin = userlastlogin == null ? null : userlastlogin.trim();
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel == null ? null : usertel.trim();
    }

    public String getUserlandtel() {
        return userlandtel;
    }

    public void setUserlandtel(String userlandtel) {
        this.userlandtel = userlandtel == null ? null : userlandtel.trim();
    }

    public String getUserjob() {
        return userjob;
    }

    public void setUserjob(String userjob) {
        this.userjob = userjob == null ? null : userjob.trim();
    }

    public String getUsercompany() {
        return usercompany;
    }

    public void setUsercompany(String usercompany) {
        this.usercompany = usercompany == null ? null : usercompany.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userrank=" + userrank +
                ", userimage='" + userimage + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userlastlogin='" + userlastlogin + '\'' +
                ", usertel='" + usertel + '\'' +
                ", userlandtel='" + userlandtel + '\'' +
                ", userjob='" + userjob + '\'' +
                ", usercompany='" + usercompany + '\'' +
                '}';
    }
}