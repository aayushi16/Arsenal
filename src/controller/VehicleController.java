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

import VO.CategoryVO;
import VO.GunVO;
import VO.UserVO;
import VO.VehicleVO;
import DAO.CategoryDAO;
import DAO.GunDAO;
import DAO.UserDAO;
import DAO.VehicleDAO;

/**
 * Servlet implementation class VehicleController
 */
@WebServlet("/VehicleController")
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleController() {
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
		
		if(flag.equals("search5"))
		{
			searchVehicle(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editVehicle(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteVehicle(request,response);
			searchVehicle(request, response);
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
		VehicleVO uv=new VehicleVO();
		uv.setVehicle_no(name);
		
		VehicleDAO ud=new VehicleDAO();
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
	private void deleteVehicle(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int vid=Integer.parseInt(request.getParameter("vehicleID"));
		VehicleVO v=new VehicleVO();
		v.setVehicle_id(vid);
		VehicleDAO d=new VehicleDAO(); 
		d.deleteVehicle(v);
		
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertVehicle"))
		{
			insertVehicle(request,response);
		}
		if(flag.equals("loadCategory"))
		{
			loadCategory(request,response);
		}
		else if(flag.equals("update"))
		{
			updateVehicle(request, response);
		}
	}

	private void loadCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CategoryDAO d=new CategoryDAO();
		
		List ls=d.search();
		HttpSession x=request.getSession();
		x.setAttribute("cat_list",ls);

	
		UserDAO d1=new UserDAO();
		List ls1=d1.search();
		x.setAttribute("user_list",ls1);
		
		response.sendRedirect("Admin/Form_Addvehicle.jsp");
				
	}
	
	protected void insertVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
	int cat=Integer.parseInt(request.getParameter("cat"));
	int v1=Integer.parseInt(request.getParameter("vehicleNo"));
	String s = request.getParameter("vehicleName");
	String s1 = request.getParameter("vehicleDes");
	
	CategoryVO categoryVO=new CategoryVO();
	categoryVO.setCat_id(cat);
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	
	VehicleVO v=new VehicleVO() ;
	v.setVehicle_no(v1);
	v.setVehicle_name(s);
	v.setVehicle_description(s1);
	v.setCategoryVO(categoryVO);
	v.setUserVO(userVO);
	VehicleDAO d=new VehicleDAO(); 
	
	d.insertVehicle(v);
	response.sendRedirect("Admin/Form_Addvehicle.jsp");

}
protected void searchVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VehicleVO v1=new VehicleVO();
		
		VehicleDAO d1=new VehicleDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("vehicle_list",ls);

		response.sendRedirect("Admin/Form_SearchVehicle.jsp");
		
	}
protected void editVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int c = Integer.parseInt(request.getParameter("vehicleID"));
	
	VehicleVO v2=new VehicleVO();  
	v2.setVehicle_id(c);
	
	VehicleDAO d2=new VehicleDAO();
	List ls=d2.editVehicle(v2);
	
	HttpSession session=request.getSession();
	session.setAttribute("vehicle_list", ls);
	
	CategoryDAO cd=new CategoryDAO();
	List ls2=cd.search();
	session.setAttribute("cat_list", ls2);
	
	UserDAO u=new UserDAO();
	List ls3=u.search();
	session.setAttribute("user_list",ls3);
	
	response.sendRedirect("Admin/Form_EditVehicle.jsp");
}

protected void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

	HttpSession session = request.getSession();
	
	int user = (int) session.getAttribute("userID");
	int cat=Integer.parseInt(request.getParameter("cat"));

	int c1 = Integer.parseInt(request.getParameter("vehicleID"));
	int g = Integer.parseInt(request.getParameter("vehicleNO"));
	String s1 = request.getParameter("vehicleName");
	String s2 = request.getParameter("vehicleDes");

	UserVO uv=new UserVO();
	uv.setUser_id(user);
	CategoryVO cv=new CategoryVO();
	cv.setCat_id(cat);
	VehicleVO v=new VehicleVO(); 
	v.setVehicle_id(c1);
	v.setVehicle_no(g);
	v.setVehicle_name(s1);
	v.setVehicle_description(s2);
	v.setCategoryVO(cv);
	v.setUserVO(uv);
	VehicleDAO d=new VehicleDAO();

	d.updateVehicle(v);
	searchVehicle(request, response);

}
}