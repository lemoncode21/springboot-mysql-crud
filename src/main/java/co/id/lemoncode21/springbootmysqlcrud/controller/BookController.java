package co.id.lemoncode21.springbootmysqlcrud.controller;


import co.id.lemoncode21.springbootmysqlcrud.model.Book;
import co.id.lemoncode21.springbootmysqlcrud.response.ResponseHandler;
import co.id.lemoncode21.springbootmysqlcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    //    Add
    @PostMapping(value = "/add")
    public ResponseHandler add(@RequestBody Book params){
        try{
            this.bookService.save(params);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success saved data!");
        }catch (Exception e){
            ResponseHandler responseHandler = new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //    Get All
    @GetMapping
    public ResponseHandler getAll(){
        try{
            List<Book> books = this.bookService.getAll();
            return  new ResponseHandler(HttpStatus.OK.toString(), "Success retrieve all data!",books);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //    Get Detail
    @GetMapping(value = "/{id}")
    public ResponseHandler getDetail(@PathVariable("id")Long id){
        try{
            Optional<Book> book = this.bookService.getDetail(id);
            return  new ResponseHandler(HttpStatus.OK.toString(),"Success retrieve detail data!", book);
        }catch (Exception e){
            return  new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //    Update
    @PutMapping(value = "/{id}")
    public ResponseHandler update(@PathVariable("id")Long id,@RequestBody Book book){
        try{
            String message = this.bookService.update(id,book);
            return new ResponseHandler(HttpStatus.OK.toString(),message);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    //    Delete
    @DeleteMapping("/{id}")
    public ResponseHandler delete(@PathVariable("id")Long id){
        try{
            this.bookService.delete(id);
            return new ResponseHandler(HttpStatus.OK.toString(), "Success deleted data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }


}
