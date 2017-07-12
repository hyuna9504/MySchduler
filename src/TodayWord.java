import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class TodayWord {
	String[] array = new String[]
    		{"swim : 수영하다","play : 놀다" ,"glass : 유리" , "tear : 눈물, 찢다", "glad : 기쁜",
    		"full : 가득찬", "dark : 어두운", "fruit : 과일", "church : 교회", "free : 자유로운","enjoy : 즐기다","fool : 바보","train : 훈련하다"
    		,"smoke : 연기,담배피다","travel : 여행하다","food : 음식","fly : 날다","turn : 방향을바꾸다","floor : 바닥,층","ask : 질문하다"
,"feel : 느끼다","wash : 씻다","sweet : 달콤한","finger : 손가락","wise : 현명한","place : 장소","child : 어린이","wrong : 틀린","face : 얼굴","care : 걱정,주의","energy : 에너지,힘"
,"bath : 목욕","earth : 지구","art : 예술","call : 부르다","worry : 걱정하다","close : 닫다,가까운","strong : 힘센","burn : 불에타다","dirty : 더러운",
"visit : 방문하다","throw : 던지다","carry : 운반하다","quite : 조용한","return : 되돌려주다","clean : 깨끗한","save : 저축하다","pay : 지불하다","move : 이동하다","live : 살다","difficult : 어려운","learn : 배우다",
"hard : 단단한,어려운","important : 중요한","believe : 믿다","interested : 관심있는","change : 바꾸다","fresh : 신선한","dry : 건조한","balance : 균형","fat : 살찐", "different : 다른",
"arrive : 도착하다","find : 발견하다","bad : 나쁜","catch : 잡다","wait : 기다리다","absent : 결석한","satisfy : 만족시키다","break : 깨다","condition : 상태,형편","mix : 섞다,혼합하다","alike : 비슷한","bore : 지루하게하다","lose : 잃어버리다",
"job : 직장,일","bend : 구부리다","active : 활동적인","cheap : 값이 싼","blood : 피","dangerous : 위험한","hide : 숨기다","allow : 허락하다","borrow : 빌리다","expect : 기대하다"
,"cover : 덮다","bear : 참다,낳다","gather : 모으다","harm : 손해","equal : 같은,동일한","border : 국경","decide : 결정하다","continue : 계속하다","bite : 물다","angry : 화가 난",
"edge : 가장자리","block : 구획","invite : 초대하다","add : 첨가하다","breeze : 산들바람","leave : 떠나다"};
	
	TodayWord(){
		
	}
	
	 String Word()
	    {
	    	Random rand = new Random();
			int num = 0;
			
		
			num = rand.nextInt(99);
			
			
			
	    return array[num];
	    }

}
