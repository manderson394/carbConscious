<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">Carb Conscious</a>

        <ul class="navbar-nav mr-1">
            <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Contact</a>
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
                    </select>
                </div>
                <div class="col">
                    <input id="navSearchField" class="form-control form-control-sm" type="text" name="searchInput" placeholder="Enter Restaurant Name...">
                </div>
            <script>
                var navSelectElement = $('#navSelectSearch'), navSearchInput = $('#navSearchField');

                navSelectElement.on('change', function () {
                    switch (navSelectElement.val()) {
                        case 'restaurant':
                            navSearchInput.attr('placeholder', 'Enter Restaurant Name...');
                            break;
                        case 'restaurantLocation':
                            navSearchInput.attr('placeholder', 'Enter Restaurant Zip Code...');
                            break;
                        case 'menuItem':
                            navSearchInput.attr('placeholder', 'Enter Menu Item Name...');
                            break;
                        case 'menuItemLocation':
                            navSearchInput.attr('placeholder', 'Enter Menu Item Zip Code...');
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
                    <div class="dropdown-menu" aria-labelledby="navDropdown">
                        <a class="dropdown-item nav-link" href="viewProfile">Profile</a>
                        <a class="dropdown-item nav-link" href="viewFavorites">My Favorites</a>
                        <a class="dropdown-item nav-link" href="viewMenuItemCreation">Create Menu Item</a>
                        <a class="dropdown-item nav-link" href="#">Create Restaurant</a>
                    </div>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
