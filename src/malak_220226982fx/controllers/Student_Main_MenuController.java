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
public class Student_Main_MenuController implements Initializable {

    @FXML
    private Label Student_Main_Menu_lbl;
    @FXML
    private Button solve_exam_btn;
    @FXML
    private Button View_his_own_result_details_btn;
    @FXML
    private Button Edit_information_btn;
    @FXML
    private Button Export_results_to_text_file_btn;
    @FXML
    private Button View_rank_btn;
    @FXML
    private Button Export_exam_to_JSON_file_btn;
    @FXML
    private Button Return_to_login_screen_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void solveExamQuestion(ActionEvent event) {
        openScene(event, "Solve_Exam.fxml");
    }

    @FXML
    private void viewResultDetails(ActionEvent event) {
        openScene(event, "viewAllStudentExamResult.fxml");
    }

    @FXML
    private void editInformation(ActionEvent event) {
        openScene(event, "editStudentInformation.fxml");
    }

    @FXML
    private void exportResults(ActionEvent event) {
        openScene(event, "exportAllStudentResult.fxml");
    }

    @FXML
    private void viewRank(ActionEvent event) {
        openScene(event, "viewStudentsRanks.fxml");
    }

    @FXML
    private void exportExamJson(ActionEvent event) {
        openScene(event, "exportExamToJsonFile.fxml");
    }

    private void openScene(ActionEvent event, String viewName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error loading " + viewName + ": " + ex.getMessage());
        }
    }

    @FXML
    private void Return(ActionEvent event) {
        openScene(event, "FXMLDocument.fxml");
    }
    
    
}
