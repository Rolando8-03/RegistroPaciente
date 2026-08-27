package ni.edu.uam.registropaciente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMessage;

    @FXML
    protected void ingresarOnClick() {
        acceder();
    }

    private void acceder() {
        String user = txtUser.getText();
        String password = txtPassword.getText();

        if (user.equals("admin") && password.equals("1234")) {
            mostrarFormularioPaciente();
        } else {
            lblMessage.setText("Usuario o contraseña incorrectos");
        }
    }

    private void mostrarFormularioPaciente() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("patient-view.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) txtUser.getScene().getWindow();
            stage.setTitle("Registro de pacientes");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            lblMessage.setText("No se pudo abrir el formulario");
        }
    }
}