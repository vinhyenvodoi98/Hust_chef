/*
 * Created by JFormDesigner on Tue Feb 20 23:28:09 ICT 2018
 */

package ClientCheft;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;




/**
 * @author Ninh Manh Hung
 */
public class CCheft extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CCheft() {
		initComponents();
	}

	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	private void passActionPerformed(ActionEvent e) {
		//dangnhap.setEditable(false);
		dangnhap.setText("");
	}

	private void dangnhapActionPerformed(ActionEvent e) {
		pass.setText("");
	}
	static String dn="";

	@SuppressWarnings("deprecation")
	private void loginbuttonActionPerformed(ActionEvent e) {
		// TODO add your code here
		try {
			s=new Socket("localhost",9999);
			
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String pa="";
		String t1="";
		if(dangnhap.getText()=="" || pass.getText()=="" )
		{
			JOptionPane.showMessageDialog(this, "ban chu nhap ki tu nao ", "ERROR",2);
		}
		else
		{
			try {
				dn=dangnhap.getText();
				pa=pass.getText();
				t1=dn.concat(" "+pa);
				msgout="LOGIN".concat(":"+t1);
				dout.writeUTF(msgout);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		try {
			msgin=din.readUTF();
			if(msgin.equals("1"))
			{
				dout.writeUTF("EXIT");
				new menu().setVisible(true);
				this.dispose();
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "sai ten dang nhap hoac mat khau","ERROR",2);
				dangnhap.setText("");
				pass.setText("");
				dangnhap.requestFocus();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		CCheft c= new CCheft();
		c.setVisible(true);
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	private void dangnhapMouseClicked(MouseEvent e) {
		// TODO add your code here
		dangnhap.setText("");
	}

	private void passMouseClicked(MouseEvent e) {
		// TODO add your code here
		pass.setText("");
	}
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Ninh Manh Hung
		label1 = new JLabel();
		pass = new JPasswordField();
		dangnhap = new JFormattedTextField();
		label2 = new JLabel();
		loginbutton = new JButton();
		label3 = new JLabel();

		//======== this ========
		setTitle("LoginCheft");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("MasterCheft Login");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(label1);
		label1.setBounds(470, 40, 225, 55);

		//---- pass ----
		pass.addActionListener(e -> passActionPerformed(e));
		pass.setText("123456");
		pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passMouseClicked(e);
			}
		});
		contentPane.add(pass);
		pass.setBounds(470, 210, 225, 35);

		//---- dangnhap ----
		dangnhap.addActionListener(e -> dangnhapActionPerformed(e));
		dangnhap.setText("Username");
		dangnhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dangnhapMouseClicked(e);
			}
		});
		contentPane.add(dangnhap);
		dangnhap.setBounds(470, 140, 225, 35);

		//---- label2 ----
		label2.setText("text");
		label2.setIcon(new ImageIcon(getClass().getResource("/color-happy-chef-vector-white-background-67692028.jpg")));
		contentPane.add(label2);
		label2.setBounds(-80, -10, 525, 450);

		//---- loginbutton ----
		loginbutton.setText("LOGIN");
		loginbutton.setFont(new Font("VNI-Lithos", Font.BOLD, 11));
		loginbutton.addActionListener(e -> loginbuttonActionPerformed(e));
		contentPane.add(loginbutton);
		loginbutton.setBounds(470, 280, 225, 35);
		contentPane.add(label3);
		label3.setBounds(685, 405, 40, 20);
		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Ninh Manh Hung
	private JLabel label1;
	private static JPasswordField pass;
	private static JFormattedTextField dangnhap;
	public static String msgout;
	public static String msgin;
	private JLabel label2;
	private JButton loginbutton;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
