package com.bs.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 图书模型，对应图书表的实体类
 * 
 * @author 若水
 *
 */
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 类别编号
	 */
	private int categoryId;
	/**
	 * 书名
	 */
	private String bookName;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 出版社
	 */
	private String publisher;
	/**
	 * 出版日期
	 */
	private Date publishDate;
	/**
	 * ISBN号
	 */
	private String ISBN;
	/**
	 * 定价
	 */
	private float fixedPrice;
	/**
	 * 现价
	 */
	private float currentPrice;
	/**
	 * 内容简介
	 */
	private String contentSummary;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 图书类别
	 */
	private BookCategory category;
	/**
	 * 购物车列表
	 */
	private List<ShoppingCart> shoppingCart;
	/**
	 * 图书收藏列表
	 */
	private List<BookCollection> bookCollection;
	/**
	 * 图书销售信息
	 */
	private BookSales bookSales;
	/**
	 * 该图书的订单信息
	 */
	private List<Order> order;
	/**
	 * 该图书的评价信息
	 */
	private List<Appraise> appraise;
	/**
	 * 购买数量
	 */
	private int number;

	public Book() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public float getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(float fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getContentSummary() {
		return contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 获得该图书的收藏人数
	 * 
	 */
	public int getCollectionNumber() {
		return this.bookCollection.size();
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public List<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<BookCollection> getBookCollection() {
		return bookCollection;
	}

	public void setBookCollection(List<BookCollection> bookCollection) {
		this.bookCollection = bookCollection;
	}

	public BookSales getBookSales() {
		return bookSales;
	}

	public void setBookSales(BookSales bookSales) {
		this.bookSales = bookSales;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<Appraise> getAppraise() {
		return appraise;
	}

	public void setAppraise(List<Appraise> appraise) {
		this.appraise = appraise;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + this.bookId + ", bookName=" + this.bookName
				+ ", author=" + this.author + ", categoryId=" + this.categoryId
				+ ", contentSummary=" + this.contentSummary + ", currentPrice="
				+ this.currentPrice + ", fixedPrice=" + this.fixedPrice
				+ ", image=" + this.image + ", ISBN=" + this.ISBN
				+ ", publisher=" + this.publisher + "appraise=" + this.appraise
				+ "bookCollection=" + this.bookCollection + ",bookSales="
				+ this.bookSales + ",category=" + this.category + "order="
				+ this.order + ",publishDate=" + this.publishDate
				+ ",shoppingCart=" + this.shoppingCart + "]";
	}
}
