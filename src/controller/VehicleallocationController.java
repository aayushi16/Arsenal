package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GunDAO;
import DAO.GunallocationDAO;
import DAO.UserDAO;
import DAO.VehicleDAO;
import DAO.VehicleallocationDAO;
import VO.GunVO;
import VO.GunallocationVO;
import VO.UserVO;
import VO.VehicleVO;
import VO.VehicleallocationVO;

/**
 * Servlet implementation class VehicleallocationController
 */
@WebServlet("/VehicleallocationController")
public class VehicleallocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleallocationController() {
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
		
		if(flag.equals("search12"))
		{
			searchVehiclestock(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editVehiclestock(request,response);
		}
	else if(flag.equals("delete"))
	{	
		deleteVehiclestock(request,response);
		searchVehiclestock(request, response);
	}
}


	private void deleteVehiclestock(HttpServletRequest request,
		HttpServletResponse response) {
	// TODO Auto-generated method stub
	int vid=Integer.parseInt(request.getParameter("stock2ID"));
	VehicleallocationVO v=new VehicleallocationVO();
	v.setStock2_id(vid);
	VehicleallocationDAO d=new VehicleallocationDAO();
	d.deleteVehiclestock(v);
	
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
		if(flag.equals("insertVehiclestock"))
		{
			insertVehiclestock(request,response);
		}
		if(flag.equals("loadVehicle"))
		{
			loadVehicle(request,response);
		}
		else if(flag.equals("update"))
		{
			updateVehiclestock(request, response);
		}
	}

	
	private void loadVehicle(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		VehicleDAO d=new VehicleDAO();
		
		List ls=d.search();
		HttpSession x=request.getSession();
		x.setAttribute("vehicle_list",ls);
		
		UserDAO d1=new UserDAO();
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_Vehicleallocation.jsp");
				
	}
	
	protected void insertVehiclestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
	int vh=Integer.parseInt(request.getParameter("vehicle"));
	
	int to = Integer.parseInt(request.getParameter("user"));
	
	System.out.println("To ="+to);
	
	String s = request.getParameter("quantity");
	String s1 = request.getParameter("tp");
	String s2 = request.getParameter("rp");
	String s3 = request.getParameter("as");
	String s4 = request.getParameter("rs");
	String s5 = request.getParameter("gas");
	String s6 = request.getParameter("km");
	VehicleVO vehicleVO=new VehicleVO();
	vehicleVO.setVehicle_id(vh);
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	
	UserVO vo = new UserVO();
	vo.setUser_id(to);
	
	VehicleallocationVO v=new VehicleallocationVO();
	v.setTo(vo);
	v.setQuantity(s);
	v.setAssign_time(s1);
	v.setRetrieve_time(s2);
	v.setAssign_status(s3);
	v.setReturn_status(s4);
	v.setGasoline(s5);
	v.setKilometer(s6);
	v.setVehicleVO(vehicleVO);
	v.setUserVO(userVO);
	VehicleallocationDAO d=new VehicleallocationDAO();
	
	d.insertvehiclestock(v);
	response.sendRedirect("Admin/Form_Vehicleallocation.jsp");

}
	protected void searchVehiclestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VehicleallocationVO v1=new VehicleallocationVO();
		
		VehicleallocationDAO d1=new VehicleallocationDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("vehicleallocation_list",ls);

		response.sendRedirect("Admin/Form_SearchVehicleallocation.jsp");
		
	}
protected void editVehiclestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int s = Integer.parseInt(request.getParameter("stock2ID"));
		
		VehicleallocationVO v2=new VehicleallocationVO(); 
		v2.setStock2_id(s);
		
		VehicleallocationDAO d2=new VehicleallocationDAO();
		List ls=d2.editVehiclestock(v2);
		HttpSession session=request.getSession();
		session.setAttribute("vehicleallocation_list", ls);
		
		VehicleDAO cd=new VehicleDAO();
		List ls2=cd.search();
		session.setAttribute("vehicle_list", ls2);
		
		UserDAO u=new UserDAO();
		List ls3=u.search();
		session.setAttribute("user_list",ls3);
		response.sendRedirect("Admin/Form_EditVehicleallocation.jsp");
	}

	protected void updateVehiclestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		int vh=Integer.parseInt(request.getParameter("vehicle"));
		int s = Integer.parseInt(request.getParameter("stock2ID"));
		String ss = request.getParameter("quantity");
		String s1 = request.getParameter("tp");
		String s2 = request.getParameter("rp");
		String s3 = request.getParameter("as");
		String s4 = request.getParameter("rs");
		String s5 = request.getParameter("gas");
		String s6 = request.getParameter("km");
	
	UserVO uv=new UserVO();
	uv.setUser_id(user);
	
	VehicleVO cv=new VehicleVO();
	cv.setVehicle_id(vh);
	
	VehicleallocationVO v=new VehicleallocationVO();
	v.setStock2_id(s);
	v.setQuantity(ss);
	v.setAssign_time(s1);
	v.setRetrieve_time(s2);
	v.setAssign_status(s3);
	v.setReturn_status(s4);
	v.setGasoline(s5);
	v.setKilometer(s6);
	v.setUserVO(uv);
	v.setVehicleVO(cv);
	
	VehicleallocationDAO d=new VehicleallocationDAO();
	
	d.updateVehiclestock(v);
	
	searchVehiclestock(request, response);

}

	}