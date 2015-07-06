package com.bs.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import javax.imageio.ImageIO;
import com.bs.bean.Appraise;
import com.bs.bean.Book;
import com.bs.bean.BookCategory;
import com.bs.bean.BookCollection;
import com.bs.bean.BookSales;
import com.bs.bean.DeliveryAddress;
import com.bs.bean.Order;
import com.bs.bean.ShoppingCart;
import com.bs.bean.User;
import com.bs.common.Mail;
import com.bs.common.ValidateCode;
import com.bs.service.UserService;
import com.bs.serviceImpl.UserServiceImpl;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 该类做测试使用
 * 
 * @author 若水
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		//testSql();
		//testCode();
		//testMail();
		/*User user=new User();
		user.setUsername("若水");
		testA(user);
		System.out.println(user.getUsername());*/
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		  /*	User user=new User();
	        user.setName("若水");
	        Test.test(user);
	        System.out.println(user.getName());*/
	}
	 public static void test(User user) {  
	      	//user.setName("ruoshui");
		 //User u=user;
		// u.setName("ruoshui");
		 User u=new User();
		 u=user;
		 u.setName("ruoshui");
	  }  
	
	private static void testA(User user){
		user=new User();
		System.out.println(user.getUsername());
		user.setUsername("ruoshui");
		System.out.println(user.getUsername());
	}
	private static void testMail() throws Exception {
	/*	SqlMapClient sqlMapper=sqlInit();
		User user =(User) sqlMapper.queryForObject("user.selectUserByUserId", 1);*/
		User user=new User();
		user.setUsername("若水");
		user.setEmail("723413782@qq.com");
		Mail mail=new Mail();
		boolean b=mail.sendMail(user, "http://www.baidu.com", "http://www.zzuli.edu.cn", 2);
		System.out.println(b);
	}
	/**
	 * 测试验证码
	 * @throws IOException 
	 */
	private static void testCode() throws IOException {
		ValidateCode vc=new ValidateCode();
		System.out.println(vc.getCode());
		System.out.println(vc.getCode());
		BufferedImage image=vc.getImage();
		File file=new File("D:/code.jpg");
		FileOutputStream fos=new FileOutputStream(file);
		ImageIO.write(image, "jpeg", fos);
	}
	/**
	 * 测试数据库操作
	 * @throws Exception
	 */
	private static void testSql() throws Exception {
		SqlMapClient sqlMapper=sqlInit();
		List<DeliveryAddress> list=sqlMapper.queryForList("deliveryAddress.queryAllDeliveryAddress");
		for(DeliveryAddress da : list){
			System.out.println(da.getAddress()+"    "+da.getUser().getUsername()+"    "+da.getUser().getName());
		}
		System.out.println("----------------------------------------------------");
		List<User> list2=sqlMapper.queryForList("user.selectUserByUserId",1);
		for(User user : list2){
			System.out.println(user.getUsername()+"    "+user.getDeliveryAddress().get(0).getAddress());
		}
		System.out.println("----------------------------------------------------");
		List<BookCategory> list3=sqlMapper.queryForList("bookCategory.selectAllCategory");
		for(BookCategory bookCategory : list3){
			System.out.println(bookCategory.getCategoryId()+"    "+bookCategory.getOneCategory()+"     "+bookCategory.getBooks().size()+"    "+bookCategory.getBooks().get(0).getBookName());
		}
		System.out.println("----------------------------------------------------");
		List<Book> list4=sqlMapper.queryForList("book.selectAllBook");
		for(Book book : list4){
			System.out.println(book.getBookId()+"    "+book.getBookName()+"     "+book.getCategory().getOneCategory());
		}
		System.out.println("----------------------------------------------------");
		List<ShoppingCart> list5=sqlMapper.queryForList("shoppingCart.selectAllShoppingCartByUserId",1);
		for(ShoppingCart cart : list5){
			System.out.println(cart.getUser().getUsername()+"    "+cart.getBook().getBookName()+"     "+cart.getNumber());
		}
		System.out.println("----------------------------------------------------");
		List<User> list6=sqlMapper.queryForList("user.selectUserByUserId",1);
		for(User user : list6){
			System.out.println(user.getUsername()+" .....................   "+user.getShoppingCart().get(0).getBook().getBookName()+"          "+user.getShoppingCart().get(0).getUser().getName()+"     "+user.getShoppingCart().get(0).getNumber());
		}
		System.out.println("----------------------------------------------------");
		Book book=(Book) sqlMapper.queryForObject("book.selectBookById",1);
		System.out.println(book.getBookName()+"    "+book.getShoppingCart().get(0).getBookId()+"     "+book.getShoppingCart().get(0).getNumber()+"    "+book.getShoppingCart().get(0).getBook());
		System.out.println("----------------------------------------------------");
		List<BookCollection> list7=sqlMapper.queryForList("bookCollection.selectAllBookCollectionByUserId",1);
		for(BookCollection bc : list7){
			System.out.println(bc.getUserId()+"    "+bc.getBook().getBookName()+"     "+bc.getUser().getUsername());
		}
		System.out.println("----------------------------------------------------");
		User user=(User) sqlMapper.queryForObject("user.selectUserByUserId",1);
		System.out.println(user.getUsername()+"     "+user.getBookCollection().get(0).getBook());
		System.out.println("----------------------------------------------------");
		Book book1=(Book) sqlMapper.queryForObject("book.selectBookById",1);
		System.out.println(book1.getBookName()+"     "+book1.getBookCollection().get(0).getUser());
		System.out.println("----------------------------------------------------");
		Book book2=(Book) sqlMapper.queryForObject("book.selectBookById",1);
		System.out.println(book2.getBookName()+"     "+book2.getBookSales().getNowNumber()+"     "+book2.getBookSales().getSalesTime());
		System.out.println("----------------------------------------------------");
		List<BookSales> list8=sqlMapper.queryForList("bookSales.selectAllBookSales");
		for(BookSales bs : list8){
			System.out.println(bs.getBookId()+"     "+bs.getSoldNumber()+"     "+bs.getBook().getBookName());
		}
		System.out.println("----------------------------------------------------");
		User user1=(User) sqlMapper.queryForObject("user.selectUserByUserId",1);
		System.out.println(user1.getUsername()+"     "+user1.getOrder().get(0).getPaymode());
		System.out.println("----------------------------------------------------");
		List<Order> list9=sqlMapper.queryForList("order.selectAllOrderByUserId",1);
		for(Order ob : list9){
			System.out.println(ob.getOrderId()+"    "+ob.getUser().getUsername()+"   "+ob.getPaymode()+"    "+ob.getBook().get(0).get("number"));
		}
		System.out.println("----------------------------------------------------");
		Book book3=(Book) sqlMapper.queryForObject("book.selectBookById",1);
		System.out.println(book3.getBookName()+"     "+book3.getOrder().get(0).getTotalprice()+"    "+book3.getOrder().get(0).getUser());
		System.out.println("----------------------------------------------------");
		List<Appraise> appraise=sqlMapper.queryForList("appraise.selectAppraiseByOrderId",1);
		for(Appraise app : appraise){
			System.out.println(app.getBook().getBookName()+"    "+app.getAppraiseContent()+"    "+app.getStarLevel());
		}
		System.out.println("----------------------------------------------------");
		User user2=(User) sqlMapper.queryForObject("user.selectUserByUserId",1);
		System.out.println(user2.getUsername()+"    "+user2.getAppraise().get(0).getAppraiseContent());
		System.out.println("----------------------------------------------------");
		Book book4=(Book)sqlMapper.queryForObject("book.selectBookById",1);
		System.out.println(book4.getBookName()+"     "+book4.getAppraise().get(0).getAppraiseContent());
		System.out.println("----------------------------------------------------");
		Order order=(Order)sqlMapper.queryForObject("order.selectOrderByOrderId",1);
		System.out.println(order.getOrderId()+"    "+order.getAppraise().get(0).getAppraiseContent());
		System.out.println("----------------------------------------------------");
		Order order1=(Order)sqlMapper.queryForObject("order.selectOrderByOrderId",1);
		System.out.println(order1.getOrderId()+"    "+order1.getDeliveryAddress().getAddress());
	}
	
	private static SqlMapClient sqlInit() throws Exception{
		Reader reader = Resources.getResourceAsReader("com/bs/test/SqlMapConfig.xml");
		SqlMapClient sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
		return sqlMapper;
	}
}
