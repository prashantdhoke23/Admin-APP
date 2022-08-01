package com.zensar.dto;

public class AdminDTO {
	private int id;
	private String name;
    private String password;
    private String email;
    private long phNumber;

    
    public int getId() {
  		return id;
  	}

  	public void setId(int id) {
  		this.id = id;
  	}
  	
    public String getName() {
	return name;
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
		return "AdminDTO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phNumber="
				+ phNumber + "]";
	}

    
	public AdminDTO(int id, String name, String password, String email, long phNumber) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phNumber = phNumber;
	}

	
	public AdminDTO() {
	}

	@Override
    public boolean equals(Object obj) {
        AdminDTO adminDto = (AdminDTO) obj;
        if (this.name.equals(adminDto.getName()))
            return true;
        return false;
    }
}
