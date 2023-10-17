    package TallerPractico.Controlador;

    import TallerPractico.Modelo.Persona;
    import javafx.event.ActionEvent;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;
    import java.util.ArrayList;

    public class registroController {
        public TextField userRegistroTxt;
        public TextField PasswordRegistroTxt;
        public Button btnRegistro;
        String user, password;
        FilesController filesController = new FilesController();
        public void clickRegistro(ActionEvent actionEvent) {
            this.user = userRegistroTxt.getText();
            this.password = PasswordRegistroTxt.getText();

            String archivo = "src/TallerPractico/Modelo/Users.txt";
            ArrayList<String> registros = filesController.consultarRegistros(archivo);
            boolean usuarioExistente = false;

            for (String registro : registros) {
                String[] valores = registro.split(",\\s*");
                if (valores.length >= 2) {
                    String existingUser = valores[0].trim();
                    if (user.equals(existingUser)) {
                        usuarioExistente = true;
                        break;
                    }
                }
            }

            if (usuarioExistente) {
                mensaje("Registro Fallido", "El usuario ya está registrado");
            } else {
                Persona nuevoUsuario = new Persona(user, password);
                String nuevoRegistro = nuevoUsuario.toString();
                filesController.AgregarRegistro(archivo, nuevoRegistro);
                mensaje("Registro Completo", "Enhorabuena, se ha registrado con éxito");
            }
        }

        public void mensaje(String title, String body){

            Alert popAlerta = new Alert(Alert.AlertType.INFORMATION);
            popAlerta.setTitle(title);
            popAlerta.setHeaderText("");
            popAlerta.setContentText(body);
            popAlerta.showAndWait();
        }
    }
