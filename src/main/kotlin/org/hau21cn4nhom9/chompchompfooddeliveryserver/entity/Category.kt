package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "category", schema = "chompchomp-fooddelivery")
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null

    @Column(name = "image")
    var image: String? = null
}