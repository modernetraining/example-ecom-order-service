package com.example.ecom.order.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -346012120;

    public static final QOrder order = new QOrder("order1");

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Order.OrderItem, QOrder_OrderItem> items = this.<Order.OrderItem, QOrder_OrderItem>createList("items", Order.OrderItem.class, QOrder_OrderItem.class, PathInits.DIRECT2);

    public final StringPath orderId = createString("orderId");

    public final NumberPath<java.math.BigDecimal> totalAmount = createNumber("totalAmount", java.math.BigDecimal.class);

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QOrder(Path<? extends Order> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata<?> metadata) {
        super(Order.class, metadata);
    }

}

