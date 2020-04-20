<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Carb Conscious</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-center">
            <li class="nav-item"> <form class="form-inline d-flex justify-content-center md-form form-sm" action="designateView" method="get">
                <div class="form-group"><select class="form-control" id="navSelectSearch" name="searchType">
                    <option value="restaurant">Search by Restaurant</option>
                    <option value="restaurantLocation">Search Restaurant by Zip Code</option>
                    <option value="menuItem">Search by Menu Item</option>
                    <option value="menuItemLocation">Search Menu Item by Zip Code</option>
                </select></div>
                <input id="navSearchField" class="form-control form-control-sm mr-3 w-75" type="text" name="searchInput" placeholder="Enter Restaurant Name...">

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

                <button class="btn" type="submit"><span class="glyphicon glyphicon-search"></span></button>
            </form></li>
        </ul>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${empty sessionScope.userFirstName}">
                    <li class="nav-item"><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li class="nav-item"><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" role="button" href="#">Welcome, ${sessionScope.userFirstName}! <span class="glyphicon glyphicon-chevron-down"></span></a>
                        <div class="dropdown-menu" aria-labelledby="navDropdown">
                            <a class="dropdown-item nav-link" href="viewProfile">Profile</a>
                            <a class="dropdown-item nav-link" href="viewFavorites">My Favorites</a>
                            <a class="dropdown-item nav-link" href="#">Add Carbohydrate Estimate</a>
                            <a class="dropdown-item nav-link" href="#">Add Menu Item</a>
                            <a class="dropdown-item nav-link" href="#">Add Restaurant</a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
