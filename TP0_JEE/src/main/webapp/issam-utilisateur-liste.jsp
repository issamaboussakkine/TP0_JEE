<%@ include file="issam-header.jsp" %>

<h2>Liste des Utilisateurs</h2>
<hr>

<div class="mb-3">
    <a href="<%= request.getContextPath() %>/issam-utilisateur-form" class="btn btn-success">Ajouter un Utilisateur</a>
</div>

<table class="table table-bordered">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="utilisateur" items="${utilisateurs}">
            <tr>
                <td>${utilisateur.id}</td>
                <td>${utilisateur.nom}</td>
                <td>${utilisateur.prenom}</td>
                <td>${utilisateur.email}</td>
                <td>
                    <a href="<%= request.getContextPath() %>/issam-utilisateur-form?action=editer&id=${utilisateur.id}" class="btn btn-primary btn-sm">Modifier</a>
                    <a href="<%= request.getContextPath() %>/issam-supprimer-utilisateur?id=${utilisateur.id}" class="btn btn-danger btn-sm" onclick="return confirm('Confirmer la suppression ?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:if test="${empty utilisateurs}">
    <div class="alert alert-info text-center">
        Aucun utilisateur trouvé.
    </div>
</c:if>

<%@ include file="issam-footer.jsp" %>