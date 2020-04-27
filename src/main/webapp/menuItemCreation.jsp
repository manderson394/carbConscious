<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <div class="container-fluid-wrapper">
            <div class="text-center">
                <h1 class="h2">Create a New Menu Item</h1>
                <form class="form" action="createMenuItem" method="post">

                    <h2 class="h3">Please select a restaurant to get started.</h2>
                    <select class="form-control" id="restaurant-select" name="menuItemRestaurant">
                        <option value="none">--Select a Restaurant--</option>
                        <c:forEach var="restaurant" items="${availableRestaurants}">
                            <option value="<c:out value="${restaurant.id}"/>">${restaurant.name}</option>
                        </c:forEach>
                    </select>
                    <div id="restaurant-dependent-missing">
                        <p>Not seeing a restaurant?</p>
                        <a class="btn" href="viewRestaurantCreation">Add New Restaurant</a>
                    </div>
                    <div id="restaurant-dependent-have">
                        <label for="name">Menu Item Name</label>
                        <input type="text" class="form-control" id="name" name="menuItemName">

                        <label for="description">Description</label>
                        <textarea class="form-control" id="description" name="menuItemDescription"></textarea>

                        <button type="submit" class="btn">Submit</button>
                    </div>
                    <button class="btn"><a class="btn stretched-link" href="index.jsp">Cancel</a></button>
                </form>

            </div>
        </div>

        <script>
            $(document).ready( function () {
                $('#restaurant-dependent').hide();
            });

            $('#restaurant-select').on('change', function () {
               var chosenOption = $(this).val();

               if (chosenOption === '' || chosenOption === 'none') {
                   $('#restaurant-dependent-have').hide();
                   $('#restaurant-dependent-missing').show();
               } else {
                   $('#restaurant-dependent-have').show();
                   $('#restaurant-dependent-missing').hide();
               }
            });
        </script>

        <c:import url="footer.jsp"/>
    </body>
</html>
