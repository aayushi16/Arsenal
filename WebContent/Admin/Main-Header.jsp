<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<div class="headerbar">
		<a class="menutoggle"><i class="fa fa-bars"></i></a>
		<!--  <form class="searchform" action="index.html" method="post">
			  <input type="text" class="form-control" name="keyword"
				placeholder="Search here...">
		</form> -->
		<div class="header-right">
			<ul class="headermenu">
				<li>
					<!--  <div class="btn-group">
						<button class="btn btn-default dropdown-toggle tp-icon"
							data-toggle="dropdown">
							<i class="glyphicon glyphicon-user"></i> <span class="badge">2</span>
						</button>
						<div class="dropdown-menu dropdown-menu-head pull-right">
							<h5 class="title">2 Newly Registered Users</h5>
							<ul class="dropdown-list user-list">
								<li class="new">
									<div class="thumb">
										<a href=""><img src="<%=request.getContextPath() %>/Admin/images/photos/user1.png" alt=""></a>
									</div>
									<div class="desc">
										<h5>
											<a href="">Draniem Daamul (@draniem)</a> <span
												class="badge badge-success">new</span>
										</h5>
									</div>
								</li>
								<li class="new">
									<div class="thumb">
										<a href=""><img src="<%=request.getContextPath() %>/Admin/images/photos/user2.png" alt=""></a>
									</div>
									<div class="desc">
										<h5>
											<a href="">Zaham Sindilmaca (@zaham)</a> <span
												class="badge badge-success">new</span>
										</h5>
									</div>
								</li>
								<li>
									<div class="thumb">
										<a href=""><img src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" alt=""></a>
									</div>
									<div class="desc">
										<h5>
											<a href="">Weno Carasbong (@wenocar)</a>
										</h5>
									</div>
								</li>
								<li>
									<div class="thumb">
										<a href=""><img src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" alt=""></a>
									</div>
									<div class="desc">
										<h5>
											<a href="">Nusja Nawancali (@nusja)</a>
										</h5>
									</div>
								</li>
								<li>
									<div class="thumb">
										<a href=""><img src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" alt=""></a>
									</div>
									<div class="desc">
										<h5>
											<a href="">Lane Kitmari (@lane_kitmare)</a>
										</h5>
									</div>
								</li>
								<li class="new"><a href="">See All Users</a></li>
							</ul>
						</div>
					</div>
				</li> -->
				<li>
					<%-- <div class="btn-group">
					<a href="<%=request.getContextPath()%>/GunallocationController?flag=searchPL">
					<button 
							data-toggle="dropdown"></button></a>
							<i class="glyphicon glyphicon-envelope" >	</i> <span class="badge">${sessionScope.msgGun}</span>
						
						<div class="dropdown-menu dropdown-menu-head pull-right">
							<h5 class="title">You Have 1 New Message</h5>
							<ul class="dropdown-list gen-list">
							<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
							<c:forEach items="${sessionScope.gunallocation_list}" var="i">
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user1.png" alt=""></span> <span
										class="desc"> <span class="name">${i.userVO.user_name }
												<span class="badge badge-success">new</span>
										</span> <span class="msg">Lorem ipsum dolor sit amet...</span>
									</span>
								</a></li>
								</c:forEach>
							</ul>
						</div>
					</div> --%>
					<div class="btn-group">
              <a href="<%=request.getContextPath()%>/GunallocationController?flag=searchPL"><button class="btn btn-default dropdown-toggle tp-icon">
                <i class="glyphicon glyphicon-envelope"></i>
                <span class="badge">${sessionScope.msgGun}</span>
              </button></a>
            </div>
				</li> 	
				
				
				<li>
				 <div class="btn-group">
				         <a href="<%=request.getContextPath()%>/ComplaintController?flag=search14">
						<button class="btn btn-default dropdown-toggle tp-icon">		
						<i class="glyphicon glyphicon-globe"></i> <span class="badge">${sessionScope.complaint }</span>
						</button></a>
						</div>
						</li>
						<!--	<div class="dropdown-menu dropdown-menu-head pull-right">
							<h5 class="title">You Have 5 New Notifications</h5>
							<ul class="dropdown-list gen-list">
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user4.png" alt=""></span> <span
										class="desc"> <span class="name">Zaham
												Sindilmaca <span class="badge badge-success">new</span>
										</span> <span class="msg">is now following you</span>
									</span>
								</a></li>
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user5.png" alt=""></span> <span
										class="desc"> <span class="name">Weno Carasbong
												<span class="badge badge-success">new</span>
										</span> <span class="msg">is now following you</span>
									</span>
								</a></li>
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" alt=""></span> <span
										class="desc"> <span class="name">Veno Leongal <span
												class="badge badge-success">new</span></span> <span class="msg">likes
												your recent status</span>
									</span>
								</a></li>
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" alt=""></span> <span
										class="desc"> <span class="name">Nusja Nawancali
												<span class="badge badge-success">new</span>
										</span> <span class="msg">downloaded your work</span>
									</span>
								</a></li>
								<li class="new"><a href=""> <span class="thumb"><img
											src="<%=request.getContextPath() %>/Admin/images/photos/user3.png" alt=""></span> <span
										class="desc"> <span class="name">Nusja Nawancali
												<span class="badge badge-success">new</span>
										</span> <span class="msg">send you 2 messages</span>
									</span>
								</a></li>
								<li class="new"><a href="">See All Notifications</a></li>
							</ul>
						</div>
					</div>
				</li>-->
				<li>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							<c:if test="${sessionScope.usertype ne 'Admin' }">
							<c:forEach items="${sessionScope.userDetail }" var="i">
									<img src="<%=request.getContextPath() %>/Admin/images/photos/loggeduser.png" alt=""> ${i.first_name }&nbsp;${i.last_name } <span
									class="caret"></span>
							</c:forEach>
							</c:if>
								<c:if test="${sessionScope.usertype eq 'Admin' }">
									<img src="<%=request.getContextPath() %>/Admin/images/photos/loggeduser.png" alt=""> Admin <span
									class="caret"></span>
								</c:if>
						</button>
						<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
							<!--  <li><a href="profile.html"><i
									class="glyphicon glyphicon-user"></i> My Profile</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
									Account Settings</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-question-sign"></i> Help</a></li>-->
							<li><a href="<%=request.getContextPath()%>/?logout=logout"><i
									class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
						</ul>
					</div>
				</li>
				<!--  <li>
					<button id="chatview" class="btn btn-default tp-icon chat-icon">
						<i class="glyphicon glyphicon-comment"></i>
					</button>
				</li>-->
			</ul>
		</div>
		<!-- header-right -->
	</div>