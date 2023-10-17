package TallerPractico.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InicioController {
    public MenuBar menuPrincipal;
    public MenuBar menuAbout;
    public Button aboutBtn;

    Stage aboutWindow = new Stage();

    public void clickAbout(ActionEvent actionEvent) {
        llamarVentana("/TallerPractico/Vista/About.fxml","About");
    }
    public void llamarVentana(String ruta, String title){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ruta)));
            aboutWindow.setTitle(title);
            aboutWindow.setScene(new Scene(root, 467, 509));
            aboutWindow.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
