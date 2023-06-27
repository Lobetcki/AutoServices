package com.example.autoservice.controller;

import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.DriverDTO;
import com.example.autoservice.dto.BalanceDTO;
import com.example.autoservice.service.DriverService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriversController {

    private final DriverService driverService;

    public DriversController(DriverService driverService) {
        this.driverService = driverService;
    }

    //1 Создание водителя
    @PostMapping
    public ResponseEntity<DriverDTO> createDriver(@RequestBody DriverDTO driverDTO) {
        DriverDTO createdDriver = driverService.createDriver(driverDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDriver);
    }

    //2 Информация о водителе
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
        DriverDTO driverDTO = driverService.getDriverById(id);
        if (driverDTO != null) {
            return ResponseEntity.ok(driverDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //3 Изменить информацию водителе
    @PutMapping("/{driverId}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable Long id, @RequestBody DriverDTO driverDTO) {
        DriverDTO updatedDriver = driverService.updateDriver(id, driverDTO);
        if (updatedDriver != null) {
            return ResponseEntity.ok(updatedDriver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //4 Удалить водителя
    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        boolean deleted = driverService.deleteDriver(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Получение всех водителей
    @GetMapping("/all")
    public ResponseEntity<List<DriverDTO>> getAllDrivers(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) Integer page,
            @RequestParam(value = "size", defaultValue = "20") @Min(1) @Max(100) Integer size,
            @RequestParam(required = false) String sortBy) {
        List<DriverDTO> drivers = driverService.getAllDrivers(page, size, sortBy);
        if (!drivers.isEmpty()) {
            return ResponseEntity.ok(drivers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Дополнительные методы для реализации бизнес-требований

    //5 Информация об авто водителя
    @GetMapping("/{driverId}/cars")
    public ResponseEntity<List<CarDTO>> getDriverCars(@PathVariable Long id) {
        List<CarDTO> cars = driverService.getDriverCars(id);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //6 Назначение авто для водителя
    @PostMapping("/{id}/cars/{carId}")
    public ResponseEntity<Void> assignCarToDriver(@PathVariable Long id, @PathVariable Long carId) {
        boolean assigned = driverService.assignCarToDriver(id, carId);
        if (assigned) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //7 Соотояние счета водителя в определенной валюте
    @GetMapping("/{driverId}/balance/{currency}")
    public ResponseEntity<BalanceDTO> getDriverBalance(@PathVariable Long driverId,
                                                       @PathVariable String currency) {
        BalanceDTO balanceDTO = driverService.getBalance(driverId, currency);
        if (balanceDTO != null) {
            return ResponseEntity.ok(balanceDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
