package model;

import java.sql.Date;

public class Order {
	private String orderID;
	private Customer customer;
	private String customerAddress;
	private String pickupAddress;
	private String status; // enum here
	private String paymentMethod; // enum here
	private String paymentStatus; // enum here
	private String paidMoney;
	private String unpaidMoney;
	private Date orderDate;
	private Date pickupDate;

	public Order() {
		super();
	}

	public Order(String orderID, Customer customer, String customerAddress, String pickupAddress, String status,
			String paymentMethod, String paymentStatus, String paidMoney, String unpaidMoney, Date orderDate,
			Date pickupDate) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.customerAddress = customerAddress;
		this.pickupAddress = pickupAddress;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.paidMoney = paidMoney;
		this.unpaidMoney = unpaidMoney;
		this.orderDate = orderDate;
		this.pickupDate = pickupDate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}

	public String getUnpaidMoney() {
		return unpaidMoney;
	}

	public void setUnpaidMoney(String unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

}
