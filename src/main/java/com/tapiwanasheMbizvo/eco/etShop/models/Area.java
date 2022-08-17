package com.tapiwanasheMbizvo.eco.etShop.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shop_area")
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String areaName;

    @OneToMany
    @JoinColumn(name = "shop_id")
    @JsonBackReference
    private Set<Shop> shops;


    public  Area (String areaName){

        this.areaName =areaName;
    }

    public  Area (Long id){

        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Set<Shop> getShops() {
        return shops;
    }
    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
