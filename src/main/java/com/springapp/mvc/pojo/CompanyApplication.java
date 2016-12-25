package com.springapp.mvc.pojo;

public class CompanyApplication {
    private Integer id;

    private String companyusername;

    private String applicationreason;

    private String companyuseremail;

    private String companyusertel;

    private String applicationtime;

    public String getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(String applicationtime) {
        this.applicationtime = applicationtime;
    }

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

    public String getApplicationreason() {
        return applicationreason;
    }

    public void setApplicationreason(String applicationreason) {
        this.applicationreason = applicationreason == null ? null : applicationreason.trim();
    }

    public String getCompanyuseremail() {
        return companyuseremail;
    }

    public void setCompanyuseremail(String companyuseremail) {
        this.companyuseremail = companyuseremail == null ? null : companyuseremail.trim();
    }

    public String getCompanyusertel() {
        return companyusertel;
    }

    public void setCompanyusertel(String companyusertel) {
        this.companyusertel = companyusertel == null ? null : companyusertel.trim();
    }
}