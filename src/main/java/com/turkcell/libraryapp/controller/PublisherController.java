package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.publisher.request.PublisherRequest;
import com.turkcell.libraryapp.dto.publisher.response.PublisherResponse;
import com.turkcell.libraryapp.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping()
    public List<PublisherResponse> getAllPublishers(){
        return publisherService.getAllPublisher();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponse createPublisher(@Valid @RequestBody PublisherRequest publisherRequest){
        return publisherService.createPublisher(publisherRequest);
    }

    @GetMapping("/{id}")
    public PublisherResponse getPublisherById(@PathVariable Integer id){
        return publisherService.getPublisherById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePublisherWithById(@PathVariable Integer id){
        publisherService.deletePublisher(id);
    }

}
