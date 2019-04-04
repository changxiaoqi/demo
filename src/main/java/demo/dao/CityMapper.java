package demo.dao;


import demo.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Dao Interface:City
 * @author duia_builder
 * @date 2018-3-8
 */
@Mapper
public interface CityMapper  {
    List<City> search(City city);

    List<City> find(City city);
}