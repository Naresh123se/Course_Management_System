package CourseTitle;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Student.Dashboard;
import Student.DataConnection;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ai extends DataConnection {

	public JFrame frame;
	private JTextField idtext;
	private JTextField week1;
	private JTextField idtext1;
	private JTextPane ans1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ai window = new Ai();
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
	public Ai() {
		initialize();
	}
	PreparedStatement pst1;
	ResultSet res1;
	private JTextField week;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 534, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("5CS037 - Concepts and Technology of AI");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 514, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autumn 2022");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setBounds(20, 46, 117, 30);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 86, 534, 225);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 534, 225);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		tabbedPane.addTab("Stream         ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Week");
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(99, 52, 224, 38);
		panel_2.add(scrollPane_1);
		
		JTextPane ques1 = new JTextPane();
		scrollPane_1.setViewportView(ques1);
		
		JLabel lblNewLabel_4 = new JLabel("Questions ");
		lblNewLabel_4.setBounds(10, 59, 63, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Answer ");
		lblNewLabel_4_1.setBounds(10, 142, 63, 14);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		btnNewButton.setBounds(430, 163, 89, 23);
		panel_2.add(btnNewButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(99, 101, 224, 85);
		panel_2.add(scrollPane_2);
		
		ans1 = new JTextPane();
		scrollPane_2.setViewportView(ans1);
		
		week1 = new JTextField();
		week1.setBounds(55, 8, 56, 20);
		panel_2.add(week1);
		week1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search ");
		btnNewButton_1.setBounds(430, 7, 89, 23);
		panel_2.add(btnNewButton_1);
		
		idtext1 = new JTextField();
		idtext1.setBounds(430, 41, 86, 20);
		panel_2.add(idtext1);
		idtext1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Classroom ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Week");
		lblNewLabel_3_1.setBounds(10, 14, 46, 14);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Questions ");
		lblNewLabel_4_2.setBounds(10, 62, 63, 14);
		panel_3.add(lblNewLabel_4_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(100, 56, 222, 36);
		panel_3.add(scrollPane_3);
		
		JTextPane ques = new JTextPane();
		scrollPane_3.setViewportView(ques);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Answer ");
		lblNewLabel_4_1_1.setBounds(10, 145, 63, 14);
		panel_3.add(lblNewLabel_4_1_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(100, 129, 222, 36);
		panel_3.add(scrollPane_4);
		
		JTextPane ans = new JTextPane();
		scrollPane_4.setViewportView(ans);
		
		JLabel lblNewLabel_5_1 = new JLabel("ID");
		lblNewLabel_5_1.setBounds(381, 14, 46, 14);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Search ");
		lblNewLabel_6_1.setBounds(381, 45, 46, 14);
		panel_3.add(lblNewLabel_6_1);
		
		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(433, 11, 86, 20);
		panel_3.add(idtext);
		
		week = new JTextField();
		week.setBounds(76, 11, 86, 20);
		panel_3.add(week);
		week.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("SEEE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID  =  idtext.getText();
				String Week  =  week.getText();
				String Question  =  ques.getText();
				String Answer =   ans.getText();
					
	                	try {
	    					
	                		pst1 = getConnection().prepareStatement("insert into TaskAI (ID,Week,Que,Ans) values (?,?,?,?) " );
	                		 pst1.setString(1, ID);
	     					pst1.setString(2, Week);
	     					pst1.setString(3, Question);
	     					pst1.setString(4, Answer);
	     					
	    					pst1.executeUpdate();
	    					
	    					 
	    					 JOptionPane.showMessageDialog(btnNewButton,"User Added");
	    					 idtext.setText(" ");
	    					 week.setText("");
	    					 ques.setText("");
	    					 ans.setText("");
	    					 
	    				
	    					 
	    				} catch (SQLException e1) {
	    					//TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	                	
	    		
			}
		});
		btnNewButton_2.setBounds(433, 163, 89, 23);
		panel_3.add(btnNewButton_2);
		
		JButton click = new JButton("New button");
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.ID1= ID1;
				String we = week.getText();
				//String ID = IDgetter();
			
				
				 
				 try {
					pst1 = getConnection().prepareStatement("Select * from TaskAI  where Week = ? ");
					pst1.setString(1, we);
					
					
					
					res1 = pst1.executeQuery();
					if(res1.next())
					{
						ques.setText(res1.getString(2));
						ans.setText(res1.getString(3));
						
						
						
					}
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		click.setBounds(430, 41, 89, 23);
		panel_3.add(click);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab(" People     ", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Students");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(289, 11, 74, 14);
		panel_4.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 281, 197);
		panel_4.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Teachers ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 11, 74, 14);
		panel_5.add(lblNewLabel_2);
		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
