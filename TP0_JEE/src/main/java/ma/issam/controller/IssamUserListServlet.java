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
import java.util.List;

/**
 * Issam : Servlet pour afficher la liste des utilisateurs
 * URL : /issam-utilisateurs
 */
@WebServlet("/issam-utilisateurs")
public class IssamUserListServlet extends HttpServlet {

    private IssamUtilisateurDAO issamUtilisateurDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    /**
     * Issam : Affiche tous les utilisateurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération de tous les utilisateurs
        List<IssamUtilisateur> utilisateurs = issamUtilisateurDAO.findAll();

        // Issam : Envoi de la liste à la JSP
        request.setAttribute("utilisateurs", utilisateurs);

        // Issam : Redirection vers la JSP d'affichage
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-utilisateur-liste.jsp");
        dispatcher.forward(request, response);
    }
}