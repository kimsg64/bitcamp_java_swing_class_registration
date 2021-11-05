package View;

import Dao.Login.LoginDao;
import Select.AllStateSession;
import View.Admin.AdminMainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstMai extends JFrame implements ActionListener {
    AllStateSession LoginSession = new AllStateSession();
    //J������ -> ���������� �����Ӹ�.setPreferredSize(new Dimension(int width,int height));
    Font font = new Font("����", Font.BOLD, 30);
    Font font2 = new Font("����", Font.BOLD, 25);
    Font font3 = new Font("����", Font.BOLD, 12);
    LoginDao LDao = new LoginDao();
    JPanel northPane = new JPanel(new BorderLayout());
    JLabel jbl = new JLabel("<html>��Ʈ���б�<br> BITCAMP UNIVERSITY</html>");
    JPanel EastPane = new JPanel(new BorderLayout()); //�������̾ƿ�? ��...setLayout(NULL)
    JLabel jbl2 = new JLabel("������û�ý���", JLabel.CENTER);
    JPanel inputIdPw = new JPanel(new BorderLayout()); //������û�����ξ��ǿ���
    JPanel inputIdPwL = new JPanel(new GridLayout(2, 1));
    JLabel jbl3 = new JLabel("�й�");
    JLabel jbl4 = new JLabel("��й�ȣ");
    JPanel inputIdPwR = new JPanel(new GridLayout(2, 1, 0, 20));
    JPanel tfp = new JPanel(new BorderLayout());
    JTextField tf = new JTextField(20);
    JPanel tfp2 = new JPanel(new BorderLayout());
    JPasswordField tf2 = new JPasswordField(20);
    JButton jbt = new JButton("�α���");//������û�����ξ��ǿ���
    JPanel btnPane = new JPanel(new FlowLayout());
    JButton jbt2 = new JButton("ID/PWã��");
    JButton jbt3 = new JButton("PW����");

    JPanel southPane = new JPanel();//���̾ƿ�����¡

    public FirstMai() {
        add(BorderLayout.NORTH, northPane);
        northPane.setPreferredSize(new Dimension(0, 70)); //����������

        jbl.setFont(font);
        jbl.setOpaque(true);
        jbl.setBackground(new Color(33, 140, 116)); //(22, 160, 133)
        jbl.setForeground(Color.white);
        northPane.add(jbl);

        //----------------------------------------------------------------

        //centerPane.setBorder(new EmptyBorder(20 , 20 , 20 , 20)); //���鼳�� ???
        EastPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));//����Ȼ���
        EastPane.setBackground(new Color(255, 229, 200));//255, 234, 167 //(255, 229, 200
        EastPane.setPreferredSize(new Dimension(500, 0));
        jbl2.setFont(font2);
        jbl2.setForeground(new Color(33, 140, 116));
        //jbl2.setHorizontalAlignment(JLabel.CENTER);
        EastPane.add(BorderLayout.NORTH, jbl2);
        //--------------------------------------------

        inputIdPw.setPreferredSize(new Dimension(300, 0));
        inputIdPw.setBackground(new Color(255, 229, 200));

        jbl3.setOpaque(true);
        jbl3.setFont(font3);
        jbl3.setBackground(new Color(255, 229, 200));

        jbl4.setOpaque(true);
        jbl4.setFont(font3);
        jbl4.setBackground(new Color(255, 229, 200));

        inputIdPwL.setBackground(new Color(255, 229, 200));
        inputIdPwL.add(jbl3);
        inputIdPwL.add(jbl4);
        inputIdPw.add(BorderLayout.WEST, inputIdPwL);

        tfp.setBackground(new Color(255, 229, 200));
        tfp2.setBackground(new Color(255, 229, 200));
        tfp.add(BorderLayout.CENTER, tf);
        tfp2.add(BorderLayout.CENTER, tf2); ///****�ؽ�Ʈ�ʵ� ���� ���Ʒ��� �־��ֱ�

        inputIdPwR.setBackground(new Color(255, 229, 200));
        inputIdPwR.add(tfp);
        inputIdPwR.add(tfp2);
        inputIdPw.add(BorderLayout.EAST, inputIdPwR);

        EastPane.add(BorderLayout.WEST, inputIdPw);
        add(BorderLayout.EAST, EastPane);

        jbt.setPreferredSize(new Dimension(90, 40)); //�α��ι�ư ����������
        jbt.setBackground(new Color(33, 140, 116));
        jbt.setForeground(Color.white);
        EastPane.add(BorderLayout.EAST, jbt);//�α��ι�ư�߰�

        btnPane.setPreferredSize(new Dimension(0, 50));//��ġ
        btnPane.setBackground(new Color(255, 229, 200));

        jbt2.setBackground(new Color(33, 140, 116));
        jbt2.setForeground(Color.white);
        jbt3.setBackground(new Color(33, 140, 116));
        jbt3.setForeground(Color.white);

        btnPane.add(jbt2);
        btnPane.add(jbt3);
        EastPane.add(BorderLayout.SOUTH, btnPane);

        //--------------------------------------------------------------------

        southPane.setPreferredSize(new Dimension(0, 200));
        add(BorderLayout.SOUTH, southPane);

        setSize(1000, 600);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbt.addActionListener(this);
        System.out.println(AllStateSession.login_id);
        System.out.println(AllStateSession.login_state);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();


        // ���̵� : tf  ��й�ȣ : tf2

        if (event==jbt) {
            if (tf.getText().length() == 0 || tf2.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "�ѹ��� Ȯ�����ּ���.", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                SessionCheckLogin(tf.getText(), tf2.getText());
            }
        }

    }

    public void SessionCheckLogin(String id, String pw) {
        int session =LDao.Login(id, pw);
        if(session==1)
        {
            AllStateSession.login_id=id;
            System.out.println(AllStateSession.login_id);
            System.out.printf("���� ���ϴ�");
            setVisible(false);

            new AdminMainPage();
            //���� ��ü �����
        }

        else if(session==2)
        {
            System.out.printf("���� ���ϴ�");
            setVisible(false);

            //new ProTestPage();
            //���� ��ü �����
        }
        else if(session==3)
        {
            System.out.printf("�л� ���ϴ�");
            setVisible(false);

            //new StudentTestPage();
            //�л� ��ü �����
        }
        else
        {
            JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ Ȯ�����ּ���.", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MainIndex();
    }
}

