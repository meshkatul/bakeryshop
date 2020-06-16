package org.perscholas.bakeryshop.repository;

import org.perscholas.bakeryshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
