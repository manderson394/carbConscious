<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<div>
    <h2>Menu Item Search Results</h2>
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
                </form>
            </div>
        </div>
    </div>
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
                        <td class="menu-item-estimate">${menuItem.calculateAverageCarbohydratesEstimate()}
                        <c:if test="${not empty sessionScope.userFirstName}">
                                <button class="add-carb btn" data-toggle="modal" data-id="<c:out value="${menuItem.id}"/>" data-target="#add-carb-modal">
                                    <i class="fas fa-plus"></i> Add Carbohydrates Estimate
                                </button>
                                <button class="add-favorite btn" data-id="<c:out value="${menuItem.id}"/>">
                                    <i class="fas fa-edit"></i> Add Favorite
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
