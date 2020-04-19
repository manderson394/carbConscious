<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<c:import url="head.jsp"/>

<body>
<c:import url="header.jsp"/>

<section>
    <form class="text-center border border-light p-5" action="updateUser" method="post">
        <p class="h4 mb-4">Edit Profile</p>

        <div class="form-row mb-4">
            <div class="col">
                <!-- First name -->
                <input type="text" class="form-control" placeholder="<c:out value="${firstName}"/>">
            </div>
            <div class="col">
                <!-- Last name -->
                <input type="text" class="form-control" placeholder="<c:out value="${lastName}"/>">
            </div>
        </div>

        <div class="form-row mb-4">
            <div class="col">
                <h4>Email:</h4>
            </div>
            <div class="col">
                <c:out value="${email}"/>
            </div>
        </div>
        <input type="text" class="form-control mb-4" placeholder="<c:out value="${userName}"/>" name="userName"/>

        <div class="form-row mb-4">
            <h4>Change Password</h4>
        </div>
        <input type="password" class="form-control" placeholder="Current Password" name="passwordCurrent" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
        <input type="password" class="form-control" placeholder="Password" name="oldPasswordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
        <input type="password" class="form-control" placeholder="Re-Enter Password" name="oldPasswordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
        <button type="submit" class="btn btn-info my-4 btn-block">Update</button>
        <button class="btn btn-info my-4 btn-block"><a href="index.jsp">Cancel</a></button>
    </form>
</section>

<c:import url="footer.jsp"/>
</body>
</html>
