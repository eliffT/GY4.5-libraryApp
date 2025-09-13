package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForAddDto;
import com.turkcell.libraryapp.dto.publisher.PublisherForGetDto;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.entity.Publisher;
import com.turkcell.libraryapp.repository.CategoryRepository;
import com.turkcell.libraryapp.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherForGetDto> getAllWithDto() {
        List<Publisher> publisherList = publisherRepository.findAll();
        List<PublisherForGetDto> publisherForGetDtoList = new ArrayList<PublisherForGetDto>();
        for(Publisher publisher : publisherList){
            PublisherForGetDto publisherForGetDto = new PublisherForGetDto();
            publisherForGetDto.setId(publisher.getId());
            publisherForGetDto.setName(publisher.getName());
            publisherForGetDtoList.add(publisherForGetDto);
        }
        return publisherForGetDtoList;
    }

    public PublisherForGetDto addWithDto(PublisherForAddDto publisherForAddDto){
        Publisher publisher = new Publisher();
        publisher.setName(publisherForAddDto.getName());

        Publisher publisherSaved = this.publisherRepository.save(publisher);
        PublisherForGetDto publisherForGetDto = new PublisherForGetDto();
        publisherForGetDto.setId(publisherSaved.getId());
        publisherForGetDto.setName(publisherSaved.getName());

        return publisherForGetDto;
    }

    public PublisherForGetDto getByIdWithDto(Integer id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        PublisherForGetDto publisherForGetDto = new PublisherForGetDto();
        publisherForGetDto.setId(publisher.getId());
        publisherForGetDto.setName(publisher.getName());
        return publisherForGetDto;
    }

    public void deletePublisherWithById(Integer id)
    {
        publisherRepository.deleteById(id);
    }

}
