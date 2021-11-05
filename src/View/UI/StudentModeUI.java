package View.UI;

import Select.AllStateSession;
import View.MainIndex;
import View.Student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentModeUI extends JFrame implements ActionListener {

    JPanel northPane;
    JLabel northlb1;
    JButton logout;

    JPanel leftMenuPane;
    String [] menuTitle = {"������û", "��û������ȸ","������û���","����Ȯ��","��������/����"};
    Font font;



    public StudentModeUI() {

        init();

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

        northlb1 = new JLabel("ID:"+ AllStateSession.login_id+"�̸�:"+AllStateSession.login_name+"�л�");//������ ���� *******�α��� �� id **********); //������ ���� *******�α��� �� id **********
        northlb1.setHorizontalAlignment(JLabel.CENTER);


        northlb1.setOpaque(true);
        northlb1.setBackground(new Color(33, 140, 116));
        northlb1.setForeground(Color.white);
        northlb1.setPreferredSize(new Dimension(900, 0));

        logout = new JButton("�α׾ƿ�");


        northPane.add(BorderLayout.WEST,northlb1); //������ ����� ���� �����ִ� JLabel �߰�
        northPane.add(BorderLayout.EAST,logout); // �α׾ƿ���ư
        northPane.setPreferredSize(new Dimension(0, 35)); //����������
        logout.addActionListener(this);
        add(BorderLayout.NORTH,northPane);

    }

    public void setLeftMenu() {
        leftMenuPane = new JPanel(new GridLayout(8,0));
        leftMenuPane.setPreferredSize(new Dimension(160, 0));//�޴����г� ������,��ġ
        leftMenuPane.setBackground(new Color(213, 213, 213));
        font = new Font("����", Font.BOLD, 17);

        for(int i=0; i<menuTitle.length; i++) {
            JButton jbt= new JButton(menuTitle[i]);
            jbt.setFont(font);
            jbt.setBackground(new Color(213, 213, 213));
            jbt.addActionListener(this);
            leftMenuPane.add(jbt);
        }


        add(BorderLayout.WEST,leftMenuPane);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        Object eventButton =e.getActionCommand();
        //{"������û", "��û������ȸ","������û���","����Ȯ��","��������/����"};
        if(event==logout)
        {
            AllStateSession.login_id=null;
            AllStateSession.login_state=0;
            setVisible(false);
            new MainIndex();//�������� ���ư�
        }
        else if(eventButton=="������û")
        {
            System.out.println("������û  ����");
            new StudentModeMain();
        }
        else if(eventButton=="��û������ȸ")
        {
            new StudentModeMain2();
            System.out.println("��û������ȸ ����");

        }
        else if(eventButton=="������û���")
        {
            System.out.println("������û���  ����");
            new StudentMode_delete();
        }
        else if(eventButton=="����Ȯ��")
        {
            System.out.println("����Ȯ��");
            new StudentModeScore();

        }
        else if(eventButton=="��������/����")
        {
            System.out.println("��������/����");
            new StudentModeProfile();
        }

    }

    public static void main(String[] args) {
        new StudentModeUI();
    }

}
