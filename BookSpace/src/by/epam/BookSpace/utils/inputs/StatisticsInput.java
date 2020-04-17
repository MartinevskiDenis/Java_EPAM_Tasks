package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Statistics;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;

import java.util.UUID;

public class StatisticsInput extends InputData<Statistics, UUID> {
    @Override
    public Statistics inputItem() {
        Statistics statistics = new Statistics();
        System.out.print("Введите id книги: ");
        UUID id = inputId();
        if (id == null) {
            return null;
        }
        statistics.setBookId(id);
        System.out.print("Введите количество лайков книги: ");
        String str = input.nextLine();
        int tmp = Parser.parseInteger(str);
        if(tmp < 0) {
            return null;
        }
        statistics.setNumberLikes(tmp);
        return statistics;
    }

    @Override
    public UUID inputId() {
        String str = input.nextLine();
        UUID id = Parser.parseUUID(str);
        return id;
    }
}
