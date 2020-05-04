<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="success-modal" tabindex="-1" role="dialog" aria-labelledby="Success" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header success-modal-header">
                Success!
                <button type="button" class="close" data-dismiss="modal" aria-label="close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="success-modal-message">${successModalMessage}</p>
            </div>
        </div>
    </div>
</div>

<c:if test="${empty successModal}">
    <c:set var="successModal" scope="request" value="false"/>
</c:if>