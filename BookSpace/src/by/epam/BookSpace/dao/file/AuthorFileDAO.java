package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class AuthorFileDAO extends DAO<Author, UUID> {
    public AuthorFileDAO() {
        super();
    }

    public AuthorFileDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileAuthorDAO");
    }

    @Override
    public ArrayList<Author> getAll() {
        ArrayList<Author> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Author>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список авторов");
        return items;
    }

    @Override
    public boolean insert(Author data) {
        ArrayList<Author> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("Добавлен автор с id=" + data.getId().toString());
            return true;
        }
        log.info("Автор уже существует");
        return false;
    }

    @Override
    public Optional<Author> getById(UUID id) {
        ArrayList<Author> items = this.getAll();
        for (Author item : items) {
            if (item.getId() == id) {
                log.info("Возвращен автор с id=" + id.toString());
                return Optional.of(item);
            }
        }
        log.info("Автор с id=" + id.toString() + " не найден");
        return Optional.empty();
    }

    @Override
    public boolean update(UUID id, Author data) {
        ArrayList<Author> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.set(i, data);
                items.get(i).setId(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Автор с id=" + id.toString() + " изменен");
                return true;
            }
        }
        log.info("Автор с id=" + id.toString() + " не найден");
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        ArrayList<Author> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Автор с id=" + id.toString() + " удален");
                return true;
            }
        }
        log.info("Автор с id=" + id.toString() + " не найден");
        return false;
    }
}
