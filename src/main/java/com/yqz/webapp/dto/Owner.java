package com.yqz.webapp.dto;

public class Owner {
    private Integer owner_id;

    private String owner_name;

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name == null ? null : owner_name.trim();
    }
}