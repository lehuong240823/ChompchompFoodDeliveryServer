package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault

@Entity
@Table(
    name = "review", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "order_item_id", columnList = "order_item_id")
    ]
)
class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_item_id", nullable = false)
    var orderItem: OrderItem? = null

    @ColumnDefault("5")
    @Column(name = "rating", nullable = false)
    var rating: Int? = null

    @Lob
    @Column(name = "content")
    var content: String? = null
}