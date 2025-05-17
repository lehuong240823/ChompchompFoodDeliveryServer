package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "access_level", schema = "chompchomp-fooddelivery", uniqueConstraints = [
        UniqueConstraint(name = "name", columnNames = ["name"])
    ]
)
class AccessLevel {
    @Id
    @Column(name = "access_level_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}