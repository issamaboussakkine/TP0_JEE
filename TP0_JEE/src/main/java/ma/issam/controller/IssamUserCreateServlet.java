package ma.issam.controller;

import ma.issam.dao.IssamUtilisateurDAO;
import ma.issam.entities.IssamUtilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/issam-creer-utilisateur")
public class IssamUserCreateServlet extends HttpServlet {
    private IssamUtilisateurDAO issamUtilisateurDAO;

    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        IssamUtilisateur nouvelUtilisateur = new IssamUtilisateur(prenom, nom, email, motDePasse);
        issamUtilisateurDAO.save(nouvelUtilisateur);

        response.sendRedirect("issam-utilisateurs");
    }
}