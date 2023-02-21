package org.example.builder_standart;

import lombok.Data;

@Data
public class Book_Stardart {
    private String title;
    private int pages;
    private String author;
    private Data data;
    private String color;

    public Book_Stardart() {
    }


    public static final class BookBuilder {
        private String title;
        private int pages;
        private String author;
        private Data data;
        private String color;


        public static BookBuilder builder() {
            return new BookBuilder();
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withPages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder withData(Data data) {
            this.data = data;
            return this;
        }

        public BookBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public Book_Stardart build() {
            Book_Stardart book = new Book_Stardart();
            book.setTitle(title);
            book.setPages(pages);
            book.setAuthor(author);
            book.setData(data);
            book.setColor(color);
            return book;
        }
    }
}
