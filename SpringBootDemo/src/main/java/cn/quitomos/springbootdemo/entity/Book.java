package cn.quitomos.springbootdemo.entity;

public class Book {

    private Integer id;

    private String name;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

//    @Override
//    public String toString() {
//        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", sid=" + sid + '}';
//    }
}
