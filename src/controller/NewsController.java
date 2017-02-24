package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CircularDAO;
import DAO.NewsDAO;
import VO.CircularVO;
import VO.NewsVO;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/NewsController")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
String flag=request.getParameter("flag");
		
		if(flag.equals("searchASS"))
		{
			searchNews(request, response);
		}
		else if(flag.equals("edit"))
		{	
			editNews(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteNews(request,response);
			searchNews(request, response);
		}
	}
	
	
	private void deleteNews(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int nid=Integer.parseInt(request.getParameter("newsID"));
		NewsVO v=new NewsVO();
		v.setNews_id(nid);
		NewsDAO d=new NewsDAO();
		d.deleteNews(v);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String flag=request.getParameter("flag");
		if(flag.equals("insertNews"))
		{
			insertNews(request,response);
		}
		else if(flag.equals("updateNews"))
		{
			updateNews(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void insertNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	
	String s = request.getParameter("newsTitle");
	String s1 = request.getParameter("newsDes");
	
	
	NewsVO v=new NewsVO(); 
	v.setNews_title(s);
	v.setNews_description(s1);
	
	NewsDAO d=new NewsDAO(); 
	
	d.insertNews(v);
	response.sendRedirect("Admin/News.jsp");

}
	
	protected void searchNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewsVO v1=new NewsVO();
		
		NewsDAO d1=new NewsDAO(); 
		List ls=d1.search();

		HttpSession x = request.getSession();
		x.setAttribute("news_list",ls);

		response.sendRedirect("Admin/Form_SearchNews.jsp");
		
	}
	protected void editNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c = Integer.parseInt(request.getParameter("newsID"));
		
		NewsVO v2=new NewsVO(); 
		v2.setNews_id(c);
		
		NewsDAO d2=new NewsDAO(); 
		List ls=d2.editNews(v2);
		
		HttpSession session=request.getSession();
		session.setAttribute("news_list", ls);
		
		response.sendRedirect("Admin/Form_EditNews.jsp");
	}

	protected void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		int c = Integer.parseInt(request.getParameter("newsID"));
	String s = request.getParameter("newsTitle");
	String s1 = request.getParameter("newsDes");
	
	
	NewsVO v=new NewsVO();
	v.setNews_id(c);
	v.setNews_title(s);
	v.setNews_description(s1);
	
	NewsDAO d=new NewsDAO();
	
	d.updateNews(v);
	
	searchNews(request, response);

}	
	}
