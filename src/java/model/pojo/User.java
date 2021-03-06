package model.pojo;
// Generated 19.04.2018 15:05:11 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer idUser;
     private int role;
     private String login;
     private String password;
     private String EMail;
     private String regDate;
     private Set reports = new HashSet(0);
     private Set requestFerts = new HashSet(0);
     private Profile profile;
     private Set requestTrees = new HashSet(0);
     private Set jobs = new HashSet(0);

    public User() {
    }

	
    public User(int role, String login, String password, String EMail, String regDate) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.EMail = EMail;
        this.regDate = regDate;
    }
    public User(int role, String login, String password, String EMail, String regDate, Set reports, Set requestFerts, Profile profile, Set requestTrees, Set jobs) {
       this.role = role;
       this.login = login;
       this.password = password;
       this.EMail = EMail;
       this.regDate = regDate;
       this.reports = reports;
       this.requestFerts = requestFerts;
       this.profile = profile;
       this.requestTrees = requestTrees;
       this.jobs = jobs;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEMail() {
        return this.EMail;
    }
    
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    public String getRegDate() {
        return this.regDate;
    }
    
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    public Set getReports() {
        return this.reports;
    }
    
    public void setReports(Set reports) {
        this.reports = reports;
    }
    public Set getRequestFerts() {
        return this.requestFerts;
    }
    
    public void setRequestFerts(Set requestFerts) {
        this.requestFerts = requestFerts;
    }
    public Profile getProfile() {
        return this.profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Set getRequestTrees() {
        return this.requestTrees;
    }
    
    public void setRequestTrees(Set requestTrees) {
        this.requestTrees = requestTrees;
    }
    public Set getJobs() {
        return this.jobs;
    }
    
    public void setJobs(Set jobs) {
        this.jobs = jobs;
    }




}


