package com.yqz.webapp.dto;

import java.util.Date;

/**
 * Created by yinqingzhun on 2017/3/3.
 */
public class InnerMessageForChatMessageDetailVO {
    private int id;

    private String type;

    private String content;

    private Date createTime;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    public Date getCreateTime(){
        return this.createTime;
    }
}
