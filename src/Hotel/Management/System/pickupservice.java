package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.*;

@SuppressWarnings("serial")
public class pickupservice extends JFrame implements ActionListener {
	JButton submit,back;
	 Choice typeofcar;
	JTable table;
	pickupservice(){
	setIconImage(Toolkit.getDefaultToolkit().getImage(pickupservice.class.getResource("/Gallery/hotelicon.png")));
		
    setLayout(null);
	setTitle("Pick Up Service");
	setResizable(false);
	getContentPane().setBackground(Color.black);
	
	JLabel pickup=new JLabel("Pick Up Service");
	pickup.setBounds(390,30,200,30);
	pickup.setForeground(Color.white);
	pickup.setFont(new Font("Tahoma",Font.BOLD,25));
    add(pickup);

    JLabel typeof=new JLabel("Type of Vehicle");
    typeof.setBounds(50,100,150,20);
    typeof.setForeground(Color.white);
    typeof.setFont(new Font("Tahoma",Font.PLAIN,18));
	add(typeof);
	
	typeofcar=new Choice();
	typeofcar.setBounds(250,100,200,25);
	add(typeofcar);
	
	try {
	      Conn c=new Conn();
	      ResultSet rs=c.s.executeQuery("Select * from driver");
	      while(rs.next()) {
	    	  typeofcar.add(rs.getString("vehichlemodel"));
	      }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	 table=new JTable();
	 table.setBounds(0,200,1000,300);
	 table.setForeground(Color.white);
	 table.setBackground(Color.black);
	 add(table);
	
	
	try {
		Conn c=new Conn();
		ResultSet rs=c.s.executeQuery("Select * from driver");
		 ResultSetMetaData rsmd=rs.getMetaData();
		 DefaultTableModel model=  (DefaultTableModel) table.getModel();
		 int cols=rsmd.getColumnCount();
		 String [] colName=new String[cols];
		 for(int i=0;i<cols;i++)
		 colName[i]=rsmd.getColumnName(i+1);
		 model.setColumnIdentifiers(colName);
		 

		 String name,age,gender,vehichle,vehichlemodel,occupied,location;
		 while(rs.next()) {
			name=rs.getString(1);
			age=rs.getString(2);
			gender=rs.getString(3);
			vehichle=rs.getString(4);
			vehichlemodel=rs.getString(5);
			occupied=rs.getString(6);
			location=rs.getString(7);

			String[] row= {name,age,gender,	vehichle,vehichlemodel,occupied,location};
			model.addRow(row);
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	
	 JLabel name=new JLabel("Name");
	 name.setBounds(30,160,100,20);
	 name.setForeground(Color.white);
	 add(name);
	 
	 JLabel age=new JLabel("Age");
	 age.setBounds(200,160,100,20);
	 age.setForeground(Color.white);
	 add(age);
	 
	 JLabel gender=new JLabel("Gender");
	 gender.setBounds(330,160,100,20);
	 gender.setForeground(Color.white);
	 add(gender);
	 
	 JLabel comp=new JLabel("Vehicle Company");
	 comp.setBounds(450,160,100,20);
	 comp.setForeground(Color.white);
	 add(comp);
	 
	 JLabel vehicle=new JLabel("Vehicle Model Number");
	 vehicle.setBounds(575,160,180,20);
	 vehicle.setForeground(Color.white);
	 add(vehicle);
	 
	 
	 JLabel aviala=new JLabel("Avaialablity");
	 aviala.setBounds(740,160,100,20);
	 aviala.setForeground(Color.white);
	 add(aviala);
	 
	 JLabel location=new JLabel("Location");
	 location.setBounds(890,160,100,20);
	 location.setForeground(Color.white);
	 add(location);
	 
	 
	 
	 
	 
	 
	submit=new JButton("Submit");
	submit.setBounds(300,520,120,30);
	submit.setBackground(Color.red);
	submit.setForeground(Color.white);
    submit.addActionListener(this);
	add(submit);

				
	back=new JButton("Back");
	back.setBounds(500,520,120,30);
	back.setBackground(Color.red);
	back.setForeground(Color.white);
    back.addActionListener(this);
	add(back);
	
	
	
	
	
	
	
	
	setBounds(150,100,1015,600);
	setVisible(true);
	
	
	
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new pickupservice();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			try {
				String query1="Select * from driver where vehichlemodel='"+typeofcar.getSelectedItem()+"'";
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query1);
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setRowCount(0); 
				 String name,age,gender,vehichle,vehichlemodel,occupied,location;
				 while(rs.next()) {
					name=rs.getString(1);
					age=rs.getString(2);
					gender=rs.getString(3);
					vehichle=rs.getString(4);
					vehichlemodel=rs.getString(5);
					occupied=rs.getString(6);
					location=rs.getString(7);

					String[] row= {name,age,gender,	vehichle,vehichlemodel,occupied,location};
					model.addRow(row);
			}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
	}

}
