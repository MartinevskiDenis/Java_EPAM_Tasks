package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Series;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;

import java.util.UUID;

public class SeriesInput extends InputData<Series, UUID> {
    @Override
    public Series inputItem() {
        Series series = new Series();
        System.out.print("Введите id автора: ");
        UUID id = inputId();
        if (id == null) {
            return null;
        }
        series.setAuthorId(id);
        System.out.print("Введите название серии книг: ");
        String str = input.nextLine();
        if (str.equals("")) {
            return null;
        }
        series.setName(str);
        System.out.print("Введите описание серии книг: ");
        str = input.nextLine();
        series.setDescription(str);
        return series;
    }

    @Override
    public UUID inputId() {
        String str = input.nextLine();
        UUID id = Parser.parseUUID(str);
        return id;
    }
}
