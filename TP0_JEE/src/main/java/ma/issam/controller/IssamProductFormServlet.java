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
import java.util.Optional;

/**
 * Issam : Servlet pour afficher le formulaire de création/édition d'un produit
 * URL : /issam-produit-form
 */
@WebServlet("/issam-produit-form")
public class IssamProductFormServlet extends HttpServlet {

    private IssamProduitDAO issamProduitDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    /**
     * Issam : Affiche le formulaire (création ou édition)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Issam : Si action = editer, on charge le produit existant
        if (action != null && action.equals("editer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<IssamProduit> produit = issamProduitDAO.findById((long) id);
            produit.ifPresent(p -> request.setAttribute("produit", p));
        }

        // Issam : Redirection vers la JSP du formulaire
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-produit-formulaire.jsp");
        dispatcher.forward(request, response);
    }
}