package resultmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class FXMLDocumentController implements Initializable {
    //Database
    Database db = new Database();
    PreparedStatement ps = null;
    
    //Anchor-Panes
    @FXML
    private AnchorPane mainpane,stdpanel,addrespanel;
    
    //Radio-Buttons
    @FXML
    private JFXRadioButton rd1,rd2,rd3;
    
    //Buttons-----
    @FXML
    private JFXButton opt_addst,opt_addrs;
    
    //Add Student Panel----
    @FXML
    private JFXButton btn_addst;
    @FXML
    private JFXTextField addst_roll,addst_name;
    @FXML
    private Label addst_warning;
    @FXML
    private FontAwesomeIconView addst_warning_check,addst_warning_close;
    //-------------
    
    @FXML
    private JFXButton class6;
    
    @FXML
    private Label rolllab,namelab;
    
    //Icons
    @FXML
    private OctIconView navigator;
   
    //Left-Opions Action Events
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == opt_addst){
            stdpanel.setVisible(true);
            stdpanel.toFront();
            navigator.setVisible(true);
            navigator.setLayoutY(28);
        }
        else if(event.getSource() == opt_addrs){
            addrespanel.setVisible(true);
            addrespanel.toFront();
            navigator.setVisible(true);
            navigator.setLayoutY(65);
        }
    }
    
    //Mouse Event of Input Fields
   @FXML
    void act2(MouseEvent event) {
        if(event.getSource() == addst_name){
            addst_warning.setVisible(false);
            addst_warning_check.setVisible(false);
            addst_warning_close.setVisible(false);
            namelab.setVisible(true);
            namelab.setLayoutX(182.0);
        }
        if(event.getSource() == addst_roll){
            addst_warning.setVisible(false);
            addst_warning_check.setVisible(false);
            addst_warning_close.setVisible(false);
            rolllab.setVisible(true);
            rolllab.setLayoutX(182.0);
        }
        //Mouse Event End
    }
    
    //Kiboard Action for Input Field
    @FXML
    void act(ActionEvent event) {
        if((event.getSource() == addst_name) || (event.getSource() == btn_addst)){
            addst_roll.requestFocus();
            addst_roll.setText("");
            addst_name.setText("");
        }
        else if(event.getSource() == addst_roll){
            addst_name.requestFocus();
        }
    //Action Events End    
    }
    //Add Student Panel Actions
    @FXML
    void addStPanelActs(ActionEvent event){
        if(event.getSource() == btn_addst){
            try{
                ps = db.Connector().prepareStatement("INSERT INTO students VALUES(?,?)");
                ps.setInt(1, Integer.parseInt(addst_roll.getText()));
                ps.setString(2, addst_name.getText());
                int i = ps.executeUpdate();
                if(i>0){
                    addst_warning_close.setVisible(false);
                    addst_warning_check.setVisible(true);
                    addst_warning.setTextFill(Color.BLUE);
                    addst_warning.setText("Student Successfully Added");
                    addst_warning.setVisible(true);
                }
                else{
                    addst_warning_check.setVisible(false);
                    addst_warning_close.setVisible(true);
                    addst_warning.setTextFill(Color.RED);
                    addst_warning.setText("Student Can't Be Added");
                    addst_warning.setVisible(true);
                }
            } catch(SQLException e) {
                addst_warning_check.setVisible(false);
                addst_warning_close.setVisible(true);
                addst_warning.setTextFill(Color.RED);
                addst_warning.setText("Student Can't Be Added");
                addst_warning.setVisible(true);
            } finally {
                try {
                    ps.close();
                } catch (Exception e) {
                    addst_warning_check.setVisible(false);
                    addst_warning_close.setVisible(true);
                    addst_warning.setText("Error for closing Database!");
                    addst_warning.setVisible(true);
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(db.isDbConnected())
            System.out.println("Connected!");
        else
            System.out.println("Not Connected!");
    }    
    
}
