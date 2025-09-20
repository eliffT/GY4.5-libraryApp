package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.publisher.request.PublisherRequest;
import com.turkcell.libraryapp.dto.publisher.response.PublisherResponse;
import com.turkcell.libraryapp.entity.Publisher;
import com.turkcell.libraryapp.mapper.PublisherMapper;
import com.turkcell.libraryapp.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository,  PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public PublisherResponse createPublisher(@Valid PublisherRequest publisherRequest){
        Publisher publisher = publisherMapper.publisherRequestToPublisher(publisherRequest);

        Publisher publisherSaved = this.publisherRepository.save(publisher);
        return publisherMapper.publisherToPublisherResponse(publisherSaved);
    }

    public List<PublisherResponse> getAllPublisher() {
        List<Publisher> publisherList = publisherRepository.findAll();
        return publisherMapper.publisherToPublisherResponseList(publisherList);
    }

    public PublisherResponse getPublisherById(Integer id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Publisher Not Found"));
        return publisherMapper.publisherToPublisherResponse(publisher);
    }

    public void deletePublisher(Integer id) {
        publisherRepository.deleteById(id);
    }

}
