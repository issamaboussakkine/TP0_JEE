package ma.issam.controller;

// Issam : Imports
import ma.issam.dao.IssamUtilisateurDAO;
import ma.issam.entities.IssamUtilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Issam : Servlet pour créer un nouvel utilisateur
 * URL : /issam-creer-utilisateur
 */
@WebServlet("/issam-creer-utilisateur")
public class IssamUserCreateServlet extends HttpServlet {
    
    private IssamUtilisateurDAO issamUtilisateurDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    /**
     * Issam : Traitement du formulaire POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Issam : Récupération des données du formulaire
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        // Issam : Création et sauvegarde de l'utilisateur
        IssamUtilisateur nouvelUtilisateur = new IssamUtilisateur(prenom, nom, email, motDePasse);
        issamUtilisateurDAO.save(nouvelUtilisateur);

        // Issam : Redirection vers la liste
        response.sendRedirect("issam-utilisateurs");
    }
}