package models;

import java.util.Date;

/*
 * The models package is the data structure that we will be passing around our application
 * */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fistname;
    private String lastname;
    private Date dateCreated;

    public User(Integer id) {
    }

    public User(String username, String password, String fistname, String lastname) {
        this.username = username;
        this.password = password;
        this.fistname = fistname;
        this.lastname = lastname;
        this.id = null;
        this.dateCreated = null;
    }

    public User(Integer id, String username, String password, String fistname, String lastname, Date dateCreated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fistname = fistname;
        this.lastname = lastname;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fistname='" + fistname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}