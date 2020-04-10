package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.AdminFileDAO;
import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.services.Service;

import java.io.File;

public class AdminFileService extends Service<Admin, String> {

    public AdminFileService() {
        this.dao = new AdminFileDAO("data" + File.separator + "admins.txt");
    }
}
