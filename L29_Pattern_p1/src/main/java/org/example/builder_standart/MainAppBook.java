package org.example.builder_standart;

public class MainAppBook {
    public static void main(String[] args) {
        Book_Stardart book = Book_Stardart.BookBuilder.builder()
                .withTitle("Tittle")
                .withAuthor("Author")
                .withPages(360)
                .build();



    }
}
