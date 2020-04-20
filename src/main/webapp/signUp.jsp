<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>

        <div class="text-center">
            <form class="form-signin" action="createNewUser" method="post">
                <p class="h4 mb-4">Sign Up</p>

                <div class="form-row mb-4">
                    <div class="col">
                        <!-- First name -->
                        <input type="text" class="form-control" placeholder="First Name">
                    </div>
                    <div class="col">
                        <!-- Last name -->
                        <input type="text" class="form-control" placeholder="Last Name">
                    </div>
                </div>

                <input type="email" class="form-control mb-4" placeholder="Email" name="email"/>
                <input type="text" class="form-control mb-4" placeholder="Username" name="userName"/>
                <input type="password" class="form-control" placeholder="Password" name="passwordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                <input type="password" class="form-control" placeholder="Re-Enter Password" name="passwordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                <button type="submit" class="btn btn-info my-4 btn-block">Submit</button>
                <button class="btn btn-info my-4 btn-block"><a href="index.jsp">Cancel</a></button>
            </form>

        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
