


import Select.AllStateSession;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealMainIndex extends JFrame implements ActionListener {

//	Functions
    AllStateSession LoginSession = new AllStateSession();

// =======================================================================================================    
    
// Fucking Swing
    // Fonts
    Font font_big = new Font("�뛾�룆占썸틦占�", Font.BOLD, 30);
    Font font_middle = new Font("�뛾�룆占썸틦占�", Font.BOLD, 25);
    Font font_small = new Font("�뛾�룆占썸틦占�", Font.BOLD, 12);
    
    // Bitcamp University panel
    JPanel northPane = new JPanel(new BorderLayout());
    	JPanel smallSpace = new JPanel();
    	JLabel title_lbl = new JLabel("<html>수강신청 프로그램<br> BITCAMP UNIVERSITY</html>");
    
    // spacing for login panel
    JPanel northSpace = new JPanel();
    JPanel westSpace = new JPanel();
    JPanel eastSpace = new JPanel();
    JPanel southSpace = new JPanel();
	
	// Login panel details
    JPanel loginPane = new JPanel(new FlowLayout());
    	JPanel loginTitle_space = new JPanel();
	    JLabel loginTitle_lbl = new JLabel("로그인", JLabel.CENTER);
	    
	    JPanel SpacePaneBetweenTitleAndInput = new JPanel();
	    
	    JPanel inputPane = new JPanel(new GridLayout(3, 1));
		    JPanel input_ID_pane = new JPanel(new GridLayout(1, 2, 20, 0));
		    	JPanel paneForID = new JPanel();
			    JLabel input_ID_Lbl = new JLabel("학번", JLabel.RIGHT);
			    JTextField idField = new JTextField(20);
			JPanel paneBetweenIDAndPW = new JPanel();
		    JPanel input_PW_pane = new JPanel(new GridLayout(1, 2, 20, 0));
		    	JPanel paneForPW = new JPanel();
			    JLabel input_PW_Lbl = new JLabel("비밀번호", JLabel.RIGHT);
			    JPasswordField pwField = new JPasswordField(20);
			    
		JPanel SpacePaneBetweenLoginAndBtn = new JPanel();
	    JButton loginButton = new JButton("로그인");
	    JPanel btnPane = new JPanel(new FlowLayout());
	    JButton idBtn = new JButton("ID/PW嶺뚢돦堉먪뵳占�");
	    JButton pwBtn = new JButton("PW�솻占�?�뇦占�?");
    
	    
	    // 占썩뫀踰�??亦낉옙?�뜮占�
	    JPanel notice1st = new JPanel();
	    JPanel notice2nd = new JPanel();
	    JPanel notice3rd = new JPanel();

    // 嶺뚮∥�뾼占쎈데 ?占쎌쓡?占쎈턄嶺뚳옙?
    public RealMainIndex() {
    	// JFrame ?占쎌읉?占쎈턄?�뇡占�?占쎈쐨 ?�땻占�?占쎌젧
    	setLayout(new FlowLayout());
    	
    	// northPane ?�땻占�?占쎌젧
    	northPane.setPreferredSize(new Dimension(1008, 100));
        title_lbl.setFont(font_big);
        title_lbl.setOpaque(true);
        title_lbl.setBackground(new Color(33, 140, 116)); //(22, 160, 133)
        title_lbl.setForeground(Color.white);
        northPane.add(title_lbl);
        add(northPane);
        
        // ?疫뀐옙?�뇡占쏙옙�꽞占쎌뒩占쎈뮡 占썩뫀踰됧첎占� + �슖�돦裕꾬옙�쟽?占쎈데 ?占쎌넮?�몭占�
        northSpace.setPreferredSize(new Dimension(900, 40));
        westSpace.setPreferredSize(new Dimension(400, 60));
        loginPane.setPreferredSize(new Dimension(500, 300));
        eastSpace.setPreferredSize(new Dimension(124, 60));
        // southSpace ?�굢�꾨Ь�⑥�ロ뱺 占썩뫀踰�??亦낉옙?�뜮占� 占쎈퉲�겫占�??�뇡占썹춯占�? ?筌랃옙
        southSpace.setPreferredSize(new Dimension(1024, 200));
        add(northSpace);
        add(westSpace);
        add(loginPane);
        add(eastSpace);
        add(southSpace);
        
        // �슖�돦裕꾬옙�쟽?占쎈데 ?占쎌넮?�몭占� ?�억옙?占쏙옙?占쎈뎄
        // Title
        loginPane.setBackground(new Color(255, 229, 200));//255, 234, 167 //(255, 229, 200
        loginTitle_space.setPreferredSize(new Dimension(500, 10));
        loginTitle_space.setBackground(new Color(255, 229, 200));
        loginTitle_lbl.setFont(font_middle);
        loginTitle_lbl.setForeground(new Color(33, 140, 116));
        loginPane.add(loginTitle_space);
        loginPane.add(loginTitle_lbl);
        
        // ???占쎈턄??占쏙옙? Input ?占쎌넮?�몭占� ?亦낉옙?占쎈턄
        SpacePaneBetweenTitleAndInput.setBackground(new Color(255, 229, 200));
        SpacePaneBetweenTitleAndInput.setPreferredSize(new Dimension(500, 40));
        loginPane.add(SpacePaneBetweenTitleAndInput);
        
        // ?占쎈뎄�뵓占�?
        input_ID_Lbl.setOpaque(true);
        input_ID_Lbl.setFont(font_small);
        input_ID_Lbl.setBackground(new Color(255, 229, 200));
        input_PW_Lbl.setOpaque(true);
        input_PW_Lbl.setFont(font_small);
        input_PW_Lbl.setBackground(new Color(255, 229, 200));

        // 嶺뚮씭�뒧獄�占� ?占쎌넮?�몭占� ?占쎈폋�뼨占�?
        input_ID_pane.add(input_ID_Lbl);
        input_PW_pane.add(input_PW_Lbl);
        
        // ?占쎌넮?�몭占� ?�땻占�?占쎌깚
        input_ID_pane.setPreferredSize(new Dimension(200, 100));
        input_ID_pane.setBackground(new Color(255, 229, 200));
        input_ID_pane.add(input_ID_Lbl);
        input_ID_pane.add(idField);
        input_PW_pane.setPreferredSize(new Dimension(200, 100));
        input_PW_pane.setBackground(new Color(255, 229, 200));
        input_PW_pane.add(input_PW_Lbl);
        input_PW_pane.add(pwField);
        
        // input ?占쎌넮?�몭占� (ID ?占쎈엷?占쎌졑嶺뚳옙? & PW ?占쎈엷?占쎌졑嶺뚳옙?)
        inputPane.setPreferredSize(new Dimension(270, 120));
        inputPane.setBackground(Color.black);
        inputPane.add(input_ID_pane);
        paneBetweenIDAndPW.setPreferredSize(new Dimension(300, 80));
        paneBetweenIDAndPW.setBackground(new Color(255, 229, 200));
        inputPane.add(paneBetweenIDAndPW);
        inputPane.add(input_PW_pane);
        loginPane.add(inputPane);
        
        // 濾곌쑨�∽옙遊�?筌뤴궗臾�?
        SpacePaneBetweenLoginAndBtn.setPreferredSize(new Dimension(50, 30));
        SpacePaneBetweenLoginAndBtn.setBackground(new Color(255, 229, 200));
        loginPane.add(SpacePaneBetweenLoginAndBtn);
        
        // Button
        loginButton.setPreferredSize(new Dimension(90, 120)); //�슖�돦裕꾬옙�쟽?占쎈데�뵓怨뚯뫓占쎈괏 ?亦낉옙?占쎈턄嶺뚯빖�쐠占쏙옙?占쎌읉
        loginButton.setBackground(new Color(33, 140, 116));
        loginButton.setForeground(Color.white);
        loginPane.add(loginButton);//�슖�돦裕꾬옙�쟽?占쎈데�뵓怨뚯뫓占쎈괏占쎈퉲�겫占�?

        btnPane.setPreferredSize(new Dimension(0, 50));//?占쎈쭊�뇖占�?
        btnPane.setBackground(new Color(255, 229, 200));

        idBtn.setBackground(new Color(33, 140, 116));
        idBtn.setForeground(Color.white);
        pwBtn.setBackground(new Color(33, 140, 116));
        pwBtn.setForeground(Color.white);

        btnPane.add(idBtn);
        btnPane.add(pwBtn);
        loginPane.add(btnPane);

        
        // 占썩뫀踰�??亦낉옙?�뜮占� ?占쎌넮?�몭占�
        notice1st.setPreferredSize(new Dimension(300, 100));
        notice2nd.setPreferredSize(new Dimension(300, 100));
        notice3rd.setPreferredSize(new Dimension(300, 100));
        notice1st.setBackground(Color.black);
        notice2nd.setBackground(Color.pink);
        notice3rd.setBackground(Color.yellow);
        southSpace.add(notice1st);
        southSpace.add(notice2nd);
        southSpace.add(notice3rd);
        
        //--------------------------------------------------------------------


        setSize(1024, 768);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loginButton.addActionListener(this);
        System.out.println(AllStateSession.login_id);
        System.out.println(AllStateSession.login_state);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
//        if (event==loginButton) {
//            if (idField.getText().length() == 0 || pwField.getText().length() == 0) {
//                JOptionPane.showMessageDialog(null, "?�뇡�뀡由곤옙�쐞占쎌맠 ?占쎈꼪?占쎈데?�뜮癒㏉떊占쎈닔�땻占�?占쎈뭵.", "Message", JOptionPane.ERROR_MESSAGE);
//            } else {
//                SessionCheckLogin(idField.getText(), pwField.getText());
//            }
//        }
    }

//    public void SessionCheckLogin(String id, String pw) {
//            int session =LDao.Login(id, pw);
//            if(session==1)
//            {
//                AllStateSession.login_id=id;
//                System.out.println(AllStateSession.login_id);
//                System.out.printf("?�젆占�?獄��쓧泥�? ?獄�占�?�젆湲룹쾸�눧癒�鍮�?占쎈펲");
//                setVisible(false);
//
//                new AdminTestPage();
//                //?�젆占�?獄��쓧泥�? �뤆�룇鍮섊뙼占� ?甕곕㉡彛뽳옙占쏙쭕占�
//            }
//
//            else if(session==2)
//            {
//                System.out.printf("占쎈쨨�솒占쏙옙�빢 ?獄�占�?�젆湲룹쾸�눧癒�鍮�?占쎈펲");
//                setVisible(false);
//
//                new ProTestPage();
//                //占쎈쨨�솒占쏙옙�빢 �뤆�룇鍮섊뙼占� ?甕곕㉡彛뽳옙占쏙쭕占�
//            }
//            else if(session==3)
//            {
//                System.out.printf("?�뇡占�?繹먲옙 ?獄�占�?�젆湲룹쾸�눧癒�鍮�?占쎈펲");
//                setVisible(false);
//
//                new StudentTestPage();
//                //?�뇡占�?繹먲옙 �뤆�룇鍮섊뙼占� ?甕곕㉡彛뽳옙占쏙쭕占�
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "?�뇡占�?占쎈턄?�억옙 占쎈쑏熬곻옙?�뵓怨뺣쐡占쎄퉰 ?占쎈꼪?占쎈데?�뜮癒㏉떊占쎈닔�땻占�?占쎈뭵.", "Message", JOptionPane.ERROR_MESSAGE);
//            }
//    }

    public static void main(String[] args) {
        new RealMainIndex();
    }
}


