
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
      JButton login, singup, passward;
      JTextField tfpassward, tfusername;
      
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JPanel p1 = new JPanel();     // this is all for frame
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));  
                                                                                                           
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();              // this is all for panal
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lblpassward = new JLabel("Passward");
        lblpassward.setBounds(60, 110, 100, 25);
        lblpassward.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassward);
        
        tfpassward = new JTextField();
        tfpassward.setBounds(60,150,300,30);
        tfpassward.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassward);
        
        login = new JButton("Login");
        login.setBounds(60,200,130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        singup = new JButton("Singup");
        singup.setBounds(230,200,130, 30);
        singup.setBackground(new Color(133, 193, 233));
        singup.setForeground(Color.WHITE);
        singup.setBorder(new LineBorder(new Color(133,193,233)));
        singup.addActionListener(this);
        p2.add(singup);
        
        passward = new JButton("Forget passward");
        passward.setBounds(130,250,130, 30);
        passward.setBackground(new Color(133, 193, 233));
        passward.setForeground(Color.WHITE);
        passward.setBorder(new LineBorder(new Color(133,193,233)));
        passward.addActionListener(this);
        p2.add(passward);
           
        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300,250,150, 20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== login){
            try{
                String username = tfusername.getText();
                String pass = tfpassward.getText();
                
                String query = "select  *  from account where username = '"+username+"'AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Loading(username);
                     
                 }else{
                     JOptionPane.showMessageDialog(null," Incorrect username and passward");
                 }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== singup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String [] args){
        new Login(); // we can write boject like this it called annonmous function
    }
    
}
