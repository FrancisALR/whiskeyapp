package loginapp;

import admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginstatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDbConnected()) {
            this.dbstatus.setText("Connected");
        } else {
            this.dbstatus.setText("Not Connected");
        }
    }

    public void login(ActionEvent action) {
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText())) {
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                adminLogin();
            } else {
                this.loginstatus.setText("Invalid Credentials");
            }
        } catch (Exception e) {

        }
    }

    @FXML
    public void adminLogin() {
        try {
            Stage adminStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/admin/admin.fxml").openStream());

            AdminController adminController = (AdminController) loader.getController();
            Scene scene = new Scene(root);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
