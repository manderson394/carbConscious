<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<c:set scope="request" var="title" value="Carb Conscious: Create Menu Item"/>
    <c:import url="../head.jsp"/>

    <body>
        <c:import url="../header.jsp"/>
        <c:import url="../successModal.jsp"/>
        <div class="text-center creation-form-block">
            <h1 class="h2 page-title px-3 py-3">Create a New Menu Item</h1>
                <form class="form needs-validation" action="createMenuItem" method="post">

                    <h2 class="h3">Please select a restaurant to get started.</h2>
                    <select class="form-control" id="restaurant-select" name="menuItemRestaurant">
                        <option value="none">--Select a Restaurant--</option>
                        <c:forEach var="restaurant" items="${availableRestaurants}">
                            <option value="<c:out value="${restaurant.id}"/>">${restaurant.name}</option>
                        </c:forEach>
                    </select>
                    <div class="mb-5" id="restaurant-dependent-missing">
                        <p>Not seeing a restaurant?</p> <a class="btn" href="viewRestaurantCreation">Add New Restaurant</a>
                    </div>
                    <div class="form-group item-field">
                        <label class="restaurant-dependent-have" for="name">Menu Item Name</label>
                        <input type="text" class="form-control restaurant-dependent-have" id="name" name="menuItemName" required/>
                        <div class="invalid-feedback">
                            ${itemErrorMap.name}
                        </div>
                    </div>

                    <div class="form-group item-field">
                        <label class="restaurant-dependent-have" for="description">Description</label>
                        <textarea class="form-control restaurant-dependent-have" id="description" name="menuItemDescription" required></textarea>
                        <div class="invalid-feedback">
                            ${itemErrorMap.description}
                        </div>
                    </div>
                    <button type="submit" class="btn restaurant-dependent-have">Submit</button>
                    <button class="btn"><a class="btn stretched-link" href="${pageContext.request.contextPath}">Cancel</a></button>
                </form>

        </div>

        <script>
            $(document).ready( function () {
                $('.restaurant-dependent-have').hide();

                if (${successModal} === true) {
                    $('#success-modal').modal('show');
                }
                if (${fn:length(itemErrorMap)} > 0) {
                    $('.needs-validation').addClass('was-validated');
                    $('.invalid-feedback').show();
                    $('#restaurant-select').val('${restaurantChosen}');
                    $('.restaurant-dependent-have').show();
                    $('#restaurant-dependent-missing').hide();
                    $('.item-field').addClass('has-error');
                }

            });

            $('#restaurant-select').on('change', function () {
               var chosenOption = $(this).val();

               if (chosenOption === '' || chosenOption === 'none') {
                   $('.restaurant-dependent-have').hide();
                   $('#restaurant-dependent-missing').show();
               } else {
                   $('.restaurant-dependent-have').show();
                   $('#restaurant-dependent-missing').hide();
               }
            });
        </script>

        <c:import url="../footer.jsp"/>
    </body>
</html>
