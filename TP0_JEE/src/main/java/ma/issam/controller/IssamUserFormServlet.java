package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamUtilisateurDAO;
import ma.issam.entities.IssamUtilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Issam : Servlet pour afficher le formulaire de création/édition d'un utilisateur
 * URL : /issam-utilisateur-form
 */
@WebServlet("/issam-utilisateur-form")
public class IssamUserFormServlet extends HttpServlet {

    private IssamUtilisateurDAO issamUtilisateurDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    /**
     * Issam : Affiche le formulaire (création ou édition)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // Issam : Si action = editer, on charge l'utilisateur existant
        if (action != null && action.equals("editer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<IssamUtilisateur> utilisateur = issamUtilisateurDAO.findById((long) id);
            utilisateur.ifPresent(u -> request.setAttribute("utilisateur", u));
        }

        // Issam : Redirection vers la JSP du formulaire
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-utilisateur-formulaire.jsp");
        dispatcher.forward(request, response);
    }
}