package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.GunDAO;
import DAO.GunallocationDAO;
import DAO.UserDAO;
import VO.CategoryVO;
import VO.GunVO;
import VO.GunallocationVO;
import VO.GunallocationmpgVO;
import VO.UserVO;

/**
 * Servlet implementation class GunallocationController
 */
@WebServlet("/GunallocationController")
public class GunallocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GunallocationController() {
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
		
		if(flag.equals("search11"))
		{
			searchGunstock(request, response);
		}
		else if(flag.equals("loadIndex"))
		{
			loadIndex(request, response);
		}

		else if(flag.equals("searchPL"))
		{
			searchPendingList(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editGunstock(request,response);
		}
	else if(flag.equals("delete"))
	{	
		deleteGunstock(request,response);
		searchGunstock(request, response);
	}
	else if(flag.equals("validate"))
	{
		
		loadDashboard(request,response);
	}
	else if(flag.equals("allocatedGuns")){
		allocatedGuns(request,response);
	}
}


	private void loadIndex(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Admin/index-2.jsp");
	}

	private void allocatedGuns(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		GunallocationDAO dao = new GunallocationDAO();
		List ls = dao.countGuns();
		
		System.out.println("Gun counts lllllllllllllllllllllllllllllllll:"+ls.size());
		session.setAttribute("gunCounts", ls);
		
		response.sendRedirect("Admin/writeFile.jsp");
	}

	private void deleteGunstock(HttpServletRequest request,
		HttpServletResponse response) {
	// TODO Auto-generated method stub
	int gid=Integer.parseInt(request.getParameter("stock1ID"));
	GunallocationVO v=new GunallocationVO();
	v.setStock1_id(gid);
	GunallocationDAO d=new GunallocationDAO();
	d.deleteGunstock(v);
	
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertGunstock"))
		{
			insertGunstock(request,response);
		}
		if(flag.equals("loadGun"))
		{
			loadGun(request,response);
		}
		else if(flag.equals("update"))
		{
			updateGunstock(request, response);
		}
	}

	
	private void loadGun(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		GunDAO d=new GunDAO();
		
		List ls=d.search();
		HttpSession x=request.getSession();
		x.setAttribute("gun_list",ls);
		
		UserDAO d1=new UserDAO();
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_Gunallocation.jsp");
				
	}
	
	protected void insertGunstock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		int gun=Integer.parseInt(request.getParameter("gun"));
	
		int to = Integer.parseInt(request.getParameter("user"));
		
		System.out.println("To ="+to);
		
	String s = request.getParameter("quantity");
	String s1 = request.getParameter("tp");
	String s2 = request.getParameter("rp");
	String s3 = request.getParameter("as");
	String s4 = request.getParameter("rs");
	String s5 = request.getParameter("nb");
	String s6 = request.getParameter("rb");
	
	GunVO gunVO=new GunVO();
	gunVO.setGun_id(gun);
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	
	UserVO vo = new UserVO();
	vo.setUser_id(to);
	
	GunallocationVO v=new GunallocationVO();
	v.setTo(vo);
	v.setQuantity(s);
	v.setAssign_time(s1);
	v.setRetrieve_time(s2);
	v.setAssign_status(s3);
	v.setReturn_status(s4);
	v.setNo_bullets(s5);
	v.setReturn_bullets(s6);
	v.setGunVO(gunVO);
	v.setUserVO(userVO);
	/*GunallocationmpgVO gm=new GunallocationmpgVO();
	gm.setAssign_time(s1);
	gm.setRetrieve_time(s2);
	gm.setAssign_status(s3);
	gm.setReturn_status(s4);
	gm.setNo_bullets(s5);
	gm.setReturn_bullets(s6);
	gm.setGunVO(gunVO);
	gm.setUserVO(userVO);*/
	GunallocationDAO d=new GunallocationDAO();
	
	d.insertGunstock(v);
	response.sendRedirect("Admin/Form_Gunallocation.jsp");

}
	protected void searchGunstock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GunallocationVO v1=new GunallocationVO();
		
		GunallocationDAO d1=new GunallocationDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("gunallocation_list",ls);

		response.sendRedirect("Admin/Form_SearchGunallocation.jsp");
		
	}
	
protected void searchPendingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GunallocationVO v1=new GunallocationVO();
		
		GunallocationDAO d1=new GunallocationDAO();
		List ls=d1.searchPL();

		HttpSession x = request.getSession();
		x.setAttribute("gunallocation_list",ls);

		response.sendRedirect("Admin/Form_SearchPendingList.jsp");
}
protected void loadDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	GunallocationDAO d1=new GunallocationDAO();
	List ls=d1.searchPL();

	HttpSession x = request.getSession();
	x.setAttribute("gunallocation_list",ls);
	System.out.println("list ls"+ls.size());

	response.sendRedirect("Admin/index-2.jsp");
	
}

protected void editGunstock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int s = Integer.parseInt(request.getParameter("stock1ID"));
		
		GunallocationVO v2=new GunallocationVO(); 
		v2.setStock1_id(s);
		
		GunallocationDAO d2=new GunallocationDAO();
		List ls=d2.editGunstock(v2);
		HttpSession session=request.getSession();
		session.setAttribute("gunallocation_list", ls);
		
		GunDAO cd=new GunDAO();
		List ls2=cd.search();
		session.setAttribute("gun_list", ls2);
		
		UserDAO u=new UserDAO();
		List ls3=u.search();
		session.setAttribute("user_list",ls3);
		response.sendRedirect("Admin/Form_EditGunallocation.jsp");
	}

	protected void updateGunstock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		int g=Integer.parseInt(request.getParameter("gun"));
		int s = Integer.parseInt(request.getParameter("stock1ID"));
		String ss = request.getParameter("quantity");
		String s1 = request.getParameter("tp");
		String s2 = request.getParameter("rp");
		String s3 = request.getParameter("as");
		String s4 = request.getParameter("rs");
		String s5 = request.getParameter("nb");
		String s6 = request.getParameter("rb");
	
		System.out.println("Status ="+s3);
		
	UserVO uv=new UserVO();
	uv.setUser_id(user);
	
	GunVO cv=new GunVO();
	cv.setGun_id(g);
	
	GunallocationVO v=new GunallocationVO();
	v.setStock1_id(s);
	v.setQuantity(ss);
	v.setAssign_time(s1);
	v.setRetrieve_time(s2);
	v.setAssign_status(s3);
	v.setReturn_status(s4);
	v.setNo_bullets(s5);
	v.setReturn_bullets(s6);
	v.setUserVO(uv);
	v.setGunVO(cv);
	
	GunallocationDAO d=new GunallocationDAO();
	
	d.updateGunstock(v);
	
	searchGunstock(request, response);

}

	}