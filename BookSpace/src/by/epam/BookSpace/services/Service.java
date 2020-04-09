package by.epam.BookSpace.services;

import by.epam.BookSpace.dao.DAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Service<T, K, D extends DAO<T, K>> {
    protected static final Logger log = LogManager.getLogger();
    protected D dao;

    public Service() {};

    public ArrayList<T> getAll() {
        return this.dao.getAll();
    }

    public boolean insert(T data) {
        return dao.insert(data);
    }

    public Optional<T> getById(K id){
        return dao.getById(id);
    }

    public boolean update(K id, T data){
        return dao.update(id, data);
    }

    public boolean delete(K id){
        return dao.delete(id);
    }
}