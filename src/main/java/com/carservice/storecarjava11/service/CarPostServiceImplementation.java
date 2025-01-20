package com.carservice.storecarjava11.service;

import com.carservice.storecarjava11.dto.CarPostDto;
import com.carservice.storecarjava11.model.CarPostModel;
import com.carservice.storecarjava11.repository.CarPostRepository;
import com.carservice.storecarjava11.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImplementation implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDto carPostDto) {
        CarPostModel carPostModel = mapCarDtoToModel(carPostDto  );
        carPostRepository.save(carPostModel);
    }

    @Override
    public List<CarPostDto> getCarSales() {
        List<CarPostDto> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarsSales.add(mapCarModelToDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDto carPostDto, Long postId) {

        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDto.getDescription());
            item.setContact(carPostDto.getContact());
            item.setPrice(carPostDto.getPrice());
            item.setBrand(carPostDto.getBrand());
            item.setEngineVersion(carPostDto.getEngineVersion());
            item.setModel(carPostDto.getModel());

            carPostRepository.save(item);

        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostModel mapCarDtoToModel(CarPostDto carPostDto) {
        CarPostModel carPostModel = new CarPostModel();

        ownerPostRepository.findById(carPostDto.getOwnerId()).ifPresentOrElse(item->{
            carPostModel.setOwnerPost(item);
            carPostModel.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostModel.setModel(carPostDto.getModel());
        carPostModel.setBrand(carPostDto.getBrand());
        carPostModel.setPrice(carPostDto.getPrice());
        carPostModel.setCity(carPostDto.getCity());
        carPostModel.setDescription(carPostDto.getDescription());
        carPostModel.setEngineVersion(carPostDto.getEngineVersion());
        carPostModel.setCreatedDate(String.valueOf(new Date()));

        return carPostModel;
    }

    private CarPostDto mapCarModelToDTO(CarPostModel carPostModel){

        return CarPostDto.builder()
                .brand(carPostModel.getBrand())
                .city(carPostModel.getCity())
                .model(carPostModel.getModel())
                .description(carPostModel.getDescription())
                .engineVersion(carPostModel.getEngineVersion())
                .createdDate(carPostModel.getCreatedDate())
                .ownerName(carPostModel.getOwnerPost().getName())
                .price(carPostModel.getPrice()).build();

    }

}
