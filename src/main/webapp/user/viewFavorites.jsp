<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="../head.jsp"/>

<body>
<c:import url="../header.jsp"/>

<div>
    <h2 class="page-title pb-5">My Favorites</h2>
</div>

<c:import url="carbohydrateEstimateModal.jsp"/>
<c:import url="../successModal.jsp"/>

<section class="container-fluid">
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
                            <td>
                                    <div class="d-flex">
                                        <span class="d-inline-block mx-2 mr-auto">
                                            ${favoriteEntry.value.menuItem.calculateAverageCarbohydratesEstimate()}
                                        </span>
                                        <c:if test="${not empty sessionScope.userFirstName}">
                                            <span class="d-inline-block mx-1" tabindex="0" data-toggle="tooltip" title="Create a new Carbohydrate Estimate">
                                                <button class="add-carb btn" data-toggle="modal" data-id="<c:out value="${favoriteEntry.value.menuItem.id}"/>" data-target="#add-carb-modal">
                                                    <i class="fas fa-edit"></i>
                                                </button>
                                            </span>
                                            <span class="d-inline-block mx-1" tabindex="0" data-toggle="tooltip" title="Remove from favorites">
                                                <button class="remove-favorite btn" data-id="<c:out value="${favoriteEntry.value.id}"/>">
                                                    <i class="fas fa-trash"></i>
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
</section>

<script>
    $(document).ready(function () {
        $('#favoritesTable').DataTable();

        if (${successModal} === true) {
            $('#success-modal').modal('show');
        }
    });

    $('#add-carb-modal').on('show.bs.modal', function(e) {
        var menuItemId = $(e.relatedTarget).data('id');
        $(e.currentTarget).find('#hidden-menu-item-id').val(menuItemId);
        $(e.currentTarget).find('#modal-page-locator').val('viewFavorites');
    });

    $('#add-carb-modal').on('hide.bs.modal', function(e) {
        $(e.currentTarget).find('#hidden-menu-item-id').val('');
        $(e.currentTarget).find('#modal-page-locator').val('');
    });

    $(".remove-favorite").on('click', function () {
        var favoriteId =  $(this).data('id');

        $.post('${pageContext.request.contextPath}/deleteFavorite', { rowFavoriteId : favoriteId }, function(data) {
            window.location.reload();
        });
    });
</script>

<c:import url="../footer.jsp"/>
</body>
</html>