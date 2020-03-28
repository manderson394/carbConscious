<nav class="navbar navbar-default navbar-fixed-top center">
        <ul class="list-inline">
            <li class="list-inline-item"><a class="navbar-header" href="index.jsp">Carb Conscious</a></li>
            <li class="list-inline-item"><a href="contact.jsp">Contact</a></li>
            <li class="list-inline-item"> <form class="form-inline" action="designateView" method="get">
                <div class="form-group"><select name="searchType">
                    <option value="restaurant">Search by Restaurant</option>
                    <option value="restaurantLocation">Search Restaurant by Location</option>
                    <option value="menuItem">Search by Menu Item</option>
                    <option value="menuItemLocation">Search Menu Item by Location</option>
                </select></div>
                <input type="text" name="searchInput" placeholder="Enter Restaurant Name...">
                <!-- TODO Make placeholder text appear dynamic to the user (need to know what to input  -->
                <!-- TODO Set up Font Awesome profile for icons (search below)-->
                <button type="submit"><span class="glyphicon glyphicon-search"></span></button>
            </form></li>
            <!-- TODO Add dynamic Sign-Up/Welcome, User field -->
            <!-- TODO Add dynamic Login/Account Menu -->
            <li class="list-inline-item"><a href="loginAction"><button>Login</button></a></li>
        </ul>
</nav>
