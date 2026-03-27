package ma.issam.controller;

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

@WebServlet("/issam-utilisateur-form")
public class IssamUserFormServlet extends HttpServlet {
    private IssamUtilisateurDAO issamUtilisateurDAO;

    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("editer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<IssamUtilisateur> utilisateur = issamUtilisateurDAO.findById((long) id);
            utilisateur.ifPresent(u -> request.setAttribute("utilisateur", u));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-utilisateur-formulaire.jsp");
        dispatcher.forward(request, response);
    }
}