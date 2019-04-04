package demo.web;

import demo.model.City;
import demo.service.spi.ICityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller of City
 *
 * @author duia_builder
 * @date 2018-3-8
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Resource(name = "cityService")
    private ICityService cityService;

    @RequestMapping(value = "/findCityByProvinceName", method = RequestMethod.POST)
    @ResponseBody
    public List<City> findCityByProvinceName(String provinceName) {
        List<City> cities = cityService.findCityByProvinceName(provinceName);
        return cities;
    }


    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @ResponseBody
    public String manager() {
        return "/city/city";
    }
}
