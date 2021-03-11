import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

//        Category category = new Category();
//        category.setName("category4");
//        session.insert("addCategory", category);

//        Category category = new Category();
//        category.setId(4);
//        session.delete("deleteCategory", category);

//        Category category = session.selectOne("getCategory", 1);
//        category.setName("category1modified");
//        session.update("updateCategory", category);
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        params.put("name", "1");
//        List<Category> categories = session.selectList("listCategoryWithProducts");
        List<Product> products = session.selectList("listProduct");
        for (Product product: products) {
            System.out.println(product.getName() + ":" + (product.getCategory() == null? null : product.getCategory().getName()));
        }
//        for (Category c: categories) {
//            System.out.println(c.getName());
//            List<Product> products = c.getProducts();
//            for (Product product: products) {
//                System.out.println("\t" + product.getName());
//            }
//        }
//        List<Order> orders = session.selectList("listOrder");
//        for (Order order: orders) {
//            System.out.println(order.getCode());
//            List<OrderItem> orderItems = order.getOrderItems();
//            for (OrderItem orderItem: orderItems) {
//                System.out.println("\t" + orderItem.getProduct().getName());
//            }
//        }

        session.commit();
        session.close();

    }
}
