package com.project.coches.controller;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class CarBrandController {

    private final ICarBrandService iCarBrandService;

    @GetMapping
    public ResponseEntity<List<CarBrandPojo>> getAll(){
        return ResponseEntity.ok(iCarBrandService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo newCarBrandPojo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarBrandService.save(newCarBrandPojo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo carBrandPojo){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iCarBrandService.save(carBrandPojo));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
