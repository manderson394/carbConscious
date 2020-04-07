<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="index.jsp">Carb Conscious</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-center">
            <li> <form class="form-inline d-flex justify-content-center md-form form-sm" action="designateView" method="get">
                <div class="form-group"><select name="searchType">
                    <option value="restaurant">Search by Restaurant</option>
                    <option value="restaurantLocation">Search Restaurant by Location</option>
                    <option value="menuItem">Search by Menu Item</option>
                    <option value="menuItemLocation">Search Menu Item by Location</option>
                </select></div>
                <input class="form-control form-control-sm mr-3 w-75" type="text" name="searchInput" placeholder="Enter Restaurant Name...">
                <!-- TODO Make placeholder text appear dynamic to the user (need to know what to input  -->
                <!-- TODO Set up Font Awesome profile for icons (search below)-->
                <button type="submit"><span class="glyphicon glyphicon-search"></span></button>
            </form></li>
        </ul>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${empty sessionScope.userFirstName}">
                    <li><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navDropdown" aria-haspopup="true" aria-expanded="false" role="button" data-toggle="dropdown" href="#">Welcome, ${sessionScope.userFirstName}! <span class="glyphicon glyphicon-chevron-down"></span></a>
                        <div class="dropdown-menu" aria-labelledby="navDropdown">
                            <a class="dropdown-item" href="#">Profile</a>
                            <a class="dropdown-item" href="viewFavorites">My Favorites</a>
                            <a class="dropdown-item" href="#">Add Carbohydrate Estimate</a>
                            <a class="dropdown-item" href="#">Add Menu Item</a>
                            <a class="dropdown-item" hrer="#">Add Restaurant</a>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
