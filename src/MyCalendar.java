import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;


public class MyCalendar extends JCalendar{
	Color spBg;
	
	void SetSpecialBGColor(Color color)
	{
		spBg=color;
	}
	
	String SetToday()
	{
		Calendar c = Calendar.getInstance ( );
		int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        
        this.getDayChooser().setDay(day);
        this.getYearChooser().setYear(year);
        this.getMonthChooser().setMonth(month);	
        
        String strSelctDay = year+"년 "+month+"월 "+day+"일";
        
        return strSelctDay;
	}
	
	int GetFirstDay(int year, int month)
	{
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		int beginday = c.get(Calendar.DAY_OF_WEEK);
		return beginday;
	}
	
	void ReDrawCalendar(int num, int month, int year)
	{
		JPanel selectedPanel = this.getDayChooser().getDayPanel();
		Component component[] = selectedPanel.getComponents();
		
		int beginday = GetFirstDay(year, month);
		
		int selnum=num+7+beginday-2;
		component[selnum].setBackground(spBg);
	}
	
	String GetSelectDay()
	{
		String strSelctDay="";
		
		int year = this.getYearChooser().getYear();
		int month = this.getMonthChooser().getMonth()+1;
		int day = this.getDayChooser().getDay();
		
		strSelctDay = year+"년 "+month+"월 "+day+"일";
		
		return strSelctDay;
	}
}
