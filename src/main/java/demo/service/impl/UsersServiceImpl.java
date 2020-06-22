package demo.service.impl;

import demo.core.AbstractService;
import demo.dao.UsersMapper;
import demo.model.Users;
import demo.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service Implementation:City
 *
 * @author duia_builder
 * @date 2018-3-8
 */
@Service
public class UsersServiceImpl extends AbstractService<Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;


    @Override
    public Users findById(Long id) {
        return this.findById(id);
    }
}
