package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(
    name = "cart", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "buyer_id_2", columnList = "buyer_id"),
        Index(name = "food_item_id", columnList = "food_item_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "buyer_id", columnNames = ["buyer_id", "food_item_id"])
    ]
)
class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    var id: Int? = null

    @Column(name = "buyer_id", nullable = false)
    var buyer: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "food_item_id", nullable = false)
    var foodItem: FoodItem? = null

    @ColumnDefault("1")
    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "added_at", nullable = false)
    var addedAt: Instant? = null
}