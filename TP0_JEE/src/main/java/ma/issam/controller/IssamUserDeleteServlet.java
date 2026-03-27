package ma.issam.controller;

import ma.issam.dao.IssamUtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/issam-supprimer-utilisateur")
public class IssamUserDeleteServlet extends HttpServlet {
    private IssamUtilisateurDAO issamUtilisateurDAO;

    public void init() {
        issamUtilisateurDAO = new IssamUtilisateurDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        issamUtilisateurDAO.delete(id);
        response.sendRedirect("issam-utilisateurs");
    }
}