package model;

public class OrderDetail {
	private String orderDetailID;
	private Order orderID;
	private Book bookID;
	private int quantity;
	private double originalPrice;
	private double discountPrice;
	private double unitPrice;
	private double VAT;
	private double totalPrice;

	public OrderDetail() {
		super();
	}

	public OrderDetail(String orderDetailID, Order orderID, Book bookID, int quantity, double originalPrice,
			double discountPrice, double unitPrice, double vAT, double totalPrice) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.bookID = bookID;
		this.quantity = quantity;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.unitPrice = unitPrice;
		VAT = vAT;
		this.totalPrice = totalPrice;
	}

	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Order getOrderID() {
		return orderID;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}

	public Book getBookID() {
		return bookID;
	}

	public void setBookID(Book bookID) {
		this.bookID = bookID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
