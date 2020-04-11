package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.SeriesFileDAO;
import by.epam.BookSpace.model.Series;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

import java.util.UUID;

public class SeriesFileService extends Service<Series, UUID> {
    public SeriesFileService() {
        this.dao = new SeriesFileDAO(Constants.PATH_SERIES);
    }
}
