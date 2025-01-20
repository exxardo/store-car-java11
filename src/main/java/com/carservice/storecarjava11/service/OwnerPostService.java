package com.carservice.storecarjava11.service;

import com.carservice.storecarjava11.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDto ownerPostDto);

}

