package com.codingdojo.loginreg.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2,max=255)
	private String first;
	@Size(min=2,max=255)	
	private String last;
	@Email()
	@NotNull()
	private String email;
	private Date createdAt;
	private Date updatedAt;
	@PrePersist
	public void OnCreate(){createdAt = new Date();}
	@PreUpdate
	public void OnUpdate(){updatedAt = new Date();}
	
	@Size(min=8,max=64)
	private String password;
	@Transient
	@Size(min=8,max=64)
	private String confirm;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getFirst() {return first;}
	public void setFirst(String first){this.first = first;}
	public String getLast() {return last;}
	public void setLast(String last) {this.last = last;}
	public String getEmail(){return email;}
	public void setEmail(String email){this.email = email;}
	public Date getCreatedAt(){return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	public Date getUpdatedAt() {return updatedAt;}
	public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getConfirm() {return confirm;}
	public void setConfirm(String confirm) {this.confirm = confirm;}
	public User(){}
}
