package CourseTitle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Oop {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oop window = new Oop();
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
	public Oop() {
		initialize();
	}

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
		
		JLabel lblNewLabel = new JLabel("5CS019 - Object-Oriented Design and Programming");
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
		
		JPanel Classroom = new JPanel();
		tabbedPane.addTab("Classroom ", null, Classroom, null);
		Classroom.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Week");
		lblNewLabel_3.setBounds(21, 35, 46, 14);
		Classroom.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(67, 32, 46, 20);
		Classroom.add(textField);
		
		JLabel lblNewLabel_4 = new JLabel("Questions ");
		lblNewLabel_4.setBounds(21, 83, 63, 14);
		Classroom.add(lblNewLabel_4);
		
		JTextPane txtpnRam_1 = new JTextPane();
		txtpnRam_1.setBounds(110, 76, 224, 38);
		Classroom.add(txtpnRam_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Answer ");
		lblNewLabel_4_1.setBounds(21, 131, 63, 14);
		Classroom.add(lblNewLabel_4_1);
		
		JTextPane txtpnRam = new JTextPane();
		txtpnRam.setBounds(110, 125, 224, 38);
		Classroom.add(txtpnRam);
		
		JButton Done = new JButton("New button");
		Done.setBounds(402, 163, 89, 23);
		Classroom.add(Done);
		
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
	}
}
