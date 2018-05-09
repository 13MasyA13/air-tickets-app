package ua.khai.golik.db.dao;

public abstract class AbstractDAOFactory {

    public abstract OrderDAO getOrderDAO();

    public abstract UserDAO getUserDAO();

    public static SQLiteDAOFactory getSQLiteDAOFactory(){
        return new SQLiteDAOFactory();
    }
}
