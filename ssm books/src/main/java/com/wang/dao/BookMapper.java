package com.wang.dao;

import com.wang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CR
 */
public interface BookMapper {

    int addBook(Books book);
    int deleteBookById(@Param("bookId") int id);
    int updateBook(Books books);
    Books queryBookById(@Param("bookId") int id);
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);
}
