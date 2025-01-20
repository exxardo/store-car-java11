package com.carservice.storecarjava11.repository;

import com.carservice.storecarjava11.model.CarPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostModel, Long> { // Está sendo passado o CarPostModel que representa a tabela do banco de dados e o Long que é o tipo da PK.
}
