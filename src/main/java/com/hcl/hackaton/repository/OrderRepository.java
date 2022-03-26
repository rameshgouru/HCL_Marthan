/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : this repo class to interact with Order Details table
 */
package com.hcl.hackaton.repository;

import com.hcl.hackaton.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
