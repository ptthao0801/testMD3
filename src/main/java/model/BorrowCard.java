package model;

import java.util.Date;

public class BorrowCard {
    private int id;
    private Book book;
    private Student student;
    private boolean borrow;
    private Date borrowDate;
    private Date returnDate;

    public BorrowCard() {
    }

    public BorrowCard(int id, Book book, Student student, boolean borrow, Date borrowDate, Date returnDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.borrow = borrow;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowCard{" +
                "id=" + id +
                ", book=" + book +
                ", student=" + student +
                ", borrow=" + borrow +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
