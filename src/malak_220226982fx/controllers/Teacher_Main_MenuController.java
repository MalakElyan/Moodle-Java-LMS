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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Teacher_Main_MenuController implements Initializable {

    @FXML
    private Button Add_students_btn;
    @FXML
    private Button Add_questions_btn;
    @FXML
    private Button View_all_questions_btn;
    @FXML
    private Button View_all_exams_btn;
    @FXML
    private Button View_students_exam_result_btn;
    @FXML
    private Button View_all_students_btn;
    @FXML
    private Button Edit_questions_btn;
    @FXML
    private Button Add_exam_btn;
    @FXML
    private Button View_exams_results_btn;
    @FXML
    private Button Export_exams_to_text_file_btn;
    @FXML
    private Button Return_to_login_screen_btn;
    @FXML
    private Label Teacher_Main_Menu_lbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void viewAllstudents(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View_All_Students.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
        
        
       View_All_StudentsController viewAllStudentsController = loader.getController();
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
    private void addquestions(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_Question.fxml"));
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
    private void viewAlQuestions(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("View_All_Question.fxml"));
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
    private void viewAllExams(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("View_Exams.fxml"));
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
    private void viewStudentsExamResult(ActionEvent event) {
    }

    @FXML
    private void editquestions(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit_Question.fxml"));
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
    private void addExam(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_Exam.fxml"));
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
    private void viewExamsResults(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewAllExamsResult.fxml"));
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
    private void exportExamsToTextFile(ActionEvent event) {
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
    

