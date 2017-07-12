import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;


public class TeamMoney extends JPanel{
	JTextField textIncome, textPayment, textTotal, text1, text2, text3;
	JLabel lblIncome, lblPayment, lblTotal, lblSelcDay;
	MyMoney dlg;
	
	private JTabbedPane tabbedPane;
	private JPanel panel;
	MyCalendar calendar = new MyCalendar();
	DefaultListModel model2;
	
	Connection con = makeConnection();
	TeamMoney(){
		setLayout(null);
		
		
		
		model2 = new DefaultListModel();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 20, 419, 370);
		add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("가계부", null, panel, null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("선택한 날짜 : ");
		lblNewLabel_5.setBounds(71, 34, 105, 30);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		lblSelcDay = new JLabel();
		lblSelcDay.setBounds(176, 34, 116, 30);
	
		panel.add(lblSelcDay);
		lblSelcDay.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblSelcDay.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblIncome = new JLabel("수입 : ");
		lblIncome.setBounds(34, 100, 57, 19);
		panel.add(lblIncome);
		lblIncome.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		lblPayment = new JLabel("지출 : ");
		lblPayment.setBounds(34, 165, 57, 24);
		panel.add(lblPayment);
		lblPayment.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		lblTotal = new JLabel("총계 : ");
		lblTotal.setBounds(34, 230, 47, 23);
		panel.add(lblTotal);
		lblTotal.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		textIncome = new JTextField();
		textIncome.setBounds(93, 100, 170, 22);
		panel.add(textIncome);
		textIncome.setColumns(10);
		
		textPayment = new JTextField();
		textPayment.setBounds(93, 167, 170, 24);
		panel.add(textPayment);
		textPayment.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setBounds(93, 231, 170, 24);
		panel.add(textTotal);
		textTotal.setColumns(10);
		
		
		JButton btnIncome = new JButton("입력");
		btnIncome.setBounds(287, 99, 85, 23);
		panel.add(btnIncome);
		btnIncome.addActionListener(new btnIncomeListener());
		
		JButton btnPayment = new JButton("입력");
		btnPayment.setBounds(287, 167, 85, 23);
		btnPayment.addActionListener(new btnPaymentListener());
		panel.add(btnPayment);
		
		JButton btnCalculate = new JButton("계산");
		btnCalculate.setBounds(287, 233, 85, 23);
		btnCalculate.addActionListener(new btnCalculateListener());
		panel.add(btnCalculate);
		
		JButton btnNewButton = new JButton("데이터저장");
		btnNewButton.setBounds(10, 295, 100, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new btnNewButtonListener());
		
		JButton btnCallButton = new JButton("불러오기");
		btnCallButton.setBounds(112, 295, 97, 23);
		btnCallButton.addActionListener(new btnCallButtonListener());
		panel.add(btnCallButton);
		
		JButton btnSaveMoney = new JButton("\uD30C\uC77C\uC800\uC7A5");
		btnSaveMoney.setBounds(211, 295, 97, 23);
		btnSaveMoney.addActionListener(new btnSaveMoneyListener());
		panel.add(btnSaveMoney);
		
		JButton btnOpenMoney = new JButton("\uD30C\uC77C\uC5F4\uAE30");
		btnOpenMoney.setBounds(310, 295, 97, 23);
		btnOpenMoney.addActionListener(new btnOpenMoneyListener());
		panel.add(btnOpenMoney);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("그래프", null, panel_1, null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
	
		
		DrawingPanel drawingPanel = new DrawingPanel();
		drawingPanel.setBounds(0, 0, 396, 306);
		panel_1.add(drawingPanel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 308, 414, 33);
		panel_1.add(panel_6);
		
		panel_6.add(new JLabel("수입"));
		
		text1 = new JTextField(3);
		panel_6.add(text1);
		
		
		panel_6.add(new JLabel("지출"));
	
		text2 = new JTextField(3);
		panel_6.add(text2);
		
		panel_6.add(new JLabel("총계"));
		
		text3 = new JTextField(3);
		panel_6.add(text3);
		
		JButton button_1 = new JButton("그래프그리기");
		panel_6.add(button_1);
		
		button_1.addActionListener(new DrawActionListener(text1,text2,text3,drawingPanel));
	}
	
	
	private Connection makeConnection() {
		// TODO Auto-generated method stub
		
		Connection c = null;
		
		String url = "jdbc:mysql://localhost/teamproject"; // 본인이 만든 테이블 이름
		String user="root";
		String password="password"; // 본인이 만든 로컬호스트 비밀번호		
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
	
	void SetStrDate(String strDate)
	{
		lblSelcDay.setText(strDate);	
	}

	
	class btnNewButtonListener implements ActionListener{

		   @Override
		   public void actionPerformed(ActionEvent e) {
		    // TODO Auto-generated method stub
		     
		    try {
		     Statement stmt = con.createStatement();
		     String sql = "insert into 가계부(날짜, 수입, 지출, 총계) values('";
		     sql+=lblSelcDay.getText()+"',"+
		    	textIncome.getText()+","
		       +textPayment.getText()+","+
		       textTotal.getText()+");";
		     
		     stmt.executeUpdate(sql);
		    } catch (SQLException e1) {
		     // TODO Auto-generated catch block
		     e1.printStackTrace();
		    }
		    
		    text1.setText(textIncome.getText());
		    text2.setText(textPayment.getText());
		    text3.setText(textTotal.getText());
		    
		   }  
		  } 
	
	 class btnCallButtonListener implements ActionListener{

		   @Override
		   public void actionPerformed(ActionEvent e) {
		    // TODO Auto-generated method stub
		     
		    try {
		     Statement stmt2 = con.createStatement();
		     String sql = "select * from 가계부 where 날짜 like \""+lblSelcDay.getText() + "\"";
		    		
		     ResultSet rss = stmt2.executeQuery(sql);
		    
				while(rss.next())
				{
					System.out.println(rss.getString("날짜"));
					int income=rss.getInt("수입");
					int payment=rss.getInt("지출");
					int total=rss.getInt("총계");
					textIncome.setText(income+"");
					textPayment.setText(payment+"");
					textTotal.setText(total+"");
					
					
					//model2.addElement(rss.getInt("지출"));
					//model2.addElement(rss.getInt("총계"));//내가 보일때는 이거만 보여라.
					
				}			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		    
		    text1.setText(textIncome.getText());
		    text2.setText(textPayment.getText());
		    text3.setText(textTotal.getText());
		    
		   }  
		  } 

	
	class btnIncomeListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				dlg = new MyMoney("수입관리", "");
				dlg.setVisible(true);
				textIncome.setText(dlg.getTotalPrice());
				text1.setText(dlg.getTotalPrice());
				
			}
			
		}
		
	class btntextListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			text1.setText(textIncome.getText());
		}
		
	}
	
		class btnCalculateListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strIncome = textIncome.getText();
				String strPayment = textPayment.getText();
				String strTotal;
				
				int varIncome=0, varPayment = 0;
				
				if(strIncome.length()>0)
					varIncome = Integer.parseInt(strIncome);
				
				if(strPayment.length()>0)
					varPayment=Integer.parseInt(strPayment);
				
				int total = varIncome-varPayment;
				
				strTotal=Integer.toString(total);
				textTotal.setText(strTotal);
			}
			
		}
		
		class btnPaymentListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				dlg = new MyMoney("지출관리", "");
				dlg.setVisible(true);
				textPayment.setText(dlg.getTotalPrice());
			}
			
		}
		
		public class btnOpenMoneyListener implements ActionListener {
			   public void actionPerformed(ActionEvent e) {
			   
				   JFileChooser chooser = new JFileChooser();
				   int ret = chooser.showOpenDialog(null);
				   String filename = null;
				   if(ret == JFileChooser.APPROVE_OPTION)
				   {
					   filename = chooser.getSelectedFile().getAbsolutePath();
				   }
				  
				   
				   FileReader file = null;
			    
			    try {
			     file = new FileReader(filename);
			     BufferedReader readbuffer = new BufferedReader(file);
			     String str = readbuffer.readLine();
			     
			    
			     textIncome.setText(str);
			     str = readbuffer.readLine();
			     textPayment.setText(str);
			     str = readbuffer.readLine();
			     textTotal.setText(str);
			     str = readbuffer.readLine();
			    
				System.out.println(str);
			    } catch (FileNotFoundException e1) {
			     // TODO Auto-generated catch block
			     e1.printStackTrace();
			    } catch (IOException e2) {
			     // TODO Auto-generated catch block
			     e2.printStackTrace();
			    }
			   }
			  
	}
		
		
		
		class btnSaveMoneyListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					JFileChooser chooser = new JFileChooser();
					int ret = chooser.showSaveDialog(null);
					
					String filename = null;
					if(ret == JFileChooser.APPROVE_OPTION)
					{				
						filename = chooser.getSelectedFile().getAbsolutePath();
						
					try{
						FileWriter file = new FileWriter(filename);
						BufferedWriter buffer = new BufferedWriter(file);
									
						textIncome.write(buffer);
					     buffer.write("\n");
					     textPayment.write(buffer);
					     buffer.write("\n");
					     textTotal.write(buffer);
					     buffer.write("\n");
				
					 } catch (FileNotFoundException e1) {
				     // TODO Auto-generated catch block
				     e1.printStackTrace();
					
					 } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
				}

			}
		
		class DrawingPanel extends JPanel
		{
			int korean, english, math;
			public void paint(Graphics g){
			g.clearRect(0,0,getWidth(),getHeight());
			g.drawLine(50,250,350,250);
			for(int cnt = 1 ;cnt<11;cnt++)
			{
				g.drawString(cnt *10 +"",25,255-20*cnt);
				g.drawLine(50, 250-20*cnt, 350,250-20*cnt);
			}
			g.drawLine(50,20,50,250);
			g.drawString("수입",100,270);
			g.drawString("지출",200,270);
			g.drawString("총계",300,270);
			g.setColor(Color.RED);
			if (korean>0)
				g.fillRect(110,250-korean*2,10,korean*2);
			if(english>0)
				g.fillRect(210,250-english*2,10,english*2);
			if(math>0)
				g.fillRect(310,250-math*2,10,math*2);
			}
			void setScores(int korean, int english, int math)
			{
				this.korean=korean;
				this.english=english;
				this.math=math;
			}
		}

		//버튼 눌렀을때 동작하는 리스너
		class DrawActionListener implements ActionListener
		{
			JTextField text1,text2,text3;
			DrawingPanel drawingPanel;
			DrawActionListener(JTextField text1, JTextField text2, JTextField text3, DrawingPanel drawingPanel)
			{
				this.text1=text1;
				this.text2=text2;
				this.text3=text3;
				this.drawingPanel = drawingPanel;
			}
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int korean = Integer.parseInt(text1.getText());
					int english = Integer.parseInt(text2.getText());
					int math = Integer.parseInt(text3.getText());
					drawingPanel.setScores(korean, english, math);
					drawingPanel.repaint();
				}
				catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(drawingPanel,"잘못된 숫자 입력입니다","에러메시지",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
}
