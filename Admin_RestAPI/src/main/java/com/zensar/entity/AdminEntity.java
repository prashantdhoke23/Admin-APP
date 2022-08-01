package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class AdminEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String password;
    private String email;
    private long phNumber;

    
    public AdminEntity(int id, String name, String password, String email, long phNumber) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phNumber = phNumber;
	}
    
    

	public AdminEntity() {
		
	}


	public String getName() {
	return name;
    }

    public int getId() {
  		return id;
  	}

  	public void setId(int id) {
  		this.id = id;
  	}

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public long getPhNumber() {
	return phNumber;
    }

    public void setPhNumber(long phNumber) {
	this.phNumber = phNumber;
    }

	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", phNumber=" + phNumber + "]";
	}
    
}
