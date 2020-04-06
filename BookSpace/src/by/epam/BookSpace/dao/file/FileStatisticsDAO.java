package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class FileStatisticsDAO extends DAO<Statistics, Integer> {
    public FileStatisticsDAO() {
        super();
    }

    public FileStatisticsDAO(String path) {
        super(path);
    }

    @Override
    public ArrayList<Statistics> getAll() {
        ArrayList<Statistics> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Statistics>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        return items;
    }

    @Override
    public boolean insert(Statistics data) {
        ArrayList<Statistics> items = this.getAll();
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
    public Optional<Statistics> getById(Integer id) {
        ArrayList<Statistics> items = this.getAll();
        for (Statistics item : items) {
            if (item.getBookId() == id) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Integer id, Statistics data) {
        ArrayList<Statistics> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getBookId() == id) {
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
        ArrayList<Statistics> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getBookId() == id) {
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