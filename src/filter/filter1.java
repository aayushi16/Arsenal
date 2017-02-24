package filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;

import DAO.CircularDAO;
import DAO.ComplaintDAO;
import DAO.GunallocationDAO;
import DAO.NewsDAO;
import DAO.UserDAO;
import DAO.UserDetailsDAO;
import VO.UserVO;

/**
 * Servlet Filter implementation class filter1
 */
@WebFilter("/*")
public class filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public filter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place     your code here
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String logout = request.getParameter("logout");
		String reg = request.getParameter("reg");
		String usertype=(String) session.getAttribute("usertype");
		
		System.out.println("registration flag===" + reg);
		//	int i = (Integer)session.getAttribute("userID");
		//System.out.println("id = = = = =" + i);
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		
		System.out.println("link =  = = = = " + uri);
		
		if(uri.contains("signup")||uri.contains("signin")||uri.contains("/css") || uri.contains("/js")&&!uri.contains("/jsp")|| uri.contains("/images")|| uri.contains("/fonts"))
		{
			System.out.println("inside reg");
			
			//requestDispatcher = request.getRequestDispatcher("/user/register.jsp");  
			//requestDispatcher.forward(request,response);  
			
			chain.doFilter(request,response);
			
		}
		
	else if (logout!= null) {
			//session.removeAttribute("userID");
			System.out.println("logout in else if");
		
			session.invalidate();
			System.out.println("after session invalidates");
			
			requestDispatcher = request.getRequestDispatcher("/Admin/signin.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("login") )
		{
			
			GunallocationDAO d11=new GunallocationDAO();
			List ls1=d11.searchPL();
			int temp=ls1.size();
			System.out.println("list msgGun"+temp);
			session.setAttribute("msgGun", temp);
			
			ComplaintDAO cd=new ComplaintDAO();
			List ls2=cd.search();
			int temp1=ls2.size();
			System.out.println("list complaint"+temp1);
			session.setAttribute("complaint", temp1);
			
			
			
			String userName = request.getParameter("uname");
			String password = request.getParameter("pass");
			System.out.println(userName+""+password);
			
			UserVO registrationMstVO = new UserVO();
			registrationMstVO.setUser_name(userName);
			registrationMstVO.setPassword(password);
			
			UserDAO registrationMstDAO = new UserDAO();
			List list =  registrationMstDAO.validate(registrationMstVO);
			
			if(list != null && list.size()>=1){
				
				Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				UserVO user=(UserVO) itr.next();
				
				int y = (Integer)user.getUser_id();
				session.setAttribute("userID",y);
				
				UserVO userVO = new UserVO();
				userVO.setUser_id(y);
				
				UserDetailsDAO detailsDAO = new UserDetailsDAO();
				List list2=detailsDAO.getUserName(userVO);
				
				session.setAttribute("userDetail", list2);
				
				System.out.println(user.getUser_post());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUser_post();
				session.setAttribute("usertype",type);
				System.out.println(y);
				if(type.equals("Officer"))
				{
				requestDispatcher = request.getRequestDispatcher("/Admin/officer.jsp");  
				requestDispatcher.forward(request,response);  
				}
				else if(type.equals("Soldier"))
				{
					CircularDAO c=new CircularDAO();
					List ls=c.searchcircular();
					session.setAttribute("searchcircular", ls);
					System.out.println("sizeeeeee"+ls.size());
					NewsDAO n=new NewsDAO();
					List lss=n.searchnews();
					session.setAttribute("searchnews", lss);
				requestDispatcher = request.getRequestDispatcher("/Admin/soldier.jsp");  
				requestDispatcher.forward(request,response);  
				}
				else if(type.equals("Admin"))
				{
					GunallocationDAO dao = new GunallocationDAO();
					List ls = dao.countGuns();
					
					session.setAttribute("gunCounts", ls);
					
				requestDispatcher = request.getRequestDispatcher("/Admin/index-2.jsp");  
				requestDispatcher.forward(request,response);  
				}
				else
				{
			
					GunallocationDAO d1=new GunallocationDAO();
					List ls=d1.searchPL();

					HttpSession x = ((HttpServletRequest) request).getSession();
					x.setAttribute("gunallocation_list",ls);
	
					
				requestDispatcher = request.getRequestDispatcher("/Admin/index-2.jsp");  
				requestDispatcher.forward(request,response);  
				}
				}
			
			else{
				 String error="Invalid Username and Password";
					session.setAttribute("error",error);
					
					requestDispatcher = request.getRequestDispatcher("/Admin/signin.jsp");  
					requestDispatcher.forward(request,response);  		
				}	
		}
		
		else if(usertype != null)
		{
			String type = (String ) session.getAttribute("usertype");
			if(type.equals("Officer"))
			{
				chain.doFilter(request, response);	
			}
			else if(type.equals("Soldier"))
			{
				chain.doFilter(request, response);
			}
			else if(type.equals("Admin"))
			{
				GunallocationDAO dao = new GunallocationDAO();
					List ls = dao.countGuns();
					
					session.setAttribute("gunCounts", ls);
					
				chain.doFilter(request, response);
			}
			
		//	chain.doFilter(request, response);
		}
		else{
			
		    requestDispatcher = request.getRequestDispatcher("/Admin/signin.jsp");
			requestDispatcher.forward(request, response);
			
			}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
