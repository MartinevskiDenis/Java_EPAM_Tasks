package by.epam.BookSpace.dao;

import java.util.ArrayList;

public abstract class DAO<T> {
    public abstract boolean insert(T data);
    public abstract <T1> T getById(T1 id);
    public abstract boolean update(T data);
    public abstract boolean delete(T data);
    public abstract ArrayList<T> getAll();
}
