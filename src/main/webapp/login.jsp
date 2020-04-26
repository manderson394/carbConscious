<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="head.jsp"/>

    <body>
        <c:import url="header.jsp"/>
        <FORM class="form-signin" ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username" class="form-control">
                <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In" class="btn">
            </TABLE>
        </FORM>
        <c:import url="footer.jsp"/>
    </body>
</html>
