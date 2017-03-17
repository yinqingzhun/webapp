package com.yqz.webapp.dto;

import java.util.List;

/**
 * Created by yinqingzhun on 2017/2/28.
 */
public class ChatMessageDetailVO {
    private int senderId;

    private String senderName;

    private String senderAvatar;

    private boolean followed;

    private List<InnerMessageForChatMessageDetailVO> message ;

    public void setSenderId(int senderId){
        this.senderId = senderId;
    }
    public int getSenderId(){
        return this.senderId;
    }
    public void setSenderName(String senderName){
        this.senderName = senderName;
    }
    public String getSenderName(){
        return this.senderName;
    }
    public void setSenderAvatar(String senderAvatar){
        this.senderAvatar = senderAvatar;
    }
    public String getSenderAvatar(){
        return this.senderAvatar;
    }
    public void setFollowed(boolean followed){
        this.followed = followed;
    }
    public boolean getFollowed(){
        return this.followed;
    }
    public void setMessage(List<InnerMessageForChatMessageDetailVO> message){
        this.message = message;
    }
    public List<InnerMessageForChatMessageDetailVO> getMessage(){
        return this.message;
    }


}
