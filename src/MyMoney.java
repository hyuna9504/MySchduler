import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MyMoney extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	
	DefaultTableModel tableModel;
	
	JFormattedTextField formattedTextField;
	private JScrollPane scrollPane_1;
	private JTextField textFieldTableITem;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JTextField textFieldTotal;
	private JLabel label_1;
	private JButton btnTotal;
	private JButton btnClose;
	
	
	public MyMoney(String strTitle, String strDate) {
		setModal(true);
		setTitle(strTitle);
		setBounds(100, 100, 393, 277);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 377, 239);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Day");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 10, 155, 15);
		lblNewLabel.setText(strDate);
		contentPanel.add(lblNewLabel);		
		
		
		String[] tableTitle = {"번호", "내역", "가격"};
		Object[][] rowData = {{"1", "감자","3500"},{"2","고추","1000"}}; //데이터

		tableModel = new DefaultTableModel(null, tableTitle);
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(12, 43, 356, 90);
		contentPanel.add(scrollPane_1);
		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_DELETE)
				{
					int row = table.getSelectedRow();
					
					tableModel.removeRow(row);
				}	
				
			}
		});
		
		JButton btnAddTable = new JButton("\uCD94\uAC00");
		btnAddTable.addActionListener(new MyAddTableButton());
		btnAddTable.setBounds(287, 160, 81, 23);
		contentPanel.add(btnAddTable);
		
		textFieldTableITem = new JTextField();
		textFieldTableITem.setBounds(69, 161, 116, 21);
		contentPanel.add(textFieldTableITem);
		textFieldTableITem.setColumns(10);
		
		label = new JLabel("\uB0B4\uC5ED");
		label.setBounds(81, 143, 39, 15);
		contentPanel.add(label);
		
		lblNewLabel_1 = new JLabel("\uAC00\uACA9");
		lblNewLabel_1.setBounds(187, 143, 39, 15);
		contentPanel.add(lblNewLabel_1);
		
		formattedTextField = new JFormattedTextField(NumberFormat.getInstance());
		formattedTextField.setBounds(186, 161, 97, 21);
		contentPanel.add(formattedTextField);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(69, 201, 214, 21);
		contentPanel.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		label_1 = new JLabel("\uCD1D\uD569 : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 204, 57, 15);
		contentPanel.add(label_1);
		
		btnTotal = new JButton("계산");
		btnTotal.addActionListener(new MyTotalPrice());
		btnTotal.setBounds(287, 200, 81, 23);
		contentPanel.add(btnTotal);
		
		btnClose = new JButton("close");
		btnClose.setBounds(271, 10, 97, 23);
		
		btnClose.addActionListener(new MyBtnCloseListener());
		contentPanel.add(btnClose);
		
		JLabel lblNewLabel_2 = new JLabel(" \uCD94\uAC00\uB0B4\uC6A9 : ");
		lblNewLabel_2.setBounds(0, 164, 69, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACC4\uBD80");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 6, 57, 27);
		contentPanel.add(lblNewLabel_3);
	}
	
	class MyAddTableButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strCount, strItem, strPrice;
			int count = tableModel.getRowCount()+1;
			strCount = Integer.toString(count);
			strItem = textFieldTableITem.getText();
			strPrice = formattedTextField.getText();
			strPrice.replace(",", "");
			
			Object rowData[] = {strCount, strItem, strPrice.replace(",", "")};
			
			tableModel.addRow(rowData);
		}
		
	}
	
	
	class MyTotalPrice implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int totalPrice=0;
			
			for(int i=0; i<tableModel.getRowCount(); i++)
			{
				String strValue = (String) tableModel.getValueAt(i, 2);
				int value = Integer.parseInt(strValue.replaceAll(",", "") );
				totalPrice+=value;

			}
			textFieldTotal.setText(Integer.toString(totalPrice));
		}
	}
	
	class MyBtnCloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
	
	String getTotalPrice()
	{
		return textFieldTotal.getText();
	}
}

