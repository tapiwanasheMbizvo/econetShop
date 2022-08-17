package com.tapiwanasheMbizvo.eco.etShop.DataLoader;

import com.tapiwanasheMbizvo.eco.etShop.models.Area;
import com.tapiwanasheMbizvo.eco.etShop.models.Shop;
import com.tapiwanasheMbizvo.eco.etShop.services.AreaService;
import com.tapiwanasheMbizvo.eco.etShop.services.ShopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Faker {

    @Bean
    CommandLineRunner commandLineRunnerFundCodeFaker(
            AreaService areaService,
            ShopService shopService) {
        return args->{


            Area area = new Area();
            area.setAreaName("MUTARE CBD");

            areaService.save(area);

            area = new Area();
            area.setAreaName("HARARE CBD");
            areaService.save(area);


            Shop shop = new Shop();
            shop.setShopName("MUTARE CBD SHOP 1");
            shop.setArea(areaService.findByAreaName("MUTARE CBD").get());
            shopService.save(shop);
            shop = new Shop();
            shop.setShopName("MUTARE CBD SHOP 2");
            shop.setArea(areaService.findByAreaName("MUTARE CBD").get());
            shopService.save(shop);


            shop = new Shop();
            shop.setShopName("HARARE CBD SHOP 1");
            shop.setArea(areaService.findByAreaName("HARARE CBD").get());
            shopService.save(shop);

            shop = new Shop();
            shop.setShopName("HARARE CBD SHOP 2");
            shop.setArea(areaService.findByAreaName("HARARE CBD").get());
            shopService.save(shop);



        };


    }

}
