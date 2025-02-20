import java.util.*;

class Student {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;
    private Map<String, Double> grades;

    public Student(String firstName, String lastName, String birthdate, String address, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getRank() {
        double avg = getAverageGrade();
        if (avg >= 8.5) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4.0) return "D";
        else return "<D";
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + className + " - Average: " + getAverageGrade() + " - Rank: " + getRank();
    }
}

class Classroom {
    private String className;
    private List<Student> students;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Map<String, Integer> getRankCount() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("A", 0);
        rankCount.put("B", 0);
        rankCount.put("C", 0);
        rankCount.put("D", 0);
        rankCount.put("<D", 0);

        for (Student student : students) {
            String rank = student.getRank();
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ").append(className).append("\n");
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }

    public String getClassName() {
        return className;
    }
}

public class quan_li_lop_cntt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Classroom> classrooms = new HashMap<>();

        // Tạo danh sách lớp và sinh viên
        Classroom class1 = new Classroom("CNTT1");
        Student student1 = new Student("Nguyen", "Van A", "01/01/2000", "Ha Noi", "CNTT1");
        student1.addGrade("Lập trình hướng đối tượng", 9.0);
        student1.addGrade("Quản lý dự án", 8.5);
        student1.addGrade("Học Máy", 7.5);
        student1.addGrade("Cơ sở dữ liệu", 8.0);
        student1.addGrade("Lập trình ứng dụng cho TBDĐ", 9.5);
        class1.addStudent(student1);

        Student student2 = new Student("Tran", "Thi B", "02/02/2000", "Ho Chi Minh", "CNTT1");
        student2.addGrade("Lập trình hướng đối tượng", 7.0);
        student2.addGrade("Quản lý dự án", 6.5);
        student2.addGrade("Học Máy", 5.5);
        student2.addGrade("Cơ sở dữ liệu", 6.0);
        student2.addGrade("Lập trình ứng dụng cho TBDĐ", 7.5);
        class1.addStudent(student2);

        classrooms.put("CNTT1", class1);

        Classroom class2 = new Classroom("CNTT2");
        Student student3 = new Student("Le", "Van C", "03/03/2000", "Da Nang", "CNTT2");
        student3.addGrade("Lập trình hướng đối tượng", 6.0);
        student3.addGrade("Quản lý dự án", 5.5);
        student3.addGrade("Học Máy", 4.5);
        student3.addGrade("Cơ sở dữ liệu", 5.0);
        student3.addGrade("Lập trình ứng dụng cho TBDĐ", 6.5);
        class2.addStudent(student3);

        classrooms.put("CNTT2", class2);

        // Hiển thị danh sách lớp
        System.out.println("Danh sách các lớp:");
        for (String className : classrooms.keySet()) {
            System.out.println(className);
        }

        // Nhập mã lớp và hiển thị thông tin
        System.out.print("Nhập mã lớp: ");
        String inputClass = scanner.nextLine();
        Classroom selectedClass = classrooms.get(inputClass);

        if (selectedClass != null) {
            System.out.println(selectedClass);
            Map<String, Integer> rankCount = selectedClass.getRankCount();
            System.out.println("Số sinh viên theo rank:");
            for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Lớp không tồn tại.");
        }
    }
} 