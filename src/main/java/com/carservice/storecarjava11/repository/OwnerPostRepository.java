package com.carservice.storecarjava11.repository;

import com.carservice.storecarjava11.model.OwnerPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostModel, Long> { // Está sendo passado o OwnerPostModel que representa a tabela do banco de dados e o Long que é o tipo da PK.
}
