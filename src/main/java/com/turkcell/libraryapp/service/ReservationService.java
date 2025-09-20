package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.bookReservation.request.CreateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.request.UpdateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.response.CreateReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetAllReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetByIdReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.UpdatedReservationResponse;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.BookReservation;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.mapper.ReservationMapper;
import com.turkcell.libraryapp.repository.BookRepository;
import com.turkcell.libraryapp.repository.ReservationRepository;
import com.turkcell.libraryapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Validated
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, BookRepository bookRepository,
                              UserRepository userRepository,  ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<GetAllReservationResponse> getAllReservations(){
        List<BookReservation> bookReservationList = reservationRepository.findAll();
        return reservationMapper.bookReservationToGetAllReservationResponseList(bookReservationList);
    }

    public CreateReservationResponse createReservations(@Valid CreateReservationRequest createReservationRequest){
        BookReservation bookReservation = reservationMapper.createBookRequestToBookReservation(createReservationRequest);

        // Buraya cezaı olan kullanıcıların rezervasyon yapmaması için iş kuralı...

        Book book = bookRepository.findById(createReservationRequest.getBookId()).
                orElseThrow(()->new NotFoundException("Book not found"));
        User user = userRepository.findById(createReservationRequest.getUserId())
                .orElseThrow(()->new NotFoundException("User not found"));

        bookReservation.setBook(book);
        bookReservation.setUser(user);

        BookReservation reservationSaved = reservationRepository.save(bookReservation);

        return reservationMapper.bookReservationToCreateReservationResponse(reservationSaved);
    }

    public GetByIdReservationResponse getReservationById(Integer id){
        BookReservation bookReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found with id: " + id));

        return reservationMapper.getBookReservationToGetByIdReservationResponse(bookReservation);
    }

    public void deleteReservation(Integer id){
        if(!reservationRepository.existsById(id)){
            throw new NotFoundException("Reservation not found with id: " + id);
        }
        reservationRepository.deleteById(id);
    }

    public UpdatedReservationResponse updateReservations(Integer id, @Valid UpdateReservationRequest request) {
        BookReservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found with id: " + id));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(()->new NotFoundException("Book not found"));

        reservation.setReservationDate(request.getReservationDate());
        reservation.setBook(book);
        BookReservation updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.bookReservationToUpdateReservationResponse(updatedReservation);
    }
}
