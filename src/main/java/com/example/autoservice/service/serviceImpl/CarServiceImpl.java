package com.example.autoservice.service.serviceImpl;

import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.PartDTO;
import com.example.autoservice.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public CarDTO createCar(CarDTO carDTO) {
        return null;
    }

    @Override
    public CarDTO getCarById(Long carId) {
        return null;
    }

    @Override
    public CarDTO updateCar(Long carId, CarDTO carDTO) {
        return null;
    }

    @Override
    public boolean deleteCar(Long carId) {
        return false;
    }

    @Override
    public List<CarDTO> getAllCars(Integer offset, Integer limit, String sortBy) {
        return null;
    }

    @Override
    public boolean installOrReplaceParts(Long carId, List<PartDTO> parts) {
        return false;
    }

    @Override
    public List<CarDTO> searchCars(String vin, String manufacturer, String brand, Integer year, Integer stateNumber) {
        return null;
    }
}
