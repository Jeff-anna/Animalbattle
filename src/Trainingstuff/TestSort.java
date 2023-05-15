package Trainingstuff;
import Trainingstuff.Student;

import java.util.ArrayList;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("01","ZhangSan",90));
        students.add(new Student("01","LiMing",95));
        students.add(new Student("03","XiaoLan",89));
        students.add(new Student("02","Wong",99));
        students.add(new Student("02","LiSi",80));
    }
}
