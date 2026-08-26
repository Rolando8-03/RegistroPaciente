package ni.edu.uam.registropaciente;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ni.edu.uam.registropaciente.dao.PatientDAO;
import ni.edu.uam.registropaciente.modelos.Patient;

public class PatientController {
    PatientDAO pacientes = new PatientDAO();

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private Label lblContador;

    @FXML
    protected void agregarOnClick(){
        leerDatos();
        cantidadPacientes();
        limpiarCampos();
    }

    private void leerDatos(){
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        agregarPaciente(new Patient(nombres,apellidos));
    }

    private void agregarPaciente(Patient patient){
        pacientes.agregarPaciente(patient);
    }

    private void cantidadPacientes(){
        lblContador.setText("Registros Guardados: " +
                pacientes.listarPacientes().size());
    }

    private void limpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtNombres.requestFocus();
    }
}
