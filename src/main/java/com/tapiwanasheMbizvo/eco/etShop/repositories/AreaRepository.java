package com.tapiwanasheMbizvo.eco.etShop.repositories;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository  extends JpaRepository<Area, Long> {

    Area findByAreaName(String areaName);


}
