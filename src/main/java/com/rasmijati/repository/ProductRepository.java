/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rasmijati.repository;

import com.rasmijati.model.Product;

/**
 *
 * @author admin
 */
public class ProductRepository extends AbstractRepository<Product> {

    @Override
    public void Edit(Product p) {
        ShowAll().stream().filter(x -> x.getId().equals(p.getId())).forEach(n -> {
            n.setId(p.getId());
            n.setName(p.getName());
            n.setDescription(p.getDescription());
            n.setPrice(p.getPrice());
            n.setImage(p.getImage());
        });
    }
}
