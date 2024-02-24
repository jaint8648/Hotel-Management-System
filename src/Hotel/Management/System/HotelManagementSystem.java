package Hotel.Management.System;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class HotelManagementSystem extends JFrame implements ActionListener {
 
	 
    HotelManagementSystem(){
    	setIconImage(Toolkit.getDefaultToolkit().getImage(HotelManagementSystem.class.getResource("/Gallery/hotelicon.png")));
        setTitle("Hotel Management System");
        setBounds(200,100,1003,565);
        setResizable(false);

        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(HotelManagementSystem.class.getResource("/Gallery/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1003,565);
        add(image);
        
        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(40,430,1000,90);
        text.setForeground(Color.black);
        text.setFont(new Font("Tahoma",Font.PLAIN,50));
        image.add(text);
        
        JButton next=new JButton("Next");
        next.setBounds(800,450,150,50);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Serif",Font.PLAIN,24));
        next.addActionListener(this);
        next.setBorder(BorderFactory.createEmptyBorder());
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(next);
        
        
        setVisible(true);
     
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
             text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    
    }    

	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Login();
		
	} 
        
        
        
    
    
    public static void main(String[] args) {
        // TODO code application logic here
   new HotelManagementSystem();
   
    
    }






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Login();
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
