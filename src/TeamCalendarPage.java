import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

import java.awt.Font;


public class TeamCalendarPage extends JPanel{
	private MyCalendar calendar_1;
	private JTextField textToday, textSelday;
	String strDate="ÃÊ±â°ª";
	TeamNotePad temppad;
	TeamCalendarPage(String str){
		calendar_1 = new MyCalendar();
		calendar_1.setBounds(12, 90, 956, 550); 
		calendar_1.setWeekOfYearVisible(false);
		calendar_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendar_1.addPropertyChangeListener("calendar", new calendarListener());
		setLayout(null);
		add(calendar_1);
		
		JButton btnSelectedday = new JButton("¼±ÅÃÇÑ ³¯Â¥");
		btnSelectedday.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		btnSelectedday.setBounds(12, 45, 120, 29); //¿ÞÂÊ, À§, ±æÀÌ, µÎ²²
		add(btnSelectedday);
		
		textSelday  = new JTextField();
		textSelday.setBounds(140, 45, 300 ,29);
		textSelday.setHorizontalAlignment(SwingConstants.CENTER);
		add(textSelday);
		textSelday .setColumns(10);	
		strDate = textSelday.getText();
		
		
		JButton btnToday = new JButton("Today");
		btnToday.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		btnToday.setBounds(534, 45, 120, 29);
		btnToday.addPropertyChangeListener("calendar", new calendarListener());
		btnToday.addActionListener(new btnTodayListener());
		setLayout(null);
		add(btnToday);
		
		textToday  = new JTextField();
		textToday.setBounds(661, 45, 306, 29);
		textToday.setHorizontalAlignment(SwingConstants.CENTER);
		add(textToday);
		textToday .setColumns(10);
		
		}
		
	
	class calendarListener implements PropertyChangeListener{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			// TODO Auto-generated method stub
			strDate = calendar_1.GetSelectDay();
			textSelday.setText(strDate);
			
			temppad.strSelectDay = strDate;
			temppad.PrintSelDay();
			//System.out.println(temppad.strSelectDay);
			}
		}
	
	
	class btnTodayListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textToday.setText(calendar_1.SetToday());
		}		
	}
	 
	public String getselectDay()
	{
		
		System.out.println(strDate);
		return strDate;
	}
	
	void setNote(TeamNotePad pad)
	{
		temppad = pad;
	}
	
}