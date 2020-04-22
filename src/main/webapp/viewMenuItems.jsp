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
            <table id="menuItemResultsTable">
                <thead>
                    <tr>
                        <th hidden>Menu Item ID</th>
                        <th>Menu Item</th>
                        <th>Restaurant</th>
                        <th>Description</th>
                        <th>Carbohydrate Approximation</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="menuItem" items="${menuItemResults}">
                    <tr>
                        <td class="menu-item-id" hidden><c:out value="${menuItem.id}"/></td>
                        <td class="menu-item-name">${menuItem.name}</td>
                        <td class="menu-item-restaurant">${menuItem.parentRestaurant.name}</td>
                        <td class="menu-item-description">${menuItem.description}</td>
                        <td class="menu-item-estimate">${menuItem.calculateAverageCarbohydratesEstimate()}
                        <c:if test="${not empty sessionScope.userFirstName}">
                                <button class="btn add-Carb">
                                    <i class="fas fa-plus"></i> Add to Favorites
                                </button>
                                <button class="btn add-Favorite">
                                    <i class="fas fa-edit"></i> Add Carbohydrates Estimate
                                </button>
                        </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <script>
        $(document).ready(function () {
            $('#menuItemResultsTable').DataTable();
        });

        $('.btn').onclick(function () {
            var menuItemId = $(this).closest('tr').find('.menu-item-id').text();

            if ($(this).hasClass('add-Carb')) {
                $.get('${pageContext.request.contextPath}/', { rowMenuItemId : menuItemId } );
            }
            if ($(this).hasClass('add-Favorite')) {
                $.get('${pageContext.request.contextPath}/addFavorite', { rowMenuItemId : menuItemId } );
            }
        });
    </script>
</section>

<c:import url="footer.jsp"/>
</body>
</html>
