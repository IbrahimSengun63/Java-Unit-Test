package com.ibrahim.java.unit.test.dtos.book.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateBook {
    private int id;
    private String name;
    private boolean available;
}
