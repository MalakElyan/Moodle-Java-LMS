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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class ViewAllExamsResultController implements Initializable {

    @FXML
    private TextArea resultsTextArea;
    @FXML
    private Label viewAllExamsResult_lbl;
    @FXML
    private Button back_btn;
    
     Exam_system examSystem = Exam_system.getInstance();

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            viewAllExamsResult();
           
        }

        public void viewAllExamsResult() {
            String resultString = examSystem.viewAllExamsResultAsString();
            resultsTextArea.setText(resultString);
            resultsTextArea.setEditable(false);
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

  