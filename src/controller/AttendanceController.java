package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.AttendanceVO;
import VO.CategoryVO;
import VO.GunVO;
import VO.SubCategoryVO;
import VO.UserVO;
import DAO.AttendanceDAO;
import DAO.CategoryDAO;
import DAO.GunDAO;
import DAO.SubcategoryDAO;
import DAO.UserDAO;

/**
 * Servlet implementation class AttendanceController
 */
@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceController() {
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
		
		if(flag.equals("search7"))
		{
			searchAttendance(request, response);
		}
		else if(flag.equals("editAttendance"))
		{	
			editAttendance(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteAttendance(request,response);
			searchAttendance(request, response);
		}
	
	}
	
	private void deleteAttendance(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int attid=Integer.parseInt(request.getParameter("attendanceID"));
		AttendanceVO v=new AttendanceVO();
		v.setAtt_id(attid);
		AttendanceDAO d=new AttendanceDAO();
		d.deleteAttendance(v);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertAttendance"))
		{
			insertAttendance(request,response);
		}
		if(flag.equals("loadUser"))
		{
			loadUser(request,response);
		}
		else if(flag.equals("update"))
		{
			updateAttendance(request, response);
		}
	}

	private void loadUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		UserDAO d1=new UserDAO();
		HttpSession x=request.getSession();
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_ManageAttendance.jsp");
				
	}
	
	protected void insertAttendance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	int user=Integer.parseInt(request.getParameter("user"));
	int t=Integer.parseInt(request.getParameter("intime"));
	int t1=Integer.parseInt(request.getParameter("outtime"));
	String s = request.getParameter("date");
	String s1 = request.getParameter("details");
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	
	AttendanceVO v=new AttendanceVO(); 
	v.setIn_time(t);
	v.setOut_time(t1);
	v.setDate(s);
	v.setDetails(s1);
	v.setUserVO(userVO);
	AttendanceDAO d=new AttendanceDAO();
	
	d.insertAttendance(v);
	response.sendRedirect("Admin/Form_ManageAttendance.jsp");

}
	
protected void searchAttendance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttendanceVO v1=new AttendanceVO();
		
		AttendanceDAO d1=new AttendanceDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("attendance_list",ls);

		response.sendRedirect("Admin/Form_SearchAttendance.jsp");
		
	}
protected void editAttendance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int c = Integer.parseInt(request.getParameter("attendanceId"));
	
	AttendanceVO v3=new AttendanceVO();
	v3.setAtt_id(c);
	
	AttendanceDAO d2=new AttendanceDAO();
	List ls=d2.editAttendance(v3);
	
	HttpSession session=request.getSession();
	session.setAttribute("attendance_list", ls);
	
	
	
	UserDAO cd=new UserDAO();
	List ls2=cd.search();
	
	session.setAttribute("user_list", ls2);
	
	response.sendRedirect("Admin/Form_EditAttendance.jsp");
}
protected void updateAttendance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

	int uid=Integer.parseInt(request.getParameter("user"));
	int a = Integer.parseInt(request.getParameter("attendanceID"));
	int t=Integer.parseInt(request.getParameter("intime"));
	int t1=Integer.parseInt(request.getParameter("outtime"));
	String s = request.getParameter("date");
	String s1 = request.getParameter("details");


UserVO uv=new UserVO();
uv.setUser_id(uid);

AttendanceVO v=new AttendanceVO();
v.setAtt_id(a);
v.setIn_time(t);
v.setOut_time(t1);
v.setDate(s);
v.setDetails(s1);
v.setUserVO(uv);

AttendanceDAO d=new AttendanceDAO();

d.updateAttendance(v);

searchAttendance(request, response);

}

}
