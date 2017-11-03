package resultmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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
    //-------------
    
    @FXML
    private JFXButton addbtn;
    
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
            namelab.setVisible(true);
            namelab.setLayoutX(182.0);
        }
        if(event.getSource() == addst_roll){
            rolllab.setVisible(true);
            rolllab.setLayoutX(182.0);
        }
        //Mouse Event End
    }
    
    //Kiboard Action for Input Field
    @FXML
    void act(ActionEvent event) {
        if((event.getSource() == addst_name) || (event.getSource() == addbtn)){
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
                if(i>0)
                    System.out.println("Updated Data!");
                else
                    System.out.println("Error to add!");
            } catch(SQLException e) {
                System.out.println("Error to add!");
            } finally {
                try {
                    ps.close();
                } catch (Exception e) {
                    System.out.println("Error in closimg database!");
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
