package View.Admin.ProFessor;

import Dao.Professor.ProfessorDAO;
import View.UI.AdminUI;
import Vo.Professor.ProfessorVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorMain_insert extends AdminUI implements ActionListener {

    JPanel pane = new JPanel(new BorderLayout());
    JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel titlelb1;

    JPanel formCenter = new JPanel(new BorderLayout());
    JPanel formcenterwestPane = new JPanel(new GridLayout(9,1)); //�󺧺����г�
    JPanel formcentercenterPane = new JPanel(new GridLayout(9,1));; //�ؽ�Ʈ�ʵ�
    JTextField[] formTf = {new JTextField(5), new JTextField(5),new JTextField(10),
            new JTextField(10),new JTextField(10),new JTextField(10),
            new JTextField(10),new JTextField(10),new JTextField(10)};

    String formLbl[] = {" ������ȣ "," �����ڵ� "," ��й�ȣ "," ������ "," �̸��� "," �ڵ��� "," ������ "," �Ի��� "," ���� "};

    JPanel southPane = new JPanel();
    JPanel spacePane = new JPanel();
    JButton insertBtn = new JButton("�߰�");
    DefaultTableModel model;

    Font font = new Font("����", Font.BOLD, 25);

    public ProfessorMain_insert() {
        init();
        add(pane);//��ü�гμ���
        setForm();

        insertBtn.addActionListener(this);
    }

    public void setForm() {

        titlelb1= new JLabel("���������Է�"); //��Ʈ����
        titlelb1.setFont(font);
        northPane.add(titlelb1);
        //northPane.setPreferredSize(new Dimension(0,140));

        pane.add(BorderLayout.NORTH,northPane);

        //=====================================================================

        formCenter.add(BorderLayout.WEST,formcenterwestPane);
        for(int i=0; i<formLbl.length; i++) {
            JLabel lb1 = new JLabel(formLbl[i]);
            formcenterwestPane.add(lb1);
        }

        formCenter.add(BorderLayout.CENTER,formcentercenterPane);
        for(int i=0; i<formTf.length; i++) {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12)); //��������
            p.add(formTf[i]);
            formcentercenterPane.add(p);
            if(i==0 || i==2 || i==7) formTf[i].setEditable(false);
        }

        pane.add(formCenter);


        spacePane.setPreferredSize(new Dimension(600, 200));
        southPane.add(spacePane);
        southPane.add(insertBtn);
        pane.add(BorderLayout.SOUTH, southPane);

//      southPane.setBorder(new LineBorder(Color.GRAY,1,true));
        insertBtn.setBackground(new Color(33, 140, 116));
        insertBtn.setForeground(Color.white);
        insertBtn.setFont(font);
        insertBtn.setPreferredSize(new Dimension(100, 30)); //��ư�������


    }

    public void actionPerformed(ActionEvent ae) {
        String eventBtn = ae.getActionCommand();
        if(eventBtn.equals("�߰�")) {
            ProfessorrInsert();
        }
    }
    public void ProfessorrInsert() {

        ProfessorVO vo = new ProfessorVO();

        vo.setMajor_code(Integer.parseInt(formTf[1].getText()));
        vo.setProf_pw(formTf[2].getText());
        vo.setProf_name(formTf[3].getText());
        vo.setProf_email(formTf[4].getText());
        vo.setProf_tel(formTf[5].getText());
        vo.setProf_room(formTf[6].getText());
        vo.setProf_birth(formTf[8].getText());

        ProfessorDAO dao = new ProfessorDAO();
        int cnt = dao.insertRecord(vo);
        if(cnt>0) {
            // new ProfessorMain().professorAllList();
            JOptionPane.showMessageDialog(this, "�������� �߰��Ǿ����ϴ�.");
        }else {
            JOptionPane.showMessageDialog(this, "�����߰� �����Ͽ����ϴ�.");
        }
    }

    public static void main(String[] args) {
        new ProfessorMain_insert();
    }
}