package co.id.lemoncode21.springbootmysqlcrud.service.Impl;

import co.id.lemoncode21.springbootmysqlcrud.model.Book;
import co.id.lemoncode21.springbootmysqlcrud.repository.BookRepository;
import co.id.lemoncode21.springbootmysqlcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> getDetail(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public String update(Long id,Book book) {
        Optional<Book> bookData = this.bookRepository.findById(id);
        if(bookData.isPresent()){
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setAuthor(book.getAuthor());
            _book.setPublisher(book.getPublisher());
            _book.setEdition(book.getEdition());
            _book.setCopies(book.getCopies());
            this.bookRepository.save(_book);
            return "Success update data!";
        }else{
            System.out.println("Id Not Found");
            return "Id not found";
        }
    }
}
