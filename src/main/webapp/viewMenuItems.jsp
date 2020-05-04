<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<div>
    <h2 class="page-title pb-5">Menu Item Search Results</h2>
</div>

<c:import url="/user/carbohydrateEstimateModal.jsp"/>
<c:import url="successModal.jsp"/>

<section class="container-fluid">
    <c:choose>
        <c:when test="${empty menuItemResults}">
            <p>Your search returned no results.</p>
        </c:when>
        <c:otherwise>
            <table id="menuItemResultsTable">
                <thead>
                    <tr>
                        <th>Menu Item</th>
                        <th>Restaurant</th>
                        <th>Description</th>
                        <th>Carbohydrate Approximation</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="menuItem" items="${menuItemResults}">
                    <tr>
                        <td class="menu-item-name">${menuItem.name}</td>
                        <td class="menu-item-restaurant">${menuItem.parentRestaurant.name}</td>
                        <td class="menu-item-description">${menuItem.description}</td>
                        <td class="menu-item-estimate">
                                <div class="d-flex">
                                    <span class="d-inline-block mx-2 mr-auto">
                                            ${menuItem.calculateAverageCarbohydratesEstimate()}
                                    </span>
                                    <c:if test="${not empty sessionScope.userFirstName}">
                                        <span class="d-inline-block mx-1" tabindex="0" data-toggle="tooltip" title="Create a new Carbohydrate Estimate">
                                            <button class="add-carb btn" data-toggle="modal" data-id="<c:out value="${menuItem.id}"/>" data-target="#add-carb-modal">
                                                <i class="fas fa-edit"></i>
                                            </button>
                                        </span>
                                        <span class="d=inline-block mx-1" tabindex="0" data-toggle="tooltip" title="Add this to your Favorites">
                                            <button class="add-favorite btn" data-id="<c:out value="${menuItem.id}"/>">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </span>
                                    </c:if>
                                </div>
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

        $('#add-carb-modal').on('show.bs.modal', function(e) {
            var menuItemId = $(e.relatedTarget).data('id');
            $(e.currentTarget).find('#hidden-menu-item-id').val(menuItemId);
        });

        $('#add-carb-modal').on('hide.bs.modal', function(e) {
           $(e.currentTarget).find('#hidden-menu-item-id').val('');
        });

        $('.add-favorite').on('click', function () {
            var menuItemId = $(this).data('id');

           $.post('${pageContext.request.contextPath}/addFavorite', { rowMenuItemId : menuItemId });
        });
    </script>
</section>

<c:import url="footer.jsp"/>
</body>
</html>
