package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
@SuppressWarnings("serial")
public class updateroomstatus extends JFrame implements ActionListener {
Choice tfcustomer;
	JTextField tfavailable,tfstatus,tfroomnumber;
	JButton update,back,check;
	updateroomstatus(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateroomstatus.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setResizable(false);
		setTitle("Update Room Status");
		getContentPane().setBackground(Color.white);	
		
		
		JLabel text=new JLabel("Update Room Status");
		text.setBounds(120, 20, 200, 30);
		text.setFont(new Font("Tahoma",Font.BOLD,18));
		text.setForeground(Color.black);
		add(text);
		
		JLabel custid=new JLabel("Customer ID");
		custid.setBounds(30, 80, 100, 20);
		custid.setForeground(Color.black);
		add(custid);
		
		tfcustomer=new Choice();
		tfcustomer.setBounds(200,80,150,25);
		add(tfcustomer);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("Select * from newcustomer");
			while(rs.next()) {
				tfcustomer.add(rs.getString("contact"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		JLabel roomnumber=new JLabel("Room Number");
		roomnumber.setBounds(30,130, 100, 20);
		roomnumber.setForeground(Color.black);
		add(roomnumber);
		
		tfroomnumber=new JTextField();
		tfroomnumber.setBounds(200,130,150,25);
		add(tfroomnumber);
		
		JLabel avaialable=new JLabel("Availablity");
		avaialable.setBounds(30,180, 100, 20);
		avaialable.setForeground(Color.black);
		add(avaialable);
		
		tfavailable=new JTextField();
		tfavailable.setBounds(200,180,150,25);
		add(tfavailable);
		
		JLabel status=new JLabel("Cleaning Status");
		status.setBounds(30,230, 100, 20);
		status.setForeground(Color.black);
		add(status);
		
		tfstatus=new JTextField();
		tfstatus.setBounds(200,230,150,25);
		add(tfstatus);
		
		check=new JButton("Check");
		check.setBounds(30,300,100,30);
		check.setBackground(Color.red);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		
		update=new JButton("Update");
		update.setBounds(150,300,100,30);
		update.setBackground(Color.red);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setBounds(270,300,100,30);
		back.setBackground(Color.red);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(updateroomstatus.class.getResource("/Gallery/cleaning.jpg"));
	    Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,50,500,300);
	    add(image);
		
		
		
		setBounds(200,170,960,430);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new updateroomstatus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==check) {
			String id=tfcustomer.getSelectedItem();
			String query="Select * from newcustomer where contact='"+id+"'";
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next()) {
					tfroomnumber.setText(rs.getString("room"));
				}
				ResultSet rs2 = c.s.executeQuery("Select * from room where roomnumber='" + tfroomnumber.getText() + "'");
				while(rs2.next()) {
					tfavailable.setText(rs2.getString("available"));
					tfstatus.setText(rs2.getString("clean"));
				}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==update) {
                @SuppressWarnings("unused")
				String number=tfcustomer.getSelectedItem();
                String room=tfroomnumber.getText();
                String available=tfavailable.getText();
                String status=tfstatus.getText();
                            
                try {
                	Conn c=new Conn();
                	c.s.executeUpdate("update room set available='"+available+"',clean='"+status+"' where roomnumber = '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data, Updated Sucessfully");
              
                
                }
                catch(Exception e2) {
                	e2.printStackTrace();
                }
		}
		else if(e.getSource()==back) {
			setVisible(false);
			 new Reception();
		}
}
	}


