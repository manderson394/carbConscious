<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<c:import url="../head.jsp"/>

<body>
<c:import url="../header.jsp"/>
<c:import url="../successModal.jsp"/>

<section>
    <div class="text-center creation-form-block">
        <h1 class="h2 page-title px-3 py-3">Edit Profile</h1>
    <form class="form needs-validation" action="updateUser" method="post">

        <div class="form-row mb-4">
            <div class="col">
                <!-- First name -->
                <div class="form-group item-field">
                    <label for="profile-first-name">First Name:</label>
                    <input id="profile-first-name" type="text" class="form-control" value="<c:out value="${firstName}"/>" name="firstName" required>
                    <div class="invalid-feedback">
                        ${profileErrorMap.firstName}
                    </div>
                </div>
            </div>
            <div class="col">
                <!-- Last name -->
                <div class="form-group item-field">
                    <label for="profile-last-name">Last Name:</label>
                    <input id="profile-last-name" type="text" class="form-control" value="<c:out value="${lastName}"/>" name="lastName" required>
                    <div class="invalid-feedback">
                        ${profileErrorMap.lastName}
                    </div>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
            <div class="col">
                <h4 class="h6">Email:</h4>
            </div>
            <div class="col mr-auto">
                <c:out value="${email}"/>
            </div>
            </div>
        </div>
        <div class="form-group item field">
            <label for="profile-user-name">Username:</label>
            <input id="profile-user-name" type="text" class="form-control mb-4" value="<c:out value="${userName}"/>" name="userName" required/>
            <div class="invalid-feedback">
                ${profileErrorMap.userName}
            </div>
        </div>
        <div class="form-row mb-4">
            <h4>Change Password</h4>
        </div>
        <div class="form-group item-field">
            <input id="profile-old-password-first" type="password" class="form-control" placeholder="Current Password" name="passwordCurrent" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
            <input id="profile-old-password-second" type="password" class="form-control" placeholder="Password" name="newPasswordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
            <div class="invalid-feedback">
                ${profileErrorMap.password}
            </div>
            <input id="profile-new-password" type="password" class="form-control" placeholder="Re-Enter Password" name="newPasswordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock"/>
        </div>
        <button type="submit" class="btn">Update</button>
        <button class="btn"><a class="btn stretched-link" href="${pageContext.request.contextPath}">Cancel</a></button>
    </form>
</section>
<script>
    $(document).ready(function () {
        if (${successModal} === true) {
            $('#success-modal').modal('show');
        }
        if (${fn:length(profileErrorMap)} > 0) {
            $('.needs-validation').addClass('was-validated');
            $('.invalid-feedback').show();
            $('.item-field').addClass('has-error');
        }
    });

</script>

<c:import url="../footer.jsp"/>
</body>
</html>
