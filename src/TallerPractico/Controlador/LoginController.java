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
import java.util.ArrayList;
import java.util.Objects;


// Aqui van los Controladores de la Ventana Login
public class LoginController {
    public Button btnacces;
    public TextField txtUser;
    public PasswordField txtPassword;
    String user, UserAuth, password, passAuth;
    Stage principalWindow = new Stage();
    Stage registroWindows = new Stage();
    FilesController filesController = new FilesController();
    String archivo = "src/TallerPractico/Modelo/Users.txt";




    public void clickEntrar(ActionEvent actionEvent){
        this.user = txtUser.getText();
        this.password = txtPassword.getText();

        ArrayList<String> datos = filesController.consultarRegistros(archivo);
        for (String cadena : datos) {
            String[] valores = cadena.split(",\\s*");
            if (valores.length >= 2) {
                UserAuth = valores[0].trim();
                passAuth = valores[1].trim();


                if (user.equals(UserAuth) && password.equals(passAuth)) {

                    Alert popAlerta = new Alert(Alert.AlertType.INFORMATION);
                    popAlerta.setTitle("Login Confirmado");
                    popAlerta.setHeaderText("");
                    popAlerta.setContentText("Bienvenido a la mejor vet de todas");
                    popAlerta.showAndWait();

                    // Abriendo la Ventana Principal

                    try {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/TallerPractico/Vista/Inicio.fxml")));
                        principalWindow.setTitle("Principal");
                        principalWindow.setScene(new Scene(root, 317, 423));
                        principalWindow.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert popAlerta = new Alert(Alert.AlertType.INFORMATION);
                    popAlerta.setTitle("Login Erroneo");
                    popAlerta.setHeaderText("");
                    popAlerta.setContentText("Por favor verifique la información");
                    popAlerta.showAndWait();
                }


            }
        }
    }

    public void clickRegistro(ActionEvent actionEvent) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/TallerPractico/Vista/Registro.fxml")));
            registroWindows.setTitle("Registro");
            registroWindows.setScene(new Scene(root, 317, 423));
            registroWindows.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
