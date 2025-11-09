package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import dao.EstudianteDAO;
import model.Estudiante;

public class FormularioEstudiantes {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtPrograma;
    @FXML private TextField txtCelular;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtSemestre;
    @FXML private TextField txtUniversidad;

    @FXML private Button btnRegistrar;
    @FXML private Button btnLimpiar;

    @FXML
    public void initialize() {
        btnRegistrar.setOnAction(e -> registrarEstudiante());
        btnLimpiar.setOnAction(e -> limpiarCampos());
    }

    private void registrarEstudiante() {
        
        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtPrograma.getText().isEmpty()) {
            mostrarAlerta("Por favor, completa los campos obligatorios (Nombre, Documento, Programa).");
            return;
        }

        Estudiante est = new Estudiante(
                txtNombre.getText(),
                txtDocumento.getText(),
                txtPrograma.getText(),
                txtCelular.getText(),
                txtCorreo.getText(),
                txtSemestre.getText(),
                txtUniversidad.getText()
        );

        EstudianteDAO dao = new EstudianteDAO();
        boolean exito = dao.registrar(est);

        if (exito) {
            mostrarAlerta("Estudiante registrado correctamente.");
            limpiarCampos();
        } else {
            mostrarAlerta("Error: el documento ya existe o hubo un problema con la base de datos.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtPrograma.clear();
        txtCelular.clear();
        txtCorreo.clear();
        txtSemestre.clear();
        txtUniversidad.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
