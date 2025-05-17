package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(
    name = "orders", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "buyer_id", columnList = "buyer_id"),
        Index(name = "order_status_id", columnList = "order_status_id"),
        Index(name = "buyer_address_id", columnList = "buyer_address_id"),
        Index(name = "voucher_id", columnList = "voucher_id")
    ]
)
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    var id: Int? = null

    @Column(name = "buyer_id", nullable = false)
    var buyer: Int? = null

    @Column(name = "amount", nullable = false, precision = 20, scale = 2)
    var amount: BigDecimal? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_status_id", nullable = false)
    var orderStatus: OrderStatus? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "buyer_address_id")
    var buyerAddress: BuyerAddress? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voucher_id")
    var voucher: Voucher? = null

    @Column(name = "address", nullable = false, length = 500)
    var address: String? = null

    @Column(name = "tracking_number", length = 50)
    var trackingNumber: String? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null
}