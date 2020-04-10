package by.epam.BookSpace.services;

import by.epam.BookSpace.dao.DAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class Service<T, K> {
    protected static final Logger log = LogManager.getLogger();
    protected DAO<T, K> dao;

    public Service() {
    }

    public ArrayList<T> getAll() {
        return this.dao.getAll();
    }

    public boolean insert(T data) {
        if (data != null) {
            return dao.insert(data);
        }
        log.info("Ошибка! В функцию передано значение null");
        return false;
    }

    public T getById(K id) {
        if (id != null) {
            return dao.getById(id).orElse(null);
        }
        log.info("Ошибка! В функцию передано значение null");
        return null;
    }

    public boolean update(K id, T data) {
        if ((id != null) && (data != null)) {
            return dao.update(id, data);
        }
        log.info("Ошибка! В функцию передано значение null");
        return false;
    }

    public boolean delete(K id) {
        if (id != null) {
            return dao.delete(id);
        }
        log.info("Ошибка! В функцию передано значение null");
        return false;
    }
}