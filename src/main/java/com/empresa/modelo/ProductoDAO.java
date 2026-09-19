package com.empresa.modelo;

/**
 *
 * @author kathy
 */

import java.sql.*;
import java.util.*;

public class ProductoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("marca")
                );
                lista.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    public void insertar(Producto p) {
        String sql = "INSERT INTO productos(nombre,precio,stock,marca) VALUES(?,?,?,?)";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getMarca());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre=?, precio=?, stock=?, marca=? WHERE id=?";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getMarca());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id=?";
        try {
            con = ConexionBD.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
