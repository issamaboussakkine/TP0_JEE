<%@ include file="issam-header.jsp" %>

<div class="jumbotron">
    <h1 class="display-4">Bienvenue</h1>
    <p class="lead">Application de Gestion d'Inventaire</p>
    <hr class="my-4">
    <p>Développée par Issam ABOUSSAKKINE - TP JEE</p>

    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header bg-primary text-white">Utilisateurs</div>
                <div class="card-body">
                    <p>Gestion des utilisateurs de l'application.</p>
                    <a class="btn btn-issam" href="<%= request.getContextPath() %>/issam-utilisateurs">Voir les Utilisateurs</a>
                    <a class="btn btn-success" href="<%= request.getContextPath() %>/issam-utilisateur-form">Ajouter un Utilisateur</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header bg-primary text-white">Produits</div>
                <div class="card-body">
                    <p>Gestion de l'inventaire des produits.</p>
                    <a class="btn btn-issam" href="<%= request.getContextPath() %>/issam-produits">Voir les Produits</a>
                    <a class="btn btn-success" href="<%= request.getContextPath() %>/issam-produit-form">Ajouter un Produit</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="issam-footer.jsp" %>