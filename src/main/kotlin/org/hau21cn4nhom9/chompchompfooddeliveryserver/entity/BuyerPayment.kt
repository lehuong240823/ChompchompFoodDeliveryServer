package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(
    name = "buyer_payment", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "buyer_id", columnList = "buyer_id"),
        Index(name = "payment_method_id", columnList = "payment_method_id")
    ]
)
class BuyerPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_payment_id", nullable = false)
    var id: Int? = null

    @Column(name = "buyer_id", nullable = false)
    var buyer: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "payment_method_id", nullable = false)
    var paymentMethod: PaymentMethod? = null

    @Column(name = "bank_code", nullable = false, length = 20)
    var bankCode: String? = null

    @Column(name = "account_number", nullable = false)
    var accountNumber: String? = null

    @Column(name = "is_default", nullable = false)
    var isDefault: Boolean? = false
}