<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="../head.jsp"/>

    <body>
        <c:import url="../header.jsp"/>
        <c:import url="../successModal.jsp"/>
        <div class="text-center creation-form-block">
            <h1 class="h2 page-title px-3 py-3">Create a New Menu Item</h1>
                <form class="form" action="createMenuItem" method="post">

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
                    <label class="restaurant-dependent-have" for="name">Menu Item Name</label>
                    <input type="text" class="form-control restaurant-dependent-have" id="name" name="menuItemName">

                    <label class="restaurant-dependent-have" for="description">Description</label>
                    <textarea class="form-control restaurant-dependent-have" id="description" name="menuItemDescription"></textarea>

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
