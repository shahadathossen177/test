/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TableView<Student> tableView;
    
    @FXML private TableColumn<Student,Integer> col_id;
    @FXML private TableColumn<Student,String> col_name;
    @FXML private TableColumn<Student,String> col_department;
    @FXML private TableColumn<Student,Integer>col_age;
    
    public ObservableList<Student> list=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con=DBConnector.getConnection();
            ResultSet rs=con.createStatement().executeQuery("select * from student_info");
            
            while(rs.next()){
                list.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getString("department"),rs.getInt("age")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        tableView.setItems(list);
        
    } 

    @FXML
    private void addStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InsertFXML.fxml"));
        Stage stage =new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    
    
}
