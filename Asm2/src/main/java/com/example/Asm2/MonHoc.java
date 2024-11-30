package com.example.Asm2;

import java.util.ArrayList;
import java.util.List;

public class MonHoc {
    public static List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Toán học"); // id = 0
        subjects.add("Văn học"); // id = 1
        subjects.add("Lịch sử"); // id = 2
        subjects.add("Hóa học"); // id = 3
        subjects.add("Vật lý"); // id = 4
        subjects.add("Sinh học"); // id = 5
        subjects.add("Ngoại ngữ"); // id = 6
        subjects.add("Tin học"); // id = 7
        return subjects;
    }

    public static String getSubjectById(int id) {
        List<String> subjects = getSubjects();
        if (id >= 0 && id < subjects.size()) {
            return subjects.get(id);
        }
        return null; // Trả về null nếu id không hợp lệ
    }
    public static boolean removeSubjectById(List<String> subjects, int id) {
        if (id >= 0 && id < subjects.size()) {
            subjects.remove(id);
            return true; // Xóa thành công
        }
        return false; // Xóa thất bại nếu id không hợp lệ
    }
    public static boolean updateSubjectById(List<String> subjects, int id, String newSubject) {
        if (id >= 0 && id < subjects.size()) {
            subjects.set(id, newSubject);
            return true; // Cập nhật thành công
        }
        return false; // Cập nhật thất bại nếu id không hợp lệ
    }
    public static boolean addSubject(List<String> subjects, String newSubject) {
        if (newSubject != null && !newSubject.trim().isEmpty()) {
            subjects.add(newSubject);
            return true; // Thêm thành công
        }
        return false; // Không thêm được nếu môn học không hợp lệ
    }


}
