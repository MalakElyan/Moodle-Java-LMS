

package malak_220226982fx;

import java.io.IOException;
import java.net.URL;
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

public class Add_TechersController implements Initializable{
/**
 * FXML Controller class
 *
 * @author NEW
 */

   Exam_system exam_system = Exam_system.getInstance();
 

    
    @FXML
    private Label Add_Teacher_lbl;
    @FXML
    private Label Teacher_Username_lbl;
    @FXML
    private Label Teacher_Password_lbl;
    @FXML
    private Label Teacher_Name_lbl;
    @FXML
    private Label Teacher_Birthdate_lbl;
    @FXML
    private Label Teacher_Gender_lbl;
    @FXML
    private Label Teacher_Salary_lbl;
    @FXML
    private Label Teacher_Field_lbl;
    @FXML
    private TextField Teacher_Username_TF;
    @FXML
    private TextField Teacher_Birthdate_TF;
    @FXML
    private TextField Teacher_Name_TF;
    @FXML
    private TextField Teacher_Field_TF;
    @FXML
    private TextField Teacher_Salary_TF;
    @FXML
    private TextField Teacher_Gender_TF;
    @FXML
    private TextField Teacher_Password_TF;
    @FXML
    private Button Add_teacher_btn;
    @FXML
    private Button Back_btn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void addteacher(ActionEvent event) {
        // قم بجمع بيانات المعلم من الحقول
        String username = Teacher_Username_TF.getText();
        String password = Teacher_Password_TF.getText();
        String name = Teacher_Name_TF.getText();
        String birthdate = Teacher_Birthdate_TF.getText();
        String gender = Teacher_Gender_TF.getText();
        double salary = Double.parseDouble(Teacher_Salary_TF.getText());
        String field = Teacher_Field_TF.getText();
        
      exam_system.addTeacher(new Teacher(salary, field, username, password, name, gender, birthdate));
      
      Teacher_Username_TF.clear();
      Teacher_Password_TF.clear();
      Teacher_Name_TF.clear();
      Teacher_Birthdate_TF.clear();
      Teacher_Gender_TF.clear();
      Teacher_Salary_TF.clear();
      Teacher_Field_TF.clear();
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
