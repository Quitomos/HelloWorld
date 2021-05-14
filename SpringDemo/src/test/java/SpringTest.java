import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Category;
import pojo.Product;
import service.ProductService;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"applicationContext.xml"}
        );
//        Category c = (Category) context.getBean("c");
//        System.out.println(c.getName());
//        Product p = (Product) context.getBean("p");
//        System.out.println(p.getCategory().getName());
        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}
