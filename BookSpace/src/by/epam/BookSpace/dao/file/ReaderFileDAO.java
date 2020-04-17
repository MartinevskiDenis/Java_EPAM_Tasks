package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class ReaderFileDAO extends DAO<Reader, String> {
    public ReaderFileDAO() {
        super();
    }

    public ReaderFileDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileReaderDAO");
    }

    @Override
    public ArrayList<Reader> getAll() {
        ArrayList<Reader> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Reader>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список пользователей");
        return items;
    }

    @Override
    public boolean insert(Reader data) {
        ArrayList<Reader> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("Добавлен пользователь с login=" + data.getLogin());
            return true;
        }
        log.info("Пользователь с login=" + data.getLogin() + " уже существует");
        return false;
    }

    @Override
    public Optional<Reader> getById(String id) {
        ArrayList<Reader> items = this.getAll();
        for (Reader item : items) {
            if (item.getLogin().equals(id)) {
                log.info("Возвращен пользователь с login=" + id);
                return Optional.of(item);
            }
        }
        log.info("Пользователь с login=" + id + " не найден");
        return Optional.empty();
    }

    @Override
    public boolean update(String id, Reader data) {
        ArrayList<Reader> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getLogin().equals(id)) {
                items.set(i, data);
                items.get(i).setLogin(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Пользователь с login=" + id + " изменен");
                return true;
            }
        }
        log.info("Пользователь с login=" + id + " не найден");
        return false;
    }

    @Override
    public boolean delete(String id) {
        ArrayList<Reader> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getLogin().equals(id)) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Пользователь с login=" + id + " удален");
                return true;
            }
        }
        log.info("Пользователь с login=" + id + " не найден");
        return false;
    }
}
