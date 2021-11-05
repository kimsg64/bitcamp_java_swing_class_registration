package View.Admin;

import Select.AllStateSession;
import View.Admin.ProFessor.ClassMain;
import View.Admin.ProFessor.ProfessorMain;
import View.Admin.ProFessor.ProfessorMain_insert;
import View.Admin.Student.StudentMain;
import View.Admin.Student.StudentMain2;
import View.MainIndex;
import View.Notice.NoticeDetail;
import View.Notice.NoticeMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage extends JFrame implements ActionListener {
	String id = AllStateSession.login_id;
	JPanel northPane;
	JLabel northlb1; 
	JButton logout;

	JPanel leftMenuPane;
	String menuTitle[] = {"�������׸��","���������ۼ�", "������������","������������","�����߰�","�л���������","�л���������"};
	JButton jbt[];
	Font font;	
	
	JPanel centerP;
	JPanel centerP_northP;
			JPanel northP_north;
			JPanel northP_center;
			
			
	ImageIcon icon;
	Image imageIcon;
	Image changeimg;
	ImageIcon changeIcon;
	JLabel lb1;

		
	public AdminMainPage() {
		init();
		addComponent();//***
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void init() {
		setNorthPane(); //nothpanel ����
		setLeftMenu(); //�޴���
		
	}

	public void setNorthPane() {		
		
		northPane = new JPanel(new BorderLayout());	
		northPane.setBackground(new Color(33, 140, 116));
		
		northlb1 = new JLabel("ID:"+AllStateSession.login_id+"�̸�:"+AllStateSession.login_name);//������ ���� *******�α��� �� id **********); //������ ���� *******�α��� �� id **********
		northlb1.setHorizontalAlignment(JLabel.CENTER);
		
	
		northlb1.setOpaque(true);
		northlb1.setBackground(new Color(33, 140, 116)); 
		northlb1.setForeground(Color.white);
		northlb1.setPreferredSize(new Dimension(900, 0)); 
		
		logout = new JButton("�α׾ƿ�");
		
		
		northPane.add(BorderLayout.WEST,northlb1); //������ ����� ���� �����ִ� JLabel �߰�
		northPane.add(BorderLayout.EAST,logout); // �α׾ƿ���ư
		northPane.setPreferredSize(new Dimension(0, 35)); //����������
		add(BorderLayout.NORTH,northPane);
		logout.addActionListener(this);
	}
	
	public void setLeftMenu() {
		leftMenuPane = new JPanel(new GridLayout(8,0));
		leftMenuPane.setPreferredSize(new Dimension(160, 0));//�޴����г� ������,��ġ
		leftMenuPane.setBackground(new Color(213, 213, 213));
		font = new Font("����", Font.BOLD, 20);

		for(int i=0; i<menuTitle.length; i++) {
			JButton jbt= new JButton(menuTitle[i]);
			jbt.setFont(font);
			jbt.setBackground(new Color(213, 213, 213));
			leftMenuPane.add(jbt);
			jbt.addActionListener(this);
		}
		add(BorderLayout.WEST,leftMenuPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		Object eventButton =e.getActionCommand();
		if(event==logout)
		{
			AllStateSession.login_id=null;
			AllStateSession.login_state=0;
			setVisible(false);
			new MainIndex();//�������� ���ư�
		}
		else if(eventButton.equals("�������׸��"))
		{
			new NoticeMain();
			//setVisible(false);
			System.out.println("�������� ������");
		}
		else if(eventButton.equals("���������ۼ�"))
		{
			new NoticeDetail();
			System.out.println("���������ۼ�");
		}
		else if(eventButton.equals("������������"))
		{
			new ClassMain();
			System.out.println("������������");
		}
		else if(eventButton.equals("������������"))
		{
			System.out.println("��������������");
			new ProfessorMain();
		}
		else if(eventButton.equals("�����߰�"))
		{
			System.out.println("�����߰�");
			new ProfessorMain_insert();
		}
		else if(eventButton.equals("�л���������"))
		{
			new StudentMain();
			System.out.println("�л���������");
		}
		else if(eventButton.equals("�л���������"))
		{
			new StudentMain2();
			System.out.println("�л���������");
		}
	}


	//------------------------------------------------------------------
	
	public void addComponent() {
		
		centerP = new JPanel(new BorderLayout());
		//add(BorderLayout.CENTER,centerP);
			centerP_northP = new JPanel(new BorderLayout());
				northP_north = new JPanel();//����..����
				northP_north.setPreferredSize(new Dimension(0,50));
				//northP_north.setBackground(Color.white);
				northP_center = new JPanel();//����
					icon= new ImageIcon("src/img/campusimg.jpg");
					imageIcon = icon.getImage();
					changeimg = imageIcon.getScaledInstance(890,200,java.awt.Image.SCALE_SMOOTH);
					changeIcon = new ImageIcon(changeimg);
					lb1 = new JLabel(changeIcon);
				
				northP_center.add(lb1);
				
			centerP.add(BorderLayout.NORTH,northP_north);
			centerP.add(BorderLayout.CENTER,northP_center);
			add(BorderLayout.CENTER,centerP);
	}

	public static void main(String[] args) {
		new AdminMainPage();
	}


}
