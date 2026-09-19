/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.modelo;

/**
 *
 * @author kathy
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa"; // cambia "empresa" por tu BD
    private static final String USER = "root"; // tu usuario de MySQL
    private static final String PASS = "";     // tu contraseña de MySQL

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver moderno
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la BD");
        } catch (Exception e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
