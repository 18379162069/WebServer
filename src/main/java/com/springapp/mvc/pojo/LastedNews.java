package com.springapp.mvc.pojo;

public class LastedNews {
    private Integer id;

    private String newstype;

    private String newsname;

    private String newscontent;

    private String newspic;

    private Integer companyuserid;

    private String newscheck;

    private String companyname;

    private String companyusertel;

    private String newsdescription;

    private String newscontentcheck;

    public String getNewscontentcheck() {
        return newscontentcheck;
    }

    public void setNewscontentcheck(String newscontentcheck) {
        this.newscontentcheck = newscontentcheck;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }

    public Integer getCompanyuserid() {
        return companyuserid;
    }

    public void setCompanyuserid(Integer companyuserid) {
        this.companyuserid = companyuserid;
    }

    public String getNewscheck() {
        return newscheck;
    }

    public void setNewscheck(String newscheck) {
        this.newscheck = newscheck;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyusertel() {
        return companyusertel;
    }

    public void setCompanyusertel(String companyusertel) {
        this.companyusertel = companyusertel;
    }

    public String getNewsdescription() {
        return newsdescription;
    }

    public void setNewsdescription(String newsdescription) {
        this.newsdescription = newsdescription;
    }

    public String getNewspic() {
        return newspic;
    }

    public void setNewspic(String newspic) {
        this.newspic = newspic;
    }



    @Override
    public String toString() {
        return "LastedNews{" +
                "id=" + id +
                ", newstype='" + newstype + '\'' +
                ", newsname='" + newsname + '\'' +
                ", newscontent='" + newscontent + '\'' +
                ", companyuserid=" + companyuserid +
                ", newscheck='" + newscheck + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companyusertel='" + companyusertel + '\'' +
                ", newsdescription='" + newsdescription + '\'' +
                ", newspic='" + newspic + '\'' +
                '}';
    }
}