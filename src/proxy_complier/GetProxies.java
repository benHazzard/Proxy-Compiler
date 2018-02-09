/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy_complier;

//Imports

import java.io.IOException;
import java.util.ArrayList;

//JSoup imports
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//Import for system
import java.lang.System;
//Import for GUI
import gui.FXMLDocumentController;
/**
 *
 * @author Ben
 */
public class GetProxies {
   
    
    //Arraylist to hold theIP
    private static ArrayList<String> proxyListIP;
    //String to hold the location that the user selects
    private static ArrayList<String> proxyListPort;
    //ArrayList to hold port number
    private String location;
    //Int for the amount of proxies that that the user want
    private int amount;
    
    //Method for getting list
    public void getProxiesJSoup() throws IOException{
        
        System.clearProperty("https.proxyPort");
        System.clearProperty("https.proxyHost");
        
        //Setting the ArrayList size to the given amount
        proxyListIP = new ArrayList<String>(amount);
        proxyListPort = new ArrayList<String>(amount);
        
        System.out.println("=========GETTING PROXIES==========");
        //Connecting the webdriver to the link
        Document webPage = Jsoup.connect(location).get();
        //Table for list of proxies
        Elements tableElement = webPage.select("tbody");
        //Navigating into the table
        Elements proxieElements = tableElement.select("tr");
        //Building the list untill the amount is equal to the given
        for(int i = 0; i <= amount; i++){
            //Getting the location for the row
            Element row = proxieElements.get(i);
            //Getting the html of the table for the proxies
            Elements cols = row.select("td"); 
            //Checking if the list contains the element
            if(!proxyListIP.contains(cols.get(0).text()) && !proxyListIP.contains(cols.get(0).text())){
                //Adding proxy
                proxyListIP.add(cols.get(0).text());
                proxyListPort.add(cols.get(1).text());    
                }
            }
        
            
            System.out.println("==========PROXIES PULLED=========="); 
           
        
    }
    
    //Setter for location
    public void setLocation(String location){
        if("US".equals(location))
            this.location = "https://www.us-proxy.org/";
        else if("UK".equals(location))
            this.location = "https://free-proxy-list.net/uk-proxy.html";
        else{
            System.out.println("No location selected, default set to US");
            this.location = "https://www.us-proxy.org/";
        }
        
        
    }
    
    //Getter for location
    public String getLocation(){
        return location;
    }
    
    //Setter for amount of proxies 
    public void setAmount(int amount){
        this.amount = amount-1;
    }
    
    //Getter for amount of proxies 
    public int getAmount(){
        return amount;
    }
    
    //Method for passing IP list
    public ArrayList<String> getIPList(){
        return proxyListIP;
    }
    
    //Method for passing Port list
    
    public ArrayList<String> getPortList(){
        return proxyListPort;
    }
    

    
}
