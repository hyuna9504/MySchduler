import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


public class TeamSchedule extends JPanel{
	TeamWeather weatherPanel_1;
	
	DefaultListModel model;
	String strFruits[] = {};
	int itemCount = strFruits.length;
	JList list;
	JTextField textField_1;
	
	Connection con = makeConnection();
	
	TeamSchedule(){
		model = new DefaultListModel();
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 44, 460, 130);
		add(scrollPane_1);

		
		list = new JList(model);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 189, 368, 23);
		add(textField_1);
		
		JButton btnAdd = new JButton("할 일 추가");
		btnAdd.addActionListener(new MyBtnAddListener());
		btnAdd.setBounds(12, 222, 222, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("할 일 삭제");
		btnDelete.setBounds(246, 222, 226, 23);
		btnDelete.addActionListener(new btnDeleteListener());
		add(btnDelete);
		
		JLabel label_1 = new JLabel("일정 & 할일");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 13));
		label_1.setBounds(12, 10, 102, 29);
		add(label_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uCD94\uAC00\uD560 \uD560 \uC77C : ");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_4.setBounds(12, 188, 90, 24);
		add(lblNewLabel_4);
		
		Init();
	}
	
	
	private Connection makeConnection() {
			// TODO Auto-generated method stub
		Connection c = null;
		
		String url = "jdbc:mysql://localhost/teamproject";
		String user="root";
		String password="password";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
			
		}
	
	void Init() {
			// TODO Auto-generated method stub		
		try {
			Statement stmt = con.createStatement();
			
			String sql = "select *from schedule ";

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				model.addElement(rs.getString("할일")); //내가 보일때는 이거만 보여라.
				int num = model.getSize();
				if(num>0)
					list.setSelectedIndex(num-1);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	
	class MyBtnAddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strItem = textField_1.getText();
			
			try {
				Statement stmt = con.createStatement();
				String sql = "insert into schedule(할일) values('";
				sql+=strItem+"')";
				
				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			model.addElement(strItem);
			
			int num = model.getSize();
			if(num>0)
				list.setSelectedIndex(num-1);
		}		
	}
	
	class btnDeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index = list.getSelectedIndex();
			String str = (String)model.getElementAt(index);
			model.remove(index);	
			if(index>0)
				list.setSelectedIndex(index-1);
			else
				list.setSelectedIndex(0);
			
			try {
				Statement stmt = con.createStatement();
				
				String sql = "delete from schedule where 할일 like('";
				sql+=str+"')";
				
				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
	}}