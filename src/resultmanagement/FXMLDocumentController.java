package resultmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.octicons.OctIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane mainpane,stdpanel,addrespanel;
     
    @FXML
    private JFXRadioButton rd1,rd2,rd3;

    @FXML
    private JFXButton addst,addrs;
    
    @FXML
    private JFXButton addbtn;
    
    @FXML
    private JFXButton class6;
    
    @FXML
    private Label rolllab,namelab;
    
    @FXML
    private JFXTextField inputroll,inputName;
    
    @FXML
    private OctIconView navigator;
        
    @FXML
    void act(ActionEvent event) {
        if((event.getSource() == inputName) || (event.getSource() == addbtn)){
            inputroll.requestFocus();
            inputroll.setText("");
            inputName.setText("");
        }
        else if(event.getSource() == inputroll){
            inputName.requestFocus();
        }
    //Action Events End    
   }
   @FXML
    void act2(MouseEvent event) {
        if(event.getSource() == inputName){
            namelab.setVisible(true);
            namelab.setLayoutX(182.0);
        }
        if(event.getSource() == inputroll){
            rolllab.setVisible(true);
            rolllab.setLayoutX(182.0);
        }
        //Mouse Event End
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == addst){
            stdpanel.setVisible(true);
            stdpanel.toFront();
            navigator.setVisible(true);
            navigator.setLayoutY(28);
        }
        else if(event.getSource() == addrs){
            addrespanel.setVisible(true);
            addrespanel.toFront();
            navigator.setVisible(true);
            navigator.setLayoutY(65);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
