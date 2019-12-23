<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp">
    <jsp:param name="pageTitle" value="Main page"/>
</jsp:include>
<div>
    <c:if test="${user != null}">
    Hello ${user}!
    </c:if>
    <c:if test="${user == null}">
        Hello buddy!
    </c:if>

    <form action="${pageContext.request.contextPath}/controller">
        <input name="command" type="hidden" value="login">
        <input name="login" type="text">
        <input name="password" type="password">
        <input type="submit" value="Login">
    </form>>

</div>
<jsp:include page="common/footer.jsp"/>

