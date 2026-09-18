/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author NEW
 */
public class Export_exams_to_textfileController implements Initializable {

    @FXML
    private Label File_Path_lbl;
    @FXML
    private Button Export_exam_btn;
    @FXML
    private Label Exam_ID_lbl;
    @FXML
    private TextField Exam_ID_TF;
    @FXML
    private TextField File_Path_TF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
