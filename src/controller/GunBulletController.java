package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CategoryVO;
import VO.GunBulletVO;
import VO.GunVO;
import VO.SubCategoryVO;
import VO.UserVO;
import DAO.CategoryDAO;
import DAO.GunBulletDAO;
import DAO.GunDAO;
import DAO.SubcategoryDAO;
import DAO.UserDAO;

/**
 * Servlet implementation class GunBulletController
 */
@WebServlet("/GunBulletController")
public class GunBulletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GunBulletController() {
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
		
		if(flag.equals("search6"))
		{
			searchGunBullet(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editGunBullet(request,response);
		}
	else if(flag.equals("delete"))
	{	
		deleteGunBullet(request,response);
		searchGunBullet(request, response);
	}
	}
	private void deleteGunBullet(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int gbid=Integer.parseInt(request.getParameter("gunbulletID"));
		GunBulletVO v=new GunBulletVO();
		v.setBullet_id(gbid);
		GunBulletDAO d=new GunBulletDAO();
		d.deleteGunBullet(v);
		
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertGunBullet"))
		{
			insertGunBullet(request,response);
		}
		if(flag.equals("loadGun"))
		{
			loadGun(request,response);
		}
	}
	
	private void loadGun(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		GunDAO d=new GunDAO();
		
		List ls=d.search();
		HttpSession x=request.getSession();
		x.setAttribute("gun_list",ls);
		
		response.sendRedirect("Admin/Form_GunBullet.jsp");
				
	}

	protected void insertGunBullet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	int gun=Integer.parseInt(request.getParameter("gun"));
	int b=Integer.parseInt(request.getParameter("bNo"));
	
	GunVO gunVO=new GunVO();
	gunVO.setGun_id(gun);;
	
	GunBulletVO v=new GunBulletVO();
	v.setBullet_no(b);
	v.setGunVO(gunVO);
	
	GunBulletDAO d=new GunBulletDAO() ;
	
	d.insertGunBullet(v);
	response.sendRedirect("Admin/Form_GunBullet.jsp");

}
protected void searchGunBullet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GunBulletVO v1=new GunBulletVO();
		
		GunBulletDAO d1=new GunBulletDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("gunbullet_list",ls);

		response.sendRedirect("Admin/Form_SearchGunBullet.jsp");
		
	}
protected void editGunBullet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int gb = Integer.parseInt(request.getParameter("gunbulletID"));
	
	GunBulletVO v2=new GunBulletVO(); 
	v2.setBullet_id(gb);
	
	GunBulletDAO d2=new GunBulletDAO();
	List ls=d2.editGunBullet(v2);
	HttpSession session=request.getSession();
	session.setAttribute("gunbullet_list", ls);
	
	GunDAO cd=new GunDAO();
	List ls2=cd.search();
	session.setAttribute("gun_list", ls2);
	response.sendRedirect("Admin/Form_EditGunBullet.jsp");
}

protected void updateGunBullet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int g=Integer.parseInt(request.getParameter("gun"));
	int b = Integer.parseInt(request.getParameter("bulletID"));
	int b1 = Integer.parseInt(request.getParameter("bulletNO"));



GunVO cv=new GunVO();
cv.setGun_id(g);
GunBulletVO v=new GunBulletVO();
v.setBullet_id(b);
v.setBullet_no(b1);
v.setGunVO(cv);


GunBulletDAO d=new GunBulletDAO();

d.updateGunBullet(v);

searchGunBullet(request, response);

}
}
