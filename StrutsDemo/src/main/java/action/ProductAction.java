package action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import pojo.Produc;
import pojo.Product;

import java.util.Date;
import java.util.Map;

public class ProductAction {
    private Product product;
    //private Produc produ;
    private Date date;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String addPage() {
        name = "testName";
        return "addPage";
    }

    public String show() {
        product = new Product();
        product.setName("productA");
        System.out.println("method: show()");
        return "show";
    }

    public String add() {
        System.out.println("method: add()");
        //System.out.println(produ.getName());
        Map m = ActionContext.getContext().getSession();
        m.put("name", "testName");
        String name = (String)ServletActionContext.getRequest().getSession().getAttribute("name");
        System.out.println("ServletSession: name = " + name);
        return "show";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public Produc getProduc() {
//        return produ;
//    }
//
//    public void setProduc(Produc produc) {
//        this.produ = produc;
//    }
}
