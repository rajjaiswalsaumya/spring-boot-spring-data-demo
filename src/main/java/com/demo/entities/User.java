package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by rohitgupta on 3/23/16.
 */

@Entity
public class User {

    @Id
    private Long id;

    @Column
    private String emailId;

    @Column
    private Date deletedAt;

    public User() {
    }

    public User(Long id, String emailId, Date deletedAt) {
        this.id = id;
        this.emailId = emailId;
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailId='" + emailId + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
