<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set scope="request" var="title" value="Carb Conscious: Login Error"/>
    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <div class="text-center">
            <h1 class="h2">Login failed.</h1>
            <button class="btn">
                <a class="btn" href="login">Please try again.</a>
            </button>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
