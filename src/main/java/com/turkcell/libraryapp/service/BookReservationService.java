package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.bookReservation.request.CreateBookReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.response.CreatedBookResevationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetAllBookReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetByIdBookResevationResponse;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.BookReservation;
import com.turkcell.libraryapp.repository.BookReservationRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookReservationService {
    private BookReservationRepository bookReservationRepository;

    public BookReservationService(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    public List<GetAllBookReservationResponse> getAllWithDto(){
        List<BookReservation> bookReservationList = bookReservationRepository.findAll();
        List<GetAllBookReservationResponse> getAllBookReservationResponseList = new ArrayList<GetAllBookReservationResponse>();

        for(BookReservation bookReservation: bookReservationList){
            GetAllBookReservationResponse getAllBookReservationResponse = new GetAllBookReservationResponse();
            getAllBookReservationResponse.setId(bookReservation.getId());
            getAllBookReservationResponse.setReservationDate(bookReservation.getReservationDate());

            getAllBookReservationResponseList.add(getAllBookReservationResponse);
        }
        return getAllBookReservationResponseList;
    }
    public CreatedBookResevationResponse createBookReservationWithDto(CreateBookReservationRequest createBookReservationRequest){
        BookReservation bookReservation = new BookReservation();
        bookReservation.setReservationDate(createBookReservationRequest.getReservationDate());

        BookReservation bookReservationSaved = bookReservationRepository.save(bookReservation);

        CreatedBookResevationResponse createdBookResevationResponse = new CreatedBookResevationResponse();
        createdBookResevationResponse.setId(bookReservationSaved.getId());
        createdBookResevationResponse.setReservationDate(bookReservationSaved.getReservationDate());

        return createdBookResevationResponse;
    }
    public GetByIdBookResevationResponse getByIdBookResevationResponse(Integer id){
        BookReservation bookReservation = bookReservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Bu id ile bir kitap rezervasyonu bulunamadı."));

        GetByIdBookResevationResponse getByIdBookResevationResponse = new GetByIdBookResevationResponse();
        getByIdBookResevationResponse.setReservationDate(bookReservation.getReservationDate());

        return getByIdBookResevationResponse;
    }
    public void deleteBookReservationWithById(Integer id){
        bookReservationRepository.deleteById(id);
    }
}
