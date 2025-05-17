package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal

@Entity
@Table(
    name = "order_item", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "order_id", columnList = "order_id"),
        Index(name = "food_item_id", columnList = "food_item_id")
    ]
)
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    var id: Int? = null

    @Column(name = "order_id", nullable = false)
    var order: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "food_item_id")
    var foodItem: FoodItem? = null

    @Column(name = "food_item_name")
    var foodItemName: String? = null

    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @Column(name = "price", nullable = false, precision = 15, scale = 2)
    var price: BigDecimal? = null
}