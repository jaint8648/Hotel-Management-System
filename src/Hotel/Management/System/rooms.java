package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.*;
@SuppressWarnings("serial")
public class rooms extends JFrame implements ActionListener {
JTable table;
	JButton back,exit;
	rooms(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(rooms.class.getResource("/Gallery/hotelicon.png")));
	setLayout(null);
	setTitle("Rooms");
	setResizable(false);
	getContentPane().setBackground(Color.black);
	 
	ImageIcon i1 = new ImageIcon(rooms.class.getResource("/Gallery/roomone.jpg"));
	Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(500,0,600,600);
	add(image);
	 
	 table=new JTable();
	 table.setBounds(0,40,500,400);
	 table.setForeground(Color.white);
	 table.setBackground(Color.black);
	 add(table);

	 try {
		 Conn c=new Conn();
		 String query="Select * from room";
		 ResultSet rs=c.s.executeQuery(query);
		 ResultSetMetaData rsmd=rs.getMetaData();
		 DefaultTableModel model=  (DefaultTableModel) table.getModel();
		 int cols=rsmd.getColumnCount();
		 String [] colName=new String[cols];
		 for(int i=0;i<cols;i++)
		 colName[i]=rsmd.getColumnName(i+1);
		 model.setColumnIdentifiers(colName);
		 

		 String roomnumber,available,clean,price,bed;
		 while(rs.next()) {
			roomnumber=rs.getString(1);
			available=rs.getString(2);
			clean=rs.getString(3);
			price=rs.getString(4);
			bed=rs.getString(5);
			String[] row= {roomnumber,available,clean,price,bed};
			model.addRow(row);
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 JLabel roomnumber=new JLabel("Room Number");
	 roomnumber.setBounds(5,10,100,20);
	 roomnumber.setForeground(Color.white);
	 add(roomnumber);
	 
	 JLabel available=new JLabel("Availability");
	 available.setBounds(110,10,100,20);
	 available.setForeground(Color.white);
	 add(available);
	 
	 JLabel status=new JLabel("Cleaning Status");
	 status.setBounds(210,10,100,20);
	 status.setForeground(Color.white);
	 add(status);
	 
	 JLabel price=new JLabel("Price");
	 price.setForeground(Color.white);
	 price.setBounds(310,10,100,20);
	 add(price);
	 
	 JLabel bedtype=new JLabel("Bed Type");
	 bedtype.setBounds(410,10,100,20);
	 bedtype.setForeground(Color.white);
	 add(bedtype);
	setBounds(150,100,1050,600);
	setVisible(true);
	
	back=new JButton("Back");
	back.setBounds(200,500,120,30);
	back.setBackground(Color.red);
	back.setForeground(Color.white);

	back.addActionListener(this);
	add(back);
	

	
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new rooms();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			setVisible(false);
			new Reception();
			
		}
		
		
		
	}

}
