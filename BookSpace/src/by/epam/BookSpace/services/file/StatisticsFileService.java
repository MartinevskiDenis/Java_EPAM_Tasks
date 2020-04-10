package by.epam.BookSpace.services.file;

import by.epam.BookSpace.dao.file.StatisticsFileDAO;
import by.epam.BookSpace.model.Statistics;
import by.epam.BookSpace.services.Service;

import java.io.File;
import java.util.UUID;

public class StatisticsFileService extends Service<Statistics, UUID> {
    public StatisticsFileService() {
        this.dao = new StatisticsFileDAO("data" + File.separator + "statistics.txt");
    }
}
