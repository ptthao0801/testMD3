package service;

import model.Student;
import service.DAO.StudentDAO;

import java.util.List;

public class StudentService implements IGenericService<Student> {

    @Override
    public List<Student> showAll() {
        return StudentDAO.getAllStudents();
    }

    @Override
    public void saveList(Student student) {

    }

    @Override
    public Student searchById(int id) {
        return StudentDAO.getStudentById(id);
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
