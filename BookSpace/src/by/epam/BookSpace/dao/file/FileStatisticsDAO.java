package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class FileStatisticsDAO extends DAO<Statistics, UUID> {
    public FileStatisticsDAO() {
        super();
    }

    public FileStatisticsDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileStatisticsDAO");
    }

    @Override
    public ArrayList<Statistics> getAll() {
        ArrayList<Statistics> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Statistics>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список статистик книг");
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
            log.info("Добавлена статистика для книги с id=" + data.getBookId().toString());
            return true;
        } else {
            log.info("Статистика для книги c id=" + data.getBookId().toString() + " уже существует");
            return false;
        }
    }

    @Override
    public Optional<Statistics> getById(UUID id) {
        ArrayList<Statistics> items = this.getAll();
        for (Statistics item : items) {
            if (item.getBookId() == id) {
                log.info("Возвращена статистика для книги с id=" + id.toString());
                return Optional.of(item);
            }
        }
        log.info("Статистика для книги с id=" + id.toString() + " не найдена");
        return Optional.empty();
    }

    @Override
    public boolean update(UUID id, Statistics data) {
        ArrayList<Statistics> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getBookId() == id) {
                items.set(i, data);
                items.get(i).setBookId(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Статистика для книги с id=" + id.toString() + " изменена");
                return true;
            }
        }
        log.info("Статистика для книги с id=" + id.toString() + " не найдена");
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        ArrayList<Statistics> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getBookId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Статистика для книги с id=" + id.toString() + " удалена");
                return true;
            }
        }
        log.info("Статистика для книги с id=" + id.toString() + " не найдена");
        return false;
    }
}