//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package proxy_complier;
//
//import java.io.IOException;
//import java.util.Scanner;
//
///**
// *
// * @author Ben
// */
//public class MainTest {
//    
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws IOException, InterruptedException {
//        //Objects
//        Scanner s = new Scanner(System.in);
//        //Variables
//        String location, fileName;
//        int amount;
//        
//       
//        while(true){
//            System.out.println("What would you like to do \n 1 Create a list of proxies, testing direct connection"
//                    + "\n 2 Check a list of old proxies \n Please enter the number: ");
//            int choice =  s.nextInt();
//            if(choice == 1){
//                System.out.println("Please enter the amount of proxies to find: ");
//                amount = s.nextInt();
//                GetProxies d = new GetProxies();
//                d.setLocation("US");
//                d.setAmount(amount);
//                d.getProxiesJSoup();
//                CheckProxies c = new CheckProxies();
//                c.testDirect();
//                WriteProxies p = new WriteProxies();
//                p.writeFile();
//            }
//            else if(choice == 2){
//            System.out.println("Please enter file name to check: ");
//            fileName = s.nextLine();
//            CheckProxies c = new CheckProxies();
//            c.checkListDirect(fileName);
//            WriteProxies p = new WriteProxies();
//            p.writeFile();
//            }
//        }     
////        
////        //Setting the lcoation to US
////        d.setLocation("US");
////        //Setting the amount of proxies
////        d.setAmount(50);
////        //Getting the proxies
////        d.getProxiesJSoup();
////        //Testing the direct connection
////        c.testDirect();
////        //Writing the file
////        p.writeFile();
////        //Chcking the proxies in the given list
////        c.checkListDirect("PROXY LIST.TXT");
////        //Writing the files with the given name
////        p.writeFile();
//////        c.constructList();
//////        System.out.println(c.getNestedList());
//    }
//    
//}
