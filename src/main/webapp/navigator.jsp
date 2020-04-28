<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="contact-modal" tabindex="-1" role="dialog" aria-labelledby="Contact" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                Contact Us
                <button type="button" class="close" data-dismiss="modal" aria-label="close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form" action="/addCarbohydrateEstimate" method="post">
                    <label for="contact-name">Name</label>
                    <input type="text" name="contactName" id="contact-name" class="form-control"/>

                    <label for="contact-email">Email</label>
                    <input type="text" name="contactEmail" id="contact-email" class="form-control"/>

                    <label for="contact-message">Message</label>
                    <textarea name="contactMessage" id="contact-message" class="form-control"></textarea>

                    <button type="submit" class="btn">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">Carb Conscious</a>

        <ul class="navbar-nav mr-1">
            <li class="nav-item">
                <a class="nav-link" href="#contact-modal" data-toggle="modal" data-target="#contact-modal">Contact</a>
            </li>
        </ul>
        <form class="form-inline" action="designateView" method="get">
            <div class="form-row">
                <div class="col">
                    <select class="form-control form-control-sm" id="navSelectSearch" name="searchType">
                        <option value="restaurant">Search by Restaurant</option>
                        <option value="restaurantLocation">Search Restaurant by Zip Code</option>
                        <option value="menuItem">Search by Menu Item</option>
                        <option value="menuItemLocation">Search Menu Item by Zip Code</option>
                        <option value="spoonacular">Search by Spoonacular Menu Item</option>
                    </select>
                </div>
                <div class="col">
                    <input id="navSearchField" class="form-control form-control-sm" type="text" name="searchInput" placeholder="Enter Restaurant Name...">
                </div>
                <div class="col">
                    <input class="form-control form-control-sm" id="apiLimit" type="number" name="apiNumberOfResults" placeholder="Result Limit"/>
                </div>
            <script>
                $(document).ready( function () {
                    if ($('#apiLimit').val() === '') {
                        $('#apiLimit').hide();
                    }
                });

                var navSelectElement = $('#navSelectSearch'), navSearchInput = $('#navSearchField');

                navSelectElement.on('change', function () {
                    switch (navSelectElement.val()) {
                        case ('restaurant' || 'menuItem'):
                            navSearchInput.attr('placeholder', 'Enter Name...');
                            $('#apiLimit').hide();
                            break;
                        case ('restaurantLocation' || 'menuItemLocation'):
                            navSearchInput.attr('placeholder', 'Enter Zip Code...');
                            $('#apiLimit').hide();
                            break;
                        case 'spoonacular':
                            navSearchInput.attr('placeholder', 'Enter Spoonacular Name...');
                            $('#apiLimit').show();
                            break;
                    }
                });
            </script>
                <div class="col">
                    <button class="btn btn-default" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
    <ul class="navbar-nav ml-auto">
        <c:choose>
            <c:when test="${empty sessionScope.userFirstName}">
                <li class="nav-item"><a class="nav-link mx-1" href="signUp"><i class="fas fa-user-plus"></i> Sign Up</a></li>
                <li class="nav-item"><a class="nav-link mx-1" href="login"><i class="fas fa-sign-in-alt"></i> Login</a></li>
            </c:when>
            <c:otherwise>
                <li class="nav-item"><a class="nav-link mx-1" href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" role="button" href="#">Welcome, ${sessionScope.userFirstName}! <span class="glyphicon glyphicon-chevron-down"></span></a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="navDropdown">
                        <a class="dropdown-item nav-link bg-dark" href="viewProfile">Profile</a>
                        <a class="dropdown-item nav-link bg-dark" href="viewFavorites">My Favorites</a>
                        <a class="dropdown-item nav-link bg-dark" href="viewMenuItemCreation">Create Menu Item</a>
                        <a class="dropdown-item nav-link bg-dark" href="viewRestaurantCreation">Create Restaurant</a>
                    </div>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>