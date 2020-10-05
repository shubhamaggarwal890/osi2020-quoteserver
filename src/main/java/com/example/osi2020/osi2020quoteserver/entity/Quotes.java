package com.example.osi2020.osi2020quoteserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quotes {
    @Id
    @GeneratedValue
    private Integer id;
    @Lob
    @Column(length = 1024)
    private String quote;
    private String author;
}
