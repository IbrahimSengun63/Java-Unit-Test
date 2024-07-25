package com.ibrahim.java.unit.test.dtos.book.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetAllBook {
    private int id;
    private String name;
    private boolean available;
}
