package by.epam.BookSpace.runner.views;

import by.epam.BookSpace.model.Comment;
import by.epam.BookSpace.model.Statistics;
import by.epam.BookSpace.runner.View;
import by.epam.BookSpace.services.file.BookFileService;
import by.epam.BookSpace.services.file.CommentFileService;
import by.epam.BookSpace.services.file.StatisticsFileService;
import by.epam.BookSpace.utils.inputs.StatisticsInput;

import java.util.UUID;

public class StatisticsView extends View<Statistics, UUID> {

    public StatisticsView() {
        this.service = new StatisticsFileService();
        this.inputData = new StatisticsInput();
    }

    @Override
    public void add() {
        Statistics item = inputData.inputItem();
        if (item != null) {
            BookFileService bookFileService = new BookFileService();
            if(bookFileService.getById(item.getBookId()) == null) {
                System.out.println("Некорректные данные");
                System.out.println();
                return;
            }
            if (!service.insert(item)) {
                System.out.println("Такой элемент уже существует");
            } else {
                int cnt = 0;
                CommentFileService commentFileService = new CommentFileService();
                for(Comment comment : commentFileService.getAll()) {
                    if(comment.getBookId().equals(item.getBookId())) {
                        ++cnt;
                    }
                }
                item.setNumberComments(cnt);
                service.update(item.getBookId(), item);
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }
}
