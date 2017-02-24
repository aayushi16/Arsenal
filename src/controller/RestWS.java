package CONTROLLER;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import DAO.CaseDAO;
import DAO.RegistrationDAO;
import Vo.Manage_case_vo;
import Vo.RegisterVo;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/androidx")
public class RestWS {
	
	@GET
	@Path("/register/{fname}/{lname}/{mno}")
	public String sayHelloStudent(@PathParam("fname")String fname,@PathParam("lname")String lname,@PathParam("mno")String mno){
		System.out.println(fname+" "+lname+" "+mno);
		
		RegisterVo registrationVO=new RegisterVo();
		registrationVO.setFname(fname);
		registrationVO.setLname(lname);
		registrationVO.setMobile(mno);
		
		RegistrationDAO registrationDAO = new RegistrationDAO();
		registrationDAO.insert(registrationVO);
		
		return "Your Rgestration Is Successfully Done";
	}
	
	@GET
	@Path("/latlang/{Phone}/{latitude}/{longitude}/{pincode}")
	public String sayHelloStudent1(@PathParam("Phone")String Phone,@PathParam("latitude")Double latitude,@PathParam("longitude")Double longitude,@PathParam("pincode")long pincode){
		System.out.println(Phone+" "+latitude+" "+longitude+" "+pincode);
		 
		 Manage_case_vo casevo =  new Manage_case_vo();
		 casevo.setLattitude(latitude);
		 casevo.setLongitude(longitude);
		 casevo.setPincode(String.valueOf(pincode));
		 casevo.setStatus("open");
		 RegistrationDAO registrationDAO=new RegistrationDAO();
		 List l=(List) registrationDAO.searchByPincode(Phone);
		 
		 Iterator i=l.iterator();
		 
		 RegisterVo registrationVO=new RegisterVo();
		 
		 registrationVO=(RegisterVo) i.next();
		 
		 casevo.setRegister(registrationVO);
		 
		 CaseDAO caseDAO = new CaseDAO();
		 caseDAO.insert(casevo);
		return "Your Message Is Successfully Send";
	}
	
}