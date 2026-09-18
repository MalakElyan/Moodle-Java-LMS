/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class ViewStudentsRanksController implements Initializable {

   
    @FXML
    private TextArea viewStudentsRanks_TA;
    @FXML
    private Button back_btn;

    Exam_system examSystem = Exam_system.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewStudentsRanks();
    }  
    
    public void viewStudentsRanks() {
            try{
            String resultString = examSystem.exploreStudentRank();
            viewStudentsRanks_TA.setText(resultString);
            viewStudentsRanks_TA.setEditable(false);
            } catch (Exception e) {
            System.out.println("An error occurred while viewing students ranks: " + e.getMessage());
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
