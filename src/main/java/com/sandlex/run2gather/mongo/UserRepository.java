package com.sandlex.run2gather.mongo;

import com.sandlex.run2gather.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * author: Alexey Peskov
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
