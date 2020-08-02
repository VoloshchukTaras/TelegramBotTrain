package com.friend.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Friend")
public class Friend {

    public Friend(){

    }

    @Id
    @Column
    private  Integer id;
    @Column
    private String InMessage;
    @Column
    private String OutMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInMessage() {
        return InMessage;
    }

    public void setInMessage(String inMessage) {
        InMessage = inMessage;
    }

    public String getOutMessage() {
        return OutMessage;
    }

    public void setOutMessage(String outMessage) {
        OutMessage = outMessage;
    }
}
