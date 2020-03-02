package by.epam.BookSpace.model;

import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String name;
    private int authorID;
    private int seriesID;
    private ArrayList<String> genres;
    private Date releaseDate;
    private int cntSymbols;
    private String discription;
    private int id;

    public Book() {
        this.name = "";
        this.authorID = 0;
        this.seriesID = 0;
        this.genres = new ArrayList<String>();
        this.releaseDate = new Date(0, 0, 0);
        this.cntSymbols = 0;
        this.discription = "";
        this.id = 0;
    }
}
