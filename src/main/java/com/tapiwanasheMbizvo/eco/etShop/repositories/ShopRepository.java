package com.tapiwanasheMbizvo.eco.etShop.repositories;

import com.tapiwanasheMbizvo.eco.etShop.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query("select s from Shop s where s.area.areaName = ?1")
    List<Shop> findByAreaName(String areaName);

    @Query("select s from Shop s where s.area.id = ?1")
    List<Shop> findByAreaId(Long id);


    Optional<Shop> findByShopName(String shopName);
}
