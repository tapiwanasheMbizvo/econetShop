package com.tapiwanasheMbizvo.eco.etShop.controllers;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import com.tapiwanasheMbizvo.eco.etShop.models.Shop;
import com.tapiwanasheMbizvo.eco.etShop.services.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/econetShop/api/v1/areas")
public class AreaController {


    private  final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }



    @PostMapping
    public ResponseEntity createAnArea(@RequestBody Area area) {

        area.setAreaName(area.getAreaName().toUpperCase());

        if(areaService.findByAreaName(area.getAreaName()).isPresent()){

            return  ResponseEntity.badRequest().body("Area with area name "+area.getAreaName()+" Already exits");

        }

        return  ResponseEntity.ok(areaService.save(area));
    }
    @GetMapping()
    public List<Area> getAllAreas() {

        return areaService.findAll();
    }



}
