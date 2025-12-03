package com.example.ecom.order.repository;

import com.example.ecom.order.model.Order;
import com.example.ecom.order.model.QOrder;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        QOrder qOrder = QOrder.order;
        JPAQuery query = new JPAQuery(entityManager);

        return query.from(qOrder)
                .where(qOrder.customerId.eq(customerId))
                .list(qOrder);
    }
}
