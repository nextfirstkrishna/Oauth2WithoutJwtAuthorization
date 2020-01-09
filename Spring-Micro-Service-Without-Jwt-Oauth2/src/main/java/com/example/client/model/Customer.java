package com.example.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="firstName")
	private String firstname;
	@Column(name="lastName")
	private String lastname;
	@Column(name="dlNumber")
	private String dlnumber;
	@Column(name="zipNumber")
	private String zipnumber;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDlnumber() {
		return dlnumber;
	}
	public void setDlnumber(String dlnumber) {
		this.dlnumber = dlnumber;
	}
	public String getZipnumber() {
		return zipnumber;
	}
	public void setZipnumber(String zipnumber) {
		this.zipnumber = zipnumber;
	}

}
