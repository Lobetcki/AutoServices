package com.example.autoservice.controller;

import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.DriverDTO;
import com.example.autoservice.dto.PartDTO;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.DriverService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarsController {

    private final CarService carService;
    private final DriverService driverService;

    public CarsController(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    //1 Создание авто
    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        CarDTO createdCar = carService.createCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    //2 Информация о авто
    @GetMapping("/{carId}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long carId) {
        CarDTO carDTO = carService.getCarById(carId);
        if (carDTO != null) {
            return ResponseEntity.ok(carDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //3 Изменить информацию об авто
    @PutMapping("/{carId}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long carId, @RequestBody CarDTO carDTO) {
        CarDTO updatedCar = carService.updateCar(carId, carDTO);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //4 Удалить авто
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        boolean deleted = carService.deleteCar(carId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //5 Информация об водителе авто
    @GetMapping("/{carId}/drivers")
    public ResponseEntity<List<DriverDTO>> getCarDrivers(@PathVariable Long carId) {
        List<DriverDTO> drivers = driverService.getDriversByCarId(carId);
        if (!drivers.isEmpty()) {
            return ResponseEntity.ok(drivers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //6 Получение всех авто
    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) Integer page,
            @RequestParam(value = "size", defaultValue = "20") @Min(1) @Max(100) Integer size,
            @RequestParam(required = false) String sortBy) {
        List<CarDTO> cars = carService.getAllCars(page, size, sortBy);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //7 Установка или замены деталей в авто
    @PostMapping("/{carId}/parts")
    public ResponseEntity<Void> installOrReplaceParts(@PathVariable Long carId, @RequestBody List<PartDTO> parts) {
        boolean updated = carService.installOrReplaceParts(carId, parts);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //8 Поиск авто
    @GetMapping("/search")
    public ResponseEntity<List<CarDTO>> searchCars(@RequestParam(required = false) String vin,
                                                   @RequestParam(required = false) String manufacturer,
                                                   @RequestParam(required = false) String brand,
                                                   @RequestParam(required = false) Integer year,
                                                   @RequestParam(required = false) Integer stateNumber) {
        List<CarDTO> cars = carService.searchCars(vin, manufacturer, brand, year, stateNumber);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}



