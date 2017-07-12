import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class TeamWord extends JPanel{
	DefaultListModel  wordModel;
	JTextField textWord;
	
	TeamWord(){
		
		setBackground(Color.PINK);
		
		wordModel = new DefaultListModel();
		JButton Wordbutton = new JButton("\uB2E8\uC5B4\uBCF4\uAE30");
		Wordbutton.setBounds(127, 119, 163, 31);
		Wordbutton.addActionListener(new WordbuttonListener());
		setLayout(null);

		add(Wordbutton);
	
		JLabel Word = new JLabel("\uC624\uB298\uC758 \uB2E8\uC5B4\uC7A5");
		Word.setFont(new Font("±¼¸²", Font.BOLD, 13));
		Word.setBounds(12, 10, 114, 31);
		
		add(Word);
		
		textWord = new JTextField();
		textWord.setHorizontalAlignment(SwingConstants.CENTER);
		textWord.setColumns(10);
		textWord.setBounds(93, 51, 222, 31);
		add(textWord);
		
		JButton button_2 = new JButton("¿À´Ãº»´Ü¾î ÀüÃ¼º¸±â");
		button_2.setBounds(127, 170, 163, 31);
		button_2.addActionListener(new button2Listener());
		add(button_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB2E8\uC5B4 : ");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_3.setBounds(50, 51, 41, 31);
		add(lblNewLabel_3);
		
		
	}
	
	class WordbuttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
			TodayWord word = new TodayWord(); 
			String strWord = word.Word(); 
			textWord.setText(strWord);
			wordModel.addElement(strWord);
			
		}
	}
	
	class button2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stubWor	
			
			Word word = new Word(wordModel);
			word.setVisible(true);
			
		}
	}

}
