<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="../head.jsp"/>

<body>
<c:import url="../header.jsp"/>

<div>
    <h2>My Favorites</h2>
</div>

<div class="modal fade" id="add-carb-modal" tabindex="-1" role="dialog" aria-labelledby="Add Carb Estimate" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                Add Carbohydrate Estimate
                <button type="button" class="close" data-dismiss="modal" aria-label="close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Enter your estimate of the grams of carbohydrates and your relative blood sugar outcome after then end of your insulin duration time period.</p>
                <form class="form" action="/addCarbohydrateEstimate" method="post">
                    <div class="row">
                        <input type="hidden" id="hidden-menu-item-id" name="menuItemIdModal"/>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="carb-grams">Grams</label>
                            <input type="text" name="carbGrams" id="carb-grams" class="form-control"/>
                        </div>
                        <div class="col">
                            <label for="outcome">Outcome</label>
                            <select name="outcome" id="outcome" class="form-control">
                                <option value="2">High</option>
                                <option value="1" selected="selected">In Range</option>
                                <option value="0">Low</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class = "col">
                            <button type="submit" class="btn">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
                            <td>${favoriteEntry.value.menuItem.calculateAverageCarbohydratesEstimate()}
                                <c:if test="${not empty sessionScope.userFirstName}">
                                    <button class="add-carb btn" data-toggle="modal" data-id="<c:out value="${favoriteEntry.value.menuItem.id}"/>" data-target="#add-carb-modal">
                                        <i class="fas fa-plus"></i> Add Carbohydrates Estimate
                                    </button>
                                </c:if>
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
    });

    $('#add-carb-modal').on('show.bs.modal', function(e) {
        var menuItemId = $(e.relatedTarget).data('id');
        $(e.currentTarget).find('#hidden-menu-item-id').val(menuItemId);
    });

    $('#add-carb-modal').on('hide.bs.modal', function(e) {
        $(e.currentTarget).find('#hidden-menu-item-id').val('');
    });
</script>

<c:import url="../footer.jsp"/>
</body>
</html>