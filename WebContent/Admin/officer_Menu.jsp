	<div class="leftpanel">
		<div class="logopanel">
			<h1>
				ARSENAL
			</h1>
		</div>
		<!-- logopanel -->
		<div class="leftpanelinner">
			<!-- This is only visible to small devices -->
			<div class="visible-xs hidden-sm hidden-md hidden-lg">
				<div class="media userlogged">
					<img alt="" src="<%=request.getContextPath() %>/Admin/images/photos/loggeduser.png" class="media-object">
					<div class="media-body">
						<h4>Aayushi</h4>
						<span>"Life is so..."</span>
					</div>
				</div>
				<h5 class="sidebartitle actitle">Account</h5>
				<ul class="nav nav-pills nav-stacked nav-bracket mb30">
					< <li><a href="profile.html"><i class="fa fa-user"></i> <span>Profile</span></a></li>
					<li><a href=""><i class="fa fa-cog"></i> <span>Account
								Settings</span></a></li>
					<li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
					<li><a href="signout.html"><i class="fa fa-sign-out"></i>
							<span>Sign Out</span></a></li>
				</ul>
			</div>
			<h5 class="sidebartitle">Navigation</h5>
			<ul class="nav nav-pills nav-stacked nav-bracket">
				<li class="active"><a
					href="<%=request.getContextPath()%>/Admin/officer.jsp"><i
						class="fa fa-home"></i> <span>Dashboard</span></a></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Category</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath()%>/CategoryController?flag=search"><i
								class="fa fa-caret-right"></i> Search Category</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage SubCategory</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath()%>/SubCategoryController?flag=search1"><i
								class="fa fa-caret-right"></i> Search SubCategory</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Users</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath()%>/UserController?flag=search2"><i
								class="fa fa-caret-right"></i> Search User</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage UserDetails</span></a>
					<ul class="children">
						<!--<li><a
							href="<%=request.getContextPath() %>/UserDetailsController?flag=loadUser"><i
								class="fa fa-caret-right"></i> Add UserDetails</a></li>-->
						<li><a
							href="<%=request.getContextPath()%>/UserDetailsController?flag=search3"><i
								class="fa fa-caret-right"></i> Search UserDetails</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Gun</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/GunController?flag=loadCategory"><i
								class="fa fa-caret-right"></i> Add Gun</a></li>
						<li><a
							href="<%=request.getContextPath()%>/GunController?flag=search4"><i
								class="fa fa-caret-right"></i> Search Gun</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Vehicle</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/VehicleController?flag=loadCategory"><i
								class="fa fa-caret-right"></i> Add Vehicle</a></li>
						<li><a href="<%=request.getContextPath()%>/VehicleController?flag=search5"><i
								class="fa fa-caret-right"></i> Search Vehicle</a></li>
					</ul></li>
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage GunBullet</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/GunBulletController?flag=loadGun"><i
								class="fa fa-caret-right"></i> Gun_Bullet Mapping</a></li>
						<li><a href="<%=request.getContextPath()%>/GunBulletController?flag=search6"><i
								class="fa fa-caret-right"></i> Search Gun Bullet</a></li>
					</ul></li>

			<!-- 	<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Attendance</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/AttendanceController?flag=loadUser"><i
								class="fa fa-caret-right"></i> Add Attendance</a></li>
						<li><a href="<%=request.getContextPath()%>/AttendanceController?flag=search7"><i
								class="fa fa-caret-right"></i> Search Attendance</a></li>
				     </ul></li>-->

					<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Stock</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/GunallocationController?flag=loadGun"><i
								class="fa fa-caret-right"></i> Gun Allocation</a></li>
						<li><a href="<%=request.getContextPath()%>/GunallocationController?flag=search11"><i
								class="fa fa-caret-right"></i> Search Gunallocated</a></li>
								
								<li><a href="<%=request.getContextPath()%>/GunallocationController?flag=searchPL"><i
								class="fa fa-caret-right"></i> Search Pending List</a></li>
								
								<li><a
							href="<%=request.getContextPath() %>/VehicleallocationController?flag=loadVehicle"><i
								class="fa fa-caret-right"></i> Vehicle Allocation</a></li>
								<li><a href="<%=request.getContextPath()%>/VehicleallocationController?flag=search12"><i
								class="fa fa-caret-right"></i> Search Vehicleallocated</a></li>
								</ul></li>


					
							<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						 <span>Manage Complaint</span>
						<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/ComplaintController?flag=loadUser"><i
								class="fa fa-caret-right"></i> Add Complaint</a></li>
						<li><a href="<%=request.getContextPath()%>/ComplaintController?flag=search14"><i
								class="fa fa-caret-right"></i> Search Complaint</a></li>
						</ul></li>
						
				<li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Maintenance</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/MaintenanceController?flag=loadUser"><i
								class="fa fa-caret-right"></i> Add Maintenance</a></li>
						<li><a href="<%=request.getContextPath()%>/MaintenanceController?flag=search13"><i
								class="fa fa-caret-right"></i> Search Maintenance</a></li>
					</ul></li>
						
						  <li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage Circulars</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/Admin/Circular.jsp"><i
								class="fa fa-caret-right"></i> Add Circulars</a></li>
						<li><a href="<%=request.getContextPath()%>/CircularController?flag=searchAS"><i
								class="fa fa-caret-right"></i>Search Circulars</a></li>
					</ul></li>
 					
 					  <li class="nav-parent"><a href=""><i class="fa fa-edit"></i>
						<span>Manage News</span></a>
					<ul class="children">
						<li><a
							href="<%=request.getContextPath() %>/Admin/News.jsp"><i
								class="fa fa-caret-right"></i> Add News</a></li>
						<li><a href="<%=request.getContextPath()%>/NewsController?flag=searchASS"><i
								class="fa fa-caret-right"></i>Search News</a></li>
					</ul></li>
			</ul>
			
			<div class="infosummary">
				<h5 class="sidebartitle"></h5>
				<ul>
					<li>
						<!--  <div class="datainfo">
							<span class="text-muted">Daily Traffic</span>
							<h4>630, 201</h4>
						</div>
						<div id="sidebar-chart" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Average Users</span>
							<h4>1, 332, 801</h4>
						</div>
						<div id="sidebar-chart2" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Disk Usage</span>
							<h4>82.2%</h4>
						</div>
						<div id="sidebar-chart3" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">CPU Usage</span>
							<h4>140.05 - 32</h4>
						</div>
						<div id="sidebar-chart4" class="chart"></div>
					</li>
					<li>
						<div class="datainfo">
							<span class="text-muted">Memory Usage</span>
							<h4>32.2%</h4>
						</div>
						<div id="sidebar-chart5" class="chart"></div>
					</li>-->
				</ul>
			</div>
			<!-- infosummary -->
		</div>
		<!-- leftpanelinner -->
	</div>