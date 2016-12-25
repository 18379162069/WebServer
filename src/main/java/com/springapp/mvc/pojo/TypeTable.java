package com.springapp.mvc.pojo;

public class TypeTable {
    private Integer id;

    private Integer type1id;

    private String type1name;

    private Integer type2id;

    private String type2name;

    private Integer type3id;

    private String type3name;

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

    public String getType1name() {
        return type1name;
    }

    public void setType1name(String type1name) {
        this.type1name = type1name == null ? null : type1name.trim();
    }

    public Integer getType2id() {
        return type2id;
    }

    public void setType2id(Integer type2id) {
        this.type2id = type2id;
    }

    public String getType2name() {
        return type2name;
    }

    public void setType2name(String type2name) {
        this.type2name = type2name == null ? null : type2name.trim();
    }

    public Integer getType3id() {
        return type3id;
    }

    public void setType3id(Integer type3id) {
        this.type3id = type3id;
    }

    public String getType3name() {
        return type3name;
    }

    public void setType3name(String type3name) {
        this.type3name = type3name == null ? null : type3name.trim();
    }
}