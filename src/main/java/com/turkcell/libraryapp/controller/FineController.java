package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.fine.request.FineRequest;
import com.turkcell.libraryapp.dto.fine.response.FinePayResponse;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
import com.turkcell.libraryapp.service.FineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fines")
public class FineController {

    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FineResponse createFine(@Valid @RequestBody FineRequest request) {
        return fineService.createFine(request);
    }

    @GetMapping
    public List<FineResponse> getAllFines() {
        return fineService.getAllFines();
    }

    @GetMapping("/{id}")
    public FineResponse getFineById(@PathVariable Integer id) {
        return fineService.getFineById(id);
    }

    @PutMapping("/{id}")
    public FineResponse updateFine(@PathVariable Integer id, @RequestBody FineRequest request) {
        return fineService.updateFine(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteFine(@PathVariable Integer id) {
        fineService.deleteFineById(id);
    }

    @GetMapping("/members/{id}")
    public List<FineResponse> getFineByUserId(@PathVariable Integer id) {
        return fineService.getFineByUserId(id);
    }

    @PostMapping("/{id}/pay")
    public FinePayResponse payFine(@PathVariable Integer id) {
        return fineService.payFine(id);
    }
}
