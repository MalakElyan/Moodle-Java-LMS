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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class View_All_TeachersController implements Initializable {

    @FXML
    private Label View_All_Teacher_lbl;
    @FXML
    private TableView<Teacher> Teacher_Tv;
    @FXML
    private TableColumn<Teacher, String> Username_Cv;
    @FXML
    private TableColumn<Teacher, String> Password_Cv;
    @FXML
    private TableColumn<Teacher, String> Name_Cv;
    @FXML
    private TableColumn<Teacher, String> Birthday_Cv;
    @FXML
    private TableColumn<Teacher, String> Gender_Cv;
    @FXML
    private TableColumn<Teacher, Double> Salary_Cv;
    @FXML
    private TableColumn<Teacher, String> Field_Cv;
    @FXML
    private Button back_btn;
    Exam_system exam_system = Exam_system.getInstance();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewAllTeachers ();
    }    
    
    public void viewAllTeachers (){
        List<Teacher> teacherList = exam_system.getTeacher();
        ObservableList <Teacher> ObList = FXCollections.observableArrayList();
        ObList.addAll(teacherList);
        
        Username_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("username"));
        Password_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("password"));
        Name_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("name"));
        Birthday_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("birthdate"));
        Gender_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("gender"));
        Salary_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,Double>("salary"));
        Field_Cv.setCellValueFactory(new PropertyValueFactory<Teacher,String>("Field"));
        
        Teacher_Tv.setItems(ObList);
        
    }

    @FXML
    void Back(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin_Main_Menu.fxml"));
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
