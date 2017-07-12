import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TeamDiary extends JPanel{
	JLabel lblNewLabel, EmoNewLabel;
	JTextArea textArea;
	ButtonGroup buttonGroup = new ButtonGroup();
	JPanel panelEmo;
	TeamCalendarPage calendar_1;
	String strDate;
	
	TeamDiary(){
	
		setLayout(null);
		lblNewLabel = new JLabel("�� �� ��");
		lblNewLabel.setBounds(211, 10, 68, 34);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 100, 433, 121);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panelEmo = new JPanel();
		panelEmo.setBounds(29, 54, 433, 36);
		panelEmo.setBackground(Color.WHITE);
		add(panelEmo);
		panelEmo.setLayout(null);
		
		JCheckBox emotionhappy = new JCheckBox("�ູ");
		buttonGroup.add(emotionhappy);
		emotionhappy.setBackground(Color.WHITE);
		emotionhappy.setHorizontalAlignment(SwingConstants.CENTER);
		emotionhappy.setBounds(78, 6, 55, 23);
		panelEmo.add(emotionhappy);
		emotionhappy.addActionListener(new emotionhappyListener());
		
		JCheckBox sad = new JCheckBox("����");
		buttonGroup.add(sad);
		sad.setHorizontalAlignment(SwingConstants.CENTER);
		sad.setBackground(Color.WHITE);
		sad.setBounds(164, 6, 57, 23);
		panelEmo.add(sad);
		sad.addActionListener(new sadListener());
		
		JCheckBox glummy = new JCheckBox("���");
		buttonGroup.add(glummy);
		glummy.setHorizontalAlignment(SwingConstants.CENTER);
		glummy.setBackground(Color.WHITE);
		glummy.setBounds(241, 6, 70, 23);
		panelEmo.add(glummy);
		glummy.addActionListener(new glummyListener());
		
		JCheckBox complex = new JCheckBox("����̹�");
		buttonGroup.add(complex);
		complex.setHorizontalAlignment(SwingConstants.CENTER);
		complex.setBackground(Color.WHITE);
		complex.setBounds(315, 6, 97, 23);
		panelEmo.add(complex);
		complex.addActionListener(new complexListener());
		
		JLabel EmoNewLabel = new JLabel("\uAC10\uC815  :");
		EmoNewLabel.setFont(new Font("����", Font.BOLD, 12));
		EmoNewLabel.setBounds(12, 10, 58, 15);
		panelEmo.add(EmoNewLabel);
		
		JButton Diary_Save = new JButton("����");
		Diary_Save.setBounds(369, 231, 93, 23);
		add(Diary_Save);
		Diary_Save.addActionListener(new btnSaveDiaryListener());
		
		JButton Diary_Open = new JButton("\uC5F4\uAE30");
		Diary_Open.addActionListener(new btnOpenDiaryListener());
		Diary_Open.setBounds(273, 231, 93, 23);
		add(Diary_Open);
		//OPEN LISTENER
	
	}
	
	void SetSelctDay(String str)
	{
		strDate = str;
	}
	
	class emotionhappyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String emoH = strDate + "          ��� : �ູ��";
			textArea.setText(emoH);
		}
		
	}
	
	class sadListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String emoS = strDate + "          ��� : ����";
			textArea.setText(emoS);
		}
		
	}
	
	class glummyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String emoG = strDate + "          ��� : �����";
			textArea.setText(emoG);
		}
		
	}
	
	class complexListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String emoC = strDate + "          ��� : ����̹���";
			textArea.setText(emoC);
		}
		
	}
	

	class btnOpenDiaryListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(null);
		String filename=null;
		if(ret == JFileChooser.APPROVE_OPTION)
		{
			filename = chooser.getSelectedFile().getAbsolutePath();
			textArea.setText(filename);
			FileReader file= null;
			try {
				file = new FileReader(filename);
				BufferedReader readbuffer = new BufferedReader(file);
				String str;
				
				//���Ͽ��� �� ���� ����
				str = readbuffer.readLine();
				textArea.setText(str);
				
				//������ ������ �Ѳ����� ����
				//���پ� �����鼭 ����
				while((str = readbuffer.readLine())!=null)
				{
					//������ ������ �ٹٲ��� �߰���
					str+='\n';
					textArea.append(str);
				}
				
				
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
	

	
	class btnSaveDiaryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser chooser = new JFileChooser();
			int ret = chooser.showSaveDialog(null);
			
			
			String filename = null;
			if(ret == JFileChooser.APPROVE_OPTION)
			{
				filename = chooser.getSelectedFile().getAbsolutePath();
				try {
					FileWriter file = new FileWriter(filename);
					BufferedWriter writebuffer = new BufferedWriter(file);
					
					//textField���� ���Ͽ� ��
					//���Ͽ� �ٹٲ�
					writebuffer.write("\n");
					
					//textArea�� �ִ� �������� ���Ͽ� ��
					textArea.write(writebuffer);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
	
	
}}