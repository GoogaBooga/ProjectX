<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
</head>
<body>
<div>
    <h1>Hello!</h1>
    <jsp:include page="WEB-INF/main.jsp">
        <jsp:param name="pageTitle" value="Main page"/>
    </jsp:include>
</div>
</body>
</html>