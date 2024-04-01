/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductRepository {

    List<Product> list;

    public ProductRepository() {
        this.list = new ArrayList<>();
    }

    public void Create(Product p) {
        this.list.add(p);
    }

    public List<Product> ShowAll() {
        return this.list;
    }

    public Product ShowById(Long id) {
        for (Product p : list) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void Delete(Product p) {
        this.list.remove(p);
    }

    public void Edit(Product p) {
        this.list.stream().filter(x -> x.getId().equals(p.getId())).forEach(n -> {
            n.setId(p.getId());
            n.setName(p.getName());
            n.setDescription(p.getDescription());
            n.setPrice(p.getPrice());
            n.setImage(p.getImage());
        });
    }
}
