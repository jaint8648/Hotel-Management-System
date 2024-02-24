package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddDrivers extends JFrame implements ActionListener {
  
	JTextField tfname,tfage,tfcar,tfcarmodel,tflocation;
     @SuppressWarnings("rawtypes")
	JComboBox gendercombo,avialablecombo;
	JButton adddri,back;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddDrivers(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddDrivers.class.getResource("/Gallery/hotelicon.png")));
		setTitle("Add Drivers");
		getContentPane().setBackground(Color.black);
		setBounds(200,180,980,530);
		setResizable(false);
		setLayout(null);
		
		JLabel adddrivers=new JLabel("Add Drivers");
		adddrivers.setBounds(150, 35, 200, 20);
		adddrivers.setFont(new Font("Century Schoolbook",Font.BOLD,22));
		adddrivers.setForeground(Color.white);
		add(adddrivers);
		
		JLabel name=new JLabel("Name");
		name.setBounds(60, 80, 200, 30);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		name.setForeground(Color.white);
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(200,80,150,30);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		add(tfname);
		

		JLabel age=new JLabel("Age");
		age.setBounds(60, 130, 120, 30);
		age.setFont(new Font("Tahoma",Font.PLAIN,16));
		age.setForeground(Color.white);
		add(age);
		
		tfage=new JTextField();
		tfage.setBounds(200,130,150,30);
		tfage.setBorder(BorderFactory.createEmptyBorder());
		add(tfage);
		
		
		JLabel gender=new JLabel("Gender");
		gender.setForeground(Color.white);
		gender.setBounds(60, 180, 120, 30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		String genderoption[]= {"Male","Female","Other","Not Specified"};
		gendercombo=new JComboBox(genderoption);
		gendercombo.setBounds(200, 180, 150, 30);
		gendercombo.setBackground(Color.white);
		gendercombo.setBorder(BorderFactory.createEmptyBorder());
		add(gendercombo);	
		
		JLabel car=new JLabel("Vehicle Company");
		car.setBounds(60, 230,150,30);
		car.setForeground(Color.white);
		car.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(car);
		
		tfcar=new JTextField();
		tfcar.setBounds(200,230,150,30);
		tfcar.setBorder(BorderFactory.createEmptyBorder());
		add(tfcar);
		
		JLabel carmodel=new JLabel("Vehicle Model");
		carmodel.setBounds(60, 280, 120, 30);
		carmodel.setForeground(Color.white);
		carmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(carmodel);
		
		
		tfcarmodel=new JTextField();
		tfcarmodel.setBounds(200, 280, 150, 30);
		tfcarmodel.setBorder(BorderFactory.createEmptyBorder());
		add(tfcarmodel);
	
		JLabel avaiable=new JLabel("Available");
		avaiable.setForeground(Color.white);
		avaiable.setBounds(60, 330, 120, 30);
		avaiable.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(avaiable);
		
		String avialableoptions[]= {"Occupied","Not Occupied"};
		avialablecombo=new JComboBox(avialableoptions);
		avialablecombo.setBounds(200, 330, 150, 30);
		avialablecombo.setBackground(Color.white);
		avialablecombo.setBorder(BorderFactory.createEmptyBorder());
		add(avialablecombo);	
		
		JLabel Location=new JLabel("Location");
		Location.setBounds(60, 380, 120, 30);
		Location.setForeground(Color.white);
		Location.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Location);
		
		tflocation=new JTextField();
		tflocation.setBounds(200, 380, 150, 30);
		tflocation.setBorder(BorderFactory.createEmptyBorder());
		add(tflocation); 	
	 	
		
		adddri=new JButton("Add Driver");
		adddri.setBounds(60,440,130,30);
		adddri.setFont(new Font("Tahoma",Font.BOLD,15));
		adddri.setBackground(Color.red);
		adddri.setForeground(Color.white);
		adddri.setBorder(BorderFactory.createEmptyBorder());
		adddri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adddri.addActionListener(this);
		add(adddri);
		
		back=new JButton("Back");
		back.setFont(new Font("Tahoma",Font.BOLD,15));
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.setBounds(220,440,130,30);
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(AddRooms.class.getResource("/Gallery/driver2.jpg"));
	    Image i2=i1.getImage().getScaledInstance(500,330,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,100,500,330);
	    add(image);
		
		
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new AddDrivers();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==adddri) {
			String name=tfname.getText();
			String age=tfage.getText();
			String gender=(String)gendercombo.getSelectedItem();
			String vehicle=tfcar.getText();
			String vehiclemodel=tfcarmodel.getText();
			String occupied=(String)avialablecombo.getSelectedItem();
			String location=tflocation.getText();
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name Should not be Empty");
				return;
			}
			if(age.equals("")) {
				JOptionPane.showMessageDialog(null,"Age Should not be Empty");
				return;
			}
			if (tfcar.getText().equals("")) {
			    JOptionPane.showMessageDialog(null, "Vehicle Company Should not be Empty");
			    return;
			}
			if (tfcarmodel.getText().equals("")) {
			    JOptionPane.showMessageDialog(null, "Vehicle Model Should not be Empty");
			    return;
			}
			if(location.equals("")) {
				JOptionPane.showMessageDialog(null,"Location Should not be Empty");
				return;
			}
		      try {
		    	  Conn c=new Conn();
		    	  String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+vehicle+"','"+ vehiclemodel+"','"+occupied+"','"+ location+"')";
		    	  c.s.executeUpdate(str);
		    	  JOptionPane.showMessageDialog(null,"New Driver Added Sucesfully");
		    
		      }
		      catch(Exception e1) {
		    	  e1.printStackTrace();
		      }
		}
		else if(e.getSource()==back) {
                 setVisible(false);		
                
	}

}
		
	}


