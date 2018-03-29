package management.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import management.dao.AddDB;
import management.dao.DeleteDB;
import management.dao.SearchAllDB;
import management.dao.SearchDB;
import management.download.DownLoad;
import management.error.ErrorId;

@SuppressWarnings("serial")
public class UI extends JFrame {
	
	SearchDB sb = new SearchDB();
	AddDB ad = new AddDB();
	DeleteDB dd = new DeleteDB();
	SearchAllDB sca = new SearchAllDB();
	DownLoad dl = new DownLoad();
	ErrorId ei = new ErrorId();
	
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JLabel lblId;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public static JTable table;
	public static JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setTitle("従業員マスタ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("検索");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField.getText().trim().equals("")) {
					ei.MSGAP18021602();
				}else {
				String str1 = textField.getText().trim();
				String str2 = textField_1.getText().trim();
				String str3 = textField_2.getText().trim();
				String str4 = textField_3.getText().trim();
				sb.search(str1,str2,str3,str4);
				}
				}
			}
		);
		btnNewButton.setBounds(798, 18, 113, 27);
		
		JButton btnNewButton_1 = new JButton("戻る");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(798, 430, 113, 27);
		
		JButton btnNewButton_2 = new JButton("ダウンロード");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dl.download();
			}
		});
		btnNewButton_2.setBounds(642, 430, 113, 27);
		
		JButton btnNewButton_3 = new JButton("登録");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str5 = textField_4.getText().trim();
				String str6 = textField_5.getText().trim();
				String str7 = textField_6.getText().trim();
				String str8 = textField_7.getText().trim();
				
				if(str5.equals("")) {
					ei.MSGAP18021602();
				}
				else if(str6.equals("")) {
					ei.MSGAP18021603();
				}else if(str7.equals("")) {
					ei.MSGAP18021604();
				}else if(str8.equals("")) {
					ei.MSGAP18021605();
				}
				else {
				ad.add(str5, str6, str7, str8);}
				
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
			}
		});
		btnNewButton_3.setBounds(19, 430, 113, 27);
		
		JButton btnNewButton_4 = new JButton("削除");
		btnNewButton_4.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				dd.removeSelectedFromTable(table);
			}
			
		}		
		);
		
		btnNewButton_4.setBounds(232, 430, 113, 27);
		
		JButton btnNewButton_5 = new JButton("一括更新");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sca.searchAll();
			}
		});
		btnNewButton_5.setBounds(429, 430, 113, 27);
		
		textField = new JTextField();
		textField.setBounds(67, 21, 46, 24);
		textField.setColumns(5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 21, 31, 24);
		textField_1.setColumns(1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 21, 86, 24);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(497, 21, 164, 24);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(14, 129, 86, 24);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(46, 187, 41, 24);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(5, 248, 107, 24);
		textField_6.setColumns(10);
		
		lblId = new JLabel("従業員");
		lblId.setBounds(14, 24, 47, 18);
		
		lblNewLabel = new JLabel("従業員名");
		lblNewLabel.setBounds(186, 24, 72, 18);
		
		lblNewLabel_1 = new JLabel("連絡先");
		lblNewLabel_1.setBounds(425, 24, 58, 18);
		
		lblNewLabel_2 = new JLabel("従業員");
		lblNewLabel_2.setBounds(19, 98, 58, 18);
		
		lblNewLabel_3 = new JLabel("従業員区分");
		lblNewLabel_3.setBounds(19, 162, 81, 18);
		
		lblNewLabel_4 = new JLabel("従業員名");
		lblNewLabel_4.setBounds(19, 218, 81, 18);
		
		lblNewLabel_5 = new JLabel("コメント(連絡先)");
		lblNewLabel_5.setBounds(19, 279, 136, 18);
		contentPane.setLayout(null);
		contentPane.add(textField_6);
		contentPane.add(textField_4);
		contentPane.add(lblId);
		contentPane.add(textField);
		contentPane.add(btnNewButton_3);
		contentPane.add(textField_5);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_4);
		contentPane.add(textField_2);
		contentPane.add(btnNewButton_5);
		contentPane.add(btnNewButton_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField_3);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		
		textField_7 = new JTextField();
		textField_7.setBounds(5, 319, 150, 82);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(213, 81, 710, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
	}
}
