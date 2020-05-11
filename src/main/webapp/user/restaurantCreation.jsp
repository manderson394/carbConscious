<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<c:set scope="request" var="title" value="Carb Conscious: Create Restaurant"/>
    <c:import url="../head.jsp"/>

    <body>
        <c:import url="../header.jsp"/>
        <c:import url="../successModal.jsp"/>

            <div class="text-center creation-form-block">
                <h1 class="h2 page-title px-3 py-3">Create a New Restaurant</h1>
                <form class="form needs-validation" action="createRestaurant" method="post">
                    <!-- name, street address, state, zip code, phone number -->
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="restaurantName" required/>
                        <div class="invalid-feedback">
                            ${restaurantErrors.name}
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="street-address">Street Address</label>
                        <input type="text" class="form-control" id="street-address" name="restaurantStreetAddress" required/>
                        <div class="invalid-feedback">
                            ${restaurantErrors.streetAddress}
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="state">State</label>
                        <input type="text" class="form-control" id="state" name="restaurantState" required/>
                        <div class="invalid-feedback">
                            ${restaurantErrors.state}
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="zip-code">Zip Code</label>
                        <input type="text" class="form-control" id="zip-code" name="restaurantZipCode" required/>
                        <div class="invalid-feedback">
                            ${restaurantErrors.zipCode}
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phone-number">Phone Number</label>
                        <input type="text" class="form-control" id="phone-number" name="restaurantPhoneNumber" required/>
                        <div class="invalid-feedback">
                            ${restaurantErrors.phoneNumber}
                        </div>
                    </div>

                    <button type="submit" class="btn">Submit</button>
                    <button class="btn"><a href="${pageContext.request.contextPath}">Cancel</a></button>
                </form>

            </div>
        <c:import url="../footer.jsp"/>
    <script>
        $(document).ready(function () {
            if (${successModal} === true) {
                $('#success-modal').modal('show');
            }

            if (${fn:length(restaurantErrors)} > 0) {
                $('.needs-validation').addClass('was-validated');
                $('.invalid-feedback').show();
            }
        });
    </script>
    </body>
</html>
