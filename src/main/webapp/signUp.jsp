<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<c:set scope="request" var="title" value="Carb Conscious: Sign Up"/>
    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <div class="container-fluid-wrapper">
            <div class="text-center">
                <form action="createNewUser" method="post" class="form registration-form needs-validation">
                    <p class="h4">Sign Up</p>

                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <!-- First name -->
                                <input type="text" class="form-control" placeholder="First Name" name="firstName" required>
                                <div class="invalid-feedback">
                                    ${errorMap.firstName}
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <!-- Last name -->
                                <input type="text" class="form-control" placeholder="Last Name" name="lastName" required>
                                <div class="invalid-feedback">
                                    ${errorMap.lastName}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email" name="email" required/>
                                <div class="invalid-feedback">
                                    ${errorMap.email}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Username" name="userName" required/>
                                <div class="invalid-feedback">
                                    ${errorMap.userName}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <input id="firstPassword" type="password" class="form-control" placeholder="Password" name="passwordFirst" aria-describedby="defaultRegisterFormPasswordHelpBlock" required/>
                                <div class="invalid-feedback">
                                    ${errorMap.password}
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col">
                                <input id="secondPassword" type="password" class="form-control" placeholder="Re-Enter Password" name="passwordSecond" aria-describedby="defaultRegisterFormPasswordHelpBlock" required/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <button id="signUpSubmit" type="submit" class="btn">Submit</button>
                        </div>
                        <div class="col">
                            <button class="btn"><a href="${pageContext.request.contextPath}">Cancel</a></button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#signUpSubmit').hide();

                if (${fn:length(errorMap)} > 0) {
                    $('.needs-validation').addClass('was-validated');
                    $('.invalid-feedback').show();
                }
            });

            $('#firstPassword').on('change', function () {
                if ($('#firstPassword').val() === $('#secondPassword').val()) {
                    $('#signUpSubmit').show();
                }
            });
            $('#secondPassword').on('change', function () {
                if ($('#firstPassword').val() === $('#secondPassword').val()) {
                    $('#signUpSubmit').show();
                }
            });
        </script>

        <c:import url="footer.jsp"/>
    </body>
</html>
