/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InsertFXMLController implements Initializable {

    @FXML
    private TextField idtf;
    @FXML
    private TextField nametf;
    @FXML
    private TextField departmenttf;
    @FXML
    private TextField agetf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insertData(ActionEvent event) throws SQLException {
        String sql = "Insert into student_info(id,name,department,age) values(?,?,?,?)";
        
        Connection con=DBConnector.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, idtf.getText());
        pst.setString(2, nametf.getText());
        pst.setString(3, departmenttf.getText());
        pst.setString(4, agetf.getText());
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Insert Successfully");
        
    }

    @FXML
    private void cancelWindow(ActionEvent event) {
        
        System.exit(0);
    }
    
}
