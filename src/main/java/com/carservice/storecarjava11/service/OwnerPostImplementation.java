package com.carservice.storecarjava11.service;

import com.carservice.storecarjava11.dto.OwnerPostDto;
import com.carservice.storecarjava11.model.OwnerPostModel;
import com.carservice.storecarjava11.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDto ownerPostDto) {

        OwnerPostModel ownerPost = new OwnerPostModel();
        ownerPost.setName(ownerPostDto.getName());
        ownerPost.setType(ownerPostDto.getType());
        ownerPost.setContactNumber(ownerPostDto.getContactNumber());

        ownerPostRepository.save(ownerPost);

    }
}

