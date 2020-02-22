<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h1>Product Form Result</h1>
<ul>
    <c:forEach var="item" items="${products}">
        <li>${item.title}</li>
    </c:forEach>
</ul>
</body>
</html>

