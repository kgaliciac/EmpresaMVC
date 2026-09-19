package com.empresa.modelo;

/**
 *
 * @author kathy
 */

import java.sql.*;
import java.util.*;

public class ClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
                lista.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    public void insertar(Cliente c) {
        String sql = "INSERT INTO clientes(nombre,email) VALUES(?,?)";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
