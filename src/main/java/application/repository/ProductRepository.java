package application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
