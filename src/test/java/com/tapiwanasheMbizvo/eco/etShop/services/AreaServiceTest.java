package com.tapiwanasheMbizvo.eco.etShop.services;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import com.tapiwanasheMbizvo.eco.etShop.repositories.AreaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AreaServiceTest {


    @Autowired
    private AreaService areaService;



    @Test
    void save() {

            Area area = new Area();

            String areaname = "TEST AREA";
            area.setAreaName(areaname);


            areaService.save(area);

            Assertions.assertThat(areaService.findByAreaName(areaname).isPresent()).isTrue();

    }
}