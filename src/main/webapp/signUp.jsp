<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>

        <div>
            <h2>Sign Up</h2>
        </div>

        <section>

            <form action="createNewUser" method="post">
                <input type="text" placeholder="First Name" name="firstName"/>
                <input type="text" placeholder="Last Name" name="lastName"/>
                <input type="email" placeholder="Email" name="email"/>
                <input type="text" placeholder="Username" name="userName"/>
                <input type="text" placeholder="Password" name="passwordFirst"/>
                <input type="text" placeholder="Re-Enter Password" name="passwordSecond"/>
                <button type="submit">Submit</button>
                <button><a href="index.jsp">Cancel</a></button>
            </form>

        </section>

        <c:import url="footer.jsp"/>
    </body>
</html>
