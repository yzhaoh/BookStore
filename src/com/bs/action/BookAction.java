package com.bs.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.bs.bean.Appraise;
import com.bs.bean.Book;
import com.bs.bean.BookSales;
import com.bs.service.AppraiseService;
import com.bs.service.BookCategoryService;
import com.bs.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 处理与图书模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class BookAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BookService bookService;
	private AppraiseService appraiseService;
	private BookCategoryService bookCategoryService;
	private List<Book> books;
	private List<Appraise> appraisess;
	private Book book;
	private Map<String, Object> status;

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
	 * 当前第几页
	 */
	private int page;
	/**
	 * 每页多少条记录
	 */
	private int limit;
	/**
	 * 图书总数
	 */
	private int total;
	/**
	 * 图书总页数
	 */
	private int pageCount;

	private int number;
	private File imageFile; // 上传的文件
	private String imageFileFileName; // 文件名称
	private String imageFileContentType; // 文件类型
	/**
	 * 搜索关键字
	 */
	private String keyword;

	private HttpServletRequest request;

	/**
	 * 排序关键字
	 */
	private String orderKeywords;
	/**
	 * 排序方式
	 */
	private String order;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public AppraiseService getAppraiseService() {
		return appraiseService;
	}

	public void setAppraiseService(AppraiseService appraiseService) {
		this.appraiseService = appraiseService;
	}

	public BookCategoryService getBookCategoryService() {
		return bookCategoryService;
	}

	public void setBookCategoryService(BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Appraise> getAppraisess() {
		return appraisess;
	}

	public void setAppraisess(List<Appraise> appraisess) {
		this.appraisess = appraisess;
	}

	public Map<String, Object> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Object> status) {
		this.status = status;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int total, int limit) {
		if (total / limit % limit == 0) {
			this.pageCount = total / limit;
		} else {
			this.pageCount = total / limit + 1;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public String getImageFileFileName() {
		return imageFileFileName;
	}

	public void setImageFileFileName(String imageFileFileName) {
		this.imageFileFileName = imageFileFileName;
	}

	public String getImageFileContentType() {
		return imageFileContentType;
	}

	public void setImageFileContentType(String imageFileContentType) {
		this.imageFileContentType = imageFileContentType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderKeywords() {
		return orderKeywords;
	}

	public void setOrderKeywords(String orderKeywords) {
		this.orderKeywords = orderKeywords;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getAllBook() {
		this.total = bookService.getTotal();
		this.books = bookService.getBooks(-1, page, limit);
		return SUCCESS;
	}

	public String alterBook() {
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setCategoryId(categoryId);
		book.setContentSummary(contentSummary);
		book.setCurrentPrice(currentPrice);
		book.setFixedPrice(fixedPrice);
		book.setISBN(ISBN);
		book.setPublishDate(publishDate);
		book.setPublisher(publisher);
		boolean b = bookService.alter(book);
		this.status = new HashMap<String, Object>();
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String addBook() {
		Book book = new Book();
		BookSales bookSales = new BookSales();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setCategoryId(categoryId);
		book.setContentSummary(contentSummary);
		book.setCurrentPrice(currentPrice);
		book.setFixedPrice(fixedPrice);
		book.setISBN(ISBN);
		book.setPublishDate(publishDate);
		book.setPublisher(publisher);
		bookSales.setNowNumber(number);
		book.setBookSales(bookSales);
		boolean b = bookService.add(book);
		this.status = new HashMap<String, Object>();
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String deleteBook() {
		this.status = new HashMap<String, Object>();
		boolean b = bookService.delete(bookId);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String uploadImage() {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/image");
		if (imageFile != null) {
			File savefile = new File(new File(realpath), imageFileFileName);
			try {
				FileUtils.copyFile(imageFile, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.status = new HashMap<String, Object>();
			boolean b = bookService.alter(bookId, imageFileFileName);
			if (b) {
				status.put("success", true);
			} else {
				status.put("failure", false);
			}
		}
		return SUCCESS;
	}

	public String deleteImage() {
		this.status = new HashMap<String, Object>();
		boolean b = bookService.alter(bookId, "");
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String search() {
		this.total = bookService.getKeyTotal(keyword);
		this.books = bookService.getBooks(keyword, page, limit);
		return SUCCESS;
	}

	public String find() {
		this.book = bookService.get(bookId);
		this.appraisess = appraiseService.getAppraises(bookId, page, limit);
		return SUCCESS;
	}

	public String findCategoryBook() {
		int total = bookCategoryService.getCount(categoryId);
		this.request.setAttribute("total", total);
		this.setPageCount(total, limit);
		this.request.setAttribute("pageCount", this.getPageCount());
		this.request.setAttribute("books",
				bookService.getBooks(categoryId, page, limit));
		return SUCCESS;
	}

	public String sortBySearch() {
		this.books = bookService.getBooks(keyword, orderKeywords, order, page,
				10);
		return SUCCESS;
	}

	public String searchBook() {
		int total = bookService.getKeyTotal(keyword);
		this.request.setAttribute("total", total);
		this.setPageCount(total, limit);
		this.request.setAttribute("pageCount", this.getPageCount());
		this.request.setAttribute("books",
				bookService.getBooks(keyword, page, limit));
		return SUCCESS;
	}

	public String test() {
		return SUCCESS;
	}

}
