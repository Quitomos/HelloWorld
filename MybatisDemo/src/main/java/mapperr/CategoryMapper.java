package mapperr;

import org.apache.ibatis.annotations.*;
import pojo.Category;

import java.util.List;

public interface CategoryMapper {

    @Insert("insert into category(name) values(#{name})")
    int add(Category category);

    @Select("select * from category")
    List<Category> list();

    @Delete("delete from category where id = #{id}")
    void delete(int id);

    @Select("select * from category where id = #{id}")
    Category get(int id);

    @Update("update category set name = #{name} where id = #{id}")
    int update(Category category);
}
