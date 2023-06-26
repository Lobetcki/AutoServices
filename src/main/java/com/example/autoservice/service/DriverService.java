package com.example.autoservice.service;

import com.example.autoservice.dto.BalanceDTO;
import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.DriverDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    List<DriverDTO> getDriversByCarId(Long carId);

    List<DriverDTO> getAllDrivers(Integer page, Integer size, String sortBy);

    DriverDTO createDriver(DriverDTO driverDTO);

    DriverDTO getDriverById(Long id);

    DriverDTO updateDriver(Long id, DriverDTO driverDTO);

    boolean deleteDriver(Long id);

    List<CarDTO> getDriverCars(Long id);

    boolean assignCarToDriver(Long id, Long carId);

    BalanceDTO getBalance(Long driverId, String currency);
}
