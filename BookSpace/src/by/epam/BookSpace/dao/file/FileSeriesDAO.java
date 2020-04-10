package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Series;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class FileSeriesDAO extends DAO<Series, UUID> {
    public FileSeriesDAO() {
        super();
    }

    public FileSeriesDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileSeriesDAO");
    }

    @Override
    public ArrayList<Series> getAll() {
        ArrayList<Series> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Series>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список серий книг");
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
            log.info("Добавлена серия книг с id=" + data.getId().toString());
            return true;
        } else {
            log.info("Серия книг уже существует");
            return false;
        }
    }

    @Override
    public Optional<Series> getById(UUID id) {
        ArrayList<Series> items = this.getAll();
        for (Series item : items) {
            if (item.getId() == id) {
                log.info("Возвращена серия книг с id=" + id.toString());
                return Optional.of(item);
            }
        }
        log.info("Серия книг с id=" + id.toString() + " не найдена");
        return Optional.empty();
    }

    @Override
    public boolean update(UUID id, Series data) {
        ArrayList<Series> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.set(i, data);
                items.get(i).setId(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Серия книг с id=" + id.toString() + " изменена");
                return true;
            }
        }
        log.info("Серия книг с id=" + id.toString() + " не найдена");
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        ArrayList<Series> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Серия книг с id=" + id.toString() + " удалена");
                return true;
            }
        }
        log.info("Серия книг с id=" + id.toString() + " не найдена");
        return false;
    }
}