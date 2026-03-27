<%@ include file="issam-header.jsp" %>

<c:if test="${utilisateur != null}">
    <h2>Modifier l'Utilisateur</h2>
    <form action="<%= request.getContextPath() %>/issam-modifier-utilisateur" method="post">
    <input type="hidden" name="id" value="${utilisateur.id}" />
</c:if>
<c:if test="${utilisateur == null}">
    <h2>Ajouter un Utilisateur</h2>
    <form action="<%= request.getContextPath() %>/issam-creer-utilisateur" method="post">
</c:if>

<div class="form-group">
<label for="prenom">Prenom</label>
    <input type="text" class="form-control" id="prenom" name="prenom" value="${utilisateur.prenom}" required>
</div>


<div class="form-group">
    <label for="nom">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" value="${utilisateur.nom}" required>
</div>

<div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email" value="${utilisateur.email}" required>
</div>

<div class="form-group">
    <label for="motDePasse">Mot de passe</label>
    <input type="password" class="form-control" id="motDePasse" name="motDePasse" <c:if test="${utilisateur == null}">required</c:if>>
    <c:if test="${utilisateur != null}">
        <small class="text-muted">Laissez vide pour conserver le mot de passe actuel.</small>
    </c:if>
</div>

<button type="submit" class="btn btn-issam">Enregistrer</button>
<a href="<%= request.getContextPath() %>/issam-utilisateurs" class="btn btn-secondary">Annuler</a>

</form>

<%@ include file="issam-footer.jsp" %>