/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

//Import for getting proxies
import proxy_complier.GetProxies;
import proxy_complier.CheckProxies;
import proxy_complier.WriteProxies;

/**
 *
 * @author Ben
 */
public class FXMLDocumentController implements Initializable {
    
    private File fileName;
    
    private String directory = "C:\\Users\\Ben\\Do7cuments\\NetBeansProjects\\Proxy_Complier"; 
    
    @FXML
    private ProgressBar progressBar;

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView imagePhoto;
    
    @FXML
    private Slider amountSlider;
    
    @FXML
    private Button openFile;
    
    @FXML
    private Text fileSelected;
   

    @FXML
    private void createNewList(ActionEvent e) throws IOException{
                
        //Reseting the progressbar
        progressBar.setProgress(0);
        
        ///Getting the proxies
        GetProxies gp = new GetProxies(); 
        
        gp.setLocation(location.getValue().toString());
        
        //Setting the amount of proxies to get
        gp.setAmount((int)amountSlider.getValue());
        
        //Calling the method to get the proxies 
        gp.getProxiesJSoup();
        
        progressBar.setProgress(0.33F);
        
        //Checking the proxies
        CheckProxies cp = new CheckProxies();
        if(checkDirect.isSelected()){
            cp.testDirect();
        }
        if(checkOther3.isSelected()){
            System.out.println("Checking other connection 3");
        }
        if(checkOther.isSelected()){
            System.out.println("Checking other connection");
        }
        
        progressBar.setProgress(0.66F);
        
        //Writing the proxies
        WriteProxies wp = new WriteProxies();
        wp.writeFile();   
        
        progressBar.setProgress(1.00F);
        
        openFile.setVisible(true);
        
        
        
    }
    
    @FXML
    private void openFileViewer(ActionEvent event) throws IOException{

          //Opening the notepad file that contains the proxies
          ProcessBuilder pb = new ProcessBuilder("Notepad.exe","PROXY LIST.txt");
          pb.start();
    }

    @FXML
    private ImageView imageLogo;
    
    @FXML
    private ChoiceBox location;

    @FXML
    private void pickFile(ActionEvent event) throws InterruptedException, FileNotFoundException{
        
        progressBar.setProgress(0);
        
        //Asking the user to open a file with JFileChooser
        JFileChooser fp = new JFileChooser(directory);
        
        fp.showOpenDialog(new JFrame()); 
        
        fileName = fp.getSelectedFile();
       
        fileSelected.setText(fileName.getName());

        progressBar.setProgress(0.33F);
              
    }
    
    @FXML
    private void checkList(ActionEvent event) throws InterruptedException, FileNotFoundException, SocketException{
        //Calling to check proxies
        CheckProxies cp = new CheckProxies();
        
        cp.checkListDirect(fileName);
        
        progressBar.setProgress(0.66F);
        
        cp.testDirect();
        
        
        WriteProxies wp = new WriteProxies();
        
        wp.writeFile();
        
        progressBar.setProgress(1.00F);
    }
    
    //Check boxes
    @FXML
    private CheckBox checkDirect;

    @FXML
    private CheckBox checkOther3;

    @FXML
    private CheckBox checkOther;
   
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Show the button for opening created file 
        
        openFile.setVisible(false);
        location.getItems().add("US");
        location.getItems().add("UK");

    }
    
 
}
