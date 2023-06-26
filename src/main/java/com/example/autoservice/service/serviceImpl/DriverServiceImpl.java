package com.example.autoservice.service.serviceImpl;

import com.example.autoservice.dto.BalanceDTO;
import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.DriverDTO;
import com.example.autoservice.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    @Override
    public List<DriverDTO> getDriversByCarId(Long carId) {
        return null;
    }

    @Override
    public List<DriverDTO> getAllDrivers(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {
        return null;
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        return null;
    }

    @Override
    public DriverDTO updateDriver(Long id, DriverDTO driverDTO) {
        return null;
    }

    @Override
    public boolean deleteDriver(Long id) {
        return false;
    }

    @Override
    public List<CarDTO> getDriverCars(Long id) {
        return null;
    }

    @Override
    public boolean assignCarToDriver(Long id, Long carId) {
        return false;
    }

    @Override
    public BalanceDTO getBalance(Long driverId, String currency) {
        return null;
    }
}
