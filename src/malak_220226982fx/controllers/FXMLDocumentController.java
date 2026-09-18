package malak_220226982fx;

import java.awt.Color;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController {
     
    @FXML
    private Label Login_Screen_lbl;
    @FXML
    private Label Username_lbl;
    @FXML
    private Label Pasword_lbl;
    @FXML
    private TextField Username_TF;
    @FXML
    private Button Login_btn;
    @FXML
    private PasswordField Password_PF;
    @FXML
    private Label label;
    @FXML
    private Label Invalid_lbl;
    
    Exam_system exam_system = Exam_system.getInstance();
    
    @FXML
    private void validateLogin(ActionEvent event) {
    String username = Username_TF.getText();
    String password = Password_PF.getText();
    
    String loginResult = exam_system.validateLogin(username, password);
    
    if (loginResult.equals("admin")) {
        // تنفيذ الإجراءات الخاصة بمستخدم الأدمن
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_Main_Menu.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    } else if (loginResult.equals("student")) {
        // تنفيذ الإجراءات الخاصة بطالب
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Student_Main_Menu.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    } else if (loginResult.equals("teacher")) {
        // تنفيذ الإجراءات الخاصة بمعلم
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Teacher_Main_Menu.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    } else {
        // معالجة حالة الدخول غير الصحيحة
        Invalid_lbl.setText("Invalid username or password.");
        Invalid_lbl.setStyle("-fx-text-fill: red;");
    }
}
    
}
  
