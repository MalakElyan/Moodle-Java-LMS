/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class ViewResultDetailsController implements Initializable {

    
    @FXML
    private TextArea viewResultDetails_TA;
    @FXML
    private Button back_btn;

    private String resultDetails;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewResultDetails_TA.setText(resultDetails);
        viewResultDetails_TA.setEditable(false);
    }  
    
//    public void setResultDetails(String details) {
//        resultDetails = details;
//        if (viewResultDetails_TA != null) {
//            viewResultDetails_TA.setText(resultDetails);
//        }
//    }

    public void setExamDetails(Exam exam, Map<Question, String> studentAnswers,String studentId) {
    try {
    StringBuilder result = new StringBuilder();
    result.append("Exam ID: ").append(exam.getId()).append("\n");
    result.append("Student ID: ").append(studentId).append("\n");
    
    double totalMarks = 0.0;
    int questionNumber = 1;
    for (Question question : exam.getQuestions()) {
        result.append("Question ").append(questionNumber).append(":").append("\n");
        result.append("Student's Answer: ").append(studentAnswers.get(question)).append("\n");
        
        if (question instanceof YesNoQuestion) {
            YesNoQuestion yesNoQuestion = (YesNoQuestion) question;
            boolean correctAnswer = yesNoQuestion.getAnswer();
            result.append("Correct Answer: ").append(correctAnswer).append("\n");
            if (studentAnswers.get(question).equalsIgnoreCase(String.valueOf(correctAnswer))) {
                result.append("Marks Obtained: ").append(question.getMarks()).append("\n");
                totalMarks += question.getMarks();
            } else {
                result.append("Marks Obtained: 0").append("\n");
            }
        } else if (question instanceof MCQQuestion) {
            MCQQuestion mcqQuestion = (MCQQuestion) question;
            int correctAnswer = mcqQuestion.getAnswer();
            result.append("Correct Answer: ").append(correctAnswer).append("\n");
            String studentAnswerStr = studentAnswers.get(question);
            if (studentAnswerStr == null || studentAnswerStr.isEmpty()) {
                result.append("Marks Obtained: 0").append("\n");
            } else {
                int studentAnswer = Integer.parseInt(studentAnswerStr);
                if (studentAnswer == correctAnswer) {
                    result.append("Marks Obtained: ").append(question.getMarks()).append("\n");
                    totalMarks += question.getMarks();
                } else {
                    result.append("Marks Obtained: 0").append("\n");
                }
            }
        } else if (question instanceof FillTheBlankQuestion) {
            FillTheBlankQuestion fillBlankQuestion = (FillTheBlankQuestion) question;
            String correctAnswer = fillBlankQuestion.getAnswer();
            result.append("Correct Answer: ").append(correctAnswer).append("\n");
            String studentAnswer = studentAnswers.get(question);
            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                result.append("Marks Obtained: ").append(question.getMarks()).append("\n");
                totalMarks += question.getMarks();
            } else {
                result.append("Marks Obtained: 0").append("\n");
            }
        }
        
        result.append("\n");
        questionNumber++;
    }
    
    result.append("Total Marks Obtained: ").append(totalMarks);
    
    viewResultDetails_TA.setText(result.toString());
    } catch (Exception e) {
        System.out.println("An error occurred while setting the exam details: " + e.getMessage());
    }
}

    @FXML
    private void BAck(ActionEvent event) {
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
