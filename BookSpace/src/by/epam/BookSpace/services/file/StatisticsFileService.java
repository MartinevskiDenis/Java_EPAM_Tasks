package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.StatisticsFileDAO;
import by.epam.BookSpace.model.Statistics;
import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.Constants;

import java.util.UUID;

public class StatisticsFileService extends Service<Statistics, UUID> {
    public StatisticsFileService() {
        this.dao = new StatisticsFileDAO(Constants.PATH_STATISTICS);
    }
}
