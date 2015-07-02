package com.sandlex.run2gather.mongo;

import com.sandlex.run2gather.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author apeskov
 */
@Repository
public interface ActivityRepository extends CrudRepository<Activity, String> {
}
