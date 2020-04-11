package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.AdminFileDAO;
import by.epam.BookSpace.model.Admin;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

public class AdminFileService extends Service<Admin, String> {

    public AdminFileService() {
        this.dao = new AdminFileDAO(Constants.PATH_ADMINS);
    }
}
