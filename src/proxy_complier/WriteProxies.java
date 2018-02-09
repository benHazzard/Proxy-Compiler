/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy_complier;

//Imports
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Ben
 */
public class WriteProxies {
    
    private ArrayList<Double> checkedList;
    private ArrayList<String> proxyIP;
    private ArrayList<String> proxyPort;
    private CheckProxies c;
    
    
    public WriteProxies(){
        c = new CheckProxies();
        proxyIP = c.testedIP();
        proxyPort = c.testedPort();
        
        
    }
    
    public void writeFile(){
        
        System.out.println("==========WRITING FILE==========");
        
        //If the file exits delete it;
        File file = new File("PROXY LIST.txt");
        if(file.delete()){
            System.out.println("=========PREVIOUS FILE FOUND AND DELETED==========");
        } 
        
        //String builder
        String fileName = "PROXY LIST.txt";
        
        try{ 
            
            //Creating new filewriter
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            
            //Printing the date at the top of the file
            pw.println("LAST DATE CHECKED: " + new Date());
            //For values in the list write to file
            for(int i = 0; i < proxyIP.size(); i++){
                pw.println(proxyIP.get(i) +":"+proxyPort.get(i));   
            }
            pw.close();
            System.out.println("==========WRITING COMPLEATE=========");
            
            
        }
        //Catching if file dosent exist
        catch(IOException e){
            System.out.print(e);
            System.out.println("=====FILE DOES NOT EXIST=====");
        }
    }
    
}
