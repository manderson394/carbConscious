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
            <table id="favoritesTable">
                <thead>
                    <tr>
                        <th>Menu Item</th>
                        <th>Description</th>
                        <th>Carbohydrates (approx.)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="favoriteEntry" items="${favoritesResults}">
                        <tr>
                            <td>${favoriteEntry.value.menuItem.name}</td>
                            <td>${favoriteEntry.value.menuItem.description}</td>
                            <td>${favoriteEntry.value.menuItem.calculateAverageCarbohydratesEstimate()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</section>

<script>
    $(document).ready(function () {
        $('#favoritesTable').DataTable();
    });
</script>

<c:import url="footer.jsp"/>
</body>
</html>