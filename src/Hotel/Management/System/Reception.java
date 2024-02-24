package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Reception extends JFrame implements ActionListener {

	JButton newcustomer,rooms,department,allemp,cusinfo,manageinfo,checkout,exit,updstatus,roomstatus,pickup,searchroom;
	
	Reception(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reception.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setTitle("Reception");
		setResizable(false);
		getContentPane().setBackground(Color.black);
		
	    newcustomer=new JButton("New Customer Form");
	    newcustomer.setBackground(Color.black);
	    newcustomer.setForeground(Color.white);
	    newcustomer.setBounds(10,30,200,30);
        newcustomer.addActionListener(this);
        newcustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    add(newcustomer);
		
		rooms=new JButton("Rooms");
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.setBounds(10,70,200,30);
		rooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rooms.addActionListener(this);
		add(rooms);
		
		
		department=new JButton("Department");
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.setBounds(10,110,200,30);
		department.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		department.addActionListener(this);
		add(department);
		

	    allemp=new JButton("All Employees");
		allemp.setBackground(Color.black);
		allemp.setForeground(Color.white);
		allemp.setBounds(10,150,200,30);
		allemp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allemp.addActionListener(this);
		add(allemp);
		
		cusinfo=new JButton("Customer Details");
		cusinfo.setBackground(Color.black);
		cusinfo.setForeground(Color.white);
		cusinfo.setBounds(10,190,200,30);
		cusinfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cusinfo.addActionListener(this);
		add(cusinfo);
		
		
		manageinfo=new JButton("Manager Details");
		manageinfo.setBackground(Color.black);
		manageinfo.setForeground(Color.white);
		manageinfo.setBounds(10,230,200,30);
		manageinfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		manageinfo.addActionListener(this);
		add(manageinfo);
		

		checkout=new JButton("Check Out");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setBounds(10,270,200,30);
		checkout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkout.addActionListener(this);
		add(checkout);
		
		
		updstatus=new JButton("Update Customer Status");
		updstatus.setBackground(Color.black);
		updstatus.setForeground(Color.white);
		updstatus.setBounds(10,310,200,30);
		updstatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updstatus.addActionListener(this);
		add(updstatus);
		
		roomstatus=new JButton("Update Room Status");
		roomstatus.setBackground(Color.black);
		roomstatus.setForeground(Color.white);
		roomstatus.setBounds(10,350,200,30);
		roomstatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		roomstatus.addActionListener(this);
		add(roomstatus);
		
		
		pickup=new JButton("Pickup Service");
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		pickup.setBounds(10,390,200,30);
		pickup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pickup.addActionListener(this);
		add(pickup);
		
		searchroom=new JButton("Search Room");
		searchroom.setBackground(Color.black);
		searchroom.setForeground(Color.white);
		searchroom.setBounds(10,430,200,30);
		searchroom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchroom.addActionListener(this);
		add(searchroom);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.setBounds(10,470,200,30);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.addActionListener(this);
		add(exit);
		

		ImageIcon i1 = new ImageIcon(Addemployee.class.getResource("/Gallery/reception.jpg"));
	    Image i2=i1.getImage().getScaledInstance(500,750,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(220,30,500,750);
	    add(image);
		
		
		
		
		
		
		
		setBounds(320,130,760,550);
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Reception();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit) {
			setVisible(false);
		}
		else if(e.getSource()== newcustomer) {
			new NewCustomer();
			setVisible(false);
		}
		else if(e.getSource()== rooms) {
			 new rooms();
			setVisible(false);
		}
		else if(e.getSource()== department) {
			new department();
			setVisible(false);
		}
		else if(e.getSource()== allemp) {
			new employeedetails();
			setVisible(false);
		}
		else if(e.getSource()== cusinfo) {
			new Customerdetails();
			setVisible(false);
		}
		else if(e.getSource()== manageinfo) {
			new managerdetails();
			setVisible(false);
		}
		else if(e.getSource()== searchroom) {
			new SearchRoom();
			setVisible(false);
		}
		else if(e.getSource()== updstatus) {
			new updatestatus();
			setVisible(false);
		}
		else if(e.getSource()== roomstatus) {
			new updateroomstatus();
			setVisible(false);
		}
		else if(e.getSource()== pickup) {
			new pickupservice();
			setVisible(false);
		}
		else if(e.getSource()== checkout) {
			 new Checkout();
			setVisible(false);
		}
	}

}
