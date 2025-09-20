package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.publisher.request.PublisherRequest;
import com.turkcell.libraryapp.dto.publisher.response.PublisherResponse;
import com.turkcell.libraryapp.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherResponse publisherToPublisherResponse(Publisher publisher);
    Publisher publisherRequestToPublisher(PublisherRequest publisherRequest);
    List<PublisherResponse> publisherToPublisherResponseList(List<Publisher> publisherList);
}
