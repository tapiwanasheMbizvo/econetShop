package com.tapiwanasheMbizvo.eco.etShop.services;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import com.tapiwanasheMbizvo.eco.etShop.repositories.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area save(Area area) {


        if (areaRepository.findByAreaName(area.getAreaName()).isPresent()) {

            return areaRepository.findByAreaName(area.getAreaName()).get();
        }


        return areaRepository.save(area);
    }


    public Optional<Area> findByAreaName(String areaName) {
        return areaRepository.findByAreaName(areaName);
    }

    public List<Area> findAll() {

        return  areaRepository.findAll();
    }

    public Optional<Area> findById(Long areaID) {

        return  areaRepository.findById(areaID);
    }
}
