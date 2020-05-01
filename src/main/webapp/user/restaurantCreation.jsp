<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="../head.jsp"/>

    <body>
        <c:import url="../header.jsp"/>
        <div class="container-fluid-wrapper">
            <div class="text-center">
                <h1 class="h2">Create a New Restaurant</h1>
                <form class="form" action="createRestaurant" method="post">
                    <!-- name, street address, state, zip code, phone number -->
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="restaurantName"/>

                    <label for="street-address">Street Address</label>
                    <input type="text" class="form-control" id="street-address" name="restaurantStreetAddress"/>

                    <label for="state">State</label>
                    <input type="text" class="form-control" id="state" name="restaurantState"/>

                    <label for="zip-code">Zip Code</label>
                    <input type="text" class="form-control" id="zip-code" name="restaurantZipCode"/>

                    <label for="phone-number">Phone Number</label>
                    <input type="text" class="form-control" id="phone-number" name="restaurantPhoneNumber"/>

                    <button type="submit" class="btn">Submit</button>
                    <button class="btn"><a href="../index.jsp">Cancel</a></button>
                </form>

            </div>
        </div>
        <c:import url="../footer.jsp"/>
    </body>
</html>
