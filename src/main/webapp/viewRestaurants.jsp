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
        <c:when test="${empty menuItemResults}">
            <p>Your search returned no results.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Restaurant</th>
                    <th>Location</th>
                    <th>Phone Number</th>
                </tr>
                <c:forEach var="restaurant" items="${restaurantList}">
                    <tr>
                        <td>${restaurant.name}</td>
                        <td></td> <!--TODO Build out support for location-->
                        <td></td> <!--TODO Build out support for phone number-->
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</section>

<c:import url="footer.jsp"/>
</body>
</html>