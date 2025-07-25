package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(
    name = "administrator", schema = "chompchomp-fooddelivery", indexes = [
        Index(name = "account_id", columnList = "account_id"),
        Index(name = "access_level_id", columnList = "access_level_id")
    ]
)
class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    var id: Int? = null

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "access_level_id", nullable = false)
    var accessLevel: AccessLevel? = null
}