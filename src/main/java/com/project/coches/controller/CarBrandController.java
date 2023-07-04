package com.project.coches.controller;

import com.project.coches.domain.dto.CarBrandDto;
import com.project.coches.domain.useCase.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/car-brands")
public class CarBrandController {

    private final ICarBrandService iCarBrandService;

    @GetMapping
    public ResponseEntity<List<CarBrandDto>> getAll(){
        return ResponseEntity.ok(iCarBrandService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandDto> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    @PostMapping
    public ResponseEntity<CarBrandDto> save(@RequestBody CarBrandDto newCarBrandDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarBrandService.save(newCarBrandDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping
    public ResponseEntity<CarBrandDto> update(@RequestBody CarBrandDto carBrandDto){
        return ResponseEntity.of(iCarBrandService.update(carBrandDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
