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
public class Solve_ExamController implements Initializable {

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
    private Button Start_Exam_btn;
    
    Exam_system exam_system = Exam_system.getInstance();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO
    viewAllExams ();
}

private void openSolveExamQuestions(Exam exam) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Solve_Exam_Questions.fxml"));
        Parent root = loader.load();

        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
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
     
    @FXML
    private void Start_Exam(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Solve_Exam_Questions.fxml"));
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
