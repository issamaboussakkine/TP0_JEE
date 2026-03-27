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
import java.util.List;

@WebServlet("/issam-utilisateurs")
public class IssamUserListServlet extends HttpServlet {
    private IssamUtilisateurDAO issamUtilisateurDAO;

    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<IssamUtilisateur> utilisateurs = issamUtilisateurDAO.findAll();
        request.setAttribute("utilisateurs", utilisateurs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-utilisateur-liste.jsp");
        dispatcher.forward(request, response);
    }
}