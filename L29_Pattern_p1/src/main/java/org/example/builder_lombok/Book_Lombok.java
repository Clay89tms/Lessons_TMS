package org.example.builder_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class Book_Lombok {

    private String title;
    private int pages;
    private String author;
    private Date date;
    private String color;


}
