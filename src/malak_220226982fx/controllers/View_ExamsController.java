/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class View_ExamsController implements Initializable {

    @FXML
    private Label View_Exams_lbl;
    @FXML
    private TableView<Exam> View_Exam_Tv;
    @FXML
    private TableColumn<Exam, Integer> Exam_ID_Cv;
    @FXML
    private TableColumn<Exam, String> Exam_Name_Cv;
    @FXML
    private TableColumn<Exam, Integer> Number_Of_Question_Cv;
    @FXML
    private TableColumn<Exam, Double> Min_Pass_Average_Cv;
    @FXML
    private Button back_btn;

    
    Exam_system exam_system = Exam_system.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAllExams ();
        
        // تعيين معالج الحدث لنقر الفأرة على الصفوف في جدول الامتحانات
        View_Exam_Tv.setRowFactory(tv -> {
        TableRow<Exam> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && !row.isEmpty()) {
        Exam selectedExam = row.getItem();
         showExamQuestions(selectedExam);
            }
        });
        return row;
    });
    }   
    
    
     public void viewAllExams (){
        List<Exam> examList = exam_system.getExam();
        ObservableList <Exam> ObList = FXCollections.observableArrayList();
        ObList.addAll(examList);
        
        Exam_ID_Cv.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("id"));
        Exam_Name_Cv.setCellValueFactory(new PropertyValueFactory<Exam, String>("name"));
        Number_Of_Question_Cv.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("numQuestions"));
        Min_Pass_Average_Cv.setCellValueFactory(new PropertyValueFactory<Exam, Double>("minPassAverage"));
        
        View_Exam_Tv.setItems(ObList);
        
    }

    
    private void showExamQuestions(Exam selectedExam) {
        List<Question> examQuestions = selectedExam.getQuestions();

        // إنشاء جدول لعرض الأسئلة
        TableView<Question> questionsTable = new TableView<>();

        // إعداد أعمدة الجدول
        TableColumn<Question, Integer> questionIdColumn = new TableColumn<>("ID");
        questionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Question, String> questionTextColumn = new TableColumn<>("Question Text");
        questionTextColumn.setCellValueFactory(new PropertyValueFactory<>("questionText"));

        TableColumn<Question, Double> questionMarkColumn = new TableColumn<>("Mark");
        questionMarkColumn.setCellValueFactory(new PropertyValueFactory<>("marks"));

       // Custom CellValueFactory لعمود booleanAnswer
       TableColumn<Question, Boolean> booleanAnswerColumn = new TableColumn<>("Answer");
       booleanAnswerColumn.setCellValueFactory(cellData -> {
       Question question = cellData.getValue();
       if (question instanceof YesNoQuestion) {
       YesNoQuestion yesNoQuestion = (YesNoQuestion) question;
       return new SimpleBooleanProperty(yesNoQuestion.getAnswer());
        }
        return null;
        });

        // Custom CellValueFactory لعمود intAnswer
        TableColumn<Question, Integer> intAnswerColumn = new TableColumn<>("Answer");
        intAnswerColumn.setCellValueFactory(cellData -> {
        Question question = cellData.getValue();
        if (question instanceof MCQQuestion) {
        MCQQuestion mcqQuestion = (MCQQuestion) question;
        return new SimpleObjectProperty<>(mcqQuestion.getAnswer());
        }
        return null;
        });

        // Custom CellValueFactory لعمود stringAnswer
        TableColumn<Question, String> stringAnswerColumn = new TableColumn<>("Answer");
        stringAnswerColumn.setCellValueFactory(cellData -> {
        Question question = cellData.getValue();
        if (question instanceof FillTheBlankQuestion) {
        FillTheBlankQuestion fillQuestion = (FillTheBlankQuestion) question;
        return new SimpleStringProperty(fillQuestion.getAnswer());
        }
        return null;
        });

        // Custom CellValueFactory لعمود choices
        TableColumn<Question, String> choicesColumn = new TableColumn<>("Choices");
        choicesColumn.setCellValueFactory(cellData -> {
        Question question = cellData.getValue();
        if (question instanceof MCQQuestion) {
        MCQQuestion mcqQuestion = (MCQQuestion) question;
        List<String> choices = mcqQuestion.getChoices();
        StringBuilder choicesString = new StringBuilder();
        for (int i = 0; i < choices.size(); i++) {
        String choice = choices.get(i);
        choicesString.append((i + 1)).append(". ").append(choice);
        if (i < choices.size() - 1) {
        choicesString.append("    ");
        }
        }
        return new SimpleStringProperty(choicesString.toString());
        }
        return null;
        });
        // إضافة الأعمدة إلى جدول الأسئلة
        questionsTable.getColumns().addAll(questionIdColumn, questionTextColumn, questionMarkColumn,
        booleanAnswerColumn, intAnswerColumn, stringAnswerColumn, choicesColumn);

        // إضافة الأسئلة إلى جدول الأسئلة
        questionsTable.getItems().addAll(examQuestions);

        // إنشاء نافذة جديدة لعرض جدول الأسئلة
        Stage stage = new Stage();
        Scene scene = new Scene(questionsTable);
        stage.setScene(scene);
        stage.show();
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
