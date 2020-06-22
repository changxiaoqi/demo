package demo.service;


import demo.core.Service;
import demo.model.Users;

/**
 * Service Interface:City
 * @author duia_builder
 * @date 2018-3-8
 */
public interface UsersService extends Service<Users> {
    Users findById(Long id);
}