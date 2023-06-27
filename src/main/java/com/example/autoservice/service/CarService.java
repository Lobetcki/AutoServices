package com.example.autoservice.service;

import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.dto.PartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    CarDTO createCar(CarDTO carDTO);

    CarDTO getCarById(Long carId);

    CarDTO updateCar(Long carId, CarDTO carDTO);

    boolean deleteCar(Long carId);

    List<CarDTO> getAllCars(Integer offset, Integer limit, String sortBy);

    boolean installOrReplaceParts(Long carId, List<PartDTO> parts);

    List<CarDTO> searchCars(String vin, String manufacturer, String brand, Integer year, Integer stateNumber);
}
