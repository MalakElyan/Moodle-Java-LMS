/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Admin_Main_MenuController implements Initializable {

    @FXML
    private Button Add_teacher_btn;
    @FXML
    private Button Add_student_btn;
    @FXML
    private Button View_teacher_btn;
    @FXML
    private Button View_student_btn;
    @FXML
    private Button Return_to_login_screen_btn;
    @FXML
    private Label Admin_menue_lbl;

    Exam_system exam_system = new Exam_system();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addTeacher(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_Teachers.fxml"));
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
    } 
    

    @FXML
    private void addStudent(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_Students.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
        // Access the controller of Add_Students.fxml
        Add_StudentsController addStudentsController = loader.getController();
        
        // Set the previous scene
        addStudentsController.setPreviousScene(((Node) event.getSource()).getScene());
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void viewAllteachers(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View_All_Teachers.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void viewAllstudents(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View_All_Students.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
         // Access the controller of Add_Students.fxml
        View_All_StudentsController viewAllStudentsController = loader.getController();
        
        // Set the previous scene
        viewAllStudentsController.setPreviousScene(((Node) event.getSource()).getScene());
            
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void Return(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
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
    }
    
    
    
}
