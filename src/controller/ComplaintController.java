package controller;

import java.io.IOException;
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

import org.hibernate.sql.Update;

import DAO.ComplaintDAO;
import DAO.MaintenanceDAO;
import DAO.UserDAO;
import VO.ComplaintVO;
import VO.MaintenanceVO;
import VO.UserVO;

/**
 * Servlet implementation class ComplaintController
 */
@WebServlet("/ComplaintController")
public class ComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("search14"))
		{
			searchComplaint(request, response);
		}
		else if(flag.equals("editComplaint"))
		{	
			editComplaint(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteComplaint(request,response);
			searchComplaint(request, response);
		}
	}
		private void deleteComplaint(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			int cid=Integer.parseInt(request.getParameter("complaintID"));
			ComplaintVO v=new ComplaintVO();
			v.setC_id(cid);
			ComplaintDAO d=new ComplaintDAO();
			d.deleteComplaint(v);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
		if(flag.equals("insertComplaint"))
		{
			insertComplaint(request,response);
		}
		if(flag.equals("loadUser"))
		{
			loadUser(request,response);
		}
		else if(flag.equals("update"))
		{
			updateComplaint(request, response);
		}
	}

	private void loadUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		UserDAO d1=new UserDAO();
		HttpSession x=request.getSession();
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_ManageComplaint.jsp");
				
	}
	
	protected void insertComplaint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		
	String ss = request.getParameter("cn");
	String s = request.getParameter("ct");
	String s1 = request.getParameter("cd");
	String s2 = request.getParameter("msg");
	String s3 = request.getParameter("reply");
	String s4 = request.getParameter("email");
	String s5 = request.getParameter("status");
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);

	
	ComplaintVO v=new ComplaintVO(); 
	v.setComplaint_name(ss);
	v.setComplaint_type(s);
	v.setComplaint_date(s1);
	v.setMessage(s2);
	v.setReply(s3);
	v.setEmail(s4);
	v.setStatus(s5);
	v.setUserVO(userVO);
	ComplaintDAO d=new ComplaintDAO();
	
	d.insertComplaint(v);
	response.sendRedirect("Admin/Form_ManageComplaint.jsp");

}
	
protected void searchComplaint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	ComplaintVO v1=new ComplaintVO();
		
	ComplaintDAO d1=new ComplaintDAO();
		List ls=d1.search();
		d1.update(v1);
		HttpSession x = request.getSession();
		x.setAttribute("complaint_list",ls);
		
		List ls2=d1.search();
		int temp1=ls2.size();
		System.out.println("list complaint"+temp1);
		x.setAttribute("complaint", temp1);
		
		
		response.sendRedirect("Admin/Form_SearchComplaint.jsp");
		
	}
protected void editComplaint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int m = Integer.parseInt(request.getParameter("complaintId"));
	
	ComplaintVO v3=new ComplaintVO();
	v3.setC_id(m);
	
	ComplaintDAO d2=new ComplaintDAO();
	List ls=d2.editComplaint(v3);
	
	HttpSession session=request.getSession();
	session.setAttribute("complaint_list", ls);
	
	UserDAO cd=new UserDAO();
	List ls2=cd.search();
	
	session.setAttribute("user_list", ls2);
	
	response.sendRedirect("Admin/Form_EditComplaint.jsp");
}
protected void updateComplaint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

	HttpSession session = request.getSession();
	
	int user = (int) session.getAttribute("userID");
	/*int user = Integer.parseInt(request.getParameter("userID"));*/
	int m = Integer.parseInt(request.getParameter("complaintID"));
	String ss = request.getParameter("cn");
	String s = request.getParameter("ct");
	String s1 = request.getParameter("cd");
	String s2 = request.getParameter("msg");
	String s3 = request.getParameter("reply");
	String e= request.getParameter("email");
	String s5 = request.getParameter("status");
UserVO uv=new UserVO();
uv.setUser_id(user);

ComplaintVO v=new ComplaintVO();
v.setC_id(m);
v.setComplaint_name(ss);
v.setComplaint_date(s1);
v.setComplaint_type(s);
v.setMessage(s2);
v.setReply(s3);
v.setEmail(e);
v.setStatus(s5);
v.setUserVO(uv);

ComplaintDAO d=new ComplaintDAO();

d.updateComplaint(v);

sendMail(e, s3);

searchComplaint(request, response);
}

protected void sendMail(String email,String msg){
	
	java.util.Properties properties = new java.util.Properties();
    properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

    System.out.println("email" +email);
    System.out.println("message" +msg);
    

     try {
        MimeMessage message = new MimeMessage(mailSession);

       
        message.setContent("Complain Solved: "+msg+"","text/html" );
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
        /*System.out.println("err = " + e);*/
    	e.printStackTrace();
     }

}

	}
