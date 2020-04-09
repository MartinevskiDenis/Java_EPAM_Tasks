package by.epam.BookSpace.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public abstract class DAO<T, K> {
    protected String path;
    protected static final Logger log = LogManager.getLogger();

    public DAO() {
        this.path = "";
    }

    public DAO(String path) {
        this.path = path;
    }

    public abstract boolean insert(T data);

    public abstract Optional<T> getById(K id);

    public abstract boolean update(K id, T data);

    public abstract boolean delete(K id);

    public abstract ArrayList<T> getAll();
}