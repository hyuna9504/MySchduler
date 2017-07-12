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

    //기상청 주소
    private String rssFeed = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=%s&gridy=%s"; //주소
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
		
    	//종로구
		
		WetIcon = new JLabel();
		WetIcon.setBounds(102, 10, 57, 56);
		add(WetIcon);

		WetIcon2 = new JLabel();
		WetIcon2.setBounds(163, 10, 57, 56);
		add(WetIcon2);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		textField.setBounds(222, 24, 266, 32);
		add(textField);
		textField.setColumns(10); 
    	
		String strResult = getTownForecast("60", "127");
		textField.setText(strResult);
		
		JLabel lblNewLabel = new JLabel("\uC624\uB298\uC758 \uB0A0\uC528 : ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 23, 94, 32);
		add(lblNewLabel);
    }
   
    /**
     *  해당 좌표의 날씨 정보를 반환.
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
            
            //변수선언을 반드시 먼저 해준다.
            String str_hour ="";
            String str_temp="";
            String str_sky="";
            String str_pty="";
            
            //선언해 둔 변수에 필요한 정보만 저장
            str_hour = el.getChildTextTrim("hour");     //동네예보 3시간 단위
            str_temp=el.getChildTextTrim("temp");
            str_sky=el.getChildTextTrim("sky"); //하늘 상태코드 (1: 맑음, 2: 구름조금, 3:구름많음, 4:흐림)
            str_pty=el.getChildTextTrim("pty"); //강수 상태코드 (0: 없음, 1: 비, 2: 비/눈, 3: 눈/비, 4: 눈)
            
            //강수 상황에 맞춰서 뿌려질 변수
            String str_tempPty="";
            
            //하늘 상황에 맞춰서 뿌려질 변수
            String str_tempSky ="";
            
            //하늘 상황에 따라 변경
            switch(str_sky)
            {
            	//str_pty에 저장되는 1,2,3,4는 글자 이므로 반드시 따옴표를 붙여 검사해야 함
	            case "1":
	            	str_tempSky="맑음";
	            	WetIcon.setIcon(image[0]);
		            break;
	            
	            case "2":
	            	str_tempSky="구름조금";
	            	WetIcon.setIcon(image[1]);

		            break;
	            
	            case "3":
	            	str_tempSky="구름많음";
	            	WetIcon.setIcon(image[2]);

	            	break;
	            case "4":
	            	str_tempSky="흐림";
	            	WetIcon.setIcon(image[3]);

	            	break;
            }
            
            
            //강수 상황에 따라 변경
            switch(str_pty)
            {
            	//str_pty에 저장되는 0,1,2,3,4는 글자 이므로 반드시 따옴표를 붙여 검사해야 함
	            case "0":
		            str_tempPty="눈비없음";
		            break;
	            
	            case "1":
		            str_tempPty="비";
	            	WetIcon2.setIcon(image[4]);

		            break;
	            
	            case "2":
		            str_tempPty="비/눈";
	            	WetIcon2.setIcon(image[5]);

		            break;
	            
	            case "3":
	            	str_tempPty="눈/비";
	            	WetIcon2.setIcon(image[5]);

	            	break;
	            case "4":
	            	str_tempPty="눈";
	            	WetIcon2.setIcon(image[6]);

	            	break;
            }
            
            
            return strResult = " "+str_hour+" 시 :   "+str_temp+"℃    " +str_tempSky+"   "+str_tempPty;
           
 

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return strResult;
    }    
}