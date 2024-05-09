package controller;

import model.Book;
import model.Student;
import service.BookService;
import service.BorrowCardService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibraryServlet", urlPatterns = "/library")
public class LibraryServlet extends HttpServlet {
    private final BookService bookService = new BookService();
    private final StudentService studentService = new StudentService();
    private final BorrowCardService borrowCardService = new BorrowCardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrowForm(req, resp);
                break;
//            case "edit":
//                showEditForm(req, resp);
//                break;
//            case "delete":
//                showDeleteForm(req, resp);
//                break;
//            case "view":
//                viewStudent(req, resp);
//                break;
            default:
                displayBooks(req, resp);
                break;
        }
    }

    private void showBorrowForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Book book = this.bookService.searchById(bookId);
        req.setAttribute("book",book);

        List<Student> students = this.studentService.showAll();
        req.setAttribute("students",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("borrow.jsp");
        dispatcher.forward(req,resp);
    }

    private void displayBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = this.bookService.showAll();
        req.setAttribute("books",books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("displayBook.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "borrow":
                borrow(req, resp);
                break;
//            case "edit":
//                updateStudent(req, resp);
//                break;
//            case "delete":
//                deleteStudent(req, resp);
//                break;
            default:
                break;
        }
    }

    private void borrow(HttpServletRequest req, HttpServletResponse resp) {
    }
}
