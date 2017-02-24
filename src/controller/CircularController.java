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

import DAO.AttachmentMappingDAO;
import DAO.CategoryDAO;
import DAO.CircularDAO;
import VO.AttachmentMappingVO;
import VO.AttachmentVO;
import VO.CategoryVO;
import VO.CircularVO;

/**
 * Servlet implementation class CircularController
 */
@WebServlet("/CircularController")
public class CircularController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CircularController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchAS"))
		{
			searchCircular(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editCircular(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteCircular(request,response);
			searchCircular(request, response);
		}
	}
	
	
	private void deleteCircular(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cirid=Integer.parseInt(request.getParameter("circularID"));
		CircularVO v=new CircularVO();
		v.setCircular_id(cirid);
		CircularDAO d=new CircularDAO();
		d.deleteCircular(v);
		
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String flag=request.getParameter("flag");
		if(flag.equals("insertCircular"))
		{
			insertCircular(request,response);
		}
		else if(flag.equals("updateCircular"))
		{
			updateCircular(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void insertCircular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	
	String s = request.getParameter("cirTitle");
	String s1 = request.getParameter("cirDes");
	
	
	

	CircularVO v=new CircularVO();
	v.setCircular_title(s);
	v.setCircular_description(s1);
	
	CircularDAO d=new CircularDAO(); 
	
	
	//getting file from Session
	
	HttpSession session =request.getSession();
	
	List myList=(List)session.getAttribute("fileList");
	
	 Iterator itr =  myList.iterator();
     
     System.out.println("Reading for session");
     int i =0;
     while (itr.hasNext()) {
 
    	 
    	 v.setPath((String)itr.next());
    	 
    	 /*attachMPG_DAO.insert(attachMPGVO);*/
    	 
    	 i++;
		}
	

	
	session.removeAttribute("fileList");
			
	
	
	

	
	d.insertCircular(v);
	response.sendRedirect("Admin/Circular.jsp");

}
	
	protected void searchCircular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CircularVO v1=new CircularVO();
		
		CircularDAO d1=new CircularDAO(); 
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("circular_list",ls);

		response.sendRedirect("Admin/Form_SearchCircular.jsp");
		
	}
	protected void editCircular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c = Integer.parseInt(request.getParameter("circularID"));
		
		CircularVO v2=new CircularVO(); 
		v2.setCircular_id(c);
		
		CircularDAO d2=new CircularDAO(); 
		List ls=d2.editCircular(v2);
		
		HttpSession session=request.getSession();
		session.setAttribute("circular_list", ls);
		
		response.sendRedirect("Admin/Form_EditCircular.jsp");
	}

	protected void updateCircular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		int c = Integer.parseInt(request.getParameter("circularID"));
	String s = request.getParameter("cirTitle");
	String s1 = request.getParameter("cirDes");
	
	
	CircularVO v=new CircularVO();
	v.setCircular_id(c);
	v.setCircular_title(s);
	v.setCircular_description(s1);
	
	CircularDAO d=new CircularDAO();
	
	d.updateCircular(v);
	
	searchCircular(request, response);

}

}


