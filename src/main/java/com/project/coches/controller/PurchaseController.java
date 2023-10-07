package com.project.coches.controller;

import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.response.PurchaseBillResponseDto;
import com.project.coches.domain.dto.response.PurchaseResponseDto;
import com.project.coches.domain.useCase.IPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/purchases")
public class PurchaseController {

    private final IPurchaseService iPurchaseService;

    @GetMapping()
    public ResponseEntity<List<PurchaseResponseDto>> getAll() {
        return ResponseEntity.ok(iPurchaseService.getAll());
    }

    @GetMapping(path = "/customers/{cardId}")
    public ResponseEntity<List<PurchaseResponseDto>> getPurchasesByIdCustomer(@PathVariable String cardId) {
        return ResponseEntity.ok(iPurchaseService.getByIdCustomer(cardId));
    }

    @GetMapping(path = "/{numberBill}")
    public ResponseEntity<PurchaseResponseDto> getPurchasesByNumberBill(@PathVariable Integer numberBill) {
        return ResponseEntity.ok(iPurchaseService.getByNumberBill(numberBill));
    }

    @PostMapping()
    public ResponseEntity<PurchaseBillResponseDto> savePurchase(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iPurchaseService.save(purchaseRequestDto));
    }
}
