package com.shopcart.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 6961651686084482288L;
	private String userName;
	private String password;
	private String fullName;
	private LocalDate date;

	public User(String userName, String password, String fullName) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.date = LocalDate.now();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userName, other.userName);
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", date=" + date
				+ "]";
	}
	
}
