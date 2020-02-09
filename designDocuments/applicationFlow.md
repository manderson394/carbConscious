# Application Flow

### Sign Up

1. User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
2. User fills out the sign up form and submits.
3. Request goes to sign up servlet.
4. Servlet creates a user object and then creates user in the database with help of a DAO.
5. Response to user confirming addition (show a message on the jsp).

### Sign In

1. User chooses Login on the menu (available on all pages, unless the user 
is signed in already).
2. User enters username and password on form and submits. 
3. If user is authenticated, the server will handle allowing access to add carbohydrate
estimates to menu items and creating or editing a favorites list.  Tomcat authentication uses for user authentication (USER and USER_ROLE tables).
4. If authentication fails, show error message/page.
5. If user forgot their username, they can select the hyperlink which will ask them to enter their email. The server then sends
an email to their address with the user name.
6. If a user forgot their password, they can select the hyperlink which will ask them for their username. The server will then send an email
to the email address linked to the username with their password.

### Find Carbohydrates for Menu Items

1. User selects the search for menu items link that is displayed on every page.
2. User selects the menu item search they desire (name or location) on the search page to which they are brought.
3. If the user selects the menu item search by name, they will enter in their search term and select the search button. This will send their
request to a servlet that queries the menu API for matching menu items.
    1. The user may select to search for menu items by location. If so, they will either click the "near me" option or 
    enter their zip code. (Stretch Goal)
4. Matching menu items returned by the API are then queried against the database for any carbohydrate information.
5. The server calculates an average of any carbohydrate data.
6. Matching menu items and carbohydrate data are sent back to a results JSP that displays the items.

### View Carbohydrates for Menu Items

1. After a user has searched for menu items, they can see carbohydrate data inline on the JSP.
2. The user may click the displayed value to see detailed data including reported outcomes and estimate information.

### Search for Restaurant Menus

1. User selects the search for menu items link that is displayed on every page.
2. User selects the restaurant search they desire (name or location) on the search page to which they are brought.
3. If the user selects the restaurant search by name, they will enter in their search term and select the search button. This will send their
request to a servlet that queries the menu API for matching menu items.
    1. The user may select to search for restaurants by location. If so, they will either click the "near me" option or 
    enter their zip code. (Stretch Goal)
4. Matching restaurants returned by the API are displayed in a JSP that displays the items. Each row will diaplay a link to 
view the menu items on the restaurant menu.
    1. If the user clicks on the menu item link, the API will be queried for available menu items.
    2. Returned menu items will be displayed on a results JSP. 

### Home Information

1. User enters the URL for carbConscious.
2. The home page will display information on the web application.

### Contact

1. User may click the Contact page.
2. The server will display a page with a form to submit an email to the admin.

### Add Carbohydrate Information for Menu Items

1. User first searches for menu items (see above).
2. Each row for a menu item will have a link to add carbohydrate information about the menu item. The user clicks this link.
The user must be signed in.
3. Application displays a popup for the user to enter information about their carbohydrate estimate and any blood sugar outcome data.
4. User submits the data, and the server writes the data back to the database for use in subsequent calculations.

### Add/Edit Menu Items for My Favorites

1. User first searches for menu items (see above).
2. Each row for a menu item will have a link add the menu item to their favorites. The user clicks this link (user must be logged in).
3. The server writes the menu item back to the database as one of the users favorites.
4. User can select a link from the dropdown in the toolbar (once logged in) to review their favorites.
5. The server retrieves the users favorites list from the database and displays it on a results JSP.
6. User can click a link to remove the menu item from their list of favorites. The server will then communicate with the database
to delete the menu item from the user's favorite list. 

### Edit Profile

1. User selects their profile from the toolbar dropdown (once logged in) on any page.
2. The server queries the database for the user's profile information and displays it in a popup.
3. The user can then edit these profile settings.
4. The user submits the updates via the browser form. 
5. The server updates the database appropriately.
