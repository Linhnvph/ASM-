package com.example.Asm2;

import java.util.ArrayList;
import java.util.List;

public class MonHoc {
    // Tạo danh sách môn học
    private static final List<String> subjects = new ArrayList<>();

    static {
        subjects.add("Toán học");
        subjects.add("Văn học");
        subjects.add("Lịch sử");
        subjects.add("Hóa học");
        subjects.add("Vật lý");
        subjects.add("Sinh học");
        subjects.add("Ngoại ngữ");
        subjects.add("Tin học");
    }

    // Phương thức tìm môn học theo ID
    public static String findSubjectById(int id) {
        if (id >= 1 && id <= subjects.size()) {
            return subjects.get(id - 1); // ID bắt đầu từ 1
        } else {
            return "Không tìm thấy môn học với ID: " + id;
        }
    }

    public static void main(String[] args) {
        // Hiển thị danh sách môn học
        System.out.println("Danh sách môn học:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }

        // Tìm môn học theo ID (ví dụ ID = 3)
        int idToFind = 3;
        System.out.println("\nMôn học với ID " + idToFind + ": " + findSubjectById(idToFind));
    }
}
