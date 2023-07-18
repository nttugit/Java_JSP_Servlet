package model;

public class Customer {
	private String customerID;
	private String username;
	private String password;
	private String fullName;
	private int sex; // 1: Nam, 0: Nữ, 2: Khác
	private String dob;
	private String phone;
	private String email;
	private String address;
//	private String deliveryAddress;
//	private String storeAddress;
	private boolean notificationRegistration;// register for receiving notifications or not
	
	// được bổ sung sau
	private String avatar;
	public Customer() {
		super();
	}

	public Customer(String customerID, String username, String password, String fullName, int sex, String dob,
			String phone, String email,  String address, boolean registeredNotification) {
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
//		this.deliveryAddress = deliveryAddress;
//		this.storeAddress = storeAddress;
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", password=" + password
				+ ", fullName=" + fullName + ", sex=" + sex + ", dob=" + dob + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", notificationRegistration=" + notificationRegistration + "]";
	}

//	public String getDeliveryAddress() {
//		return deliveryAddress;
//	}
//
//	public void setDeliveryAddress(String deliveryAddress) {
//		this.deliveryAddress = deliveryAddress;
//	}
//
//	public String getStoreAddress() {
//		return storeAddress;
//	}
//
//	public void setStoreAddress(String storeAddress) {
//		this.storeAddress = storeAddress;
//	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
}
