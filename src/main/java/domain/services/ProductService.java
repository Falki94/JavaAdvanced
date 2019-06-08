package domain.services;

import domain.Product;
import domain.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private static List<Product> db = new ArrayList<Product>();
    static {
        db.add(new Product(1,"cos",100,ProductType.GRAPHICCARD));
        db.add(new Product(2,"cos1",110, ProductType.HARDDISCDRIVE));
        db.add(new Product(3,"cos2",120,ProductType.MOTHERBOARD));
        db.add(new Product(4,"cos3",130,ProductType.RAM));
        db.add(new Product(5,"cos4",140,ProductType.GRAPHICCARD));
        db.add(new Product(6,"cos5",150, ProductType.HARDDISCDRIVE));
        db.add(new Product(7,"cos6",160,ProductType.MOTHERBOARD));
        db.add(new Product(8,"cos7",170,ProductType.RAM));
    }
    
    // private static XcomRepository db = new XcomRepository();

    private static int currentId = 1;

    public List<Product> getAll() {
        return db;
    }

    public Product get(int id) {
        for (Product p : db) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getByPrice(double price) {
        return db.stream().filter(x -> x.getPrice() == price).collect(Collectors.toList());
    }

    public List<Product> getByName(String name) {
        return db.stream().filter(x -> x.getName() == name).collect(Collectors.toList());
    }

    public List<Product> getByCategory(ProductType category) {
        return db.stream().filter(x -> x.getCategory() == category).collect(Collectors.toList());
    }

    public void add(Product m) {
        m.setId(currentId++);
        db.add(m);
    }

    public void update(Product product) {
        for (Product p : db) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
            }
        }
    }

    public void delete(Product m) {
        db.remove(m);
    }

}
