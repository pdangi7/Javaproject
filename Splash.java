package travel.management.system;
import javax.swing.*;       //Swing package java ke extended package me hota hai isliye javax ka use kiya hi 
import java.awt.*;                                   // Jframe bhi swing package me hota hai 

public class Splash extends JFrame implements Runnable {        //here we extends Jframe because to use some methods(setlocation, setsize)
    Thread thread;
                                                                    //boz these all methods are present in jframe 
    
    Splash(){
//        setSize(1200, 600);        //Setsize is use for build a frame but it is hide for user.
//        setLocation(200, 100);     //use to adjust the location of frame
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));  //Icons ko assecc krne ke liye 
                                                                                                          //imageicons class ka use krte hai 
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);           // with the help of Jlabe we a=can write the text into the frame
        add(image);
        
        setVisible(true);             // setvisible is used for to show the hide frame
        thread = new Thread(this);
        thread.start();             // used for multithread behaviour bcoz if we call direct run call then it did not act like multithread so that's why we use start 
    }
    
     public void run(){               // we can call run method with the help of thread class object.
         try{
               Thread.sleep(5000); // argument in millisecond
       //          new Login();
                  setVisible(false); 
           }catch(Exception e){}
         
    
}
     
     
     
  
    public static void main (String[] args){
        Splash frame = new Splash();
        
        int x=1;
        
        for (int i = 1; i<500; x+=5, i+=4)
        {
           frame.setLocation( 750 - (x+i)/2, 400 - (i/2 ));
           frame.setSize( x + i, i);
           try{
               Thread.sleep(8);
           }catch(Exception e){}
        } 
        new Login();
        
        
    }
}
