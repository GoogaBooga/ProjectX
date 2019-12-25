<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="WEB-INF/common/header.jsp">
    <jsp:param name="pageTitle" value="Main page"/>
</jsp:include>
<div>
    <c:if test="${user != null}">
    Hello ${user}!
    </c:if>
    <c:if test="${user == null}">
        <a href="<c:url value="/controller?command=login"/>">Login page</a>
    </c:if>

    <form action="${pageContext.request.contextPath}/controller">
        <input name="command" type="hidden" value="login">
        <input name="login" type="text">
        <input name="password" type="password">
        <input type="submit" value="Login">
    </form>>

</div>
<jsp:include page="WEB-INF/common/footer.jsp"/>

