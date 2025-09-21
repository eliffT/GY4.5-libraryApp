package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.bookReservation.request.CreateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.request.UpdateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.response.CreateReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetAllReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetByIdReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.UpdatedReservationResponse;
import com.turkcell.libraryapp.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping()
    public List<GetAllReservationResponse> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping()
    public CreateReservationResponse createReservations(@Valid @RequestBody CreateReservationRequest createReservationRequest){
        return reservationService.createReservations(createReservationRequest);
    }
    @GetMapping("{id}")
    public GetByIdReservationResponse getReservationById(@PathVariable Integer id){
        return reservationService.getReservationById(id);
    }
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(id);
    }

    @PostMapping("/update/{id}")
    public UpdatedReservationResponse  updateReservations(@PathVariable Integer id, @Valid @RequestBody UpdateReservationRequest updateReservationRequest){
        return reservationService.updateReservations(id, updateReservationRequest);
    }

}
