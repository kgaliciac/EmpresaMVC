package com.empresa.controlador;

/**
 *
 * @author kathy
 */

import com.empresa.modelo.Empleado;
import com.empresa.modelo.EmpleadoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/EmpleadoServlet")

public class EmpleadoServlet extends HttpServlet {
    EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleado> lista = dao.listar();
        request.setAttribute("listaEmpleados", lista);
        RequestDispatcher rd = request.getRequestDispatcher("vista/empleados.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String puesto = request.getParameter("puesto");
        LocalDate fechaContratacion = LocalDate.parse(request.getParameter("fechaContratacion"));

        Empleado e = new Empleado(0, nombre, apellidos, puesto, fechaContratacion);
        dao.insertar(e);

        response.sendRedirect("EmpleadoServlet");
    }
}
