<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<div>
    <h2>Menu Item Search Results</h2>
</div>

<section>
    <c:choose>
        <c:when test="${empty restaurantResults}">
            <p>Your search returned no results.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Restaurant</th>
                    <th>Location</th>
                    <th>Phone Number</th>
                </tr>
                <c:forEach var="restaurant" items="${restaurantResults}">
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