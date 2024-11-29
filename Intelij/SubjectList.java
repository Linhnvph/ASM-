package com.example.lap3_4;
import java.util.ArrayList;
import java.util.List;

public class SubjectList {
    public static void main(String[] args) {
        // Tạo danh sách môn học
        List<String> subjects = new ArrayList<>();
        subjects.add("Toán học");
        subjects.add("Văn học");
        subjects.add("Lịch sử");
        subjects.add("Hóa học");
        subjects.add("Vật lý");
        subjects.add("Sinh học");
        subjects.add("Ngoại ngữ");
        subjects.add("Tin học");

        // Hiển thị danh sách môn học
        System.out.println("Danh sách môn học:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }
    }
}
