package com.tapiwanasheMbizvo.eco.etShop.controllers;


import com.tapiwanasheMbizvo.eco.etShop.models.Shop;
import com.tapiwanasheMbizvo.eco.etShop.services.AreaService;
import com.tapiwanasheMbizvo.eco.etShop.services.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/econetShop/api/v1/shops")
public class ShopController {


    private final ShopService shopService;
    private  final AreaService areaService;

    public ShopController(ShopService shopService,
                          AreaService areaService) {
        this.shopService = shopService;
        this.areaService = areaService;
    }



    @PostMapping
    public ResponseEntity createShop(@RequestBody Shop shop) {
        //if the area does not exist the endpoint will return a bad request

        shop.setShopName(shop.getShopName().toUpperCase());
        if (areaService.findByAreaName(shop.getArea().getAreaName()).isPresent()) {
            return ResponseEntity.badRequest().body("Area does with name "+areaService.findByAreaName(shop.getArea().getAreaName())+" not exist");
        }
        if(shopService.getShopByName(shop.getShopName()).isPresent()){

            return ResponseEntity.badRequest().body("Shop with name "+shop.getShopName()+"   already exists");
        }
            return ResponseEntity.ok(shopService.save(shop));
    }


    @GetMapping("/{id}")
    public ResponseEntity getAllShopsInAreaWithGivenId( @PathVariable(name = "id") Long areaID){



        if(areaService.findById(areaID).isPresent()){

        return  ResponseEntity.ok(shopService.getShopsInAreaById(areaID));

        }else{

            return  ResponseEntity.badRequest().body("Area with id "+areaID+" does not exist");
        }
    }
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.findAll();
    }

}
