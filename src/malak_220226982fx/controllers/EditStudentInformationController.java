/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class EditStudentInformationController implements Initializable {

    @FXML
    private Label Student_Id_lbl;
    @FXML
    private Label New_Student_Password_lbl;
    @FXML
    private Label New_Student_Name_lbl;
    @FXML
    private Label New_Student_Birthdate_lbl;
    @FXML
    private Label New_Student_Gender_lbl;
    @FXML
    private TextField Student_Id_TF;
    @FXML
    private TextField New_Student_Password_TF;
    @FXML
    private TextField New_Student_Name_TF;
    @FXML
    private TextField New_Student_Birthdate_TF;
    @FXML
    private TextField New_Student_Gender_TF;
    @FXML
    private Button edit_btn;
    @FXML
    private Button back_btn;

    Exam_system exam_system = Exam_system.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Edit(ActionEvent event) {
        try{
        int studentId = Integer.parseInt(Student_Id_TF.getText());
        String newStudentPassword = New_Student_Password_TF.getText();
        String newStudentName = New_Student_Name_TF.getText();
        String newBirthdate = New_Student_Birthdate_TF.getText();
        String newStudentGender = New_Student_Gender_TF.getText();
        
        // استدعاء الدالة editQuestion مع المعلومات المستخرجة
        exam_system.editStudent(studentId, newStudentPassword, newStudentName, newBirthdate, newStudentGender);

        // إعادة تعيين حقول الإدخال
        Student_Id_TF.setText("");
        New_Student_Password_TF.setText("");
        New_Student_Name_TF.setText("");
        New_Student_Birthdate_TF.setText("");
        New_Student_Gender_TF.setText("");

        // عرض رسالة تأكيد
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Student Information");
        alert.setHeaderText(null);
        alert.setContentText("Student Information edited successfully!");
        alert.showAndWait();
        } catch (NumberFormatException e) {
        System.out.println("Invalid input: Please enter a valid numeric value for Student ID.");
    } catch (Exception e) {
        System.out.println("An error occurred while editing the student information: " + e.getMessage());
    }
    }

    @FXML
    private void Back(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Student_Main_Menu.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Student Main Menu");
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }
    
}
