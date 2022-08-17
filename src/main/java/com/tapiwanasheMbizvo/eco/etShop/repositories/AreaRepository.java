package com.tapiwanasheMbizvo.eco.etShop.repositories;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository  extends JpaRepository<Area, Long> {

    Optional<Area> findByAreaName(String areaName);


}
