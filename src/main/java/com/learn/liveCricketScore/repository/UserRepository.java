package com.learn.liveCricketScore.repository;
import com.learn.liveCricketScore.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<Users, Integer> {
    @Query("SELECT u FROM Users u JOIN u.orders o JOIN o.productId p GROUP BY u ORDER BY SUM(o.quantity) DESC")
    List<Users> findTop3UsersByOrderCount(Pageable pageable);
}
