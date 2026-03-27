package ma.issam.controller;

import ma.issam.dao.IssamProduitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/issam-supprimer-produit")
public class IssamProductDeleteServlet extends HttpServlet {
    private IssamProduitDAO issamProduitDAO;

    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        issamProduitDAO.delete((long) id);
        response.sendRedirect("issam-produits");
    }
}