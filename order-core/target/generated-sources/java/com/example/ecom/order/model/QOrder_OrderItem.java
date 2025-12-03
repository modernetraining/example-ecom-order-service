package com.example.ecom.order.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QOrder_OrderItem is a Querydsl query type for OrderItem
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QOrder_OrderItem extends BeanPath<Order.OrderItem> {

    private static final long serialVersionUID = 1162168091;

    public static final QOrder_OrderItem orderItem = new QOrder_OrderItem("orderItem");

    public final StringPath productId = createString("productId");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QOrder_OrderItem(String variable) {
        super(Order.OrderItem.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QOrder_OrderItem(Path<? extends Order.OrderItem> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QOrder_OrderItem(PathMetadata<?> metadata) {
        super(Order.OrderItem.class, metadata);
    }

}

