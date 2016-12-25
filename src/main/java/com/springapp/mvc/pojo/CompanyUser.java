package com.springapp.mvc.pojo;

public class CompanyUser {
    private Integer id;

    private String companyusername;

    private String companyuserpic;

    private String companyuseraccount;


    private String companyuserpassword;

    private String companyusertel;

    private String companyusermanager;

    private String companyuserlandtel;

    private String companyuseremail;

    private String companylastlogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyusername() {
        return companyusername;
    }

    public void setCompanyusername(String companyusername) {
        this.companyusername = companyusername == null ? null : companyusername.trim();
    }

    public String getCompanyuserpic() {
        return companyuserpic;
    }

    public void setCompanyuserpic(String companyuserpic) {
        this.companyuserpic = companyuserpic == null ? null : companyuserpic.trim();
    }

    public String getCompanyuseraccount() {
        return companyuseraccount;
    }

    public void setCompanyuseraccount(String companyuseraccount) {
        this.companyuseraccount = companyuseraccount == null ? null : companyuseraccount.trim();
    }

    public String getCompanyuserpassword() {
        return companyuserpassword;
    }

    public void setCompanyuserpassword(String companyuserpassword) {
        this.companyuserpassword = companyuserpassword == null ? null : companyuserpassword.trim();
    }

    public String getCompanyusertel() {
        return companyusertel;
    }

    public void setCompanyusertel(String companyusertel) {
        this.companyusertel = companyusertel == null ? null : companyusertel.trim();
    }

    public String getCompanyusermanager() {
        return companyusermanager;
    }

    public void setCompanyusermanager(String companyusermanager) {
        this.companyusermanager = companyusermanager == null ? null : companyusermanager.trim();
    }

    public String getCompanyuserlandtel() {
        return companyuserlandtel;
    }

    public void setCompanyuserlandtel(String companyuserlandtel) {
        this.companyuserlandtel = companyuserlandtel == null ? null : companyuserlandtel.trim();
    }

    public String getCompanyuseremail() {
        return companyuseremail;
    }

    public void setCompanyuseremail(String companyuseremail) {
        this.companyuseremail = companyuseremail == null ? null : companyuseremail.trim();
    }

    public String getCompanylastlogin() {
        return companylastlogin;
    }

    public void setCompanylastlogin(String companylastlogin) {
        this.companylastlogin = companylastlogin == null ? null : companylastlogin.trim();
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "id=" + id +
                ", companyusername='" + companyusername + '\'' +
                ", companyuserpic='" + companyuserpic + '\'' +
                ", companyuseraccount='" + companyuseraccount + '\'' +
                ", companyuserpassword='" + companyuserpassword + '\'' +
                ", companyusertel='" + companyusertel + '\'' +
                ", companyusermanager='" + companyusermanager + '\'' +
                ", companyuserlandtel='" + companyuserlandtel + '\'' +
                ", companyuseremail='" + companyuseremail + '\'' +
                ", companylastlogin='" + companylastlogin + '\'' +
                '}';
    }
}