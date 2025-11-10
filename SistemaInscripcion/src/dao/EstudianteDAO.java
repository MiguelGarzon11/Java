package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.Estudiante;
import db.Conexion;
import java.sql.*;


public class EstudianteDAO {
    public boolean registrar(Estudiante estudiante) {

        String sql = "INSERT INTO estudiantes (nombre_completo, documento, programa, celular, correo, semestre, universidad) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getNombreCompleto());
            stmt.setString(2, estudiante.getDocumento());
            stmt.setString(3, estudiante.getPrograma());
            stmt.setString(4, estudiante.getCelular());
            stmt.setString(5, estudiante.getCorreo());
            stmt.setString(6, estudiante.getSemestre());
            stmt.setString(7, estudiante.getUniversidad());


            stmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println(" Documento duplicado: " + estudiante.getDocumento());
            return false;
        } catch (SQLException e) {
            return false;
        }

    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";

        try (Connection conn = Conexion.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante e = new Estudiante(
                    rs.getString("nombre_completo"),
                    rs.getString("documento"),
                    rs.getString("programa"),
                    rs.getString("celular"),
                    rs.getString("correo"),
                    rs.getString("semestre"),
                    rs.getString("universidad")
                );
                lista.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener estudiantes: " + e.getMessage());
        }

        return lista;
    }

}