    package TallerPractico.Controlador;

    import TallerPractico.Modelo.Persona;
    import javafx.event.ActionEvent;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;

    public class registroController {
        public TextField userRegistroTxt;
        public TextField PasswordRegistroTxt;
        public Button btnRegistro;
        String user, password;
        FilesController filesController = new FilesController();
        Persona persona1 = new Persona();
        public void clickRegistro(ActionEvent actionEvent) {
            this.user = userRegistroTxt.getText();
            this.password = PasswordRegistroTxt.getText();
            Persona nuevaPersona = new Persona(user, password);
            String registro = nuevaPersona.toString();
            String archivo = "src/TallerPractico/Modelo/Users.txt";
            filesController.AgregarRegistro(archivo, registro);

            mensaje("Registro Completo","Enhorabuena se ha registrado con éxito");
        }
        public void autentificador(){}

        public void mensaje(String title, String body){

            Alert popAlerta = new Alert(Alert.AlertType.INFORMATION);
            popAlerta.setTitle(title);
            popAlerta.setHeaderText("");
            popAlerta.setContentText(body);
            popAlerta.showAndWait();
        }
    }
