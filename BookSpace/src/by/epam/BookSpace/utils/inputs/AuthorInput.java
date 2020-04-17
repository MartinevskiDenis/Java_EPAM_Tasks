package by.epam.BookSpace.utils.inputs;

import by.epam.BookSpace.model.Author;
import by.epam.BookSpace.utils.InputData;
import by.epam.BookSpace.utils.Parser;

import java.util.UUID;

public class AuthorInput extends InputData<Author, UUID> {
    @Override
    public Author inputItem() {
        Author author = new Author();
        System.out.print("Введите имя автора: ");
        String str = input.nextLine();
        if(str.equals("")) {
            return null;
        }
        author.setName(str);
        System.out.print("Введите фамилию автора: ");
        str = input.nextLine();
        author.setSurname(str);
        System.out.print("Введите описание автора: ");
        str = input.nextLine();
        author.setDescription(str);
        return author;
    }

    @Override
    public UUID inputId() {
        String str = input.nextLine();
        UUID id = Parser.parseUUID(str);
        return id;
    }
}
