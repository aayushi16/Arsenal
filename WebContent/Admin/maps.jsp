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
  <link href="<%=request.getContextPath() %>/Admin/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">

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
      <h2><i class="fa fa-map-marker"></i> Maps <span></span></h2>
      <div class="breadcrumb-wrapper">
        <span class="label">You are here:</span>
        <ol class="breadcrumb">
          <li><a href="index-2.jsp">Arsenal</a></li>
          <li class="active">Maps</li>
        </ol>
      </div>
    </div>
    
    <div class="contentpanel">
        
       <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">Google Maps</h4>
            <p><a href="../../../../hpneo.github.io/gmaps/index.html" target="_blank">gmaps.js</a> allows you to use the potential of Google Maps in a simple way.</p>
        </div><!-- panel-heading -->
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <h5 class="subtitle">Basic Map</h5>
                    <p>Some basic example of using google maps with latitude and longitude defined.</p>
                    <div id="gmap" style="height: 300px"></div>
                </div><!-- col-md-6 -->
                <div class="col-md-6">
                    <h5 class="subtitle">Map With Marker</h5>
                    <p>Some example of using google maps with markers enabled</p>
                    <div id="gmap-marker" style="height: 300px"></div>
                </div><!-- col-md-6 -->
            </div><!-- row -->
        </div><!-- panel-body -->
        </div><!-- panel -->   
        
      <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">jVectorMap</h4>
            <p><a href="../../../../jvectormap.com/index.html" target="_blank">jVectorMap</a> uses only native browser technologies like JavaScript, CSS, HTML, SVG or VML. No Flash or any other proprietary browser plug-in is required.</p>
        </div><!-- panel-heading -->
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <h5 class="subtitle">World Map</h5>
                    <p>Some basic example of using vector map displaying the map of the world.</p>
                    <div id="vectormap-world" style="height: 300px"></div>
                </div><!-- col-md-6 -->
                <div class="col-md-6">
                    <h5 class="subtitle">Map By Country</h5>
                    <p>Below is an example of vector map that display only by country (ie United States)</p>
                    <div id="vectormap-country" style="height: 300px"></div>
                </div><!-- col-md-6 -->
            </div><!-- row -->
        </div><!-- panel-body -->
    </div><!-- panel -->
        
  </div><!-- mainpanel -->
  
  <div class="rightpanel">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs nav-justified">
        <li class="active"><a href="#rp-alluser" data-toggle="tab"><i class="fa fa-users"></i></a></li>
        <li><a href="#rp-favorites" data-toggle="tab"><i class="fa fa-heart"></i></a></li>
        <li><a href="#rp-history" data-toggle="tab"><i class="fa fa-clock-o"></i></a></li>
        <li><a href="#rp-settings" data-toggle="tab"><i class="fa fa-gear"></i></a></li>
    </ul>
        
    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane active" id="rp-alluser">
            <h5 class="sidebartitle">Online Users</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/userprofile.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user1.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <span class="pull-right badge badge-danger">2</span>
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
            
            <div class="mb30"></div>
            
            <h5 class="sidebartitle">Offline Users</h5>
            <ul class="chatuserlist">
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane" id="rp-favorites">
            <h5 class="sidebartitle">Favorites</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user1.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane" id="rp-history">
            <h5 class="sidebartitle">History</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Hi hello, ctc?... would you mind if I go to your...</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>This is to inform you that your product that we...</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Are you willing to have a long term relat...</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane pane-settings" id="rp-settings">
            
            <h5 class="sidebartitle mb20">Settings</h5>
            <div class="form-group">
                <label class="col-xs-8 control-label">Show Offline Users</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-xs-8 control-label">Enable History</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-xs-8 control-label">Show Full Name</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle-chat1 toggle-success"></div>
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-xs-8 control-label">Show Location</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>
            
        </div><!-- tab-pane -->
        
    </div><!-- tab-content -->
  </div><!-- rightpanel -->
  </div>
  
</section>


<script src="<%=request.getContextPath() %>/Admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/toggles.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/retina.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery.cookies.js"></script>


<script src="<%=request.getContextPath() %>/Admin/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="<%=request.getContextPath() %>/Admin/js/jquery-jvectormap-us-aea-en.js"></script>

<script src="../../../../maps.google.com/maps/api/jsae28?sensor=true"></script>
<script src="<%=request.getContextPath() %>/Admin/js/gmaps.js"></script>

<script src="<%=request.getContextPath() %>/Admin/js/custom.js"></script>
<script>
    jQuery(document).ready(function(){
        
        "use strict";
        
        new GMaps({
            div: '#gmap',
            lat: -12.043333,
            lng: -77.028333
        });
        
        var map_marker = new GMaps({
            div: '#gmap-marker',
            lat: -12.043333,
            lng: -77.028333
        });
        
        map_marker.addMarker({
            lat: -12.043333,
            lng: -77.028333,
            click: function(e) {
              alert('You clicked in this marker');
            }
        });
        
        jQuery('#vectormap-world').vectorMap({
            map: 'world_mill_en',
            regionStyle: {
                initial: {
                    fill: '#a5a7aa'
                },
                hover: {
                    fill: '#6e7072'
                }     
            },
            backgroundColor: '#fcfcfc'
        });
        
        jQuery('#vectormap-country').vectorMap({
            map: 'us_aea_en',
            regionStyle: {
                initial: {
                    fill: '#a5a7aa'
                },
                hover: {
                    fill: '#6e7072'
                }     
            },
            backgroundColor: '#fcfcfc'
        });
        
    });
</script>

</body>


</html>
