import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class TodayWord {
	String[] array = new String[]
    		{"swim : �����ϴ�","play : ���" ,"glass : ����" , "tear : ����, ����", "glad : ���",
    		"full : ������", "dark : ��ο�", "fruit : ����", "church : ��ȸ", "free : �����ο�","enjoy : ����","fool : �ٺ�","train : �Ʒ��ϴ�"
    		,"smoke : ����,����Ǵ�","travel : �����ϴ�","food : ����","fly : ����","turn : �������ٲٴ�","floor : �ٴ�,��","ask : �����ϴ�"
,"feel : ������","wash : �Ĵ�","sweet : ������","finger : �հ���","wise : ������","place : ���","child : ���","wrong : Ʋ��","face : ��","care : ����,����","energy : ������,��"
,"bath : ���","earth : ����","art : ����","call : �θ���","worry : �����ϴ�","close : �ݴ�,�����","strong : ����","burn : �ҿ�Ÿ��","dirty : ������",
"visit : �湮�ϴ�","throw : ������","carry : ����ϴ�","quite : ������","return : �ǵ����ִ�","clean : ������","save : �����ϴ�","pay : �����ϴ�","move : �̵��ϴ�","live : ���","difficult : �����","learn : ����",
"hard : �ܴ���,�����","important : �߿���","believe : �ϴ�","interested : �����ִ�","change : �ٲٴ�","fresh : �ż���","dry : ������","balance : ����","fat : ����", "different : �ٸ�",
"arrive : �����ϴ�","find : �߰��ϴ�","bad : ����","catch : ���","wait : ��ٸ���","absent : �Ἦ��","satisfy : ������Ű��","break : ����","condition : ����,����","mix : ����,ȥ���ϴ�","alike : �����","bore : �����ϰ��ϴ�","lose : �Ҿ������",
"job : ����,��","bend : ���θ���","active : Ȱ������","cheap : ���� ��","blood : ��","dangerous : ������","hide : �����","allow : ����ϴ�","borrow : ������","expect : ����ϴ�"
,"cover : ����","bear : ����,����","gather : ������","harm : ����","equal : ����,������","border : ����","decide : �����ϴ�","continue : ����ϴ�","bite : ����","angry : ȭ�� ��",
"edge : �����ڸ�","block : ��ȹ","invite : �ʴ��ϴ�","add : ÷���ϴ�","breeze : ���ٶ�","leave : ������"};
	
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
