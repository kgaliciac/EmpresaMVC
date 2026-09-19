package com.empresa.controlador;

/**
 *
 * @author kathy
 */

import com.empresa.modelo.Producto;
import com.empresa.modelo.ProductoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ProductoServlet")

public class ProductoServlet extends HttpServlet {
    ProductoDAO dao = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> lista = dao.listar();
        request.setAttribute("listaProductos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("vista/productos.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String marca = request.getParameter("marca");

        Producto p = new Producto(0, nombre, precio, stock, marca);
        dao.insertar(p);

        response.sendRedirect("ProductoServlet");
    }
}