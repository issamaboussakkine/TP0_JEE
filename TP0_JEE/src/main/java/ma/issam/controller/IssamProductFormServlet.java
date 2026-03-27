package ma.issam.controller;

import ma.issam.dao.IssamProduitDAO;
import ma.issam.entities.IssamProduit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/issam-produit-form")
public class IssamProductFormServlet extends HttpServlet {
    private IssamProduitDAO issamProduitDAO;

    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("editer")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<IssamProduit> produit = issamProduitDAO.findById((long) id);
            produit.ifPresent(p -> request.setAttribute("produit", p));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-produit-formulaire.jsp");
        dispatcher.forward(request, response);
    }
}