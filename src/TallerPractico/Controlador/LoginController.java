package TallerPractico.Controlador;
import TallerPractico.Controlador.FilesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


// Aqui van los Controladores de la Ventana Login
public class LoginController {
    public Button btnacces;
    public TextField txtUser;
    public PasswordField txtPassword;
    String user, UserAuth, password, passAuth;
    Stage summonWindows = new Stage();
    FilesController filesController = new FilesController();
    String archivo = "src/TallerPractico/Modelo/Users.txt";
    public void clickEntrar(ActionEvent actionEvent) {
        this.user = txtUser.getText();
        this.password = txtPassword.getText();
        boolean loginExitoso = false;

        ArrayList<String> datos = filesController.consultarRegistros(archivo);
        for (String cadena : datos) {
            String[] valores = cadena.split(",\\s*");
            if (valores.length >= 2) {
                UserAuth = valores[0].trim();
                passAuth = valores[1].trim();

                if (user.equals(UserAuth) && password.equals(passAuth)) {
                    loginExitoso = true;
                    break;
                }
            }
        }

        if (loginExitoso) {
            mensaje("Login Confirmado", "Es un placer tenerte de vuelta");
            llamarVentana("/TallerPractico/Vista/Inicio.fxml", "Principal");
        } else {
            mensaje("Login Erroneo", "Por favor verifique la información");
        }
    }

    public void clickRegistro(ActionEvent actionEvent) {
        llamarVentana("/TallerPractico/Vista/Registro.fxml","Registro");
    }
    public void mensaje(String title, String body){

        Alert popAlerta = new Alert(Alert.AlertType.INFORMATION);
        popAlerta.setTitle(title);
        popAlerta.setHeaderText("");
        popAlerta.setContentText(body);
        popAlerta.showAndWait();
    }
    public void llamarVentana(String ruta, String title){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ruta)));
            summonWindows.setTitle(title);
            summonWindows.setScene(new Scene(root));


            summonWindows.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
