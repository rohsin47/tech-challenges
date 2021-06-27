package com.alds.local.others;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rohsingh
 *
 */
public class StudentWithHighestScore {

    static class Student implements Comparable<Student> {
        public String name;
        public int avgScore;
        public int count;

        @Override
        public int compareTo(Student o) {
            if (this.avgScore < o.avgScore) {
                return 1;
            } else {
                return -1;
            }
        }

        public String toString() {
            return "Student[" + name + "," + avgScore + "," + count + "]";
        }
    }

    public static String findHighestScore(String[][] in) {

        Map<String, Student> data = new HashMap<>();

        for (String[] row : in) {
            if (!data.containsKey(row[0])) {
                Student s = new Student();
                s.name = row[0];
                s.avgScore = Integer.parseInt(row[1]);
                s.count = 1;
                data.put(row[0], s);
            } else {
                Student so = data.get(row[0]);
                so.count += 1;
                so.avgScore = so.avgScore + Integer.parseInt(row[1]);
            }
        }

        System.out.println(data);

        List<Student> res = data.values().stream().collect(Collectors.toList());

        String s = null;
        double max = 0;
        for (Student stu : res) {
            double avg = stu.avgScore / (double) stu.count;
            if (max < avg) {
                s = stu.name;
                max = avg;
            }
        }

        return s + " : " + max;
    }

    public static void main(String[] args) {
        String[][] in = { { "Jerry", "65" }, { "Bob", "71" }, { "Jerry", "23" }, { "Eric", "83" }, { "Eric", "68" },
                { "Bob", "80" }, { "Jerry", "25" }, { "Eric", "98" } };
        System.out.println(findHighestScore(in));
    }

}
