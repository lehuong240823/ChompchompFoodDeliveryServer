package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "payment_method", schema = "chompchomp-fooddelivery", uniqueConstraints = [
        UniqueConstraint(name = "name", columnNames = ["name"])
    ]
)
class PaymentMethod {
    @Id
    @Column(name = "payment_method_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}