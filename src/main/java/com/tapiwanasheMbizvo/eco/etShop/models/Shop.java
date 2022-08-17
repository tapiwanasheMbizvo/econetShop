package com.tapiwanasheMbizvo.eco.etShop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String shopName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    @JsonBackReference
    private Area area;

    public Shop() {
    }

    public Shop(Long id, String shopName, Area area) {
        this.id = id;
        this.shopName = shopName;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
