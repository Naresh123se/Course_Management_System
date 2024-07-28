package Result;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EmptyBorder;

import Student.DataConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result extends DataConnection {

	private JFrame frame;
	private JTextField nametext;
	private JTextField namebox;
	private JTextField idtext;
	private JTextField sextext;
	private JTextField aitext;
	private JTextField nmctext;
	private JTextField ooptext;
	private JTextField totaltext;
	private JTextField resulttext;
	Component btnNewButton;
	//public String na;
	//private static String ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//System.out.print(ID1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result window = new Result();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Result() {
		initialize();
		
	}
	
	
	public Result(String ID) {
		
		 initialize();
		 
		 idtext.setText(ID);
		/// System.out.println(idtext);
		

		
		}
	PreparedStatement pst;
	
	ResultSet res;
	
	//System.out.print(na);
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			//private Object ID1;

			@Override
			public void componentShown(ComponentEvent e) {
				
				
				
				
			}
		});
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
		});
		frame.setBounds(100, 100, 550, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		contentPanel.setLayout(null);
		contentPanel.setForeground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBounds(0, 0, 534, 411);
		frame.getContentPane().add(contentPanel);
		
		JPanel panel = new JPanel();
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 534, 137);
		contentPanel.add(panel);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 49, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 102, 89, 14);
		panel.add(lblCourseName);
		
		JLabel ID11 = new JLabel("ID");
		ID11.setBounds(252, 49, 46, 14);
		panel.add(ID11);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sex");
		lblNewLabel_1_1.setBounds(252, 102, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		nametext = new JTextField();
		nametext.setFont(new Font("Tahoma", Font.BOLD, 11));
		nametext.setColumns(10);
		nametext.setBounds(121, 49, 101, 20);
		panel.add(nametext);
		
		namebox = new JTextField();
		namebox.setFont(new Font("Tahoma", Font.BOLD, 11));
		namebox.setColumns(10);
		namebox.setBounds(121, 99, 101, 20);
		panel.add(namebox);
		
		idtext = new JTextField();
		idtext.setFont(new Font("Tahoma", Font.BOLD, 11));
		idtext.setColumns(10);
		idtext.setBounds(328, 49, 101, 20);
		panel.add(idtext);
		
		sextext = new JTextField();
		sextext.setFont(new Font("Tahoma", Font.BOLD, 11));
		sextext.setColumns(10);
		sextext.setBounds(328, 99, 101, 20);
		panel.add(sextext);
		
		JLabel lblNewLabel_2 = new JLabel("RESULTS");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 11, 93, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(458, 0, 76, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("AI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 196, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NMC");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(20, 289, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("OOP");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 242, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("40");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(265, 196, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("40");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(265, 242, 46, 14);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("40");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(265, 289, 46, 14);
		contentPanel.add(lblNewLabel_8);
		
		aitext = new JTextField();
		aitext.setFont(new Font("Tahoma", Font.BOLD, 12));
		aitext.setBounds(404, 193, 36, 20);
		contentPanel.add(aitext);
		aitext.setColumns(10);
		
		nmctext = new JTextField();
		nmctext.setFont(new Font("Tahoma", Font.BOLD, 12));
		nmctext.setBounds(404, 239, 36, 20);
		contentPanel.add(nmctext);
		nmctext.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("100");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_1.setBounds(142, 196, 46, 14);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("100");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7_1.setBounds(142, 242, 46, 14);
		contentPanel.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("100");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_1.setBounds(142, 289, 46, 14);
		contentPanel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Titles ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(20, 151, 62, 14);
		contentPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Total Marks");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(129, 151, 88, 14);
		contentPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Pass Marks");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1_1.setBounds(249, 148, 88, 14);
		contentPanel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Obtain Marks");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1_1_1.setBounds(389, 151, 99, 14);
		contentPanel.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Total");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(20, 329, 46, 14);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("300");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(142, 329, 46, 14);
		contentPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("120");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(265, 329, 46, 14);
		contentPanel.add(lblNewLabel_11);
		
		ooptext = new JTextField();
		ooptext.setFont(new Font("Tahoma", Font.BOLD, 12));
		ooptext.setColumns(10);
		ooptext.setBounds(404, 286, 36, 20);
		contentPanel.add(ooptext);
		
		totaltext = new JTextField();
		totaltext.setFont(new Font("Tahoma", Font.BOLD, 13));
		totaltext.setColumns(10);
		totaltext.setBounds(404, 326, 36, 20);
		contentPanel.add(totaltext);
		
		resulttext = new JTextField();
		resulttext.setFont(new Font("Tahoma", Font.BOLD, 14));
		resulttext.setBounds(438, 368, 76, 32);
		contentPanel.add(resulttext);
		resulttext.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = idtext.getText();
			
		
				 
				 try {
					pst = getConnection().prepareStatement("Select * from Marks  inner join study where Marks.ID = ? and study.ID = ? ");
					pst.setString(1, ID);
					pst.setString(2, ID);
					
					
					res = pst.executeQuery();
					if(res.next())
					{
						nametext.setText(res.getString(2));
						namebox.setText(res.getString(3));
						sextext.setText(res.getString(9));
						
						aitext.setText(res.getString(4));
						nmctext.setText(res.getString(5));
						ooptext.setText(res.getString(6));
						
						int s1=Integer.parseInt(aitext.getText());
						int s2=Integer.parseInt(nmctext.getText());
						int s3=Integer.parseInt(ooptext.getText());
						int result =s1+s2+s3;
						String s0=String .valueOf(result);
						totaltext.setText(s0);
						if(s1<40 ||s2<40 || s3<40)
						{
							resulttext.setText("FAIL");
						}
						else
						{
							resulttext.setText("PASS");
						}
					
						
					}
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		});
		btnNewButton_1.setBounds(69, 373, 107, 23);
		contentPanel.add(btnNewButton_1);
		frame.setVisible(true);
	}
}
