/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Solve_Exam_QuestionsController implements Initializable {

     @FXML
    private Label Exam_ID_lbl;
    @FXML
    private Label Student_ID_lbl;
    @FXML
    private TextField Exam_ID_TF;
    @FXML
    private TextField Student_ID_TF;
    @FXML
    private TextField Answer_TF;
    @FXML
    private Label Answer_lbl;
    @FXML
    private Button Next_btn;
    @FXML
    private Label Question_lbl;
    @FXML
    private Label Question_Text_lbl;
    @FXML
    private Label Question_ID_lbl;
    @FXML
    private Label Question_Mark_lbl;
    @FXML
    private Label Question_Choices_lbl;
    @FXML
    private Label Mark_lbl;
   
    
    private Exam currentExam;
    private int currentQuestionIndex;
    Exam_system exam_system = Exam_system.getInstance();
    
    // Add a new field to store the student's answer for each question
    private Map<Question, String> studentAnswers = new HashMap<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Next_btn.setOnAction(event -> onNextButtonClicked());
    }    

    private void onNextButtonClicked() {
    // If there is no current exam, get it from the exam system
    if (currentExam == null) { 
        int examId = Integer.parseInt(Exam_ID_TF.getText());
        currentExam = exam_system.getExamById(examId);
        
        if (currentExam == null) {
            System.out.println("Exam not found!");
            return;
        }
        
        // Display exam information
        Exam_ID_lbl.setText("Exam ID: " + currentExam.getId());
        Student_ID_lbl.setText("Student ID: " + Student_ID_TF.getText());
        currentQuestionIndex = 0;
    } else {
        // Save answer for the current question
        String studentAnswer = Answer_TF.getText();
        studentAnswers.put(currentExam.getQuestions().get(currentQuestionIndex), studentAnswer);
        
        // Move to the next question
        currentQuestionIndex++;
        
        // If there are no more questions, calculate and display the total marks
        if (currentQuestionIndex >= currentExam.getQuestions().size()) {
            calculateTotalMarks();
            return;
        }
    }

    // Get the current question and display its information
    Question currentQuestion = currentExam.getQuestions().get(currentQuestionIndex);
    Question_ID_lbl.setText("" + currentQuestion.getId());
    Question_Text_lbl.setText("" + currentQuestion.getQuestionText());
    Question_Mark_lbl.setText("" + currentQuestion.getMarks());

    if (currentQuestion instanceof YesNoQuestion) {
        YesNoQuestion yesNoQuestion = (YesNoQuestion) currentQuestion;
        Question_Choices_lbl.setText(""); // Clear choices label for Yes/No question
        Answer_lbl.setText("Answer (true/false):");
        Answer_TF.clear();
        Answer_TF.setDisable(false);
    } else if (currentQuestion instanceof MCQQuestion) {
        MCQQuestion mcqQuestion = (MCQQuestion) currentQuestion;
        StringBuilder choices = new StringBuilder("Choices:\n");
        List<String> mcqChoices = mcqQuestion.getChoices();
        for (int i = 0; i < mcqChoices.size(); i++) {
            String choice = mcqChoices.get(i);
            choices.append(i + 1).append(". ").append(choice).append("\t");
        }
        Question_Choices_lbl.setText(choices.toString());
        Answer_lbl.setText("Answer (Choice Number):");
        Answer_TF.clear();
        Answer_TF.setDisable(false);
    } else if (currentQuestion instanceof FillTheBlankQuestion) {
        Question_Choices_lbl.setText(""); // Clear choices label for Fill in the Blank question
        Answer_lbl.setText("Answer:");
        Answer_TF.clear();
        Answer_TF.setDisable(false);
    }
    
    // If this is the last question, change the "Next" button label to "Finish"
    if (currentQuestionIndex == currentExam.getQuestions().size() - 1) {
        Next_btn.setText("Finish");
    }
}
    
    private void calculateTotalMarks() {
        double totalMarks = 0.0;
        int examId = Integer.parseInt(Exam_ID_TF.getText());
        int studentId = Integer.parseInt(Student_ID_TF.getText());
        
        for (Question question : currentExam.getQuestions()) {
            if (question instanceof YesNoQuestion) {
                YesNoQuestion yesNoQuestion = (YesNoQuestion) question;
                String studentAnswer = studentAnswers.get(question); // Use the stored student's answer
                boolean correctAnswer = yesNoQuestion.getAnswer();
                   if (studentAnswer != null && studentAnswer.equalsIgnoreCase(String.valueOf(correctAnswer))) {
                    totalMarks += question.getMarks();
                }
                   exam_system.saveExamQuestionAnswer(studentId, examId, question.getId(), studentAnswer);
            } else if (question instanceof MCQQuestion) {
                MCQQuestion mcqQuestion = (MCQQuestion) question;
                String studentAnswerStr = studentAnswers.get(question); // Use the stored student's answer
                if (studentAnswerStr == null || studentAnswerStr.isEmpty()) {
                    continue;
                }
                try {
                    int studentAnswer = Integer.parseInt(studentAnswerStr);
                    int correctAnswer = mcqQuestion.getAnswer();
                    if (studentAnswer == correctAnswer) {
                        totalMarks += question.getMarks();
                    }
                } catch (NumberFormatException ex) {
                    continue;
                }
            exam_system.saveExamQuestionAnswer(studentId, examId, question.getId(), studentAnswerStr);
            } else if (question instanceof FillTheBlankQuestion) {
                FillTheBlankQuestion fillBlankQuestion = (FillTheBlankQuestion) question;
                String studentAnswer = studentAnswers.get(question); // Use the stored student's answer
                String correctAnswer = fillBlankQuestion.getAnswer();
                     if (studentAnswer != null && studentAnswer.equalsIgnoreCase(correctAnswer)) {
                    totalMarks += question.getMarks();
                }
                 exam_system.saveExamQuestionAnswer(studentId, examId, question.getId(), studentAnswer);
            }
        }
        
        Mark_lbl.setText("Total Marks: " + totalMarks);
        exam_system.saveExamMark(studentId, examId, totalMarks);
    }
    
    // ..
    @FXML
    private void Back(ActionEvent event) {
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

    

