package by.epam.BookSpace.runner;

import by.epam.BookSpace.dao.file.FileAuthorDAO;
import by.epam.BookSpace.model.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

public class Main {
    static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        Author obj = new Author();
        obj.setId(1);
        obj.setName("Test1");
        obj.setSurname("Test2");
        obj.setRating(100);
        obj.setDescription("Test3");
        FileAuthorDAO test = new FileAuthorDAO("data" + File.separator + "author.txt");
        //test.insert(obj);
        test.update(1, obj);
        ArrayList<Author> lst = test.getAll();
        log.info(lst);
    }
}
