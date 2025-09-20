package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.fine.request.FineRequest;
import com.turkcell.libraryapp.dto.fine.response.FinePayResponse;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
import com.turkcell.libraryapp.entity.Fine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FineMapper {

    @Mapping(target="loanId", source = "loan.id")
    FineResponse  fineToFineResponse(Fine fine);
    @Mapping(target="loanId", source = "loan.id")
    FinePayResponse fineToFinePayResponse(Fine fine);
    @Mapping(target = "loan.id", source = "loanId")
    Fine fineRequestToFine(FineRequest request);
    @Mapping(target = "loanId", source = "loan.id")
    List<FineResponse> fineToFineResponseList(List<Fine> fines);

}
