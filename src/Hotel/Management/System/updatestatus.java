package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

@SuppressWarnings("serial")
public class updatestatus extends JFrame implements ActionListener {

	Choice tfcustomer;
	JTextField tfroom,tfname,tfcheckin,tfamtpaid,tfpenamt;
	JButton check,update,back;
	updatestatus(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(updatestatus.class.getResource("/Gallery/hotelicon.png")));
	setLayout(null);
	setResizable(false);
	setTitle("Update Customer Status");
	getContentPane().setBackground(Color.white);	
	
	
	JLabel text=new JLabel("Update Customer Status");
	text.setBounds(120, 20, 300, 30);
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
	roomnumber.setBounds(30,120, 100, 20);
	roomnumber.setForeground(Color.black);
	add(roomnumber);
	
	tfroom=new JTextField();
	tfroom.setBounds(200,120,150,25);
	add(tfroom);
	
	JLabel name=new JLabel("Name");
	name.setBounds(30,160, 100, 20);
	name.setForeground(Color.black);
	add(name);
	
	tfname=new JTextField();
	tfname.setBounds(200,160,150,25);
	add(tfname);
	
	JLabel checkintime=new JLabel("Check in Time");
	checkintime.setBounds(30,200, 100, 20);
	checkintime.setForeground(Color.black);
	add(checkintime);
	
	tfcheckin=new JTextField();
	tfcheckin.setBounds(200,200,150,25);
	add(tfcheckin);
	

	JLabel amtpaid=new JLabel("Amount Paid");
	amtpaid.setBounds(30,240, 100, 20);
	amtpaid.setForeground(Color.black);
	add(amtpaid);
	
	tfamtpaid=new JTextField();
	tfamtpaid.setBounds(200,240,150,25);
	add(tfamtpaid);
	
	
	JLabel penamt=new JLabel("Pending Amount");
	penamt.setBounds(30,280, 100, 20);
	penamt.setForeground(Color.black);
	add(penamt);
	
	tfpenamt=new JTextField();
	tfpenamt.setBounds(200,280,150,25);
	add(tfpenamt);
	
	check=new JButton("Check");
	check.setBounds(30,340,100,30);
	check.setBackground(Color.red);
	check.setForeground(Color.white);
	check.addActionListener(this);
	add(check);
	
	update=new JButton("Update");
	update.setBounds(150,340,100,30);
	update.setBackground(Color.red);
	update.setForeground(Color.white);
	update.addActionListener(this);
	add(update);
	
	back=new JButton("Back");
	back.setBounds(270,340,100,30);
	back.setBackground(Color.red);
	back.setForeground(Color.white);
	back.addActionListener(this);
	
	ImageIcon i1 = new ImageIcon(updatestatus.class.getResource("/Gallery/updateroom.jpg"));
    Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(400,50,500,300);
    add(image);
	
	add(back);
    setBounds(200,170,950,430);
	setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new updatestatus();
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
					tfroom.setText(rs.getString("room"));
					tfname.setText(rs.getString("name"));
					tfcheckin.setText(rs.getString("time"));
					tfamtpaid.setText(rs.getString("deposit"));
				}
				ResultSet rs2=c.s.executeQuery("Select * from room where roomnumber='"+tfroom.getText()+"'");
				while(rs2.next()) {
					String price=rs2.getString("price");
					int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfamtpaid.getText());
					tfpenamt.setText(""+amountpaid);
				}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==update) {
                String number=tfcustomer.getSelectedItem();
                String room=tfroom.getText();
                String name=tfname.getText();
                String checkin=tfcheckin.getText();
                String deposit=tfamtpaid.getText();
                
                try {
                	Conn c=new Conn();
                	c.s.executeUpdate("update newcustomer set room='"+room+"',name='"+name+"',time='"+checkin+"',deposit='"+deposit+"' where contact = '"+number+"'");
                JOptionPane.showMessageDialog(null,"Data Sucessfully Updated");
        
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