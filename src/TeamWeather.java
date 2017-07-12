import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.UIManager;
import java.awt.Font;
public class TeamWeather extends JPanel{

    //���û �ּ�
    private String rssFeed = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=%s&gridy=%s"; //�ּ�
    JLabel WetIcon, WetIcon2;
    JPanel panel;
	String strResult;
    JTextField textField;

    
    
    ImageIcon[] image = {new ImageIcon(this.getClass().getResource("images/1.png")),//0
			new ImageIcon(this.getClass().getResource("images/2.PNG")), //1
			new ImageIcon(this.getClass().getResource("images/3.PNG")), //2
			new ImageIcon(this.getClass().getResource("images/4.PNG")),//3
			new ImageIcon(this.getClass().getResource("images/01.png")),//4
			new ImageIcon(this.getClass().getResource("images/02.png")),//5
			new ImageIcon(this.getClass().getResource("images/04.png"))};//6

    
    public TeamWeather()
    {
		setLayout(null);
		
    	//���α�
		
		WetIcon = new JLabel();
		WetIcon.setBounds(102, 10, 57, 56);
		add(WetIcon);

		WetIcon2 = new JLabel();
		WetIcon2.setBounds(163, 10, 57, 56);
		add(WetIcon2);
		
		textField = new JTextField();
		textField.setFont(new Font("���� ���", Font.BOLD, 13));
		textField.setBounds(222, 24, 266, 32);
		add(textField);
		textField.setColumns(10); 
    	
		String strResult = getTownForecast("60", "127");
		textField.setText(strResult);
		
		JLabel lblNewLabel = new JLabel("\uC624\uB298\uC758 \uB0A0\uC528 : ");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 23, 94, 32);
		add(lblNewLabel);
    }
   
    /**
     *  �ش� ��ǥ�� ���� ������ ��ȯ.
     * @return 
     */
    String getTownForecast(String x, String y) {        
    	String strResult="";
                
        try {
        
            SAXBuilder parser = new SAXBuilder();        
            parser.setIgnoringElementContentWhitespace(true);
                      
            String url = String.format(rssFeed, x, y);
            
            Document doc = parser.build(url);
            Element root = doc.getRootElement();
            
            Element channel = root.getChild("body");
            List<Element> list = channel.getChildren("data");
     
            Element el = (Element)list.get(0);
            
            //���������� �ݵ�� ���� ���ش�.
            String str_hour ="";
            String str_temp="";
            String str_sky="";
            String str_pty="";
            
            //������ �� ������ �ʿ��� ������ ����
            str_hour = el.getChildTextTrim("hour");     //���׿��� 3�ð� ����
            str_temp=el.getChildTextTrim("temp");
            str_sky=el.getChildTextTrim("sky"); //�ϴ� �����ڵ� (1: ����, 2: ��������, 3:��������, 4:�帲)
            str_pty=el.getChildTextTrim("pty"); //���� �����ڵ� (0: ����, 1: ��, 2: ��/��, 3: ��/��, 4: ��)
            
            //���� ��Ȳ�� ���缭 �ѷ��� ����
            String str_tempPty="";
            
            //�ϴ� ��Ȳ�� ���缭 �ѷ��� ����
            String str_tempSky ="";
            
            //�ϴ� ��Ȳ�� ���� ����
            switch(str_sky)
            {
            	//str_pty�� ����Ǵ� 1,2,3,4�� ���� �̹Ƿ� �ݵ�� ����ǥ�� �ٿ� �˻��ؾ� ��
	            case "1":
	            	str_tempSky="����";
	            	WetIcon.setIcon(image[0]);
		            break;
	            
	            case "2":
	            	str_tempSky="��������";
	            	WetIcon.setIcon(image[1]);

		            break;
	            
	            case "3":
	            	str_tempSky="��������";
	            	WetIcon.setIcon(image[2]);

	            	break;
	            case "4":
	            	str_tempSky="�帲";
	            	WetIcon.setIcon(image[3]);

	            	break;
            }
            
            
            //���� ��Ȳ�� ���� ����
            switch(str_pty)
            {
            	//str_pty�� ����Ǵ� 0,1,2,3,4�� ���� �̹Ƿ� �ݵ�� ����ǥ�� �ٿ� �˻��ؾ� ��
	            case "0":
		            str_tempPty="�������";
		            break;
	            
	            case "1":
		            str_tempPty="��";
	            	WetIcon2.setIcon(image[4]);

		            break;
	            
	            case "2":
		            str_tempPty="��/��";
	            	WetIcon2.setIcon(image[5]);

		            break;
	            
	            case "3":
	            	str_tempPty="��/��";
	            	WetIcon2.setIcon(image[5]);

	            	break;
	            case "4":
	            	str_tempPty="��";
	            	WetIcon2.setIcon(image[6]);

	            	break;
            }
            
            
            return strResult = " "+str_hour+" �� :   "+str_temp+"��    " +str_tempSky+"   "+str_tempPty;
           
 

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return strResult;
    }    
}