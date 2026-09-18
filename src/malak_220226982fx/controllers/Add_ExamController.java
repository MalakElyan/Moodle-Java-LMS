/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
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
public class Add_ExamController implements Initializable {

    @FXML
    private Label Add_Exam_lbl;
    @FXML
    private Label Exam_ID_lbl;
    @FXML
    private Label Exam_Name_lbl;
    @FXML
    private Label Number_Of_Questions_lbl;
    @FXML
    private Label Minimum_Passing_Average_lbl;
    @FXML
    private TextField Exam_ID_TF;
    @FXML
    private TextField Exam_Name_TF;
    @FXML
    private TextField Number_Of_Questions_TF;
    @FXML
    private TextField Allowed_Question_Types_TF;
    @FXML
    private TextField Number_Of_Questions_To_Add_TF;
    @FXML
    private Label Allowed_Question_Types_lbl;
    @FXML
    private Label Number_Of_Questions_To_Add_lbl;
    @FXML
    private TextField Minimum_Passing_Average_TF;
    @FXML
    private Button Add_Exam_btn;
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
    private void addExam(ActionEvent event) {
    int examId = Integer.parseInt(Exam_ID_TF.getText());
    String examName = Exam_Name_TF.getText();
    int numQuestions = Integer.parseInt(Number_Of_Questions_TF.getText());
    double minPassAverage = Double.parseDouble(Minimum_Passing_Average_TF.getText());

    HashMap<String, Integer> allowedQuestionTypes = new HashMap<>();
    String allowedTypesText = Allowed_Question_Types_TF.getText();
    String numQuestionsText = Number_Of_Questions_To_Add_TF.getText();

    String[] allowedTypesArray = allowedTypesText.split(",");
    String[] numQuestionsArray = numQuestionsText.split(",");

    if (allowedTypesArray.length != numQuestionsArray.length) {
        System.out.println("Invalid input: Number of allowed question types does not match number of questions to add.");
        return;
    }

    for (int i = 0; i < allowedTypesArray.length; i++) {
        String allowedType = allowedTypesArray[i].trim();
        int numQuestionsOfType = Integer.parseInt(numQuestionsArray[i].trim());
        allowedQuestionTypes.put(allowedType, numQuestionsOfType);
    }

    // Now you can call the addExam() function with the provided parameters
    exam_system.addExam(examId, examName, numQuestions, minPassAverage, allowedQuestionTypes);
    
    Exam_ID_TF.clear();
    Exam_Name_TF.clear();
    Number_Of_Questions_TF.clear();
    Minimum_Passing_Average_TF.clear();
    Allowed_Question_Types_TF.clear();
    Number_Of_Questions_To_Add_TF.clear();
}
    

    @FXML
    private void Back(ActionEvent event) {
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
    }
    
}
