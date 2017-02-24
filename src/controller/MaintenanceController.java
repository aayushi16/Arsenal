package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AttendanceDAO;
import DAO.MaintenanceDAO;
import DAO.UserDAO;
import VO.AttendanceVO;
import VO.MaintenanceVO;
import VO.UserVO;

/**
 * Servlet implementation class MaintenanceController
 */
@WebServlet("/MaintenanceController")
public class MaintenanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintenanceController() {
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
		
		if(flag.equals("search13"))
		{
			searchMaintenance(request, response);
		}
		else if(flag.equals("editMaintenance"))
		{	
			editMaintenance(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteMaintenance(request,response);
			searchMaintenance(request, response);
		}
	
	}
	
	private void deleteMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int mid=Integer.parseInt(request.getParameter("maintenanceID"));
		MaintenanceVO v=new MaintenanceVO();
		v.setM_id(mid);
		MaintenanceDAO d=new MaintenanceDAO();
		d.deleteMaintenance(v);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String flag=request.getParameter("flag");
		if(flag.equals("insertMaintenance"))
		{
			insertMaintenance(request,response);
		}
		if(flag.equals("loadUser"))
		{
			loadUser(request,response);
		}
		else if(flag.equals("update"))
		{
			updateMaintenance(request, response);
		}
	}

	private void loadUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		UserDAO d1=new UserDAO();
		HttpSession x=request.getSession();
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_ManageMaintenance.jsp");
				
	}
	
	protected void insertMaintenance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
int to = Integer.parseInt(request.getParameter("user"));
		
		System.out.println("To ="+to);
		
	String des = request.getParameter("description");
	String s = request.getParameter("cd");
	String s1 = request.getParameter("md");
	String s2 = request.getParameter("status");
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	UserVO vo = new UserVO();
	vo.setUser_id(to);
	
	MaintenanceVO v=new MaintenanceVO(); 
	v.setTo(vo);
	v.setDescription(des);
	v.setCreated_date(s);
	v.setModified_date(s1);
	v.setStatus(s2);
	v.setUserVO(userVO);
	MaintenanceDAO d=new MaintenanceDAO();
	
	d.insertMaintenance(v);
	response.sendRedirect("Admin/Form_ManageMaintenance.jsp");

}
	
protected void searchMaintenance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	MaintenanceVO v1=new MaintenanceVO();
		
	MaintenanceDAO d1=new MaintenanceDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("maintenance_list",ls);

		response.sendRedirect("Admin/Form_SearchMaintenance.jsp");
		
	}
protected void editMaintenance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int m = Integer.parseInt(request.getParameter("maintenanceId"));
	
	MaintenanceVO v3=new MaintenanceVO();
	v3.setM_id(m);
	
	MaintenanceDAO d2=new MaintenanceDAO();
	List ls=d2.editMaintenance(v3);
	
	HttpSession session=request.getSession();
	session.setAttribute("maintenance_list", ls);
	
	
	
	UserDAO cd=new UserDAO();
	List ls2=cd.search();
	
	session.setAttribute("user_list", ls2);
	
	response.sendRedirect("Admin/Form_EditMaintenance.jsp");
}
protected void updateMaintenance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

	HttpSession session = request.getSession();
	
	int user = (int) session.getAttribute("userID");
	int m = Integer.parseInt(request.getParameter("maintenanceID"));
	String des = request.getParameter("description");
	String s = request.getParameter("cd");
	String s1 = request.getParameter("md");
	String s2 = request.getParameter("status");

UserVO uv=new UserVO();
uv.setUser_id(user);

MaintenanceVO v=new MaintenanceVO();
v.setM_id(m);
v.setDescription(des);
v.setCreated_date(s);
v.setModified_date(s1);
v.setStatus(s2);
v.setUserVO(uv);

MaintenanceDAO d=new MaintenanceDAO();

d.updateMaintenance(v);

searchMaintenance(request, response);

}

}
