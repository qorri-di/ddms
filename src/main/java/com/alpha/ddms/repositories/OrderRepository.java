package com.alpha.ddms.repositories;

import com.alpha.ddms.domains.OrderModel;
import com.alpha.ddms.domains.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel,String> {
    @Query(value = "select * from trx_order where order_id LIKE concat(?1,'%') " +
            "order by order_id DESC limit 1",nativeQuery = true)
    Optional<OrderModel> findLatestId(String orderId);
}
