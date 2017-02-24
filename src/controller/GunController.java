package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CategoryVO;
import VO.GunVO;
import VO.SubCategoryVO;
import VO.UserVO;
import DAO.CategoryDAO;
import DAO.GunDAO;
import DAO.SubcategoryDAO;
import DAO.UserDAO;

/**
 * Servlet implementation class GunController
 */
@WebServlet("/GunController")
public class GunController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GunController() {
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
		
		if(flag.equals("search4"))
		{
			searchGun(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editGun(request,response);
		}
	else if(flag.equals("delete"))
	{	
		deleteGun(request,response);
		searchGun(request, response);
	}
	else if(flag.equals("validate"))
	{	
		validate(request,response);
	}
	else if(flag.equals("markerLoad"))
	{	
		markerLoad(request,response);
	}
}
	
	private void markerLoad(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("in get");
		HttpSession session=request.getSession();

		try {
			String result="";
			result+="<root>";
			
			
			GunDAO csed=new GunDAO();
			List ls=csed.search();
			System.out.println("gun size is jj "+ls.size());
			Iterator i=ls.iterator();
			GunVO mcv=new GunVO();
			while(i.hasNext())
			{
				mcv=(GunVO) i.next();
				result+="<data>"; 	
				String s1=String.valueOf(mcv.getLatitude());
				
				result+="<latitude>"+s1+"</latitude>";
				
				String s2 = String.valueOf(mcv.getLongitude());
				result+="<longitude>"+s2+"</longitude>";
				
				int status=mcv.getGun_id();
				result+="<gunId>"+status+"</gunId>";
				
				int gunNo=mcv.getGun_no();
				result+="<gunNo>"+gunNo+"</gunNo>";
				
			/*	String ambulance=String.valueOf(mcv.getAmbulance().getA_id());
				result+="<ambulance>"+ambulance+"</ambulance>";

				String coordinator=+String.valueOf(mcv.getCoordinator().getC_id());
				result+="<coordinator>"+coordinator+"</coordinator>";
				
*/				
				result+="</data>";
				System.out.println("Latitude::"+s1+"longitude::"+s2);
			}
			
			
						result+="</root>";
			PrintWriter out=response.getWriter();
			out.println(result);
			System.out.println(result);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void validate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int name=Integer.parseInt(request.getParameter("name"));
		System.out.println("name isss"+name);
		GunVO uv=new GunVO();
		uv.setGun_no(name);
		
		GunDAO ud=new GunDAO();
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
	private void deleteGun(HttpServletRequest request,
		HttpServletResponse response) {
	// TODO Auto-generated method stub
	int gid=Integer.parseInt(request.getParameter("gunID"));
	GunVO v=new GunVO();
	v.setGun_id(gid);
	GunDAO d=new GunDAO();
	d.deleteGun(v);
	
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertGun"))
		{
			insertGun(request,response);
		}
		if(flag.equals("loadCategory"))
		{
			loadCategory(request,response);
		}
		else if(flag.equals("update"))
		{
			updateGun(request, response);
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
		List lss=d1.search();
		x.setAttribute("user_list",lss);
		
		response.sendRedirect("Admin/Form_Addgun.jsp");
				
	}
	
	protected void insertGun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		
	int cat=Integer.parseInt(request.getParameter("cat"));
	int g1=Integer.parseInt(request.getParameter("gunNo"));
	String s = request.getParameter("gunName");
	String s1 = request.getParameter("gunDes");
	CategoryVO categoryVO=new CategoryVO();
	categoryVO.setCat_id(cat);
	
	UserVO userVO=new UserVO();
	userVO.setUser_id(user);
	
	GunVO v=new GunVO();
	v.setGun_no(g1);
	v.setGun_name(s);
	v.setGun_description(s1);
	v.setCategoryVO(categoryVO);
	v.setUserVO(userVO);
	GunDAO d=new GunDAO();
	
	d.insertGun(v);
	response.sendRedirect("Admin/Form_Addgun.jsp");

}
	protected void searchGun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GunVO v1=new GunVO();
		
		GunDAO d1=new GunDAO();
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("gun_list",ls);

		response.sendRedirect("Admin/Form_SearchGun.jsp");
		
	}
protected void editGun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c = Integer.parseInt(request.getParameter("gunID"));
		
		GunVO v2=new GunVO(); 
		v2.setGun_id(c);
		
		GunDAO d2=new GunDAO();
		List ls=d2.editGun(v2);
		HttpSession session=request.getSession();
		session.setAttribute("gun_list", ls);
		
		CategoryDAO cd=new CategoryDAO();
		List ls2=cd.search();
		session.setAttribute("cat_list", ls2);
		
		UserDAO u=new UserDAO();
		List ls3=u.search();
		session.setAttribute("user_list",ls3);
		response.sendRedirect("Admin/Form_EditGun.jsp");
	}

	protected void updateGun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		
		int user = (int) session.getAttribute("userID");
		int cat=Integer.parseInt(request.getParameter("cat"));
		int c = Integer.parseInt(request.getParameter("gunID"));
		int g = Integer.parseInt(request.getParameter("gunNO"));
	String s1 = request.getParameter("gunName");
	String s2 = request.getParameter("gunDes");
	
	UserVO uv=new UserVO();
	uv.setUser_id(user);
	
	CategoryVO cv=new CategoryVO();
	cv.setCat_id(cat);
	
	GunVO v=new GunVO();
	v.setGun_id(c);
	v.setGun_no(g);
	v.setGun_name(s1);
	v.setGun_description(s2);
	v.setUserVO(uv);
	v.setCategoryVO(cv);
	
	GunDAO d=new GunDAO();
	
	d.updateGun(v);
	
	searchGun(request, response);

}
	}
