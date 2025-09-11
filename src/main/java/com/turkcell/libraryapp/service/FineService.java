package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.fine.FineForAddDto;
import com.turkcell.libraryapp.dto.fine.FineForGetDto;
import com.turkcell.libraryapp.entity.Fine;
import com.turkcell.libraryapp.repository.FineRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FineService {

    private final FineRepository fineRepository;

    public FineService(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }


    public List<FineForGetDto> getAllWithDto() {
        List<Fine> fineList = fineRepository.findAll();
        List<FineForGetDto> response = new ArrayList<>();

        for (Fine fine : fineList) {
            FineForGetDto dto = new FineForGetDto();
            dto.setId(fine.getId());
            dto.setIsPaid(fine.getIspaid());
            dto.setAmount(fine.getAmount());
            response.add(dto);
        }
        return response;
    }

    public FineForGetDto getByIdWithDto(Integer id) {
        Fine fine = fineRepository.findById(id).orElseThrow();

        FineForGetDto dto = new FineForGetDto();
        dto.setId(fine.getId());
        dto.setIsPaid(fine.getIspaid());
        dto.setAmount(fine.getAmount());
        return dto;
    }

    public FineForGetDto updateWithDto(Integer id, FineForAddDto request) {
        Fine fine = fineRepository.findById(id).orElseThrow();

        fine.setIspaid(request.getIsPaid());
        fine.setAmount(request.getAmount());

        Fine updated = fineRepository.save(fine);

        FineForGetDto dto = new FineForGetDto();
        dto.setId(updated.getId());
        dto.setIsPaid(updated.getIspaid());
        dto.setAmount(updated.getAmount());
        return dto;
    }


    public void deleteById(Integer id) {
        fineRepository.deleteById(id);
    }
}
