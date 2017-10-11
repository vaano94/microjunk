package com.microtest.repository;

import com.microtest.domain.NotificationLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by john on 10/11/17.
 */
@Repository
public interface NotificationRepository extends CrudRepository<NotificationLog, Long> {


}
