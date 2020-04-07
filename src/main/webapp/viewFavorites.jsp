<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<div>
    <h2>My Favorites</h2>
</div>

<section>
    <c:choose>
        <c:when test="${empty favoritesResults}">
            <p>You have no favorites. Use the Search Bar at the top to find some new favorites!</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Menu Item</th>
                    <th>Description</th>
                    <th>Carbohydrates (approx.)</th>
                </tr>
                <c:forEach var="favorite" items="${favoritesResults}">
                    <tr>
                        <td>${restaurant.name}</td>
                        <td>${restaurant.streetAddress}, ${restaurant.state} ${restaurant.zipCode}</td>
                        <td>${restaurant.phoneNumber}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</section>

<c:import url="footer.jsp"/>
</body>
</html>