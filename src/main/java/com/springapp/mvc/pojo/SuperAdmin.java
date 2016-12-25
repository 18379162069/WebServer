package com.springapp.mvc.pojo;

public class SuperAdmin {
    private Integer id;

    private String superadminaccount;

    private String superadminpassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperadminaccount() {
        return superadminaccount;
    }

    public void setSuperadminaccount(String superadminaccount) {
        this.superadminaccount = superadminaccount == null ? null : superadminaccount.trim();
    }

    public String getSuperadminpassword() {
        return superadminpassword;
    }

    public void setSuperadminpassword(String superadminpassword) {
        this.superadminpassword = superadminpassword == null ? null : superadminpassword.trim();
    }
}