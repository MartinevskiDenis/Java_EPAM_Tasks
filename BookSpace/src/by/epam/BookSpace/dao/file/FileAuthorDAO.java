package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Author;

import java.io.*;
import java.util.ArrayList;

public class FileAuthorDAO extends DAO<Author, Integer> {
    public FileAuthorDAO() {
        super();
    }

    public FileAuthorDAO(String path) {
        super(path);
    }

    @Override
    public boolean insert(Author data) {
        ArrayList<Author> items = new ArrayList<Author>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Author>) input.readObject();
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
    public Author getById(Integer id) {
        if (id == null) {
            log.info("Error! Incorrect id");
            return null;
        }
        ArrayList<Author> items = new ArrayList<Author>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Author>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        for (Author item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean update(Integer id, Author data) {
        if ((id == null) || (data == null)) {
            log.info("Error! Incorrect input");
            return false;
        }
        ArrayList<Author> items = new ArrayList<Author>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Author>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getId() == id) {
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
    public boolean delete(Author data) {
        if (data == null) {
            log.info("Error! Incorrect input");
            return false;
        }
        ArrayList<Author> items = new ArrayList<Author>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Author>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        if (items.remove(data)) {
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
                output.writeObject(items);
                output.close();
            } catch (IOException e) {
                log.error(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Author> getAll() {
        ArrayList<Author> items = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Author>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        return items;
    }
}
