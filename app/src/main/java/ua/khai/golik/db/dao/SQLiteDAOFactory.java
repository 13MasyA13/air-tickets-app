package ua.khai.golik.db.dao;

public class SQLiteDAOFactory extends AbstractDAOFactory {

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }
}
