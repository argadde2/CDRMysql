package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "callers")
public class Caller implements Serializable{
	private static final long serialVersionUID = -3009157732242241606L;
	
public Timestamp getCalldate() {
		return calldate;
	}

	public void setCalldate(Timestamp calldate) {
		this.calldate = calldate;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

@Id
public int id;
@Column(name = "type")
private String type;

@Column(name = "company")
private String company;

@Column(name = "dnis")
private String dnis;

@Column(name = "ani")
private String ani;

@Column(name = "calldate")
private Timestamp calldate;
@Column(name = "enddate")
private Timestamp enddate;

@Column(name = "duration")
private int duration;

@Column(name = "billsec")
private int billsec;
public String getDnis() {
	return dnis;
}

public void setDnis(String dnis) {
	this.dnis = dnis;
}

public String getAni() {
	return ani;
}

public void setAni(String ani) {
	this.ani = ani;
}



public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public int getBillsec() {
	return billsec;
}

public void setBillsec(int billsec) {
	this.billsec = billsec;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public Caller()
{
	
}

}
