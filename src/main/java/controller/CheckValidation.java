package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckValidation {
    public static boolean isValidBorrowId(String borrowId) {
        return borrowId.matches("MS-\\d+");
    }

    public static boolean isValidDate(String input) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidReturnDate(String borrowDate, String returnDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date borrow = format.parse(borrowDate);
            Date returnD = format.parse(returnDate);
            return !returnD.before(borrow);
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Kiểm tra mã mượn sách
        String borrowId = "MS-1234";
        System.out.println("isValidBorrowId: " + isValidBorrowId(borrowId));

        // Kiểm tra ngày hợp lệ
        String date = "10/05/2024";
        System.out.println("isValidDate: " + isValidDate(date));

        // Kiểm tra ngày trả sách
        String borrowDate = "10/05/2024";
        String returnDate = "15/05/2024";
        System.out.println("isValidReturnDate: " + isValidReturnDate(borrowDate, returnDate));
    }
}

