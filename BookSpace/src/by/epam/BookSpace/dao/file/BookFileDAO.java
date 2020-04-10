package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class BookFileDAO extends DAO<Book, UUID> {
    public BookFileDAO() {
        super();
    }

    public BookFileDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileBookDAO");
    }

    @Override
    public ArrayList<Book> getAll() {
        ArrayList<Book> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Book>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список книг");
        return items;
    }

    @Override
    public boolean insert(Book data) {
        ArrayList<Book> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("Добавлена книга с id=" + data.getId().toString());
            return true;
        }
        log.info("Книга уже существует");
        return false;
    }

    @Override
    public Optional<Book> getById(UUID id) {
        ArrayList<Book> items = this.getAll();
        for (Book item : items) {
            if (item.getId() == id) {
                log.info("Возвращена книга с id=" + id.toString());
                return Optional.of(item);
            }
        }
        log.info("Книга с id=" + id.toString() + " не найдена");
        return Optional.empty();
    }

    @Override
    public boolean update(UUID id, Book data) {
        ArrayList<Book> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.set(i, data);
                items.get(i).setId(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Книга с id=" + id.toString() + " изменена");
                return true;
            }
        }
        log.info("Книга с id=" + id.toString() + " не найдена");
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        ArrayList<Book> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Книга с id=" + id.toString() + " удалена");
                return true;
            }
        }
        log.info("Книга с id=" + id.toString() + " не найдена");
        return false;
    }
}