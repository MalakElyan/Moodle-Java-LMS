/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class ExportExamToJsonFileController implements Initializable {

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
    private Label exportExamToJSONFile_lbl;

    private Exam_system exam_system = Exam_system.getInstance();
    @FXML
    private Button back_btn;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAllExams();

       // تعيين معالج الحدث لنقر الفأرة على الصفوف في جدول الامتحانات
    View_Exam_Tv.setRowFactory(tv -> {
        TableRow<Exam> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && !row.isEmpty()) {
                Exam selectedExam = row.getItem();
                showExamQuestions(selectedExam);
            }
        });
        return row;
    });

    // تعيين معالج الحدث لنقر الفأرة مزدوج النقر على الصفوف في جدول الامتحانات
    View_Exam_Tv.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2) {
            Exam selectedExam = View_Exam_Tv.getSelectionModel().getSelectedItem();
            if (selectedExam != null) {
                export(selectedExam);
            }
        }
    });
    }

    public void viewAllExams() {
        try{
        List<Exam> examList = exam_system.getExams();
        ObservableList<Exam> ObList = FXCollections.observableArrayList();
        ObList.addAll(examList);

        Exam_ID_Cv.setCellValueFactory(new PropertyValueFactory<>("id"));
        Exam_Name_Cv.setCellValueFactory(new PropertyValueFactory<>("name"));
        Number_Of_Question_Cv.setCellValueFactory(new PropertyValueFactory<>("numQuestions"));
        Min_Pass_Average_Cv.setCellValueFactory(new PropertyValueFactory<>("minPassAverage"));

        View_Exam_Tv.setItems(ObList);
        } catch (Exception e) {
        System.out.println("An error occurred while viewing exams: " + e.getMessage());
    }
    }

     private void showExamQuestions(Exam selectedExam) {
        try{
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
        questionsTable.getColumns().addAll(questionIdColumn, questionTextColumn, questionMarkColumn,choicesColumn);

        // إضافة الأسئلة إلى جدول الأسئلة
        questionsTable.getItems().addAll(examQuestions);

        // إنشاء نافذة جديدة لعرض جدول الأسئلة
        Stage stage = new Stage();
        Scene scene = new Scene(questionsTable);
        stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
        System.out.println("An error occurred while showing exam questions: " + e.getMessage());
    }
    } 
    

    private void export(Exam selectedExam) {
        try{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Destination Folder");
        fileChooser.setInitialFileName("exam.json");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showSaveDialog(new Stage());

        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            exam_system.exportExamToJSONFile(selectedExam.getId(), filePath);
            exportExamToJSONFile_lbl.setText("Exam exported successfully!");
        }
        } catch (Exception e) {
        System.out.println("An error occurred while exporting the exam: " + e.getMessage());
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
