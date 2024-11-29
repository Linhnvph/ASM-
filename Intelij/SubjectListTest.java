package com.example.lap3_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectListTest {
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
    void testDisplaySubjects() {
        // Kiểm tra danh sách hiển thị ban đầu
        assertEquals(8, subjects.size());
        assertEquals("Toán học", subjects.get(0));
        assertEquals("Tin học", subjects.get(7));
    }

    @Test
    void testAddSubject() {
        // Thêm môn học mới
        subjects.add("Âm nhạc");
        assertEquals(9, subjects.size());
        assertTrue(subjects.contains("Âm nhạc"));
    }

    @Test
    void testAddDuplicateSubject() {
        // Thử thêm môn học trùng
        String newSubject = "Toán học";
        if (!subjects.contains(newSubject)) {
            subjects.add(newSubject);
        }
        assertEquals(8, subjects.size()); // Không thêm trùng lặp
    }

    @Test
    void testEditSubject() {
        // Sửa tên môn học
        int indexToEdit = 2; // Lịch sử
        subjects.set(indexToEdit, "Sử học");
        assertEquals("Sử học", subjects.get(indexToEdit));
    }

    @Test
    void testEditSubjectWithInvalidIndex() {
        // Sửa với chỉ số không hợp lệ
        int invalidIndex = 100;
        try {
            subjects.set(invalidIndex, "Sử học");
            fail("Không nên cho phép sửa với chỉ số không hợp lệ");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true); // Ngoại lệ mong đợi
        }
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
    void testSearchSubjectFound() {
        // Tìm kiếm môn học có từ khóa "học"
        String keyword = "học";
        List<String> results = new ArrayList<>();
        for (String subject : subjects) {
            if (subject.toLowerCase().contains(keyword.toLowerCase())) {
                results.add(subject);
            }
        }
        assertEquals(8, results.size()); // Tất cả môn học chứa từ "học"
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
}
