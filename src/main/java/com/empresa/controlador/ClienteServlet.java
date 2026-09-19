package com.empresa.controlador;

/**
 *
 * @author kathy
 */

import com.empresa.modelo.Cliente;
import com.empresa.modelo.ClienteDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ClienteServlet")

public class ClienteServlet extends HttpServlet {
    ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listaClientes", dao.listar());
        RequestDispatcher rd = request.getRequestDispatcher("vista/clientes.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        Cliente c = new Cliente(0, nombre, email);
        dao.insertar(c);
        response.sendRedirect("ClienteServlet");
    }
}
