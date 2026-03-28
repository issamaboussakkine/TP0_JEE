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

/**
 * Issam : Servlet pour créer un nouveau produit
 * URL : /issam-creer-produit
 */
@WebServlet("/issam-creer-produit")
public class IssamProductCreateServlet extends HttpServlet {

    private IssamProduitDAO issamProduitDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    /**
     * Issam : Traitement du formulaire POST pour créer un produit
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String sku = request.getParameter("sku");

        // Issam : Création du nouveau produit
        IssamProduit nouveauProduit = new IssamProduit(nom, description, prix, quantite, sku);

        // Issam : Sauvegarde en base de données
        issamProduitDAO.save(nouveauProduit);

        // Issam : Redirection vers la liste des produits
        response.sendRedirect("issam-produits");
    }
}