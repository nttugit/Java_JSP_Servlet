package model;

public class Customer {
	private String customerID;
	private String username;
	private String password;
	private String fullName;
	private String sex;
	private String dob;
	private String phone;
	private String email;
	private String address;
	private String deliveryAddress;
	private String storeAddress;
	private boolean notificationRegistration;// register for receiving notifications or not

	public Customer() {
		super();
	}

	public Customer(String customerID, String username, String password, String fullName, String sex, String dob,
			String phone, String email, boolean registeredNotification, String address, String deliveryAddress,
			String storeAddress) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.notificationRegistration = registeredNotification;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.storeAddress = storeAddress;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRegisteredNotification() {
		return notificationRegistration;
	}

	public void setRegisteredNotification(boolean registeredNotification) {
		this.notificationRegistration = registeredNotification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

}
