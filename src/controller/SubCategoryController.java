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
import DAO.SubcategoryDAO;
import DAO.UserDAO;
import VO.CategoryVO;
import VO.SubCategoryVO;
import VO.UserVO;
	/**
	 * Servlet implementation class Reg
	 */
	@WebServlet("/SubCategoryController")
	public class SubCategoryController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SubCategoryController() {
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
		
		if(flag.equals("search1"))
		{
			searchSubCategory(request, response);
		}
		else if(flag.equals("editSubCategory"))
		{	
			editSubCategory(request,response);
		}
		else if(flag.equals("delete"))
		{	
			deleteSubCategory(request,response);
			searchSubCategory(request, response);
		}
		else if(flag.equals("validate"))
		{	
			validate(request,response);
		}
	}
	
		private void validate(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			
			String name=request.getParameter("name");
			System.out.println("name isss"+name);
			SubCategoryVO sv=new SubCategoryVO();
			sv.setSubcat_name(name);
			
			SubcategoryDAO sd=new SubcategoryDAO();
			List ls=sd.validate(sv);
			PrintWriter pw=response.getWriter();
			System.out.println("mmmmmmmmmmmmmmmmmmm"+ls.size());
			pw.write("<root>");
			if(ls.size()>=1)
			{

				System.out.println("already");
//				pw.write("[{\"flag\":\"false\"}]");
				pw.write("<flag>false</flag>");
				
			}
			else
			{
				System.out.println("no");
				pw.write("<flag>true</flag>");
			}
			pw.write("</root>");
	
		}
		
	private void deleteSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int subcatid=Integer.parseInt(request.getParameter("subcategoryID"));
		SubCategoryVO v=new SubCategoryVO();
		v.setSubcat_id(subcatid);
		SubcategoryDAO d=new SubcategoryDAO();
		d.deleteSubCategory(v);
		
	}	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			String flag=request.getParameter("flag");
			if(flag.equals("insertSubCategory"))
			{
				insertSubCategory(request,response);
			}
			if(flag.equals("loadCategory"))
			{
				loadCategory(request,response);
			}
			else if(flag.equals("update"))
			{
				updateSubCategory(request, response);
			}
		}
		

		private void loadCategory(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			CategoryDAO d=new CategoryDAO();
			
			List ls=d.search();
			HttpSession x=request.getSession();
			x.setAttribute("cat_list",ls);
			
			response.sendRedirect("Admin/Form_AddSubCategory.jsp");
					
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void insertSubCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
		int cat=Integer.parseInt(request.getParameter("cat"));
		String s = request.getParameter("subcatName");
		String s1 = request.getParameter("subcatDes");
		
		CategoryVO categoryVO=new CategoryVO();
		categoryVO.setCat_id(cat);
		
		SubCategoryVO v=new SubCategoryVO();
		v.setSubcat_name(s);
		v.setSubcat_description(s1);
		v.setCategoryVO(categoryVO);
		
		SubcategoryDAO d=new SubcategoryDAO();
		
		d.insertSubCategory(v);
		response.sendRedirect("Admin/Form_AddSubCategory.jsp");

}

	protected void searchSubCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			SubCategoryVO v1=new SubCategoryVO();
			
			SubcategoryDAO d1=new SubcategoryDAO();
			List ls=d1.search();

			HttpSession x = request.getSession();
			x.setAttribute("subcategory_list",ls);

			response.sendRedirect("Admin/Form_SearchSubCategory.jsp");
			
		}

	protected void editSubCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c = Integer.parseInt(request.getParameter("subcategoryId"));
		
		SubCategoryVO v3=new SubCategoryVO();
		v3.setSubcat_id(c);
		
		SubcategoryDAO d2=new SubcategoryDAO();
		List ls=d2.editSubCategory(v3);
		
		HttpSession session=request.getSession();
		session.setAttribute("subcategory_list", ls);
		
		
		
		CategoryDAO cd=new CategoryDAO();
		List ls2=cd.search();
		
		session.setAttribute("cat_list", ls2);
		
		response.sendRedirect("Admin/Form_EditSubCategory.jsp");
	}
	protected void updateSubCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int catid=Integer.parseInt(request.getParameter("cat"));
		int c = Integer.parseInt(request.getParameter("subcategoryID"));
	String s = request.getParameter("subcategoryName");
	String s1 = request.getParameter("subcategoryDes");
	
	
	CategoryVO cv=new CategoryVO();
	cv.setCat_id(catid);
	
	SubCategoryVO v=new SubCategoryVO();
	v.setSubcat_id(c);
	v.setSubcat_name(s);
	v.setSubcat_description(s1);
	v.setCategoryVO(cv);
	
	SubcategoryDAO d=new SubcategoryDAO();
	
	d.updateSubCategory(v);
	
	searchSubCategory(request, response);

}
	}
