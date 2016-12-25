package com.springapp.mvc.pojo;

public class Service {
    private Integer id;

    private Integer type1id;

    private Integer type2id;

    private Integer type3id;

    private String servicename;

    private String servicepic;

    private Integer companyuserid;

    private String servicedescription;

    private String servicemanage;

    private String servicecheck;
    private String servicemanagetel;

    public String getServicepic() {
        return servicepic;
    }

    public void setServicepic(String servicepic) {
        this.servicepic = servicepic;
    }



    public String getServicemanagetel() {
        return servicemanagetel;
    }

    public void setServicemanagetel(String servicemanagetel) {
        this.servicemanagetel = servicemanagetel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType1id() {
        return type1id;
    }

    public void setType1id(Integer type1id) {
        this.type1id = type1id;
    }

    public Integer getType2id() {
        return type2id;
    }

    public void setType2id(Integer type2id) {
        this.type2id = type2id;
    }

    public Integer getType3id() {
        return type3id;
    }

    public void setType3id(Integer type3id) {
        this.type3id = type3id;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }

    public Integer getCompanyuserid() {
        return companyuserid;
    }

    public void setCompanyuserid(Integer companyuserid) {
        this.companyuserid = companyuserid;
    }

    public String getServicedescription() {
        return servicedescription;
    }

    public void setServicedescription(String servicedescription) {
        this.servicedescription = servicedescription == null ? null : servicedescription.trim();
    }

    public String getServicemanage() {
        return servicemanage;
    }

    public void setServicemanage(String servicemanage) {
        this.servicemanage = servicemanage == null ? null : servicemanage.trim();
    }

    public String getServicecheck() {
        return servicecheck;
    }

    public void setServicecheck(String servicecheck) {
        this.servicecheck = servicecheck == null ? null : servicecheck.trim();
    }
}