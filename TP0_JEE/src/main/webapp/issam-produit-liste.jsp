<%@ include file="issam-header.jsp" %>

<h2>Catalogue des Produits</h2>
<hr>

<div class="row mb-3">
    <div class="col-md-6">
        <a href="<%= request.getContextPath() %>/issam-produit-form" class="btn btn-success">Ajouter un Produit</a>
    </div>
    <div class="col-md-6">
        <form action="<%= request.getContextPath() %>/issam-produits" method="get" class="form-inline float-right">
            <input type="text" class="form-control mr-2" name="keyword" placeholder="Rechercher un produit..." value="${keyword}">
            <button type="submit" class="btn btn-issam">Rechercher</button>
        </form>
    </div>
</div>

<table class="table table-bordered">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Quantite</th>
            <th>SKU</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td>${produit.id}</td>
                <td>${produit.nom}</td>
                <td>${produit.description}</td>
                <td>${produit.prix} DH</td>
                <td>
                    <c:choose>
                        <c:when test="${produit.quantite < 5}">
                            <span class="badge badge-danger">${produit.quantite} (Stock faible)</span>
                        </c:when>
                        <c:otherwise>
                            ${produit.quantite}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${produit.sku}</td>
                <td>
                    <a href="<%= request.getContextPath() %>/issam-produit-form?action=editer&id=${produit.id}" class="btn btn-primary btn-sm">Modifier</a>
                    <a href="<%= request.getContextPath() %>/issam-supprimer-produit?id=${produit.id}" class="btn btn-danger btn-sm" onclick="return confirm('Confirmer la suppression de ce produit ?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:if test="${empty produits}">
    <div class="alert alert-info text-center">
        Aucun produit trouve.
    </div>
</c:if>

<%@ include file="issam-footer.jsp" %>