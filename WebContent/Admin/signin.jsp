<!DOCTYPE html>
<html lang="en">


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/Admin/images/favicon.png" type="image/png">

  <title>ARSENAL</title>

  <link href="<%=request.getContextPath() %>/Admin/css/style.default.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="<%=request.getContextPath() %>/Admin/js/html5shiv.js"></script>
  <script src="<%=request.getContextPath() %>/Admin/js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="signin">


<section>
  
    <div class="signinpanel">
        
        <div class="row">
            
            <div class="col-md-7">
                
                <div class="signin-info">
                    <div class="logopanel">
                        <h1>[ ARSENAL ]</h1>
                    </div><!-- logopanel -->
                
                    <div class="mb20"></div>
                
                    <h3><strong>Welcome to ARSENAL</strong></h3>
                    <ul>
                       <!--  <li><i class="fa fa-arrow-circle-o-right mr5"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> </li> -->
                    </ul>
                    <div class="mb20"></div>
                   
                </div><!-- signin0-info -->
            
            </div><!-- col-sm-7 -->
            
            <div class="col-md-5">
                	
                <form method="post" action="<%=request.getContextPath()%>/">
                    <h4 class="nomargin">Sign In</h4>
                    <p class="mt5 mb20">Login to access your account.</p>
                
                    <input type="text" class="form-control uname" placeholder="Username" required="required" name="uname"/>
                    <input type="password" class="form-control pword" placeholder="Password" required="required" name="pass"/>
                    <a href="#"><small></small></a>
                    
                   <%String error1=(String)session.getAttribute("error");
                        if(error1!=null){
                        out.println(error1);
                        session.removeAttribute(error1);}%>
                    <input type="hidden" name="flag" value="login">
                    <button class="btn btn-success btn-block">Sign In</button>
                    
                </form>
            </div><!-- col-sm-5 -->
            
        </div><!-- row -->
        
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2014. All Rights Reserved. ARSENAL
            </div>
            <div class="pull-right">
                Created By: <a href="../../../index.html" target="_blank">PLANET RING</a>
            </div>
        </div>
        
    </div><!-- signin -->
  
</section>


<script src="<%=request.getContextPath() %>/Admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.cookies.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/toggles.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/retina.min.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/custom.js"></script>
<script>
    jQuery(document).ready(function(){
        
        // Please do not use the code below
        // This is for demo purposes only
        var c = jQuery.cookie('change-skin');
        if (c && c == 'greyjoy') {
            jQuery('.btn-success').addClass('btn-orange').removeClass('btn-success');
        } else if(c && c == 'dodgerblue') {
            jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
        } else if (c && c == 'katniss') {
            jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
        }
    });
</script>

</body>

<!-- Mirrored from themepixels.com/demo/webpage/bracket/signin.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 05 Oct 2014 06:25:52 GMT -->
</html>
