package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.GunDAO;
import DAO.SubcategoryDAO;
import DAO.UserDAO;
import DAO.UserDetailsDAO;
import VO.CategoryVO;
import VO.GunVO;
import VO.SubCategoryVO;
import VO.UserDetailsVO;
import VO.UserVO;

/**
 * Servlet implementation class UserDetailsController
 */
@WebServlet("/UserDetailsController")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsController() {
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
		
		if(flag.equals("search3"))
		{
			searchUserDetails(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editUserDetails(request,response);
		}
	else if(flag.equals("delete"))
	{	
		deleteUserDetails(request,response);
		searchUserDetails(request, response);
	}
	else if(flag.equals("validate"))
	{	
		validate(request,response);
	}
}

	private void validate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int name=Integer.parseInt(request.getParameter("name"));
		System.out.println("name isss"+name);
		UserDetailsVO uv=new UserDetailsVO();
		uv.setUser1_no(name);
		
		UserDetailsDAO ud=new UserDetailsDAO();
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
	

	private void deleteUserDetails(HttpServletRequest request,
		HttpServletResponse response) {
	// TODO Auto-generated method stub
	int userid=Integer.parseInt(request.getParameter("userdetailsID"));
	UserDetailsVO v=new UserDetailsVO();
	v.setUser1_id(userid);
	UserDetailsDAO d=new UserDetailsDAO();
	d.deleteUserDetails(v);
	
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertUserDetails"))
		{
			insertUserDetails(request,response);
		}
		if(flag.equals("loadUser"))
		{
			loadUser(request,response);
		}
		else if(flag.equals("update"))
		{
			updateUserDetails(request, response);
		}
	}
	

	private void loadUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		UserDAO d=new UserDAO();
		
		List ls=d.search();
		HttpSession x=request.getSession();
		x.setAttribute("user_list",ls);
		
		response.sendRedirect("Admin/Form_UserManagement.jsp");
				
	
	}
		
		protected void insertUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
			HttpSession session = request.getSession();
			
			int user = (int) session.getAttribute("userID");
			
			int uno=Integer.parseInt(request.getParameter("userNo"));
			long c=Integer.parseInt(request.getParameter("contact"));
			int g=Integer.parseInt(request.getParameter("gunNO"));
		String s = request.getParameter("fname");
		String s1 = request.getParameter("lname");
		String s2 = request.getParameter("address");
		String s3 = request.getParameter("address1");
		String s4 = request.getParameter("email");
		
		String s5 = request.getParameter("post");
		
		UserVO userVO = new UserVO();
		userVO.setUser_id(user);
		
		UserDetailsVO v=new UserDetailsVO();
		v.setUserVO(userVO);
		v.setUser1_no(uno);
		v.setFirst_name(s);
		v.setLast_name(s1);
		v.setAddress1(s2);
		v.setAddress2(s3);
		v.setEmail_id(s4);
		v.setPost(s5);
		v.setContact_no(c);;
		v.setGun1_no(g);
		
		
		
		UserDetailsDAO d=new UserDetailsDAO();
		
		d.insertUserDetails(v);
		response.sendRedirect("Admin/Form_UserManagement.jsp");

}		
	
protected void searchUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UserDetailsVO v1=new UserDetailsVO();
			
			UserDetailsDAO d1=new UserDetailsDAO();
			List ls=d1.search();

			HttpSession x = request.getSession();
			x.setAttribute("user1_list",ls);

			response.sendRedirect("Admin/Form_SearchUserDetails.jsp");
			
		}
protected void editUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int c = Integer.parseInt(request.getParameter("userdetailsID"));
	
	UserDetailsVO v2=new UserDetailsVO();
	v2.setUser1_id(c);
	
	UserDetailsDAO d2=new UserDetailsDAO();
	List ls=d2.editUserDetails(v2);
	HttpSession session=request.getSession();
	session.setAttribute("userdetails_list", ls);
	
	UserDAO u=new UserDAO();
	List ls3=u.search();
	session.setAttribute("user_list",ls3);
	response.sendRedirect("Admin/Form_EditUserDetails.jsp");
}

protected void updateUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int uno=Integer.parseInt(request.getParameter("userNo"));
	long c=Integer.parseInt(request.getParameter("contact"));
	int u=Integer.parseInt(request.getParameter("user"));
	int c1 = Integer.parseInt(request.getParameter("userdetailsID"));
	int g=Integer.parseInt(request.getParameter("gunNO"));
	String s = request.getParameter("fname");
	String s1 = request.getParameter("lname");
	String s2 = request.getParameter("address");
	String s3 = request.getParameter("address1");
	String s4 = request.getParameter("email");	
	String s5 = request.getParameter("post");

UserVO uv=new UserVO();
uv.setUser_id(u);

UserDetailsVO v=new UserDetailsVO();
v.setUser1_id(c1);
v.setUser1_no(uno);
v.setFirst_name(s);
v.setLast_name(s1);
v.setAddress1(s2);
v.setAddress2(s3);
v.setEmail_id(s4);
v.setPost(s5);
v.setContact_no(c);
v.setGun1_no(g);
v.setUserVO(uv);

UserDetailsDAO d=new UserDetailsDAO();

d.updateUserDetails(v);

searchUserDetails(request, response);

}
}

