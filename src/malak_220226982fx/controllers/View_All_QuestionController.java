/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.TableCell;
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
public class View_All_QuestionController implements Initializable {
    
    Exam_system exam_system = Exam_system.getInstance();

    @FXML
    private TableView<Question> Question_Tv;
    @FXML
    private TableColumn<Question, Integer> ID_Cv;
    @FXML
    private TableColumn<Question, String> QuestionText_Cv;
    @FXML
    private TableColumn<Question, Double> Mark_Cv;
    @FXML
    private TableColumn<YesNoQuestion, Boolean> booleanAnswer_Cv;
    @FXML
    private TableColumn<MCQQuestion, Integer> intAnswer_Cv;
    @FXML
    private TableColumn<FillTheBlankQuestion, String> StringAnswer_Cv;
    @FXML
    private Button back_btn;
    @FXML
    private TableColumn<MCQQuestion, String> choicesColumn;

    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAllQuestion ();
    }  
    
   public void viewAllQuestion() {
    List<Question> questionList = exam_system.getQuestions();
    ObservableList<Question> ObList = FXCollections.observableArrayList();
    ObList.addAll(questionList);

    ID_Cv.setCellValueFactory(new PropertyValueFactory<>("id"));
    QuestionText_Cv.setCellValueFactory(new PropertyValueFactory<>("questionText"));
    Mark_Cv.setCellValueFactory(new PropertyValueFactory<>("marks"));

    // Custom CellValueFactory for booleanAnswer_Cv
    booleanAnswer_Cv.setCellValueFactory(cellData -> {
        Question question = cellData.getValue();
        if (question instanceof YesNoQuestion) {
            YesNoQuestion yesNoQuestion = (YesNoQuestion) question;
            return new SimpleBooleanProperty(yesNoQuestion.getAnswer());
        }
        return null;
    });

    // Custom CellValueFactory for intAnswer_Cv
    intAnswer_Cv.setCellValueFactory(cellData -> {
    Question question = cellData.getValue();
    if (question instanceof MCQQuestion) {
        MCQQuestion mcqQuestion = (MCQQuestion) question;
        return new SimpleObjectProperty<>(mcqQuestion.getAnswer());
    }
    return null;
});

    StringAnswer_Cv.setCellValueFactory(cellData -> {
    Question question = cellData.getValue();
    if (question instanceof FillTheBlankQuestion) {
        FillTheBlankQuestion fillQuestion = (FillTheBlankQuestion) question;
        return new SimpleStringProperty(fillQuestion.getAnswer());
    }
    return null;
});
    
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

    Question_Tv.setItems(ObList);

    choicesColumn.setCellFactory(column -> new TableCell<MCQQuestion, String>() {
        @Override
        protected void updateItem(String choices, boolean empty) {
            super.updateItem(choices, empty);
            setText(choices);
        }
    });
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
