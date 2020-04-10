package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class AdminFileDAO extends DAO<Admin, String> {
    public AdminFileDAO() {
        super();
    }

    public AdminFileDAO(String path) {
        super(path);
        log.info("Создан объект для работы с FileAdminDAO");
    }

    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> items = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            items = (ArrayList<Admin>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        log.info("Возвращен список администраторов");
        return items;
    }

    @Override
    public boolean insert(Admin data) {
        ArrayList<Admin> items = this.getAll();
        if (!items.contains(data)) {
            items.add(data);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                output.writeObject(items);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("Добавлен администратор с login=" + data.getLogin());
            return true;
        }
        log.info("Администратор с login=" + data.getLogin() + " уже существует");
        return false;
    }

    @Override
    public Optional<Admin> getById(String id) {
        ArrayList<Admin> items = this.getAll();
        for (Admin item : items) {
            if (item.getLogin() == id) {
                log.info("Возвращен администратор с login=" + id);
                return Optional.of(item);
            }
        }
        log.info("Администратор с login=" + id + " не найден");
        return Optional.empty();
    }

    @Override
    public boolean update(String id, Admin data) {
        ArrayList<Admin> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getLogin() == id) {
                items.set(i, data);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Администратор с login=" + id + " изменен");
                return true;
            }
        }
        log.info("Администратор с login=" + id + " не найден");
        return false;
    }

    @Override
    public boolean delete(String id) {
        ArrayList<Admin> items = this.getAll();
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getLogin() == id) {
                items.remove(i);
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
                    output.writeObject(items);
                } catch (IOException e) {
                    log.error(e);
                }
                log.info("Администратор с login=" + id + " удален");
                return true;
            }
        }
        log.info("Администратор с login=" + id + " не найден");
        return false;
    }
}
