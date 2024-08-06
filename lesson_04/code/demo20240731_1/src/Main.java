import app.controller.ProductController;
import app.entity.Product;
import app.repository.ProductRepository;
import app.repository.ProductRepositoryImpl;
import app.service.ProductService;
import app.service.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ProductRepository repository = new ProductRepositoryImpl();
//        ProductService service = new ProductServiceImpl(repository);
//        ProductController controller = new ProductController(service);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".app");
        ProductController controller = context.getBean(ProductController.class);
        System.out.println(controller.getAllProducts());
    }
}