import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.collections.*;


public class Main extends Application {
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField clave;
    @FXML
    private Button norobot;
    @FXML
    private TextField captchaout;
    @FXML
    private TextField unidades;
    @FXML
    private Button ingresar;
    @FXML
    private TextField salida;

    //private Convertidor conv = new Convertidor(2900.15,3500.25);
    ObservableList<String> os = FXCollections.observableArrayList("USA", "EUR", "COL");

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void stop() {
        System.exit(0);
    }

    @FXML
    protected void convierte() {
        String solucion = (usuario.getText());
        String contra = clave.getText();
       // double user=Double.parseDouble(usuario.getText());
        //System.out.println(usuario.getText());

        salida.setText(""+ contra);
    }
    @FXML
    protected void captcha() {

        captchaout.setText("4+tres");
    }

    public static void main(String[] args){
        Application.launch(args);

    }
}
