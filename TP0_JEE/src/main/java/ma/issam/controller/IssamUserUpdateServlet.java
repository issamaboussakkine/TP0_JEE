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
import java.util.Optional;

/**
 * Issam : Servlet pour modifier un utilisateur
 * URL : /issam-modifier-utilisateur
 */
@WebServlet("/issam-modifier-utilisateur")
public class IssamUserUpdateServlet extends HttpServlet {

    private IssamUtilisateurDAO issamUtilisateurDAO;

    /**
     * Issam : Initialisation du DAO
     */
    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    /**
     * Issam : Traitement du formulaire POST pour modifier un utilisateur
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Issam : Récupération des paramètres du formulaire
        Long id = Long.parseLong(request.getParameter("id"));
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        // Issam : Recherche de l'utilisateur existant
        Optional<IssamUtilisateur> optionalUtilisateur = issamUtilisateurDAO.findById(id);

        // Issam : Mise à jour de l'utilisateur s'il existe
        if (optionalUtilisateur.isPresent()) {
            IssamUtilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setPrenom(prenom);
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);

            // Issam : Mise à jour du mot de passe uniquement s'il est fourni
            if (motDePasse != null && !motDePasse.isEmpty()) {
                utilisateur.setMotDePasse(motDePasse);
            }

            // Issam : Sauvegarde des modifications
            issamUtilisateurDAO.update(utilisateur);
        }

        // Issam : Redirection vers la liste des utilisateurs
        response.sendRedirect("issam-utilisateurs");
    }
}