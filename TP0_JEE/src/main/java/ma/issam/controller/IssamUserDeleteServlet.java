package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamUtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Issam : Servlet pour supprimer un utilisateur
 * URL : /issam-supprimer-utilisateur
 */
@WebServlet("/issam-supprimer-utilisateur")
public class IssamUserDeleteServlet extends HttpServlet {

    private IssamUtilisateurDAO issamUtilisateurDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    /**
     * Issam : Suppression de l'utilisateur via son ID
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération de l'ID de l'utilisateur à supprimer
        Long id = Long.parseLong(request.getParameter("id"));

        // Issam : Suppression en base de données
        issamUtilisateurDAO.delete(id);

        // Issam : Redirection vers la liste des utilisateurs
        response.sendRedirect("issam-utilisateurs");
    }
}