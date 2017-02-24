package controller;

	import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import java.util.List;

	import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.UserDAO;
import VO.CategoryVO;
import VO.UserVO;

	/**
	 * Servlet implementation class Reg
	 */
	@WebServlet("/CategoryController")
	public class CategoryController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CategoryController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
			String flag=request.getParameter("flag");
			
			if(flag.equals("search"))
			{
				searchCategory(request, response);
			}
			else if(flag.equals("edit"))
			{	
				editCategory(request,response);
			}
			else if(flag.equals("delete"))
			{	
				deleteCategory(request,response);
				searchCategory(request, response);
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
			CategoryVO cv=new CategoryVO();
			cv.setCat_name(name);
			
			CategoryDAO cd=new CategoryDAO();
			List ls=cd.validate(cv);
			PrintWriter pw=response.getWriter();
			System.out.println("mmmmmmmmmmmmmmmmmmm"+ls.size());
			pw.write("<root>");
			if(ls.size()>=1)
			{
				/*System.out.println("already");
				pw.write("true");
				
			}
			else
			{
				System.out.println("no");
				pw.write("false");
			}*/
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
		
		private void deleteCategory(HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			int catid=Integer.parseInt(request.getParameter("categoryID"));
			CategoryVO v=new CategoryVO();
			v.setCat_id(catid);
			CategoryDAO d=new CategoryDAO();
			d.deleteCategory(v);
			
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			String flag=request.getParameter("flag");
			if(flag.equals("insertCategory"))
			{
				insertCategory(request,response);
			}
			else if(flag.equals("updateCategory"))
			{
				updateCategory(request, response);
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void insertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		

		
		String s = request.getParameter("catName");
		String s1 = request.getParameter("catDes");
		
		
		CategoryVO v=new CategoryVO();
		v.setCat_name(s);
		v.setCat_description(s1);
		
		CategoryDAO d=new CategoryDAO();
		
		d.insertCategory(v);
		response.sendRedirect("Admin/Form_AddCategory.jsp");

}
		
		protected void searchCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CategoryVO v1=new CategoryVO();
			
			CategoryDAO d1=new CategoryDAO();
			List ls=d1.search();

			HttpSession x = request.getSession();
			x.setAttribute("category_list",ls);

			response.sendRedirect("Admin/Form_SearchCategory.jsp");
			
		}
		protected void editCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int c = Integer.parseInt(request.getParameter("categoryID"));
			
			CategoryVO v2=new CategoryVO();
			v2.setCat_id(c);
			
			CategoryDAO d2=new CategoryDAO();
			List ls=d2.editCategory(v2);
			
			HttpSession session=request.getSession();
			session.setAttribute("category_list", ls);
			
			response.sendRedirect("Admin/Form_EditCategory.jsp");
		}

		protected void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		

			int c = Integer.parseInt(request.getParameter("categoryID"));
		String s = request.getParameter("categoryName");
		String s1 = request.getParameter("categoryDes");
		
		
		CategoryVO v=new CategoryVO();
		v.setCat_id(c);
		v.setCat_name(s);
		v.setCat_description(s1);
		
		CategoryDAO d=new CategoryDAO();
		
		d.updateCategory(v);
		
		searchCategory(request, response);

}
		
}