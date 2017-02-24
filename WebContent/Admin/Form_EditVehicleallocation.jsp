<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/Admin/images/favicon.png" type="image/png">

  <title>Vehicle Allocation</title>

  <link href="<%=request.getContextPath() %>/Admin/css/style.default.css" rel="stylesheet">
   <link rel="stylesheet" href="<%=request.getContextPath() %>/Admin/css/bootstrap-fileupload.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/Admin/css/bootstrap-timepicker.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/Admin/css/jquery.tagsinput.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/Admin/css/colorpicker.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/Admin/css/dropzone.css">

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
          <li><a href="Form_VehicleAllocation.jsp">Forms</a></li>
          <li class="active">Vehicle Allocation</li>
        </ol>
      </div>
    </div>
    
    <div class="contentpanel">
      
      <div class="row">
        
        <div class="col-md-6">
         <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <c:forEach items="${sessionScope.vehicleallocation_list}" var="i">
          <form id="basicForm" action="<%=request.getContextPath() %>/VehicleallocationController" method="post" class="form-horizontal">
          <div class="panel panel-default">
              <div class="panel-heading">
                <div class="panel-btns">
                  <a href="#" class="panel-close">&times;</a>
                  <a href="#" class="minimize">&minus;</a>
                </div>
                <h4 class="panel-title">Vehicle Allocation</h4>
                <p>Please provide Vehicle Allocation Details</p>
              </div>
              <div class="panel-body">
              
               <!-- <div class="form-group">
                  <label class="col-sm-3 control-label">From Officer</label>
                  <div class="col-sm-9">
                    <select id="user" name="user" data-placeholder="Choose One" title="Please select user" class="select2" required>
                      <option value="">Choose One</option>
                       <c:forEach items="${sessionScope.user_list}" var="j">
                       <c:if test="${j.user_id eq i.userVO.user_id }">
                      	<option value="${j.user_id }" selected="selected">${j.user_name }</option>
                       </c:if>
                       <c:if test="${j.user_id ne i.userVO.user_id }">
                      	<option value="${j.user_id }">${j.user_name }</option>
                       </c:if>
                      </c:forEach>
                      
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
                </div>-->
        
              <div class="form-group">
                  <label class="col-sm-3 control-label">To Soldier</label>
                  <div class="col-sm-9">
                     <select id="user" name="user" data-placeholder="Choose One" title="Please select user" class="select2" required>
                      <option value="">Choose One</option>
                       <c:forEach items="${sessionScope.user_list}" var="j">
                       <c:if test="${j.user_id eq i.userVO.user_id }">
                      	<option value="${j.user_id }" selected="selected">${j.user_name }</option>
                       </c:if>
                       <c:if test="${j.user_id ne i.userVO.user_id }">
                      	<option value="${j.user_id }">${j.user_name }</option>
                       </c:if>
                      </c:forEach>
                      
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Vehicle</label>
                  <div class="col-sm-9">
                   <select id="vehicle" name="vehicle" data-placeholder="Choose One" title="Please select vehicle" class="select2" required>
                      <option value="">Choose One</option>
                       <c:forEach items="${sessionScope.vehicle_list}" var="k">
                       <c:if test="${k.vehicle_id eq i.vehicleVO.vehicle_id }">
                      	<option value="${k.vehicle_id }" selected="selected">${k.vehicle_name }</option>
                       </c:if>
                       <c:if test="${k.vehicle_id ne i.vehicleVO.vehicle_id }">
                      	<option value="${k.vehicle_id }">${k.vehicle_name }</option>
                       </c:if>
                      </c:forEach>
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
                </div>
              
                <input type="hidden" name="flag" value="update">
                <div class="form-group">
                  <label class="col-sm-3 control-label">Quantity <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="quantity" class="form-control" placeholder="Type Quantity..." requiredd="" value="${i.quantity}" />
                  </div>
                </div>
                
                 <div class="form-group">
                  <label class="col-sm-3 control-label">Assign Time <span class="asterisk">*</span></label>
                   <div class="input-group mb15">
                <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                <div class="bootstrap-timepicker"><input name="tp" id="timepicker" type="text" class="form-control" value="${i.assign_time}"></div>
              </div>
                </div>
                
                 <div class="form-group">
                  <label class="col-sm-3 control-label">Retrieve Time <span class="asterisk">*</span></label>
                 <div class="input-group mb15">
                <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                <div class="bootstrap-timepicker"><input name="rp" id="timepicker_1" type="text" class="form-control" value="${i.retrieve_time}"></div>
              </div>
                </div>
                
                 <div class="form-group">
                  <label class="col-sm-3 control-label">Assign Status</label>
                  <div class="col-sm-9">
                    <select id="status" name="as" data-placeholder="Choose One" title="Please select Status" class="select2" required="" />
                       <c:if test="${i.assign_status eq 'true' }">
                      	<option value="true" selected="selected">True</option>
                      	<option value="false">False</option>
                       </c:if>
                       <c:if test="${i.assign_status eq 'false' }">
                       <option value="true">True</option>
                      	<option value="false" selected="selected">False</option>
                       </c:if>
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
                </div>
                
                 <div class="form-group">
                  <label class="col-sm-3 control-label">Return Status<span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                   <select id="status" name="rs" data-placeholder="Choose One" title="Please select Status" class="select2" required="">
                       <c:if test="${i.return_status eq 'true' }">
                      	<option value="true" selected="selected">True</option>
                      	<option value="false">False</option>
                       </c:if>
                       <c:if test="${i.return_status eq 'false' }">
                       <option value="true">True</option>
                      	<option value="false" selected="selected">False</option>
                       </c:if>
                    </select>
                    <label class="error" for="flowers"></label>
                  </div>
                </div>
                
                <div class="form-group">
               <label class="col-sm-3 control-label">Gasoline Required <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="gas" class="form-control" placeholder="Type litres of Gasoline Required..." required="" value="${i.gasoline}" />
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-3 control-label">Kilometres Travelled <span class="asterisk">*</span></label>
                  <div class="col-sm-9">
                    <input type="text" name="km" class="form-control" placeholder="Type Travelled Kilometres..." required="" value="${i.kilometer}" />
                  </div>
                </div>
                
                <input type="hidden" name="stock2ID" value="${i.stock2_id }">
              </div><!-- panel-body -->
              <div class="panel-footer">
                <div class="row">
                  <div class="col-sm-9 col-sm-offset-3">
                    <button class="btn btn-primary">Submit</button>
                  <!--   <button type="reset" class="btn btn-default">Reset</button>-->
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

<script src="<%=request.getContextPath() %>/Admin/js/custom.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/jquery.autogrow-textarea.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap-fileupload.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap-timepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.tagsinput.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.mousewheel.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/dropzone.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/colorpicker.js"></script>

 
 
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
jQuery(document).ready(function(){
    
  // Chosen Select
  jQuery(".chosen-select").chosen({'width':'100%','white-space':'nowrap'});
  
  // Tags Input
  jQuery('#tags').tagsInput({width:'auto'});
   
  // Textarea Autogrow
  jQuery('#autoResizeTA').autogrow();
  
  // Color Picker
  if(jQuery('#colorpicker').length > 0) {
	 jQuery('#colorSelector').ColorPicker({
			onShow: function (colpkr) {
				jQuery(colpkr).fadeIn(500);
				return false;
			},
			onHide: function (colpkr) {
				jQuery(colpkr).fadeOut(500);
				return false;
			},
			onChange: function (hsb, hex, rgb) {
				jQuery('#colorSelector span').css('backgroundColor', '#' + hex);
				jQuery('#colorpicker').val('#'+hex);
			}
	 });
  }
  
  // Color Picker Flat Mode
	jQuery('#colorpickerholder').ColorPicker({
		flat: true,
		onChange: function (hsb, hex, rgb) {
			jQuery('#colorpicker3').val('#'+hex);
		}
	});
   
  // Date Picker
 /*  jQuery('#datepicker').datepicker();
  
  jQuery('#datepicker-inline').datepicker();
  
  jQuery('#datepicker-multiple').datepicker({
    numberOfMonths: 3,
    showButtonPanel: true
  });
  
  // Spinner
  var spinner = jQuery('#spinner').spinner();
  spinner.spinner('value', 0);
  
  // Input Masks
  jQuery("#date").mask("99/99/9999");
  jQuery("#phone").mask("(999) 999-9999");
  jQuery("#ssn").mask("999-99-9999");
 */  
  // Time Picker
  jQuery('#timepicker').timepicker({defaultTIme: false});
 jQuery('#timepicker_1').timepicker({defaultTIme: false});
 jQuery('#timepicker2').timepicker({showMeridian: false});
  jQuery('#timepicker3').timepicker({minuteStep: 15});

  
});
</script>
</body>
</html>