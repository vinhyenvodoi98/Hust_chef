package ClientCheft;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
//import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends CCheft {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String dangnhap;
	private JFrame frame;
	static Connection con;
	static PreparedStatement ps;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public menu() {
		String name="";
		name =FindName();
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	private void initialize(String name) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 697, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblXinCho = new JLabel("Xin Ch\u00E0o");
		lblXinCho.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblXinCho.setBounds(409, 11, 59, 29);
		frame.getContentPane().add(lblXinCho);
		
		JTextArea TextName = new JTextArea();
		TextName.setFont(new Font("Monospaced", Font.BOLD, 13));
		TextName.setBounds(469, 15, 142, 20);
		frame.getContentPane().add(TextName);
		TextName.setEditable(false);
		TextName.setText(name);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/Inside-Restaurant1.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(109, 54, 572, 394);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ClientCheft\\bin\\buttomtest.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image img = new ImageIcon(this.getClass().getResource("/8fce5c74ecdf5d25f6c3a81f9a7b7.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
			}
		});
		btnNewButton.setBounds(10, 88, 89, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Món mới 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image img = new ImageIcon(this.getClass().getResource("/27574142_170798810208276_2729752673556365312_n.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
			}
		});
		btnNewButton_1.setBounds(10, 119, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image img = new ImageIcon(this.getClass().getResource("/hamburger.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
			}
		});
		btnNewButton_2.setBounds(10, 153, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(10, 187, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(10, 221, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblThcn = new JLabel("Th\u1EF1c \u0110\u01A1n");
		lblThcn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThcn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThcn.setBounds(10, 45, 89, 29);
		frame.getContentPane().add(lblThcn);
		
		
		
		JButton btnThot = new JButton("Tho\u00E1t");
		
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CCheft().setVisible(true);
				frame.dispose();
			}
		});
		btnThot.setBounds(610, 14, 71, 23);
		frame.getContentPane().add(btnThot);
		
		
		
	}

	private String FindName() { 
		String name="";
		try {
			s=new Socket("localhost",9999);
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		String msgout="";
		msgout="SELECT INFORMATION".concat(":"+CCheft.dn);
		try {
			dout.writeUTF(msgout);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			name=din.readUTF();
			dout.writeUTF("EXIT");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return name;
	}
	public void setVisible(boolean b) {
		
		menu window = new menu();
		window.frame.setVisible(true);
	}
}
