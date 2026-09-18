/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class View_All_StudentsController implements Initializable {

    Exam_system exam_system = Exam_system.getInstance();

    
    @FXML
    private Label View_All_Students_lbl;
    @FXML
    private TableView<Student> Student_Tv;
    @FXML
    private TableColumn<Student, String> Username_Cv;
    @FXML
    private TableColumn<Student, String> Password_Cv;
    @FXML
    private TableColumn<Student, String> Name_Cv;
    @FXML
    private TableColumn<Student, Integer> UniversityId_Cv;
    @FXML
    private TableColumn<Student, String> Birthday_Cv;
    @FXML
    private TableColumn<Student, String> Gender_Cv;
    @FXML
    private Button back_btn;
    
    private Scene previousScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAllStudent ();
    }    
    
     public void viewAllStudent (){
        List<Student> studentList = exam_system.getStudent();
        ObservableList <Student> ObList = FXCollections.observableArrayList();
        ObList.addAll(studentList);
        
        Username_Cv.setCellValueFactory(new PropertyValueFactory<Student,String>("username"));
        Password_Cv.setCellValueFactory(new PropertyValueFactory<Student,String>("password"));
        Name_Cv.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        Birthday_Cv.setCellValueFactory(new PropertyValueFactory<Student,String>("birthdate"));
        Gender_Cv.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        UniversityId_Cv.setCellValueFactory(new PropertyValueFactory<Student,Integer>("universityId"));
       
        
        Student_Tv.setItems(ObList);
        
    }

   @FXML
    private void Back(ActionEvent event) {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(previousScene);
    stage.show();
    }
    
    public void setPreviousScene(Scene scene) {
    previousScene = scene;
    }
    
    
}


