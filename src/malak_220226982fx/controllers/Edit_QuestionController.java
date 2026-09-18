package malak_220226982fx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Edit_QuestionController implements Initializable {

    @FXML
    private Label Qustion_ID_lbl;
    @FXML
    private Label New_Question_Text_lbl;
    @FXML
    private Label New_Question_Mark_lbl;
    @FXML
    private TextField Qustion_ID_TF;
    @FXML
    private TextField New_Question_Text_TF;
    @FXML
    private TextField New_Question_Mark_TF;
      @FXML
    private Button Edit_Question_btn;
    @FXML
    private Label New_Question_Answer_lbl;
    @FXML
    private Label New_Choices_lbl;
    @FXML
    private TextField New_Question_Answer_TF;
    @FXML
    private TextField New_Choices_TF;
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
    private void editQuestion(ActionEvent event) {
        int questionId = Integer.parseInt(Qustion_ID_TF.getText());
        String newQuestionText = New_Question_Text_TF.getText();
        double newMark = Double.parseDouble(New_Question_Mark_TF.getText());
        String newAnswer = New_Question_Answer_TF.getText();
        String choicesString = New_Choices_TF.getText();
        List<String> newChoices = Arrays.asList(choicesString.split(","));

        // استدعاء الدالة editQuestion مع المعلومات المستخرجة
        exam_system.editQuestion(questionId, newQuestionText, newMark, newAnswer, newChoices);

        // إعادة تعيين حقول الإدخال
        Qustion_ID_TF.setText("");
        New_Question_Text_TF.setText("");
        New_Question_Mark_TF.setText("");
        New_Question_Answer_TF.setText("");
        New_Choices_TF.setText("");

        // عرض رسالة تأكيد
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Edit Question");
        alert.setHeaderText(null);
        alert.setContentText("Question edited successfully!");
        alert.showAndWait();
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
