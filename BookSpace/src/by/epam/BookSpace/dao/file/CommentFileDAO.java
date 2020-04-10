package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Comment;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class CommentFileDAO extends DAO<Comment, UUID> {
    public CommentFileDAO() {
        super();
    }

    public CommentFileDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileCommentDAO");
    }

    @Override
    public ArrayList<Comment> getAll() {
        ArrayList<Comment> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Comment>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список комментариев");
        return items;
    }

    @Override
    public boolean insert(Comment data) {
        ArrayList<Comment> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("Добавлен комментарий с id=" + data.getId().toString());
            return true;
        }
        log.info("Комментарий уже существует");
        return false;
    }

    @Override
    public Optional<Comment> getById(UUID id) {
        ArrayList<Comment> items = this.getAll();
        for (Comment item : items) {
            if (item.getId() == id) {
                log.info("Возвращен комментарий с id=" + id.toString());
                return Optional.of(item);
            }
        }
        log.info("Комментарий с id=" + id.toString() + " не найден");
        return Optional.empty();
    }

    @Override
    public boolean update(UUID id, Comment data) {
        ArrayList<Comment> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.set(i, data);
                items.get(i).setId(id);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Комментарий с id=" + id.toString() + " изменен");
                return true;
            }
        }
        log.info("Комментарий с id=" + id.toString() + " не найден");
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        ArrayList<Comment> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Комментарий с id=" + id.toString() + " удален");
                return true;
            }
        }
        log.info("Комментарий с id=" + id.toString() + " не найден");
        return false;
    }
}