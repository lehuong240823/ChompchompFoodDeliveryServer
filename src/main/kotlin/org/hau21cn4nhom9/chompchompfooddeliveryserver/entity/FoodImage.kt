package org.hau21cn4nhom9.chompchompfooddeliveryserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "food_image", schema = "chompchomp-fooddelivery")
class FoodImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    var id: Int? = null

    @Column(name = "image_url")
    var imageUrl: String? = null
}