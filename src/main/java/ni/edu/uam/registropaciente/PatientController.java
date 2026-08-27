package ni.edu.uam.registropaciente;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import ni.edu.uam.registropaciente.dao.PatientDAO;
import ni.edu.uam.registropaciente.modelos.Patient;

import java.time.LocalDate;

public class PatientController {

    private final PatientDAO listado = new PatientDAO();
    private final ToggleGroup grupoGenero = new ToggleGroup();

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private DatePicker dpFechaNac;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private RadioButton rbFemenino;

    @FXML
    private CheckBox cbTieneSeguro;

    @FXML
    private Label lblRegistros;

    @FXML
    private ListView<String> lvRegistros;

    @FXML
    private void initialize() {
        // Ambos botones pertenecen al mismo grupo: solo se puede elegir uno.
        rbMasculino.setToggleGroup(grupoGenero);
        rbFemenino.setToggleGroup(grupoGenero);

        // La fecha se selecciona con el calendario.
        dpFechaNac.setEditable(false);
        mostrarRegistros();
    }

    @FXML
    protected void guardarOnClick() {
        if (!validarDatos()) {
            return;
        }

        leerDatos();
        mostrarRegistros();
        limpiarCampos();
    }

    private boolean validarDatos() {
        if (txtNombres.getText().trim().isEmpty()) {
            mostrarMensaje("Ingrese los nombres del paciente.");
            return false;
        }

        if (txtApellidos.getText().trim().isEmpty()) {
            mostrarMensaje("Ingrese los apellidos del paciente.");
            return false;
        }

        if (dpFechaNac.getValue() == null) {
            mostrarMensaje("Seleccione la fecha de nacimiento.");
            return false;
        }

        if (dpFechaNac.getValue().isAfter(LocalDate.now())) {
            mostrarMensaje("La fecha de nacimiento no puede ser futura.");
            return false;
        }

        if (grupoGenero.getSelectedToggle() == null) {
            mostrarMensaje("Seleccione el género del paciente.");
            return false;
        }

        return true;
    }

    private void leerDatos() {
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        LocalDate fechaNacimiento = dpFechaNac.getValue();
        boolean tieneSeguro = cbTieneSeguro.isSelected();

        String genero;
        if (rbMasculino.isSelected()) {
            genero = "Masculino";
        } else {
            genero = "Femenino";
        }

        Patient paciente = new Patient(nombres, apellidos, fechaNacimiento,
                genero, tieneSeguro);
        agregarDatos(paciente);
    }

    private void agregarDatos(Patient paciente) {
        listado.agregar(paciente);
    }

    private void mostrarRegistros() {
        lvRegistros.getItems().clear();

        for (Patient paciente : listado.obtenerRegistros()) {
            String seguro = "No";
            if (paciente.isTieneSeguro()) {
                seguro = "Sí";
            }

            // Cada paciente ocupa un elemento de la lista.
            lvRegistros.getItems().add(
                    "Paciente: " + paciente.getNombres() + " " + paciente.getApellidos()
                            + "\nFecha de nacimiento: " + paciente.getFechaNacimiento()
                            + "\nGénero: " + paciente.getGenero()
                            + "\nTiene seguro: " + seguro
            );
        }

        lblRegistros.setText("Registros Guardados: "
                + listado.obtenerRegistros().size());
    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        dpFechaNac.setValue(null);
        grupoGenero.selectToggle(null);
        cbTieneSeguro.setSelected(false);
        txtNombres.requestFocus();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Registro de pacientes");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
