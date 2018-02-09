/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy_complier;

//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.Scanner;

//Import for GUI
import gui.FXMLDocumentController;
/**
 *
 * @author Ben
 */
public class CheckProxies{
    
    private ArrayList<String> proxyIP;
    private ArrayList<String> proxyPort;
    private static ArrayList<String> testedIP;
    private static ArrayList<String> testedPort;
    
    
    private ArrayList<ArrayList<Integer>> newTestedList;
    private final GetProxies g;
    
    public CheckProxies(){
        g = new GetProxies();
        proxyIP = g.getIPList(); 
        proxyPort = g.getPortList();
    }
    
    //Testing list 
    public void testDirect() throws SocketException{
        
        System.out.println("==========TESTING DIRECT CONNECTION==========");
        testedIP = new ArrayList<String>();
        testedPort = new ArrayList<String>();
        
        for(int i = 0; i < proxyIP.size(); i++){
            String IP = proxyIP.get(i);
            String portString = proxyPort.get(i);
            int Port = Integer.parseInt(portString);
            
            //Setting system properties
            System.setProperty("https.proxyHost", IP);
            System.setProperty("https.proxyPort", portString);
      
            try{
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(IP, Port));
                URL url = new URL("https://www.us-proxy.org/");
                HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection(proxy);
                testedIP.add(IP);
                testedPort.add(portString);
                System.out.println("=====CONNECTION PASSED=====");
                httpsCon.disconnect(); 
                
            }
            catch(IOException e){
                System.out.println("=====CONNECTION FAILED=====");


            } 
        }
        
        System.out.println("==========TESTING COMPLEATE==========");
        
       
    } 
    public int proxyType(){
        return 1;
    }
    
    public ArrayList<String> testedIP(){
        return testedIP;
    }
    
    public ArrayList<String> testedPort(){
        return testedPort;
    }
    
  
    
    public String getNestedList(){
        return newTestedList.toString();
    }
    
    public void checkListDirect(File fileName) throws InterruptedException, FileNotFoundException{
        Thread.sleep(5000);
        //Boolean for even and odd lines
        boolean direction = true;
        //Scanner for the passed in file 
        Scanner s = new Scanner(fileName);
        
        //Clearing the proxy ArrayLists
        if(!proxyIP.isEmpty()){
            proxyIP.clear();
            proxyPort.clear();
        }
        
        while(s.hasNext()){
            String nextLine = s.nextLine();
            if(nextLine.contains("DATE")){
                System.out.println("Skipping date line");
            }
            else if(nextLine.contains(":")){
                String[] parts = nextLine.split(":");
                proxyIP.add(parts[0]);
                proxyPort.add(parts[1]);
            }
            else{
                if(direction == true){
                    proxyIP.add(nextLine);
                    direction = false;
                }
                else{
                    proxyPort.add(nextLine);
                    direction = true;
                }
                    
                
            }
            
        }
        
    s.close(); 
    }
    
}
       
            
        
    


    

