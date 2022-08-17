package com.tapiwanasheMbizvo.eco.etShop.services;

import com.tapiwanasheMbizvo.eco.etShop.models.Shop;
import com.tapiwanasheMbizvo.eco.etShop.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }


    public Optional<Shop> getShopByName(String shopName){

        return shopRepository.findByShopName(shopName);
    }

    public Shop save(Shop shop) {


        //check if the shop names exists
        if(getShopByName(shop.getShopName()).isPresent()){

            return  getShopByName(shop.getShopName()).get();
        }

        return shopRepository.save(shop);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public  List<Shop> getShopsInAreaByAreaName(String areaName) {
        return shopRepository.findByAreaName(areaName);
    }

    public  List<Shop> getShopsInAreaById(Long areaId ){

        return shopRepository.findByAreaId(areaId);
    }

}
