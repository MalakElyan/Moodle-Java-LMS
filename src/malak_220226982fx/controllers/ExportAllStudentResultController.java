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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class ExportAllStudentResultController implements Initializable {

   
    @FXML
    private Label studentID_lbl;
    @FXML
    private Label filePath_lbl;
    @FXML
    private Button export_btn;
    @FXML
    private TextField studentID_TF;
    @FXML
    private TextField filePath_TF;
    @FXML
    private Button back_btn;

    Exam_system examSystem = Exam_system.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Export(ActionEvent event) {
        try{
        int studentId = Integer.parseInt(studentID_TF.getText());
        String filePath = filePath_TF.getText();
        
        examSystem.exportStudentExamResultsToFile(filePath, studentId);
        
        studentID_TF.clear();
        filePath_TF.clear();
        } catch (NumberFormatException e) {
        System.out.println("Invalid input: Please enter a valid numeric value for Student ID.");
        } catch (Exception e) {
        System.out.println("An error occurred while exporting the student's exam results: " + e.getMessage());
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
