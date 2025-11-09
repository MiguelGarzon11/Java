package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import model.Estudiante;
import db.Conexion;


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
            e.printStackTrace();
            return false;
        }

    }
}