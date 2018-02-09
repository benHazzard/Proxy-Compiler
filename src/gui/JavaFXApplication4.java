/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;  
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 *
 * @author Ben
 */
public class JavaFXApplication4 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentProxyCompiler.fxml"));
        stage.setTitle("Proxy Compiler");
        stage.getIcons().add(new Image("file:C:\\Users\\Ben\\Desktop\\Programing\\Java\\Projects\\Proxy_Compiler\\zz-advantage.jpg"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
