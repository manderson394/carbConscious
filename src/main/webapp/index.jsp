<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

    <body>
    <div class="container-fluid">
        <c:import url="header.jsp"/>

        <div>
            <h2>Counting carbs better together</h2>
        </div>
            <!-- TODO Determine and add an image
            <img src="">
            -->
        <main role="main" class="container-fluid">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-tile">Our Goal</h3>
                    <p class="card-text">
                        <!-- TODO Make this meaningful and pretty! -->
                        Living with diabetes and counting carbohydrates at your favorite restaurant doesn't have to be difficult.
                        Rather than blindly guessing how many carbohydrates are in your favorite dish, why not lean on the experience
                        of other diabetics who have already eaten that very same meal?

                        CarbConscious allows diabetics like you to crowd source carbohydrate estimates for your favorite menu items
                        so that you don't have to struggle to figure out what value to use to calculate your insulin dosing. Our site
                        allows diabetics to enter in their carbohydrate estimates and document the outcomes of their insulin dosing
                        based on those estimates. Our algorithm then uses this data to calculate an average carbohydrate value for
                        menu items with these user-entered data points.

                        Interested in being a part of the effort to make eating out with diabetes easier? Click the link below
                        to set up an account and get started!
                    </p>
                </div>
            </div>

            <div class="card">
                <a href="signUp.jsp" class="card-link">Get Started</a>
            </div>
        </main>
        <c:import url="footer.jsp"/>
    </div>
    </body>
</html>
