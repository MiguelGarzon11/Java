package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import dao.EstudianteDAO;
import model.Estudiante;

public class FormularioEstudiantes extends JFrame {

    private JTextField txtNombre, txtDocumento, txtPrograma, txtCelular, txtCorreo, txtSemestre, txtUniversidad;
    private JButton btnRegistrar, btnLimpiar, btnVerEstudiantes;

    public FormularioEstudiantes() {
        setTitle("Registro de Estudiantes");
        setSize(450, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Campos
        txtNombre = new JTextField();
        txtDocumento = new JTextField();
        txtPrograma = new JTextField();
        txtCelular = new JTextField();
        txtCorreo = new JTextField();
        txtSemestre = new JTextField();
        txtUniversidad = new JTextField();

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnLimpiar = new JButton("Limpiar");
        btnVerEstudiantes = new JButton("Ver Estudiantes");

        // Agregar componentes al panel
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Documento:"));
        panel.add(txtDocumento);
        panel.add(new JLabel("Programa:"));
        panel.add(txtPrograma);
        panel.add(new JLabel("Celular:"));
        panel.add(txtCelular);
        panel.add(new JLabel("Correo:"));
        panel.add(txtCorreo);
        panel.add(new JLabel("Semestre:"));
        panel.add(txtSemestre);
        panel.add(new JLabel("Universidad:"));
        panel.add(txtUniversidad);

        panel.add(btnRegistrar);
        panel.add(btnLimpiar);
        panel.add(btnVerEstudiantes);

        add(panel);

        // Eventos de botones
        btnRegistrar.addActionListener(e -> registrarEstudiante());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnVerEstudiantes.addActionListener(e -> mostrarEstudiantes());
    }

    private void registrarEstudiante() {
        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtPrograma.getText().isEmpty()) {
            mostrarMensaje("Por favor, completa los campos obligatorios (Nombre, Documento, Programa).");
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
            mostrarMensaje("Estudiante registrado correctamente.");
            limpiarCampos();
        } else {
            mostrarMensaje("Error: el documento ya existe o hubo un problema con la base de datos.");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtPrograma.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        txtSemestre.setText("");
        txtUniversidad.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void mostrarEstudiantes() {
        EstudianteDAO dao = new EstudianteDAO();
        List<Estudiante> lista = dao.obtenerTodos();

        if (lista.isEmpty()) {
            mostrarMensaje("No hay estudiantes registrados.");
            return;
        }

        // Crear una nueva ventana con JTable
        JFrame frameTabla = new JFrame("Lista de Estudiantes");
        frameTabla.setSize(800, 400);
        frameTabla.setLocationRelativeTo(this);

        String[] columnas = {"Nombre", "Documento", "Programa", "Celular", "Correo", "Semestre", "Universidad"};
        String[][] datos = new String[lista.size()][columnas.length];

        for (int i = 0; i < lista.size(); i++) {
            Estudiante e = lista.get(i);
            datos[i][0] = e.getNombreCompleto();
            datos[i][1] = e.getDocumento();
            datos[i][2] = e.getPrograma();
            datos[i][3] = e.getCelular();
            datos[i][4] = e.getCorreo();
            datos[i][5] = e.getSemestre();
            datos[i][6] = e.getUniversidad();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);

        frameTabla.add(scroll);
        frameTabla.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioEstudiantes().setVisible(true));
    }
}

