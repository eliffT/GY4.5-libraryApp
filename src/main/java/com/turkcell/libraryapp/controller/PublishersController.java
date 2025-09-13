package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.book.BookForAddDto;
import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForAddDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForGetDto;
import com.turkcell.libraryapp.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublishersController {

    private PublisherService publisherService;

    public PublishersController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping()
    public List<PublisherForGetDto> getAllWithDto(){
        return publisherService.getAllWithDto();
    }
    @PostMapping()
    public PublisherForGetDto addBookWithDto(@RequestBody PublisherForAddDto publisherForAddDto){
        return publisherService.addWithDto(publisherForAddDto);
    }
    @GetMapping("/{id}")
    public PublisherForGetDto getByIdWithDto(@PathVariable Integer id){
        return publisherService.getByIdWithDto(id);
    }

    @DeleteMapping("/{id}")
    public void deletePublisherWithById(@PathVariable Integer id){
        publisherService.deletePublisherWithById(id);
    }

}
