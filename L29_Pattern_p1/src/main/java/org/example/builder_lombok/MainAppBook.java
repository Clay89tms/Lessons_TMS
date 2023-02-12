package org.example.builder_lombok;

import org.example.builder_lombok.Book_Lombok;


public class MainAppBook {
    public static void main(String[] args) {
        Book_Lombok build = Book_Lombok.builder()
                .title("Title")
                .author("Author")
                .pages(365).build();

    }
}
