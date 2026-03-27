package ma.issam.controller;

import ma.issam.dao.IssamUtilisateurDAO;
import ma.issam.entities.IssamUtilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/issam-modifier-utilisateur")
public class IssamUserUpdateServlet extends HttpServlet {
    private IssamUtilisateurDAO issamUtilisateurDAO;

    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        Optional<IssamUtilisateur> optionalUtilisateur = issamUtilisateurDAO.findById(id);
        if (optionalUtilisateur.isPresent()) {
            IssamUtilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setPrenom(prenom);
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);

            if (motDePasse != null && !motDePasse.isEmpty()) {
                utilisateur.setMotDePasse(motDePasse);
            }

            issamUtilisateurDAO.update(utilisateur);
        }

        response.sendRedirect("issam-utilisateurs");
    }
}