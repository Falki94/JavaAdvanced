package rest;

import domain.Product;
import domain.ProductType;
import javax.ws.rs.Path;
import domain.services.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResources {

    private ProductService db = new ProductService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll() {
        return db.getAll();
    }

    @POST       
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Product product) {
        db.add(product);
        return Response.ok(product.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        Product result = db.getAll().stream().filter(x->x.getId()==id).findFirst().get();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }
    
    @GET
    @Path("/price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getByPrice(@PathParam("price") double price){
        return  db.getAll().stream().filter(x->x.getPrice()==price).collect(Collectors.toList());
    }
    
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getByName(@PathParam("name") String name){
        return db.getAll().stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
    }
    
    @GET
    @Path("/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getByCategory(@PathParam("category") ProductType category){
        return db.getAll().stream().filter(x->x.getCategory() == category).collect(Collectors.toList());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Product p) {
        Product result = db.get(id);
        if (result == null) {
            return Response.status(404).build();
        }
        p.setId(id);
        db.update(p);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Product result = db.get(id);
        if (result == null) {
            return Response.status(404).build();
        }
        db.delete(result);
        return Response.ok().build();
    }
}
