/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
public class Add_MCQController implements Initializable {

    @FXML
    private Label Qustion_Id_lbl;
    @FXML
    private Label Question_text_lbl;
    @FXML
    private Label Question_Mark_lbl;
    @FXML
    private Label Question_answer_lbl;
    @FXML
    private Label Option1_lbl;
    @FXML
    private Label Optin2_lbl;
    @FXML
    private Label Option3_lbl;
    @FXML
    private Label Option4_lbl;
    @FXML
    private TextField Qustion_Id_TF;
    @FXML
    private TextField Question_text_TF;
    @FXML
    private TextField Question_Mark_TF;
    @FXML
    private TextField Question_answer_TF;
    @FXML
    private TextField Option1_TF;
    @FXML
    private TextField Optin2_TF;
    @FXML
    private TextField Option4_TF;
    @FXML
    private TextField Option3_TF;
    @FXML
    private Button back_btn;
    @FXML
    private Button add_btn;

    Exam_system exam_system = Exam_system.getInstance();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) {
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
    private void Add(ActionEvent event) {
    int id = Integer.parseInt(Qustion_Id_TF.getText());
    String questionText = Question_text_TF.getText();
    int answer = Integer.parseInt(Question_answer_TF.getText());
    double marks = Double.parseDouble(Question_Mark_TF.getText());

    List<String> choices = new ArrayList<>();
    choices.add(Option1_TF.getText());
    choices.add(Optin2_TF.getText());
    choices.add(Option3_TF.getText());
    choices.add(Option4_TF.getText());

    exam_system.createMCQQuestion(id, questionText, answer, marks, choices);

    // Clear the input fields after adding the question
    Qustion_Id_TF.clear();
    Question_text_TF.clear();
    Question_answer_TF.clear();
    Question_Mark_TF.clear();
    Option1_TF.clear();
    Optin2_TF.clear();
    Option3_TF.clear();
    Option4_TF.clear();
}    
}
