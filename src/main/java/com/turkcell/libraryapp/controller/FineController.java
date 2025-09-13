package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.fine.request.FineRequest;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
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

    @PostMapping
    public FineResponse add(@RequestBody FineRequest request) {
        return fineService.addWithDto(request);
    }

    @GetMapping
    public List<FineResponse> getAll() {
        return fineService.getAllWithDto();
    }

    @GetMapping("/{id}")
    public FineResponse getById(@PathVariable Integer id) {
        return fineService.getByIdWithDto(id);
    }

    @PutMapping("/{id}")
    public FineResponse update(@PathVariable Integer id, @RequestBody FineRequest request) {
        return fineService.updateWithDto(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fineService.deleteById(id);
    }
}
