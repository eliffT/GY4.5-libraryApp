package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.bookReservation.request.CreateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.request.UpdateReservationRequest;
import com.turkcell.libraryapp.dto.bookReservation.response.CreateReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetAllReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.GetByIdReservationResponse;
import com.turkcell.libraryapp.dto.bookReservation.response.UpdatedReservationResponse;
import com.turkcell.libraryapp.entity.BookReservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "book.id", source = "bookId")
    BookReservation createBookRequestToBookReservation(CreateReservationRequest reservationRequest);

    @Mapping(target = "book.id", source = "bookId")
    BookReservation updateBookRequestToBookReservation(UpdateReservationRequest reservationRequest);

    CreateReservationResponse bookReservationToCreateReservationResponse(BookReservation bookReservation);

    UpdatedReservationResponse bookReservationToUpdateReservationResponse(BookReservation bookReservation);

    GetByIdReservationResponse getBookReservationToGetByIdReservationResponse(BookReservation bookReservation);
    List<GetAllReservationResponse> bookReservationToGetAllReservationResponseList(List<BookReservation> bookReservationList);

}
