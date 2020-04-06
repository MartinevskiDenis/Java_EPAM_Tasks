package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Series;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class FileSeriesDAO extends DAO<Series, Integer> {
    public FileSeriesDAO() {
        super();
    }

    public FileSeriesDAO(String path) {
        super(path);
    }

    @Override
    public ArrayList<Series> getAll() {
        ArrayList<Series> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Series>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        return items;
    }

    @Override
    public boolean insert(Series data) {
        ArrayList<Series> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            return true;
        } else {
            log.info("Error! This item already exists");
            return false;
        }
    }

    @Override
    public Optional<Series> getById(Integer id) {
        ArrayList<Series> items = this.getAll();
        for (Series item : items) {
            if (item.getId() == id) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Integer id, Series data) {
        ArrayList<Series> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.set(i, data);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        ArrayList<Series> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                return true;
            }
        }
        return false;
    }
}