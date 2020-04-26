<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <div class="container-fluid-wrapper">
            <div class="text-center">
                <form action="createNewUser" method="post" class="form-signin">
                    <p class="h4">Sign Up</p>

                    <div class="row">
                        <div class="col">
                            <!-- First name -->
                            <input type="text" class="form-control" placeholder="First Name">
                        </div>
                        <div class="col">
                            <!-- Last name -->
                            <input type="text" class="form-control" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="row">
                        <input type="email" class="form-control" placeholder="Email" name="email"/>
                    </div>
                    <div class="row">
                        <input type="text" class="form-control" placeholder="Username" name="userName"/>
                    </div>
                    <div class="row">
                        <div class="col">
                            <input type="password" class="form-control" placeholder="Password" name="passwordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                        </div>
                        <div class="col">
                            <input type="password" class="form-control" placeholder="Re-Enter Password" name="passwordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <button type="submit" class="btn">Submit</button>
                        </div>
                        <div class="col">
                            <button class="btn"><a href="index.jsp">Cancel</a></button>
                        </div>
                    </div>
                </form>

            </div>
        </div>

        <c:import url="footer.jsp"/>
    </body>
</html>
