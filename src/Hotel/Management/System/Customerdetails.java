package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.*;
@SuppressWarnings("serial")
public class Customerdetails extends JFrame implements ActionListener {

	JTable table;
	JButton back;
	Customerdetails(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customerdetails.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setTitle("Customer Details");
		setResizable(false);
		getContentPane().setBackground(Color.blue);
		
		table=new JTable();
		table.setBounds(0,50,1000,400);
		table.setForeground(Color.white);
	    table.setBackground(Color.blue);
		add(table);
		
		try {
			 Conn c=new Conn();
			 String query="Select * from newcustomer";
			 ResultSet rs=c.s.executeQuery(query);
			 ResultSetMetaData rsmd=rs.getMetaData();
			 DefaultTableModel model=  (DefaultTableModel) table.getModel();
			 int cols=rsmd.getColumnCount();
			 String [] colName=new String[cols];
			 for(int i=0;i<cols;i++)
			 colName[i]=rsmd.getColumnName(i+1);
			 model.setColumnIdentifiers(colName);
			 

			 String id,contact,name,gender,country,room,time,deposit;
			 
			 while(rs.next()) {
				id=rs.getString(1);
				contact=rs.getString(2);
				name=rs.getString(3);
			    gender=rs.getString(4);
				country=rs.getString(5);
				room=rs.getString(6);
				time=rs.getString(7);
				deposit=rs.getString(8);
				
				
				String[] row= {id,contact,name,gender,country,room,time,deposit};
				model.addRow(row);
			 }
		 }
		
		
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 JLabel documents=new JLabel("Document");
		 documents.setBounds(25,10,100,20);
		 documents.setForeground(Color.white);
		 add(documents);
		
		 JLabel contact=new JLabel("Document ID");
		 contact.setBounds(150,10,100,20);
		 contact.setForeground(Color.white);
		 add(contact);
		
		 JLabel name=new JLabel("Name");
		 name.setBounds(285,10,100,20);
		 name.setForeground(Color.white);
		 add(name);
		 
		 JLabel gender=new JLabel("Gender");
		 gender.setBounds(400,10,100,20);
		 gender.setForeground(Color.white);
		 add(gender);

		 JLabel country=new JLabel("Country");
		 country.setBounds(540,10,100,20);
		 country.setForeground(Color.white);
		 add(country);

		 JLabel room=new JLabel("Rooms");
		 room.setBounds(650,10,100,20);
		 room.setForeground(Color.white);
		 add(room);

		 JLabel time=new JLabel("Date & Time");
		 time.setBounds(770,10,100,20);
		 time.setForeground(Color.white);
		 add(time);
		 
		 JLabel deposit=new JLabel("Deposit");
		 deposit.setBounds(890,10,100,20);
		 deposit.setForeground(Color.white);
		 add(deposit);
		 
			back=new JButton("Back");
			back.setBounds(420,500,120,30);
			back.setBackground(Color.red);
			back.setForeground(Color.white);
			
			back.setFont(new Font("Tahoma",Font.BOLD,18));
			back.addActionListener(this);
			add(back);
			
		 
		
		
		setBounds(150,100,1000,600);
	    setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Customerdetails();

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
