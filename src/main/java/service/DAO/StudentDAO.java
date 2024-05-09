package service.DAO;

import model.BorrowCard;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static service.DAO.BorrowCardDAO.getConnection;

public class StudentDAO {
    public static Student getStudentById(int id){
        Student student = null;
        String query = "SELECT * FROM student where student_id = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("full_name"));
                student.setNameClass(rs.getString("class"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(student);
        return student;
    }
    public static List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("full_name"));
                student.setNameClass(rs.getString("class"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Student student:students){
            System.out.println(student);
        }
        return students;
    }
}
