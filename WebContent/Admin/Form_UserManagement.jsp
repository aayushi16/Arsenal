<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/Admin/images/favicon.png" type="image/png">

  <title>Manage User</title>

  <link href="<%=request.getContextPath() %>/Admin/css/style.default.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
<script type="text/javascript">
  var flaginsert= false;
function check()
{
	
		var a=document.getElementById("userNo").value.trim();
	/* if(a=="")
		{
		alert("please enter username");
		document.basicForm.userName.focus();
		flaginsert = false;
		}
	else 
		{
		 */
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function()
		{
			if(xmlhttp.readyState==4)
				{
		
				var xml = xmlhttp.responseXML;
				//var jsonObj=JSON.parse(xmlhttp.responseText);
				//alert("ggggggggggggggggg"+xml=="0");
				
				var flag =  xml.documentElement.getElementsByTagName("flag");//jsonObj[0].flag;
				var x =flag[0].firstChild.nodeValue;
			//	alert("dddddddddddddd"+x);
				if(flag[0].firstChild.nodeValue=="true")
					{
					//alert("sdfsd")
						flaginsert= true;
						//alert(flaginsert)
					}
					else
						{
							document.getElementById("userNo").value="";
							alert("Already Assigned User Number ")
							document.basicForm.userNo.focus();
							flaginsert= false;
						}
					
				}
			
			
			
		}
		xmlhttp.open("get","${pageContext.request.contextPath}/UserDetailsController?flag=validate&name="+a,true);
		xmlhttp.send();
		
		return flaginsert;
		
}

</script>
</head>
<body>
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>
  
  <jsp:include page="Main-menu.jsp"></jsp:include>
  <div class="mainpanel">
    
   <c:if test="${sessionScope.usertype eq 'Soldier' }">
    
    <jsp:include page="Sol_Header.jsp"></jsp:include>
</c:if>

 <c:if test="${sessionScope.usertype eq 'Admin' }">
    
    <jsp:include page="Main-Header.jsp"></jsp:include>
</c:if>

<c:if test="${sessionScope.usertype eq 'Officer' }">
    
    <jsp:include page="Main-Header.jsp"></jsp:include>
</c:if>

   
    <div class="pageheader">
      <h2><i class="fa fa-pencil"></i> Forms </h2>
      <div class="breadcrumb-wrapper">
        <span class="label">You are here:</span>
        <ol class="breadcrumb">
          <li><a href="index-2.jsp">Arsenal</a></li>
          <li><a href="Form_UserManagement.jsp">Forms</a></li>
          <li class="active">Manage User</li>
        </ol>
      </div>
    </div>
    
    <div class="contentpanel">
      
      <div class="row">
        
        <div class="col-md-6">
          <form id="basicForm" action="<%=request.getContextPath()%>/UserDetailsController" method="post" "form-horizontal">
          <div class="panel panel-default">
              <div class="panel-heading">
                <div class="panel-btns">
                  <a href="#" class="panel-close">&times;</a>
                  <a href="#" class="minimize">&minus;</a>
                </div>
                <h4 class="panel-title">Register</h4>
                <p>Please provide User Details</p>
              </div>
              <div class="panel-body">
              
<!--                  <div class="form-group">
                  <label class="col-sm-3 control-label">User</label>
                  <div class="col-sm-9">
               <select id="user" name="user" data-placeholder="Choose One" title="Please select user" class="select2" required>
                      <option value="">Choose One</option>
                       <c:forEach items="${sessionScope.user_list}" var="i">
                      	<option value="${i.user_id }">${i.user_name }</option>
                      </c:forEach>
                      
                    </select>
                    </div>
                    </div>-->
               	<input type="hidden" name="flag" value="insertUserDetails"> 
                <div class="form-group">
                  <label class="col-sm-3 control-label">User Number <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="userNo" id="userNo" class="form-control" placeholder="Type User Number..." required  onblur="check()"/>
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Firstname <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="fname" class="form-control" placeholder="Type Firstname..." required />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Lastname <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="lname" class="form-control" placeholder="Type Lastname..." required />
                  </div>
                </div>

				<div class="form-group">
                  <label class="col-sm-3 control-label">Address <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="address" class="form-control" placeholder="Type User Address..." required />
                  </div>
                </div>

				<div class="form-group">
                  <label class="col-sm-3 control-label">Additional Address <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="address1" class="form-control" placeholder="Type Additional Address..." required />
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-sm-3 control-label">Contact <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="contact" class="form-control" placeholder="Type Contact Number..." required />
                  </div>
                </div>
                
                  <div class="form-group">
                  <label class="col-sm-3 control-label">Email <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="email" name="email" class="form-control" placeholder="Type your email..." required />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Post <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="post" class="form-control" placeholder="Type User Post..." required />
                  </div>
                </div>
          
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Gun Number <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="gunNO" class="form-control" placeholder="Type User Gun number..." required />
                  </div>
                </div>
                
              </div><!-- panel-body -->
              <div class="panel-footer">
                <div class="row">
                  <div class="col-sm-9 col-sm-offset-3">
                    <button class="btn btn-primary">Register</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                  </div>
                </div>
              </div>
            
          </div><!-- panel -->
          </form>
          
          
        </div><!-- col-md-6 -->
        
              
      
    </div><!-- contentpanel -->
    
  </div><!-- mainpanel -->
   
</section>

<script src="<%=request.getContextPath() %>/Admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/toggles.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/retina.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.cookies.js"></script>


<script src="<%=request.getContextPath() %>/Admin/js/select2.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.validate.min.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/custom.js"></script>

<script>
jQuery(document).ready(function(){
    
    "use strict";
    
    // Select2
  jQuery(".select2").select2({
    width: '100%',
    minimumResultsForSearch: -1
  });
  
  // Basic Form
  jQuery("#basicForm").validate({
    highlight: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-error');
    }
  });
  
  // Error Message In One Container
  jQuery("#basicForm2").validate({
	 errorLabelContainer: jQuery("#basicForm2 div.error")
  });
  
  // With Checkboxes and Radio Buttons
  jQuery("#basicForm3").validate({
    highlight: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-error');
    }
  });
  
  // Validation with select boxes
  jQuery("#basicForm4").validate({
    highlight: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function(element) {
      jQuery(element).closest('.form-group').removeClass('has-error');
    }
  });
  
  
});
</script>
</body>
</html>