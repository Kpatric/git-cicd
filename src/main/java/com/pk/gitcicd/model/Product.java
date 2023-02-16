package com.pk.gitcicd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    public int Id;
    public String productName;
    public String productPrice;
    public String productDescription;
    private int stock;
}
