<nav class="navbar navbar-default navbar-fixed-top center">
        <ul class="list-inline">
            <li class="list-inline-item float-left"><a href="index.jsp">Carb Conscious</a></li>
            <li class="list-inline-item"><a href="contact.jsp">Contact</a></li>
            <li class="list-inline-item"> <form class="form-inline d-flex justify-content-center md-form form-sm" action="designateView" method="get">
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
            <!-- TODO Add dynamic Sign-Up/Welcome, User field -->
            <!-- TODO Add dynamic Login/Account Menu -->
            <li class="list-inline-item float-right"><a href="loginAction"><button>Login</button></a></li>
        </ul>
</nav>
