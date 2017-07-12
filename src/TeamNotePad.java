import java.awt.Color;

import javax.swing.JPanel;

public class TeamNotePad extends JPanel{
	
	TeamDiary diary;
	TeamWeather weather;
	TeamMoney money;
	TeamWord word;
	TeamSchedule schedule;
	String strSelectDay;
	TeamCalendarPage cal;
	public TeamNotePad() {
		money = new TeamMoney();
		
		money.setBounds(12, 3, 433, 393);
		money.setLayout(null);
		add(money);
		
		word = new TeamWord();
		word.setBounds(24, 400, 419, 248);
		word.setLayout(null);
		add(word);
		
		weather = new TeamWeather();
		weather.setBounds(468, 40, 495, 65);
		weather.setVisible(true);
		setLayout(null);		
		add(weather);
		
		diary = new TeamDiary();
		diary.setBounds(468, 103, 490, 288);
		diary.setBackground(Color.PINK);
		diary.setLayout(null);
		
		add(diary);
		
		schedule = new TeamSchedule();
		schedule.setBounds(468, 400, 490, 248);
		schedule.setBackground(Color.PINK);
		schedule.setLayout(null);
		add(schedule);
		
		
		this.setVisible(true);
		
		}
	
		void setCalendar(TeamCalendarPage temCal)
		{
			String str = temCal.strDate;
			System.out.println(str);
		}
	
		void PrintSelDay()
		{
			System.out.println(strSelectDay);
			money.SetStrDate(strSelectDay);
			diary.SetSelctDay(strSelectDay);
		}
		
	}
