package malak_220226982fx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Add_StudentsController implements Initializable {
    
    Exam_system exam_system = Exam_system.getInstance();

    @FXML
    private Label Add_Student_lbl;
    @FXML
    private Label Student_Username_lbl;
    @FXML
    private Label Student_Password_lbl;
    @FXML
    private Label Student_Name_lbl;
    @FXML
    private Label Student_UniversityId_lbl;
    @FXML
    private Label Student_Birthdate_lbl;
    @FXML
    private Label Student_Gender_lbl;
    @FXML
    private TextField Student_Username_TF;
    @FXML
    private TextField Student_Password_TF;
    @FXML
    private TextField Student_Name_TF;
    @FXML
    private TextField Student_UniversityId_TF;
    @FXML
    private TextField Student_Birthdate_TF;
    @FXML
    private TextField Student_Gender_TF;
    @FXML
    private Button Add_student_btn;
    @FXML
    private Button back_btn;
    
    private Scene previousScene;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addStudent(ActionEvent event) {
        
        String username = Student_Username_TF.getText();
        String password = Student_Password_TF.getText();
        String name = Student_Name_TF.getText();
        String birthdate = Student_Birthdate_TF.getText();
        String gender = Student_Gender_TF.getText();
        int UniversityId = Integer.parseInt(Student_UniversityId_TF.getText());
        
      exam_system.addStudent(new Student(UniversityId, username, password, name, gender, birthdate));
       
      Student_Username_TF.clear();
      Student_Password_TF.clear();
      Student_Name_TF.clear();
      Student_Birthdate_TF.clear();
      Student_Gender_TF.clear();
      Student_UniversityId_TF.clear();
    }
    

    @FXML
    private void Back(ActionEvent event) {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(previousScene);
    stage.show();
    }
    
    public void setPreviousScene(Scene scene) {
    previousScene = scene;
    }
    
}
