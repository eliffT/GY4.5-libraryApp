package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.bookReservation.request.CreateBookReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.response.CreatedBookResevationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetAllBookReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetByIdBookResevationResponse;
import com.turkcell.libraryapp.service.BookReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookreservations")
public class BookReservationController {
    private BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @GetMapping()
    public List<GetAllBookReservationResponse> getAllWithDto(){
        return bookReservationService.getAllWithDto();
    }
    @PostMapping()
    public CreatedBookResevationResponse createBookReservationWithDto(@RequestBody CreateBookReservationRequest createBookReservationRequest){
        return bookReservationService.createBookReservationWithDto(createBookReservationRequest);
    }
    @GetMapping("{id}")
    public GetByIdBookResevationResponse getByIdBookResevationResponse(@PathVariable Integer id){
        return bookReservationService.getByIdBookResevationResponse(id);
    }
    @DeleteMapping("{id}")
    public void deleteBookReservationWithById(@PathVariable Integer id){
        bookReservationService.deleteBookReservationWithById(id);
    }
}
