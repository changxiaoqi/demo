package demo.web;

import demo.core.Result;
import demo.core.ResultGenerator;
import demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller of City
 *
 * @author duia_builder
 * @date 2018-3-8
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/findById")
    @ResponseBody
    public Result findById(Long id){
        return ResultGenerator.genSuccessResult(usersService.findById(id));
    }
}
