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

  <title>User Attendance</title>

  <link href="<%=request.getContextPath() %>/Admin/css/style.default.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->

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
          <li><a href="Form_ManageAttendance.jsp">Forms</a></li>
          <li class="active">User Attendance</li>
        </ol>
      </div>
    </div>
    
    <div class="contentpanel">
      
      <div class="row">
	 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <c:forEach items="${sessionScope.attendance_list}" var="i">        
        <div class="col-md-6">
           <form id="basicForm" action="<%=request.getContextPath() %>/AttendanceController" method="post" class="form-horizontal">
          <div class="panel panel-default">
              <div class="panel-heading">
                <div class="panel-btns">
                  <a href="#" class="panel-close">&times;</a>
                  <a href="#" class="minimize">&minus;</a>
                </div>
                <h4 class="panel-title">Manage Attendance</h4>
                <p>Please provide User Attendance Details</p>
              </div>
              <div class="panel-body">
              <div class="form-group">
                 <label class="col-sm-3 control-label">User</label>
                  <div class="col-sm-9">
                    <select id="user" name="user" data-placeholder="Choose One" title="Please select user" class="select2" required>
                      <option value="">Choose One</option>
                       <c:forEach items="${sessionScope.user_list}" var="k">
                      	<c:if test="${k.user_id eq i.userVO.user_id }">
                      	<option value="${k.user_id }" selected="selected">${k.user_name }</option>
                       </c:if>
                       <c:if test="${k.user_id ne i.userVO.user_id }">
                      	<option value="${k.user_id }">${k.user_name }</option>
                       </c:if>
                      </c:forEach>
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
              </div>
              <input type="hidden" name="flag" value="update">
                <div class="form-group">
                  <label class="col-sm-3 control-label">In-Time <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="intime" class="form-control" placeholder="Type In-time..." required="" value="${i.in_time}" />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Out-Time <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="outtime" class="form-control" placeholder="Type Out-time..." required="" value="${i.out_time}" />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Date <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="date" class="form-control" placeholder="Type Date..." required="" value="${i.date}" />
                  </div>
                </div>
                
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Details <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <textarea rows="5" name="details" class="form-control" placeholder="Write Details..." required="">${i.details}</textarea>
                  </div>
                </div>
                 <input type="hidden" name="attendanceID" value="${i.att_id }">   
              </div><!-- panel-body -->
              <div class="panel-footer">
                <div class="row">
                  <div class="col-sm-9 col-sm-offset-3">
                    <button class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                  </div>
                </div>
            </div>
          </div><!-- panel -->
          </form>
        </c:forEach>
        
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

<script src="js/custom.js"></script>

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