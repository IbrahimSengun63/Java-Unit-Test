package com.ibrahim.java.unit.test.dtos.book.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetBookByName {
    private String name;
    private boolean available;
}
