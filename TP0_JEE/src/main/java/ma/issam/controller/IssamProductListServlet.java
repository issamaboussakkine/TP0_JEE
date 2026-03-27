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
import java.util.List;

@WebServlet("/issam-produits")
public class IssamProductListServlet extends HttpServlet {
    private IssamProduitDAO issamProduitDAO;

    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<IssamProduit> produits = issamProduitDAO.findAll();
        request.setAttribute("produits", produits);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/issam-produit-liste.jsp");
        dispatcher.forward(request, response);
    }
}