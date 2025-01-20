package com.carservice.storecarjava11.model;

import com.carservice.storecarjava11.model.OwnerPostModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tb_car_post")
@Data
@NoArgsConstructor
public class CarPostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engine_version")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_create_date")
    private String createdDate;

    @Column(name = "car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostModel ownerPost;

}
