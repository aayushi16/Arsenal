<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<c:if test="${sessionScope.usertype eq 'Admin' }">
		<jsp:include page="admin_menu.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.usertype eq 'Officer'}">
		<jsp:include page="officer_Menu.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.usertype eq 'Soldier'}">
		<jsp:include page="soldier_menu.jsp"></jsp:include>
	</c:if>