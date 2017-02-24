<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/Admin/images/favicon.png" type="image/png">

  <title>User Login</title>

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
	
		var a=document.getElementById("userName").value.trim();
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
							document.getElementById("userName").value="";
							alert("Already Assigned Username ")
							document.basicForm.userName.focus();
							flaginsert= false;
						}
					
				}
			
			
			
		}
		xmlhttp.open("get","${pageContext.request.contextPath}/UserController?flag=validate&name="+a,true);
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
    
    <jsp:include page="Main-Header.jsp"></jsp:include>
  
    <div class="pageheader">
      <h2><i class="fa fa-pencil"></i> Forms </h2>
      <div class="breadcrumb-wrapper">
        <span class="label">You are here:</span>
        <ol class="breadcrumb">
          <li><a href="index-2.jsp">Arsenal</a></li>
          <li><a href="Form_User.jsp">Forms</a></li>
          <li class="active">User Login</li>
        </ol>
      </div>
    </div>
    
    <div class="contentpanel">
      
      <div class="row">
        
        <div class="col-md-6">
          <form name="basicForm" action="<%=request.getContextPath() %>/UserController" onsubmit="return CheckPassword()" class="form-horizontal" method="post">
          <div class="panel panel-default">
              <div class="panel-heading">
                <div class="panel-btns">
                  <a href="#" class="panel-close">&times;</a>
                  <a href="#" class="minimize">&minus;</a>
                </div>
                <h4 class="panel-title">User Login</h4>
                <p>Please provide User Login Details.</p>
              </div>
              <div class="panel-body">
                
			<input type="hidden" name="flag" value="insertUser">	              
                <div class="form-group">
                  <label class="col-sm-3 control-label">Username <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="userName" id="userName" class="form-control" placeholder="Type Username..." required  onblur="check()" />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Password <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="password" id="txtpassword" name="Password" class="form-control" placeholder="Type Password..." required />
                    <span style="color:#636e7b">[Use One UpperCase; Use One LowerCase;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Use One Numeric Digit; Min 6 to 20 Characters ]
                  </span>
                  </div>
                  </div>
                  
                  <div class="form-group">
                  <label class="col-sm-3 control-label">Email <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="email" name="email" id="email" class="form-control" placeholder="Type Email_ID..." required />
                  </div>
                </div>
                    
                <div class="form-group">
                  <label class="col-sm-3 control-label">Status <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <textarea rows="5" name="status" class="form-control" placeholder="Write Status..." required></textarea>
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">User Post <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="Post" class="form-control" placeholder="Type User Post..." required />
                  </div>
                </div>
                
                
                
              </div><!-- panel-body -->
              <div class="panel-footer">
                <div class="row">
                  <div class="col-sm-9 col-sm-offset-3">
                    <input type="submit" class="btn btn-primary" value="Submit"/>
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
<script>
function CheckPassword()   
{   
	var inputtxt = document.getElementById("txtpassword");
var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;  
if(inputtxt.value.match(passw))   
{   
//alert('Correct, try another...')
 //var x =check();
//alert("ffffffffffffffff "+x);
//alert("flaginsert value"+flaginsert);
 /* if(flaginsert)
	{
	//alert("sdfsdfds jj");
	document.basicForm.submit();
	
	}
else{
	return false;
	alert("wrong");
} 	 */
  
}
else  
{   
alert('INVALID PASSWORD! Please enter atleast one Uppercase, Lowercase And Numeric Digit');
document.getElementById("txtpassword").value="";
document.basicForm.Password.focus();
return false;     
}
} 
</script>
</body>
</html>