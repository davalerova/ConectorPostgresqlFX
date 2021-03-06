package interfaz;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.fxml.*;

import java.util.Scanner;

import modelo.Captcha;
import modelo.Cliente;
import modelo.ProcesoInformacionCliente;
import modelo.Login;


public class Main extends Application {
    private Scanner input;
    private Cliente cliente;
    private ProcesoInformacionCliente procesoCliente;
    private Login login;
    private Captcha cp;
    private boolean robot;


    @FXML
    private TextField usuario;
    @FXML
    private PasswordField clave;
    @FXML
    private Button norobot;
    @FXML
    private TextField captchaout;
    @FXML
    private TextField captchain;
    @FXML
    private Button ingresar;
    @FXML
    private TextField salida;

    public Main() {
        this.input=new Scanner(System.in);
        this.procesoCliente=new ProcesoInformacionCliente();
        this.cliente=new Cliente();
        this.login=new Login();
        this.robot=false;

    }


    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("HJCSoft");
        stage.show();

    }
    public void stop() {
        System.exit(0);
    }

    @FXML
    protected boolean iniciaSesion() {
        this.login=new Login();
        String user = usuario.getText();
        String contra = clave.getText();
        int captcha = Integer.parseInt(captchain.getText());
        login.setUsuario(user);
        login.setContrasena(contra);
        if(procesoCliente.validarUsuario(login).equals(user)&&!(user.length()==0||contra.length()==0)&&captcha==cp.getSum()&&robot){
            salida.setText("Bienvenid@ "+user);
            //robot=false;
            return true;
        }
        else{
            salida.setText("Contraseña o usuario incorrecto, intente de nuevo");
            captchaout.setText("");
            procesoCliente.registrarLoginFallido(login);
            robot=false;
            return false;
        }
    }
    @FXML
    protected void captcha() {
        this.robot=true;
        cp = new Captcha();
        captchaout.setText(cp.validarCaptha());
    }

    public static void main(String[] args){
        Main app=new Main();
        while(true){
            Application.launch(args);
            if(app.iniciaSesion())break;
        }

    }

}
