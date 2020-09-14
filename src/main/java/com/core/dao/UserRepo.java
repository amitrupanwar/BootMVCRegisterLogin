package com.core.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.core.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, String> {

}
