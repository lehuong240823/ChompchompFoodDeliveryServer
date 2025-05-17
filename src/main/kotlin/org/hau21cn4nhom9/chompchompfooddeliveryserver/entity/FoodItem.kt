package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal

@Entity
@Table(
    name = "food_item", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "category_id", columnList = "category_id"),
        Index(name = "food_item_status_id", columnList = "food_item_status_id")
    ]
)
class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "category_id")
    var category: Category? = null

    @Column(name = "name", nullable = false, length = 100)
    var name: String? = null

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "image_id", nullable = false)
    var image: FoodImage? = null

    @Lob
    @Column(name = "description")
    var description: String? = null

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    var price: BigDecimal? = null

    @Column(name = "stock", nullable = false)
    var stock: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "food_item_status_id", nullable = false)
    var foodItemStatus: FoodItemStatus? = null
}