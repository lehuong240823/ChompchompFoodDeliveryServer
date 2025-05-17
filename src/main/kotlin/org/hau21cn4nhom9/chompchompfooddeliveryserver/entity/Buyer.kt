package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "buyer", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "account_id", columnList = "account_id")
    ]
)
class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id", nullable = false)
    var id: Int? = null

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null

    @Column(name = "full_name", nullable = false, length = 100)
    var fullName: String? = null
}