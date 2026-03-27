<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="issam-header.jsp" %>

<div class="alert alert-danger">
    <h4 class="alert-heading">Une erreur est survenue</h4>
    <p>Une erreur inattendue s'est produite lors du traitement de votre demande.</p>
    <hr>
    <p class="mb-0">Veuillez vérifier les informations saisies ou contacter l'administrateur.</p>

    <c:if test="${pageContext.errorData != null}">
        <hr>
        <p><strong>Code d'erreur :</strong> ${pageContext.errorData.statusCode}</p>
        <p><strong>Message :</strong> ${pageContext.errorData.throwable.message}</p>
    </c:if>

    <div class="mt-4">
        <a href="<%= request.getContextPath() %>/issam-index.jsp" class="btn btn-issam">Retour à l'accueil</a>
        <a href="javascript:history.back()" class="btn btn-secondary">Retour à la page précédente</a>
    </div>
</div>

<%@ include file="issam-footer.jsp" %>