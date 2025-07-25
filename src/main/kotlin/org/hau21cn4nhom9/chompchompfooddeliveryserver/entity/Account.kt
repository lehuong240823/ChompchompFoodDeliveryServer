package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(
    name = "account", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "account_role_id", columnList = "account_role_id"),
        Index(name = "account_status_id", columnList = "account_status_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "username", columnNames = ["username"]),
        UniqueConstraint(name = "email", columnNames = ["email"])
    ]
)
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    var id: Int? = null

    @Column(name = "email", nullable = false, length = 50)
    var email: String? = null

    @Column(name = "username", nullable = false, length = 50)
    var username: String? = null

    @Column(name = "phone_number", length = 15)
    var phoneNumber: String? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_role_id", nullable = false)
    var accountRole: AccountRole? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_status_id", nullable = false)
    var accountStatus: AccountStatus? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "create_time", nullable = false)
    var createTime: Instant? = null
}