package by.epam.BookSpace.dao.file;

import by.epam.BookSpace.dao.DAO;
import by.epam.BookSpace.model.Reader;

import java.io.*;
import java.util.ArrayList;

public class FileReaderDAO extends DAO<Reader, String> {
    public FileReaderDAO() {
        super();
    }

    public FileReaderDAO(String path) {
        super(path);
    }
    
    @Override
    public boolean insert(Reader data) {
        ArrayList<Reader> items = new ArrayList<Reader>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Reader>) input.readObject();
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
    public Reader getById(String id) {
        if (id == null) {
            log.info("Error! Incorrect id");
            return null;
        }
        ArrayList<Reader> items = new ArrayList<Reader>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Reader>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        for (Reader item : items) {
            if (item.getLogin().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean update(String id, Reader data) {
        if ((id == null) || (data == null)) {
            log.info("Error! Incorrect input");
            return false;
        }
        ArrayList<Reader> items = new ArrayList<Reader>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Reader>) input.readObject();
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
    public boolean delete(Reader data) {
        if (data == null) {
            log.info("Error! Incorrect input");
            return false;
        }
        ArrayList<Reader> items = new ArrayList<Reader>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Reader>) input.readObject();
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
    public ArrayList<Reader> getAll() {
        ArrayList<Reader> items = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            items = (ArrayList<Reader>) input.readObject();
            input.close();
        } catch (IOException e) {
            log.error(e);
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        return items;
    }
}
