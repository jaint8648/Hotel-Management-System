package Hotel.Management.System;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class Dashboard extends JFrame implements ActionListener {
JMenuItem calculator,notepad;
	
	Dashboard(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/Gallery/hotelicon.png")));
		setTitle("DashBoard");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
		setLayout(null);
	    
		ImageIcon i1 = new ImageIcon(Dashboard.class.getResource("/Gallery/hotel.jpg"));
	    Image i2=i1.getImage().getScaledInstance(1380,1000,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,1380,1000);
	    add(image);
    
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        mb.setBackground(Color.black);
        image.add(mb);
        
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setFont(new Font("Tahoma",Font.PLAIN,12));
        hotel.setForeground(Color.white);
        mb.add(hotel);
        
        JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.white);
        admin.setFont(new Font("Tahoma",Font.PLAIN,12));
        mb.add(admin);
        
        JMenuItem reception=new JMenuItem("Reception");
        hotel.add(reception);
        reception.addActionListener(this);
        
        
        JMenuItem addemployee=new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms=new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        

        JMenuItem adddrivers=new JMenuItem("Add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        
	    JMenuItem logout=new JMenuItem("Log Out");
	    logout.addActionListener(this);
	    admin.add(logout);
	    
	    JMenu Tools=new JMenu("Tools");
	    Tools.setForeground(Color.white);
	    Tools.setFont(new Font("Tahoma",Font.PLAIN,12));
        mb.add(Tools);
        
        calculator=new JMenuItem("Calculator");
        calculator.addActionListener(this);
        Tools.add(calculator);
        
        notepad=new JMenuItem("Notepad");
        notepad.addActionListener(this);
        Tools.add(notepad);
        
        
        
	    setUndecorated(true);
	    setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new Dashboard();
		
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Add Employee")) {
			 new Addemployee();
		}
		else if(e.getActionCommand().equals("Add Rooms")) {
			new AddRooms();
		}
		else if(e.getActionCommand().equals("Add Drivers")) {
			 new AddDrivers();

		}
		else if(e.getActionCommand().equals("Reception")) {
			  new Reception();

		}
		else if(e.getActionCommand().equals("Log Out")) {
			  System.exit(0);

		}
		else if(e.getActionCommand().equals("Log Out")) {
			  System.exit(0);

		}
		else if(e.getSource()==calculator) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==notepad) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
