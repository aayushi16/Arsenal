package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



import javax.mail.*;

import java.security.MessageDigest;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.SubcategoryDAO;
import DAO.UserDAO;
import VO.CategoryVO;
import VO.SubCategoryVO;
import VO.UserVO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.println("ffffffffffffff"+flag);
		if(flag.equals("search2"))
		{
			searchUser(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editUser(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteUser(request,response);
			searchUser(request, response);
		}
		else if(flag.equals("validate"))
		{	
			validate(request,response);
		}
	}
	private void validate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		System.out.println("name isss"+name);
		UserVO uv=new UserVO();
		uv.setUser_name(name);
		
		UserDAO ud=new UserDAO();
		List ls=ud.validate(uv);
		PrintWriter pw=response.getWriter();
		System.out.println("mmmmmmmmmmmmmmmmmmm"+ls.size());
		pw.write("<root>");
		if(ls.size()>=1)
		{
			System.out.println("already");
//			pw.write("[{\"flag\":\"false\"}]");
			pw.write("<flag>false</flag>");
			
		}
		else
		{
			System.out.println("no");
			pw.write("<flag>true</flag>");
		}
		pw.write("</root>");
	}
	
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("userID"));
		UserVO v=new UserVO();
		v.setUser_id(uid);
		UserDAO d=new UserDAO();
		d.deleteUser(v);
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertUser"))
		{
			insertUser(request,response);
		}
		else if(flag.equals("update"))
		{
			updateUser(request, response);
		}
		
	}
	
	protected void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String s = request.getParameter("userName");
		String s1 = request.getParameter("Password");
		String e = request.getParameter("email");
		String s2 = request.getParameter("status");
		String s3 = request.getParameter("Post");
		
		UserVO v=new UserVO();
		v.setUser_name(s);
		v.setPassword(s1);
		v.setStatus(s2);
		v.setUser_post(s3);
		v.setEmail(e);
		UserDAO d=new UserDAO();
		
		d.insertUser(v);
		
		sendMail(e, s, s1);
		
		response.sendRedirect("Admin/Form_User.jsp");
	
	}
	
	protected void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserVO v1=new UserVO();
		
		UserDAO d1=new UserDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("user_list",ls);

		response.sendRedirect("Admin/Form_SearchUser.jsp");
		
	}
	protected void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c = Integer.parseInt(request.getParameter("userID"));
		
		UserVO v2=new UserVO(); 
		v2.setUser_id(c);
		
		UserDAO d2=new UserDAO();
		List ls=d2.editUser(v2);
		
		HttpSession session=request.getSession();
		session.setAttribute("user_list", ls);
		
		response.sendRedirect("Admin/Form_EditUser.jsp");
	}

	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		int c = Integer.parseInt(request.getParameter("userID"));
	String s = request.getParameter("userName");
	String s1 = request.getParameter("Password");
	String e = request.getParameter("email");
	String s2 = request.getParameter("status");
	String s3 = request.getParameter("Post");
	
	UserVO v=new UserVO();
	v.setUser_id(c);
	v.setUser_name(s);
	v.setPassword(s1);
	v.setEmail(e);
	v.setStatus(s2);
	v.setUser_post(s3);
	UserDAO d=new UserDAO();
	
	d.updateUser(v);
	sendMail(e,s,s1);
	
	searchUser(request, response);

}
	
	protected void sendMail(String email,String usr,String pwd){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

        
        
 
         try {
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("your username is "+usr+" your password is "+pwd+"","text/html" );
            message.setSubject("Hii");
            
            InternetAddress sender = new InternetAddress("110120116059@git.org.in", "Administrator");
             InternetAddress receiver = new InternetAddress(email);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO, receiver);
             message.saveChanges();
            
            javax.mail.Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, "110120116059@git.org.in", "brf@8860");
             transport.sendMessage(message, message.getAllRecipients());
            transport.close();
                      
        } catch (Exception e) {
            System.out.println("err = " + e);
         }

}}