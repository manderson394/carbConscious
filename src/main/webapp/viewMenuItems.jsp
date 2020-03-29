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
                    <th>Menu Item</th>
                    <th>Restaurant</th>
                    <th>Description</th>
                    <th>Carbohydrate Approximation</th>
                </tr>
                <c:forEach var="menuItem" items="${menuItemResults}">
                    <tr>
                        <td>${menuItem.name}</td>
                        <td>${menuItem.parentRestaurant.name}</td>
                        <td>${menuItem.description}</td>
                        <td>${menuItem.calculateAverageCarbohydratesEstimate}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</section>

<c:import url="footer.jsp"/>
</body>
</html>
