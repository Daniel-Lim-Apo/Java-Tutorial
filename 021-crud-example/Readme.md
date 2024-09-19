# Java MongoDB CRUD Example Project with MongoDB Atlas

This project demonstrates how to build a Java CRUD (Create, Read, Update, Delete) application using Spring Boot and MongoDB Atlas.

## 1. Set Up MongoDB Atlas

1. Go to [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) and create an account if you don't have one.
2. Create a new Cluster and set up a database user.
3. Whitelist your IP address or allow access from anywhere.
4. Obtain your MongoDB connection string (it should look something like this: `mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority`).

## 2. Set Up a Spring Boot Project

You can use [Spring Initializr](https://start.spring.io/) to create a Spring Boot project. Select the following dependencies:

- Spring Web
- Spring Data MongoDB
- Lombok (optional but useful)

Alternatively, you can create the `pom.xml` manually.

### `pom.xml` File:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.mvnrepository.com/POM/4.0.0
         http://www.mvnrepository.com/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>mongodb-crud</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.0</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

Use

mvn clean install

## 3. Configure MongoDB Connection

Add your MongoDB connection string to `src/main/resources/application.properties` file.

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
```

## 4. Create the Model

Create a `Product` class as your model.

```java
package com.example.mongodbcrud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
}
```

## 5. Create the Repository

```java
package com.example.mongodbcrud.repository;

import com.example.mongodbcrud.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
```

## 6. Create the Service Layer

```java
package com.example.mongodbcrud.service;

import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
```

## 7. Create the Controller

```java
package com.example.mongodbcrud.controller;

import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
```

## 8. Run the Application

Run the application with Maven:

```bash
mvn spring-boot:run
```

## 9. Test the Endpoints

You can use VSCode RestClient, Insomnia, Postman or cURL to test the API endpoints.

### Create a Product (POST `/api/products`)

```json
POST /api/products
{
  "name": "Laptop",
  "description": "A high-end gaming laptop",
  "price": 1200.00
}
```

### Get All Products (GET `/api/products`)

### Get a Product by ID (GET `/api/products/{id}`)

### Update a Product (PUT `/api/products/{id}`)

```json
PUT /api/products/{id}
{
  "name": "Updated Laptop",
  "description": "An updated description",
  "price": 1100.00
}
```

### Delete a Product (DELETE `/api/products/{id}`)
