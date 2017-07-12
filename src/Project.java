import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Project extends JFrame{
	JPanel panel;
	Connection con = makeConnection();
	String str_selDay;
	Project(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Project.class.getResource("/images/IKON.png"))); //아이콘바꾸기
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 755);
		this.setTitle("TeamProject");
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setBounds(0, 0, 984, 717);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 999, 717);
		panel.add(tabbedPane);
		
		TeamCalendarPage panel_1 = new TeamCalendarPage(str_selDay);
		tabbedPane.addTab("달력", null, panel_1, null);
		
		
		TeamNotePad panel_2 = new TeamNotePad();
		tabbedPane.addTab("NotePad", null, panel_2, null);
		panel_2.setLayout(null);
		
		panel_1.setNote(panel_2);
		
		this.setVisible(true);
		
		}
	
	Connection makeConnection() {
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
	}
