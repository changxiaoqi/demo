package demo.service;

import demo.dao.CityMapper;
import demo.model.City;
import demo.service.spi.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service Implementation:City
 *
 * @author duia_builder
 * @date 2018-3-8
 */
@Service
public class CityService  implements ICityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findCityByProvinceName(String provinceName) {
        if (StringUtils.isEmpty(provinceName)) {
            return null;
        }
        City city = new City();
        city.setName(provinceName);
        city.setLevel(1);
        List<City> cityList = cityMapper.find(city);
        if (cityList == null || cityList.isEmpty()) {
            return null;
        }
        City province = cityList.get(0);
        City city1 = new City();
        city1.setParentId(province.getId());
        List<City> cities = cityMapper.search(city1);
        return cities;
    }
}
