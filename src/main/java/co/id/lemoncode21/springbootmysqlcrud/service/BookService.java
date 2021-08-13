package co.id.lemoncode21.springbootmysqlcrud.service;

import co.id.lemoncode21.springbootmysqlcrud.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    //CRUD

    List<Book> getAll();

    Optional<Book> getDetail(Long id);

    void save(Book book);

    void delete(Long id);

    String update(Long id,Book book);

}
