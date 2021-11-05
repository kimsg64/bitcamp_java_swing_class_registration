package View.Student;

import Dao.Student.StudentModeDAO;
import View.UI.StudentModeUI;
import Vo.Student.StudentModeVO2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class StudentModeMain2 extends StudentModeUI implements ActionListener {

    JPanel centerPane = new JPanel(new BorderLayout()); //StudentModeUI_2 �� ���Ϳ����� ���� ū��

    JPanel centerPane_northP;
    JLabel lb1 ;// ������û��� ��
    JPanel centerPane_centerP;
    JPanel centerP_NP;
    JComboBox jcb;
    JTextField tf;
    JButton jbt;
    JButton jbt2;
    JPanel centerP_CP;
    String title;
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    JPanel centerPane_southP;


    public StudentModeMain2() {
        init();
        add(centerPane);

        showClass();
        classAllList2();
    }

    public void showClass() {

        centerPane_northP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPane_northP.setPreferredSize(new Dimension(0,35));
        //centerPane_northP.setBorder(new LineBorder(Color.gray,1));
        lb1 = new JLabel("���Ǽ�����û���");
        lb1.setPreferredSize(new Dimension(130,40));

        centerPane_northP.add(lb1);

        centerPane_centerP = new JPanel(new BorderLayout());
        centerP_NP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String comboList[] = {"���ǹ�ȣ","�̼�����","���Ǹ�","������"};
        jcb = new JComboBox(comboList);
        tf = new JTextField(15);
        jbt= new JButton("�˻�");;
        jbt2 = new JButton("��ϻ��ΰ�ħ");
        centerP_NP.add(jcb);    centerP_NP.add(tf); centerP_NP.add(jbt); centerP_NP.add(jbt2);
        centerPane_centerP.add(BorderLayout.NORTH,centerP_NP);
        centerP_CP = new JPanel(new BorderLayout());
        title= "���ǹ�ȣ/�����̸�/�̼�����/���Ǹ�/����/���ǽð�/���ǽ�/�����ο�/��û�ο�/���ǵ����"; ;
        model= new  DefaultTableModel(title.split("/"),0);;
        table = new JTable(model);
        sp = new JScrollPane(table);
        centerP_CP.add(sp);
        centerPane_centerP.add(BorderLayout.CENTER,sp);


        centerPane_southP = new JPanel();
        centerPane_southP.setPreferredSize(new Dimension(0,40));

        centerPane.add(BorderLayout.NORTH,centerPane_northP);
        centerPane.add(BorderLayout.CENTER,centerPane_centerP);
        centerPane.add(BorderLayout.SOUTH,centerPane_southP);

        jbt.addActionListener(this);
        jbt2.addActionListener(this);

    }


    public void classAllList2() {

        System.out.println("�ø���Ʈ����");
        StudentModeDAO dao = new StudentModeDAO(); //�����ڸ���� ��������DAOŬ����
        List<StudentModeVO2> list = dao.selectClassRecord(); //��ü�л����������
        setClassModel2(list);//�ҷ��°� ����

    }
    //�������̺� ��϶���ֱ�
    public void setClassModel2(List<StudentModeVO2> list) { //����Ʈ���ް�
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++) {

            StudentModeVO2 vo = list.get(i); //ȸ���Ѹ��� ���� ->�迭�� ���� model�� �߰���ų����
            Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
                    vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};

            model.addRow(obj); //�迭�߰�
        }
    }


    public void actionPerformed(ActionEvent ae) {
        Object eventBtn = ae.getSource();

        if(eventBtn==jbt) { //�˻�
            classSearch();

        }else if(eventBtn==jbt2) { //��ϻ��ΰ�ħ
            classAllList2(); //��ư�������ϻ��ζ�
        }

    }

    //���������˻�
    public void classSearch() {
        String search =tf.getText(); //�˻��Ҵܾ�

        System.out.println(search);
        if(search!=null && !search.equals(" ")) { // �˻�� �ִ�
            String searchField =String.valueOf(jcb.getSelectedItem()); // �˻��� : �л���ȣ", "�л��̸�", "�а�����"
            //�ʵ������ �����ͷ� ������
            String fieldName=" "; //��ʵ忡�� �˻����� �ܾ ������

            if(searchField.equals("���ǹ�ȣ")) {
                fieldName="c.class_code";
            }else if(searchField.equals("�̼�����")) {
                fieldName="c.class_div";

            }else if(searchField.equals("���Ǹ�")) {
                fieldName="c.class_name";
            }else if(searchField.equals("������")) {
                fieldName="p.prof_name";
            }
            StudentModeDAO dao = new StudentModeDAO();
            List<StudentModeVO2>list = dao.searchClassRecord2(search,fieldName);
            setClassModel2(list);
            tf.setText("");
        }
    }



    public static void main(String[] args) {
        new StudentModeMain2();

    }

}
