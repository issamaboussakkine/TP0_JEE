<%@ include file="issam-header.jsp" %>

<c:if test="${produit != null}">
    <h2>Modifier un Produit</h2>
    <form action="<%= request.getContextPath() %>/issam-modifier-produit" method="post">
    <input type="hidden" name="id" value="${produit.id}" />
</c:if>
<c:if test="${produit == null}">
    <h2>Ajouter un Produit</h2>
    <form action="<%= request.getContextPath() %>/issam-creer-produit" method="post">
</c:if>

<div class="form-group">
    <label for="nom">Nom du produit</label>
    <input type="text" class="form-control" id="nom" name="nom" value="${produit.nom}" required>
</div>

<div class="form-group">
    <label for="description">Description</label>
    <textarea class="form-control" id="description" name="description" rows="3">${produit.description}</textarea>
</div>

<div class="form-row">
    <div class="form-group col-md-6">
        <label for="prix">Prix unitaire (DH)</label>
        <input type="number" step="0.01" class="form-control" id="prix" name="prix" value="${produit.prix}" required>
    </div>
    <div class="form-group col-md-6">
        <label for="quantite"> Quantite en stock</label>
        <input type="number" class="form-control" id="quantite" name="quantite" value="${produit.quantite}" required>
    </div>
</div>

<div class="form-group">
    <label for="sku">Code SKU</label>
    <input type="text" class="form-control" id="sku" name="sku" value="${produit.sku}" required>
</div>

<button type="submit" class="btn btn-issam">Enregistrer</button>
<a href="<%= request.getContextPath() %>/issam-produits" class="btn btn-secondary">Annuler</a>

</form>

<%@ include file="issam-footer.jsp" %>