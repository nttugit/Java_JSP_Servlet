package model;

import java.sql.Date;

public class Author{
	private String authorID;
	private String fullName;
	private Date dob;
	private String bio;
	
	
	
	public Author() {
		super();
	}
	
	
	
	public Author(String authorID, String fullName, Date dob, String bio) {
		super();
		this.authorID = authorID;
		this.fullName = fullName;
		this.dob = dob;
		this.bio = bio;
	}



	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}