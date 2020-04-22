<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <div class="container-fluid-wrapper">
            <div class="text-center">
                <form class="form" action="" method="post">


                    <input type="email" class="form-control mb-4" placeholder="Email" name="email"/>
                    <input type="text" class="form-control mb-4" placeholder="Username" name="userName"/>
                    <input type="password" class="form-control" placeholder="Password" name="passwordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                    <input type="password" class="form-control" placeholder="Re-Enter Password" name="passwordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
                    <button type="submit" class="btn btn-info my-4 btn-block">Submit</button>
                    <button class="btn btn-info my-4 btn-block"><a href="index.jsp">Cancel</a></button>
                </form>

            </div>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
