<nav class="navbar navbar-light bg-light">
    <a href="index.jsp">Home</a>
    <a href="contact.jsp">Contact</a>
    <form class="form-inline" action="designateView" method="get">
        <select name="searchType">
            <option value="restaurant">Search by Restaurant</option>
            <option value="restaurantLocation">Search Restaurant by Location</option>
            <option value="menuItem">Search by Menu Item</option>
            <option value="menuItemLocation">Search Menu Item by Location</option>
        </select>
        <input type="text" name="searchInput" placeholder="Enter Restaurant Name...">
        <!-- TODO Make placeholder text appear dynamic to the user (need to know what to input  -->
        <!-- TODO Set up Font Awesome profile for icons (search below)-->
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
    <!-- TODO Add dynamic Sign-Up/Welcome, User field -->
    <!-- TODO Add dynamic Login/Account Menu -->
    <a href="loginAction"><button>Login</button></a>
</nav>
