package com.jobPortal.lib;

import java.time.LocalDate;

public class JobSeeker implements Comparable<JobSeeker> {
	private static Integer START = 100;
	
	private Integer registrationId;
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private Long aadharId;
	private Long phoneNumber;
	private LocalDate graduationDate;
	private Degree degree;
	
	public JobSeeker() {
		super();
		this.registrationId = START++;
	}

	public JobSeeker(String name, String email, String password, LocalDate dateOfBirth,
			Long aadharId, Long phoneNumber, LocalDate graduationDate, Degree degree) {
		
		this.registrationId = START++;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.aadharId = aadharId;
		this.phoneNumber = phoneNumber;
		this.graduationDate = graduationDate;
		this.degree = degree;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getAadharId() {
		return aadharId;
	}

	public void setAadharId(Long aadharId) {
		this.aadharId = aadharId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) return false;
		if (this.getClass() != o.getClass()) return false;
		if (o == this) return true;
		
		if (!this.registrationId.equals(((JobSeeker)o).registrationId) &&
				!this.email.equals(((JobSeeker)o).email)) return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 31 * this.registrationId  * this.email.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return "JobSeeker:"
				+ "[registrationId=" + registrationId + ", name=" + name + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", aadharId=" + aadharId + ", phoneNumber=" + phoneNumber + ", graduationDate="
				+ graduationDate + ", degree=" + degree + "]\n";
	}

	@Override
	public int compareTo(JobSeeker o) {
		return this.registrationId.compareTo(o.registrationId);
	}
	
}
