package View.Notice;

import DataBase.DBConnection;
import Vo.Notice.NoticeVO;

import java.util.ArrayList;
import java.util.List;

public class NoticeDAO extends DBConnection {

    public NoticeDAO() {

    }

    // ��ü ������ ����

    public List<NoticeVO> setAllNotices() {
        List<NoticeVO> notices = new ArrayList<NoticeVO>();
        try {
            dbConn();
            String sql = "select notice_code, notice_title, notice_con, to_char(notice_date, 'YYYY-MM-DD'), to_char(notice_update, 'YYYY-MM-DD') from notice order by notice_code desc";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                NoticeVO vo = new NoticeVO();
                vo.setCode(rs.getInt(1));
                vo.setTitle(rs.getString(2));
                vo.setContent(rs.getString(3));
                vo.setDate(rs.getString(4));
                vo.setUpdate(rs.getString(5));
                notices.add(vo);
            }

        } catch(Exception e) {
            System.out.println("��ü ���� ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return notices;
    }

    // ���ڵ� �߰�
    public int addRecord(String title, String content) {
        int cnt = 0;
        try {
            dbConn();
            String sql = "insert into notice values(no_code.nextval, ?, ?, sysdate, sysdate)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            cnt = pstmt.executeUpdate();
        } catch(Exception e) {
            System.out.println("�߰� ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    // ���ڵ� ����(�� â ��� ������ �ۼ��� ���� �����ֱ�)
    public void showOldRecord(NoticeVO willBeUpdated) {
        int willBeShown = willBeUpdated.getCode();
        try {
            dbConn();
            String sql = "select notice_code, notice_title, notice_con, to_char(notice_date, 'YYYY-MM-DD'), to_char(notice_update, 'YYYY-MM-DD') from notice where notice_code=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, willBeShown);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                NoticeVO vo = new NoticeVO();
                vo.setCode(rs.getInt(1));
                vo.setTitle(rs.getString(2));
                vo.setContent(rs.getString(3));
                vo.setDate(rs.getString(4));
                vo.setUpdate(rs.getString(5));
                NoticeDetail oldNotice = new NoticeDetail(vo);
                oldNotice.setFrame();
                oldNotice.updateContent();
            }
        } catch(Exception e) {
            System.out.println("��ȸ ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
    }

    // �Ϸ� ��ư Ŭ���� > DB�� ������Ʈ
    public int updateComplete(String title, String content, int code) {
        int cnt = 0;
        try {
            dbConn();
            String sql = "update notice set notice_title=?, notice_con=? where notice_code=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, code);
            cnt = pstmt.executeUpdate();
        } catch(Exception e) {
            System.out.println("���� ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    // ����
    public int removeRecord(NoticeVO willBeRemoved) {
        int cnt = 0;
        try {
            dbConn();
            String sql = "delete from notice where notice_code=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, willBeRemoved.getCode());
            cnt = pstmt.executeUpdate();
        } catch(Exception e) {
            System.out.println("���� ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    // �˻�
    public List<NoticeVO> searchRecords(String keyword) {
        List<NoticeVO> notices = new ArrayList<NoticeVO>();
        try {
            dbConn();
            String sql = "select notice_code, notice_title, notice_con, to_char(notice_date, 'YYYY-MM-DD'), to_char(notice_update, 'YYYY-MM-DD') from notice where notice_title like '%" + keyword + "%' order by notice_code desc";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                NoticeVO vo = new NoticeVO();
                vo.setCode(rs.getInt(1));
                vo.setTitle(rs.getString(2));
                vo.setContent(rs.getString(3));
                vo.setDate(rs.getString(4));
                vo.setUpdate(rs.getString(5));
                notices.add(vo);
                System.out.println("DAO���� ���� ����: " + vo.getTitle());
            }

        } catch(Exception e) {
            System.out.println("��ü ���� ����");
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return notices;
    }
}
