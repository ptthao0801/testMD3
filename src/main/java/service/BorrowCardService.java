package service;

import model.BorrowCard;
import service.DAO.BorrowCardDAO;

import java.util.List;

public class BorrowCardService implements IGenericService<BorrowCard>{
    @Override
    public List<BorrowCard> showAll() {
        return BorrowCardDAO.getAllBorrowCards();
    }

    @Override
    public void saveList(BorrowCard borrowCard) {

    }

    @Override
    public BorrowCard searchById(int id) {
        return BorrowCardDAO.getBorrowCardById(id);
    }

    @Override
    public void update(int id, BorrowCard borrowCard) {

    }

    @Override
    public void delete(int id) {

    }
}
