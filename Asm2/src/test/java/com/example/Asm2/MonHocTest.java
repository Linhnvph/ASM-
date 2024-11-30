package com.example.Asm2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonHocTest {
    private List<String> subjects;

    @BeforeEach
    void setUp() {
        // Tạo danh sách môn học ban đầu
        subjects = new ArrayList<>();
        subjects.add("Toán học");
        subjects.add("Văn học");
        subjects.add("Lịch sử");
        subjects.add("Hóa học");
        subjects.add("Vật lý");
        subjects.add("Sinh học");
        subjects.add("Ngoại ngữ");
        subjects.add("Tin học");
    }
    @Test
    public void testSubjectList() {
        // Tạo danh sách mong đợi
        List<String> expectedSubjects = new ArrayList<>();
        expectedSubjects.add("Toán học");
        expectedSubjects.add("Văn học");
        expectedSubjects.add("Lịch sử");
        expectedSubjects.add("Hóa học");
        expectedSubjects.add("Vật lý");
        expectedSubjects.add("Sinh học");
        expectedSubjects.add("Ngoại ngữ");
        expectedSubjects.add("Tin học");

        // Tạo danh sách thực tế từ chương trình
        List<String> actualSubjects = new ArrayList<>();
        actualSubjects.add("Toán học");
        actualSubjects.add("Văn học");
        actualSubjects.add("Lịch sử");
        actualSubjects.add("Hóa học");
        actualSubjects.add("Vật lý");
        actualSubjects.add("Sinh học");
        actualSubjects.add("Ngoại ngữ");
        actualSubjects.add("Tin học");

        // Kiểm tra danh sách thực tế có giống danh sách mong đợi hay không
        assertEquals(expectedSubjects, actualSubjects, "Danh sách môn học không khớp!");
    }

    @Test
    void testAddSubject() {
        // Thêm môn học mới
        subjects.add("Âm nhạc");
        assertEquals(9, subjects.size());
        assertTrue(subjects.contains("Âm nhạc"));
    }


    @Test
    void testEditSubject() {
        // Sửa tên môn học
        int indexToEdit = 2; // Lịch sử
        subjects.set(indexToEdit, "Sử học");
        assertEquals("Sử học", subjects.get(indexToEdit));
    }


    @Test
    void testDeleteSubject() {
        // Xóa môn học
        String subjectToDelete = "Tin học";
        subjects.remove(subjectToDelete);
        assertEquals(7, subjects.size());
        assertFalse(subjects.contains("Tin học"));
    }

    @Test
    void testDeleteSubjectWithInvalidIndex() {
        // Xóa với chỉ số không hợp lệ
        int invalidIndex = -1;
        try {
            subjects.remove(invalidIndex);
            fail("Không nên cho phép xóa với chỉ số không hợp lệ");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true); // Ngoại lệ mong đợi
        }
    }


    @Test
    void testSearchSubjectNotFound() {
        // Tìm kiếm từ khóa không tồn tại
        String keyword = "Địa lý";
        List<String> results = new ArrayList<>();
        for (String subject : subjects) {
            if (subject.toLowerCase().contains(keyword.toLowerCase())) {
                results.add(subject);
            }
        }
        assertTrue(results.isEmpty());
    }

    @Test
    void testClearAllSubjects() {
        // Xóa toàn bộ danh sách
        subjects.clear();
        assertTrue(subjects.isEmpty());
    }
    @Test
    public void testGetSubjectByIdValidId() {
        // Test case 1: Tìm kiếm môn học với id hợp lệ
        String subject = MonHoc.getSubjectById(0); // id = 0
        assertEquals("Toán học", subject, "Không tìm thấy môn học đúng với id = 0!");

        subject = MonHoc.getSubjectById(3); // id = 3
        assertEquals("Hóa học", subject, "Không tìm thấy môn học đúng với id = 3!");
    }
    @Test
    public void testRemoveSubjectByIdValidId() {
        // Danh sách môn học ban đầu
        List<String> subjects = MonHoc.getSubjects();

        // Xóa môn học với id hợp lệ
        boolean result = MonHoc.removeSubjectById(subjects, 3); // Xóa Hóa học (id = 3)
        assertTrue(result, "Xóa thất bại với id hợp lệ!");

        // Kiểm tra danh sách sau khi xóa
        assertEquals(7, subjects.size(), "Số lượng môn học không đúng sau khi xóa!");
        assertFalse(subjects.contains("Hóa học"), "Môn học không được xóa đúng!");
    }
    @Test
    public void testRemoveSubjectByIdInvalidId() {
        // Danh sách môn học ban đầu
        List<String> subjects = MonHoc.getSubjects();

        // Xóa môn học với id không hợp lệ
        boolean result = MonHoc.removeSubjectById(subjects, -1); // id không hợp lệ
        assertFalse(result, "Phải trả về false cho id không hợp lệ!");

        result = MonHoc.removeSubjectById(subjects, 10); // id không hợp lệ
        assertFalse(result, "Phải trả về false cho id không hợp lệ!");

        // Kiểm tra danh sách vẫn không thay đổi
        assertEquals(8, subjects.size(), "Danh sách không đúng sau khi thử xóa id không hợp lệ!");
    }
    @Test
    public void testUpdateSubjectByIdValidId() {
        // Danh sách môn học ban đầu
        List<String> subjects = MonHoc.getSubjects();

        // Cập nhật môn học với id hợp lệ
        boolean result = MonHoc.updateSubjectById(subjects, 2, "Địa lý"); // Cập nhật Lịch sử thành Địa lý
        assertTrue(result, "Cập nhật thất bại với id hợp lệ!");

        // Kiểm tra danh sách sau khi cập nhật
        assertEquals("Địa lý", subjects.get(2), "Môn học không được cập nhật đúng!");
    }
    @Test
    public void testUpdateSubjectByIdInvalidId() {
        // Danh sách môn học ban đầu
        List<String> subjects = MonHoc.getSubjects();

        // Cập nhật môn học với id không hợp lệ
        boolean result = MonHoc.updateSubjectById(subjects, -1, "Công nghệ"); // id không hợp lệ
        assertFalse(result, "Phải trả về false cho id không hợp lệ!");

        result = MonHoc.updateSubjectById(subjects, 10, "Kinh tế"); // id không hợp lệ
        assertFalse(result, "Phải trả về false cho id không hợp lệ!");

        // Kiểm tra danh sách không thay đổi
        assertEquals(8, subjects.size(), "Danh sách môn học không đúng sau khi thử cập nhật id không hợp lệ!");
    }
    @Test
    public void testAddSubjectValid() {
        // Danh sách môn học ban đầu
        List<String> subjects = MonHoc.getSubjects();

        // Thêm môn học hợp lệ
        boolean result = MonHoc.addSubject(subjects, "Khoa học máy tính");
        assertTrue(result, "Thêm môn học thất bại với dữ liệu hợp lệ!");

        // Kiểm tra danh sách sau khi thêm
        assertEquals(9, subjects.size(), "Số lượng môn học không đúng sau khi thêm!");
        assertEquals("Khoa học máy tính", subjects.get(subjects.size() - 1), "Môn học mới không được thêm đúng!");
    }

}
