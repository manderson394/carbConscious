<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<div>
    <h2 class="page-title pb-5">Menu Item Search Results</h2>
</div>

<section class="container-fluid">
    <c:choose>
        <c:when test="${empty restaurantResults}">
            <p>Your search returned no results.</p>
        </c:when>
        <c:otherwise>
            <table id="restaurantResultsTable">
                <thead>
                    <tr>
                        <th>Restaurant</th>
                        <th>Location</th>
                        <th>Phone Number</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="restaurant" items="${restaurantResults}">
                    <tr>
                        <td>
                                ${restaurant.name}
                            <button class="restaurant-drilldown btn btn-sm" data-id="<c:out value="${restaurant.id}"/>">
                                    <p class="text-muted">Click to view menu items</p>
                            </button>
                        </td>
                        <td>${restaurant.streetAddress}, ${restaurant.state} ${restaurant.zipCode}</td>
                        <td>${restaurant.phoneNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</section>
<script>
    $(document).ready(function () {
        $('#restaurantResultsTable').DataTable();
    });

    $('.restaurant-drilldown').on('click', function(e) {
        var restaurantId = $(e.currentTarget).data('id');
        var url = '${pageContext.request.contextPath}/viewMenuItemsFromRestaurant?restaurant=' + restaurantId;

        window.location.assign(url);
    });
</script>

<c:import url="footer.jsp"/>
</body>
</html>