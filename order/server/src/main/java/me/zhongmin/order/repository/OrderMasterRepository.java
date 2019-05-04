package me.zhongmin.order.repository;

import me.zhongmin.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**

 * 2017-12-10 16:11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
