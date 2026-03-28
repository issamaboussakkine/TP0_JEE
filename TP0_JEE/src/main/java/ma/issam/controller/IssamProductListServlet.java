package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamProduitDAO;
import ma.issam.entities.IssamProduit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Issam : Servlet pour afficher la liste des produits
 * URL : /issam-produits
 */
@WebServlet("/issam-produits")
public class IssamProductListServlet extends HttpServlet {

    private IssamProduitDAO issamProduitDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    /**
     * Issam : Affiche tous les produits
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération de tous les produits
        List<IssamProduit> produits = issamProduitDAO.findAll();

        // Issam : Envoi de la liste à la JSP
        request.setAttribute("produits", produits);

        // Issam : Redirection vers la JSP d'affichage
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-produit-liste.jsp");
        dispatcher.forward(request, response);
    }
}