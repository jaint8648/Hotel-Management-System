package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.*;

@SuppressWarnings("serial")
public class department extends JFrame implements ActionListener {

	JTable table;
	JButton back;
	department(){
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(department.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setTitle("Department");
		setResizable(false);
		getContentPane().setBackground(Color.white);
		 
		
		table=new JTable();
		table.setBounds(0,50,700,180);
		table.setForeground(Color.black);
	    table.setBackground(Color.white);
		add(table);
		
		try {
			 Conn c=new Conn();
			 String query="Select * from department";
			 ResultSet rs=c.s.executeQuery(query);
			 ResultSetMetaData rsmd=rs.getMetaData();
			 DefaultTableModel model=  (DefaultTableModel) table.getModel();
			 int cols=rsmd.getColumnCount();
			 String [] colName=new String[cols];
			 for(int i=0;i<cols;i++)
			 colName[i]=rsmd.getColumnName(i+1);
			 model.setColumnIdentifiers(colName);
			 

			 String departments,budget;
			 while(rs.next()) {
				departments=rs.getString(1);
				budget=rs.getString(2);
				String[] row= {departments,budget};
				model.addRow(row);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 JLabel department=new JLabel("Department");
		 department.setBounds(140,12,100,20);
		 department.setForeground(Color.black);
		 add(department);
		 
		 JLabel budget=new JLabel("Budget");
		 budget.setBounds(480,12,100,20);
		 budget.setForeground(Color.black);
		 add(budget);
		
			ImageIcon i1 = new ImageIcon(department.class.getResource("/Gallery/department.jpg"));
			Image i2=i1.getImage().getScaledInstance(250,276,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(50,230,250,267);
			add(image);
			
			back=new JButton("Back");
			back.setBounds(500,300,100,50);
			back.setBackground(Color.white);
			back.setForeground(Color.black);
			back.addActionListener(this);
			back.setFont(new Font("Tahoma",Font.BOLD,18));
			add(back);
	    setBounds(400,200,700,480);	
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new department();
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
