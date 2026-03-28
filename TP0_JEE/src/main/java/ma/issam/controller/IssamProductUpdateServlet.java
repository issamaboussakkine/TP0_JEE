package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamProduitDAO;
import ma.issam.entities.IssamProduit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * Issam : Servlet pour modifier un produit
 * URL : /issam-modifier-produit
 */
@WebServlet("/issam-modifier-produit")
public class IssamProductUpdateServlet extends HttpServlet {

    private IssamProduitDAO issamProduitDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    /**
     * Issam : Traitement du formulaire POST pour modifier un produit
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération des paramètres du formulaire
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String sku = request.getParameter("sku");

        // Issam : Recherche du produit existant
        Optional<IssamProduit> optionalProduit = issamProduitDAO.findById((long) id);

        // Issam : Mise à jour du produit s'il existe
        if (optionalProduit.isPresent()) {
            IssamProduit produit = optionalProduit.get();
            produit.setNom(nom);
            produit.setDescription(description);
            produit.setPrix(BigDecimal.valueOf(prix));
            produit.setQuantite(quantite);
            produit.setSku(sku);
            issamProduitDAO.update(produit);
        }

        // Issam : Redirection vers la liste des produits
        response.sendRedirect("issam-produits");
    }
}