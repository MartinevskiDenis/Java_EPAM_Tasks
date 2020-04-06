package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Admin;

import java.io.*;
import java.util.ArrayList;

public class FileAdminDAO extends DAO<Admin, String> {
    public FileAdminDAO() {
        super();
    }

    public FileAdminDAO(String path) {
        super(path);
    }

    @Override
    public boolean insert(Admin data) {
        ArrayList<Admin> items = new ArrayList<Admin>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Admin>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        if (!items.contains(data)) {
            items.add(data);
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
                output.writeObject(items);
                output.close();
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
    public Admin getById(String id) {
        if (id == null) {
            log.info("Error! Incorrect id");
            return null;
        }
        ArrayList<Admin> items = new ArrayList<Admin>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Admin>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        for (Admin item : items) {
            if (item.getLogin().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean update(String id, Admin data) {
        if ((id == null) || (data == null)) {
            log.info("Error! Incorrect input");
            return false;
        }
        ArrayList<Admin> items = new ArrayList<Admin>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Admin>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getLogin().equals(id)) {
                items.set(i, data);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
                    output.writeObject(items);
                    output.close();
                } catch (IOException e) {
                    log.error(e);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }

    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> items = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Admin>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        return items;
    }
}
