package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.fine.FineForAddDto;
import com.turkcell.libraryapp.dto.fine.FineForGetDto;
import com.turkcell.libraryapp.service.FineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/fines")
public class FineController {

    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping //+
    public List<FineForGetDto> getAll() {
        return fineService.getAllWithDto();
    }

    @GetMapping("/{id}") //+
    public FineForGetDto getById(@PathVariable Integer id) {
        return fineService.getByIdWithDto(id);
    }


    @PutMapping("/{id}") //+
    public FineForGetDto update(@PathVariable Integer id, @RequestBody FineForAddDto request) {
        return fineService.updateWithDto(id, request);
    }

    //{
    //  "isPaid": false,
    //  "amount": 290
    //}

    @DeleteMapping("/{id}") //+
    public void delete(@PathVariable Integer id) {
        fineService.deleteById(id);
    }
}
