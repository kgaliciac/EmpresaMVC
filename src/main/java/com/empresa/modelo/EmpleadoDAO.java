package com.empresa.modelo;

/**
 *
 * @author kathy
 */

import java.sql.*;
import java.util.*;
import java.sql.Date;

public class EmpleadoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("puesto"),
                    rs.getDate("fecha_contratacion").toLocalDate()
                );
                lista.add(e);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return lista;
    }

    public void insertar(Empleado e) {
        String sql = "INSERT INTO empleados(nombre,apellidos,puesto,fecha_contratacion) VALUES(?,?,?,?)";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getPuesto());
            ps.setDate(4, Date.valueOf(e.getFechaContratacion()));
            ps.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public void actualizar(Empleado e) {
        String sql = "UPDATE empleados SET nombre=?, apellidos=?, puesto=?, fecha_contratacion=? WHERE id=?";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getPuesto());
            ps.setDate(4, Date.valueOf(e.getFechaContratacion()));
            ps.setInt(5, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id=?";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
