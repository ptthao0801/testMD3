package service.DAO;

import model.Book;
import model.BorrowCard;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowCardDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "12345678_ABC";
    static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found!");
        }
        return connection;
    }

    public static BorrowCard getBorrowCardById(int id){
        BorrowCard borrowCard = null;
        String query = "SELECT * FROM borrow_card where borrow_id = ?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                borrowCard = new BorrowCard();
                borrowCard.setId(rs.getInt("borrow_id"));
                int bookId = (rs.getInt("book_id"));
                Book book = BookDAO.getBookById(bookId);
                borrowCard.setBook(book);
                int studentId = (rs.getInt("student_id"));
                Student student = StudentDAO.getStudentById(studentId);
                borrowCard.setStudent(student);
                borrowCard.setBorrow(rs.getBoolean("borrow_status"));
                borrowCard.setBorrowDate(rs.getDate("borrow_date"));
                borrowCard.setReturnDate(rs.getDate("return_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(borrowCard);
        return borrowCard;
    }

    public static List<BorrowCard> getAllBorrowCards(){
        List<BorrowCard> borrowCards = new ArrayList<>();
        String query = "SELECT * FROM borrow_card;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BorrowCard borrowCard = new BorrowCard();
                borrowCard.setId(rs.getInt("borrow_id"));
                int bookId = (rs.getInt("book_id"));
                Book book = BookDAO.getBookById(bookId);
                borrowCard.setBook(book);
                int studentId = (rs.getInt("student_id"));
                Student student = StudentDAO.getStudentById(studentId);
                borrowCard.setStudent(student);
                borrowCard.setBorrow(rs.getBoolean("borrow_status"));
                borrowCard.setBorrowDate(rs.getDate("borrow_date"));
                borrowCard.setReturnDate(rs.getDate("return_date"));
                borrowCards.add(borrowCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(BorrowCard borrowCard:borrowCards){
            System.out.println(borrowCard);
        }
        return borrowCards;
    }
}
