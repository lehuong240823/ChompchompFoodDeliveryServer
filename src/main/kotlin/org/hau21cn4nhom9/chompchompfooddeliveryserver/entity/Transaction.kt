package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(
    name = "transaction", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "order_id", columnList = "order_id"),
        Index(name = "payment_method_id", columnList = "payment_method_id"),
        Index(name = "buyer_payment_id", columnList = "buyer_payment_id"),
        Index(name = "transaction_status_id", columnList = "transaction_status_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "payment_method_name", columnNames = ["payment_method_name"])
    ]
)
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    var paymentMethod: PaymentMethod? = null

    @Column(name = "payment_method_name", nullable = false, length = 50)
    var paymentMethodName: String? = null

    @Column(name = "transaction_no", length = 20)
    var transactionNo: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "buyer_payment_id")
    var buyerPayment: BuyerPayment? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "transaction_status_id", nullable = false)
    var transactionStatus: TransactionStatus? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "transaction_time", nullable = false)
    var transactionTime: Instant? = null
}