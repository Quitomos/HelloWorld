package cn.quitomos.springbootdemo.mapper;

import cn.quitomos.springbootdemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> getBookList();
}
