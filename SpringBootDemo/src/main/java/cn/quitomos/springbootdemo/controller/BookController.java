package cn.quitomos.springbootdemo.controller;

import cn.quitomos.springbootdemo.entity.Book;
import cn.quitomos.springbootdemo.mapper.BookMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookMapper bookMapper;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> listBook() throws Exception {
        PageHelper.startPage(1, 2);
        List<Book> bookList = bookMapper.getBookList();
        System.out.println(bookList.size());
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);
        return pageInfo.getList();
    }

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
}
