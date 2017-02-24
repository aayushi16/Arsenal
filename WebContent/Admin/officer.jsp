<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/Admin/images/favicon.png" type="image/png">

  <title>Arsenal</title>

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
  
  <jsp:include page="officer_Menu.jsp"></jsp:include>
  <div class="mainpanel">
    
    <jsp:include page="Main-Header.jsp"></jsp:include>
    
    <div class="pageheader">
      <h2><i class="fa fa-home"></i> Dashboard <span></span></h2>
      <div class="breadcrumb-wrapper">
        <span class="label">You are here:</span>
        <ol class="breadcrumb">
          <li><a href="index-2.html">Arsenal</a></li>
          <li class="active">Dashboard</li>
        </ol>
      </div>
    </div>
    <iframe src="Admin/map.jsp" height="500px" width="900px"></iframe>
</div>
</section>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-ui-1.10.3.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/toggles.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/retina.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.cookies.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/flot/jquery.flot.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/flot/jquery.flot.resize.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/flot/jquery.flot.spline.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/morris.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/raphael-2.1.0.min.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/custom.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/dashboard.js"></script>

</body>

<!-- Mirrored from themepixels.com/demo/webpage/bracket/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 05 Oct 2014 06:24:46 GMT -->
</html>
