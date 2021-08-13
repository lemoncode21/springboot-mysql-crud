package co.id.lemoncode21.springbootmysqlcrud.repository;

import co.id.lemoncode21.springbootmysqlcrud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
