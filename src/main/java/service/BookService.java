package service;

import model.Book;
import model.Student;
import service.DAO.BookDAO;

import java.util.List;

public class BookService implements IGenericService<Book>{


    @Override
    public List<Book> showAll() {
        return BookDAO.getAllBooks();
    }

    @Override
    public void saveList(Book book) {

    }

    @Override
    public Book searchById(int id) {
        return BookDAO.getBookById(id);
    }

    @Override
    public void update(int id, Book book) {

    }

    @Override
    public void delete(int id) {

    }
}
