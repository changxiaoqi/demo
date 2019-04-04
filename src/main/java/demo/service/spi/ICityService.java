package demo.service.spi;


import demo.model.City;

import java.util.List;

/**
 * Service Interface:City
 * @author duia_builder
 * @date 2018-3-8
 */
public interface ICityService  {

    /**
     *根据省份的名字查找下面的城市
     * @param provinceName
     * @return
     */
    List<City> findCityByProvinceName(String provinceName);


}