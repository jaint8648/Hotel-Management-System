package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
     JTextField username;
     JPasswordField password;
	 JButton login,reset;
	
	 Login(){
		 setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Gallery/hotelicon.png")));
		 setTitle("Login");
		 getContentPane().setBackground(Color.black);
		 setResizable(false);
		 setLayout(null);
	
		JLabel user=new JLabel("Username");
		user.setForeground(Color.white);
		user.setBounds(40,40,100,30);
		user.setFont(new Font("Century Schoolbook",Font.BOLD,17));
		add(user);
		
		username=new JTextField();
		username.setBounds(150, 40, 150, 30);
		username.setBorder(BorderFactory.createEmptyBorder());
		
		add(username);
		
		
		JLabel pass=new JLabel("Password");
		pass.setForeground(Color.white);
		pass.setBounds(40,110,100,30);
		pass.setFont(new Font("Century Schoolbook",Font.BOLD,17));
		add(pass);
		
		password=new JPasswordField();
		password.setBounds(150, 110, 150, 30);
		password.setBorder(BorderFactory.createEmptyBorder());
		
		add(password);
		
		login=new JButton("Login");
		login.setBounds(40, 190, 120, 30);
		login.setBackground(Color.white);
		login.setForeground(Color.black);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setBorder(BorderFactory.createEmptyBorder());
		login.addActionListener(this);
		add(login);
		
		reset=new JButton("Exit");
		reset.setBounds(180, 190, 120, 30);
		reset.setBackground(Color.white);
		reset.setForeground(Color.black);
		reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reset.setBorder(BorderFactory.createEmptyBorder());
		reset.addActionListener(this);
		add(reset);
		
		ImageIcon i1 = new ImageIcon(Login.class.getResource("/Gallery/login1.png"));
		Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350,30,200,200);
		add(image);
		
		setBounds(380,230,600,300);
		setVisible(true);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

            new Login();
	
	}




	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			String user=username.getText();
			@SuppressWarnings("deprecation")
			String pass=password.getText();
		
		try {
			Conn c=new Conn();
			String query="Select * from login where Username='"+user+"'and Password='"+pass+"'";
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new Dashboard();
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid Username and Passoword");
				
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	
		}
		else if(e.getSource()==reset) {
			setVisible(false);
			   
		}
		
		
	}

}
