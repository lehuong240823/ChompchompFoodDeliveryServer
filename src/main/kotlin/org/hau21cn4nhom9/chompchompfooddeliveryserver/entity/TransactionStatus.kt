package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "transaction_status", schema = "chompchomp-fooddelivery")
class TransactionStatus {
    @Id
    @Column(name = "transaction_status_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}