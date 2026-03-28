package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamProduitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Issam : Servlet pour supprimer un produit
 * URL : /issam-supprimer-produit
 */
@WebServlet("/issam-supprimer-produit")
public class IssamProductDeleteServlet extends HttpServlet {

    private IssamProduitDAO issamProduitDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    /**
     * Issam : Suppression du produit via son ID
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération de l'ID du produit à supprimer
        int id = Integer.parseInt(request.getParameter("id"));

        // Issam : Suppression en base de données
        issamProduitDAO.delete((long) id);

        // Issam : Redirection vers la liste des produits
        response.sendRedirect("issam-produits");
    }
}