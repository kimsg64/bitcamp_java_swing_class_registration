package View.Professor;

import Dao.Professor.ProfessorModeDAO;
import View.UI.ProfessorModeUI;
import Vo.Student.StudentVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProfessorModeMain2 extends ProfessorModeUI implements ActionListener {
    JPanel pane = new JPanel(new BorderLayout());
    JLabel titlelb1;
    JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel searchLbl = new JLabel("교수명");
    DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
    JComboBox<String> searchkey = new JComboBox<String>(searchModel);
    JTextField searchWord = new JTextField(20);
    JButton searchBtn = new JButton("검색");
    JButton newBtn = new JButton("새로고침");
    JPanel centerPane = new JPanel(new BorderLayout());
    DefaultTableModel model;
    JTable professorList;
    JScrollPane sp;
    JPanel southPane = new JPanel(new BorderLayout());
    JPanel updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel updateCenter = new JPanel(new BorderLayout());
    JPanel updateSouth = new JPanel();

    DefaultTableModel model2;
    JTable professorList2;
    JScrollPane sp2;
    int row;
    public ProfessorModeMain2() {
        init();
        add(pane);
        pane.add(BorderLayout.NORTH,northPane);
        pane.add(BorderLayout.CENTER,centerPane);
        pane.add(BorderLayout.SOUTH,southPane);

        showProfessorALL();

    }

    public void showProfessorALL() {

        //north
        titlelb1= new JLabel("강의목록"); //폰트설정
        //titlelb1.setFont(font);
        northPane.add(titlelb1);
        setSearchForm();

        //center
        String title = "수업이름/학생번호/학생학년/학생이름/학생전공/학생연락처";
        model = new DefaultTableModel(title.split("/"),0);
        professorList = new JTable(model);
        sp = new JScrollPane(professorList);
        professor_StudentAllList();
        centerPane.add(sp);

    }
    //교수검색 폼
    public void setSearchForm() {
        searchModel.addElement("수업이름");
        searchModel.addElement("학생번호");
        searchModel.addElement("학생이름");
        northPane.add(searchkey);
        northPane.add(searchWord);
        northPane.add(searchBtn);
        northPane.add(newBtn);
        searchBtn.addActionListener(this);
        newBtn.addActionListener(this);
    }
    public void professor_StudentAllList() {
        ProfessorModeDAO dao = new ProfessorModeDAO();
        java.util.List<StudentVO> list = dao.allRecord();
        setProfessor_studentlistModel(list);
    }
    public void setProfessor_studentlistModel(java.util.List<StudentVO> list) {
        //기존 JTable의 목록을 지우고 새로 리스트를 출력한다.
        model.setRowCount(0);
        //컬렉션에 있는 vo를 get하여 JTable에 목록으로 추가한다.
        for(int i=0;i<list.size();i++) {
            StudentVO vo = list.get(i);
            Object[] obj = {vo.getClass_name(),vo.getStu_Code(),vo.getStu_grade(),vo.getStu_name(),
                    vo.getMajor_name(),vo.getStu_tel(),};
            model.addRow(obj);

        }
    }

    //교수가 내강의듣는 학생 검색
    public void Professor_StudentSearch() {
        //검색어가 입력되어있는지 확인.
        String search = searchWord.getText();
        if(search!=null && !search.equals("")) {//검색어가 있다.
            String searchField = (String)searchkey.getSelectedItem();//검색키 이름 전화번호 주소
            String fieldName = "";
            if(searchField.equals("수업이름")) {
                fieldName = "c.Class_name";
            }else if(searchField.equals("학생번호")) {
                fieldName = "st.Stu_Code";
            }else if(searchField.equals("학생이름")) {
                fieldName = "st.Stu_name";
            }

            ProfessorModeDAO dao = new ProfessorModeDAO();
            List<StudentVO> list = dao.searchRecord(search,fieldName);
            setProfessor_studentlistModel(list);
            searchWord.setText("");
        }
    }


    public void actionPerformed(ActionEvent ae) {
        String eventBtn = ae.getActionCommand();
        if(eventBtn.equals("검색")) {
            Professor_StudentSearch();
        }else if(eventBtn.equals("새로고침")) {
            professor_StudentAllList();
        }
    }


    public static void main(String[] args) {
        new ProfessorModeMain2();
    }
}

