package com.noureldin.route.data

import com.noureldin.route.model.Dimensions
import com.noureldin.route.model.Meta
import com.noureldin.route.model.Product
import com.noureldin.route.model.ProductEntity
import com.noureldin.route.model.Review

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tags = tags.joinToString(","),
        brand = brand ?: "",  // Provide a default value or handle null appropriately
        sku = sku,
        weight = weight,
        width = dimensions.width,
        height = dimensions.height,
        depth = dimensions.depth,
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviews = reviews.joinToString(separator = "|") { "${it.rating}:${it.comment}:${it.date}:${it.reviewerName}:${it.reviewerEmail}" },
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        createdAt = meta.createdAt,
        updatedAt = meta.updatedAt,
        barcode = meta.barcode,
        qrCode = meta.qrCode,
        images = images.joinToString(","),
        thumbnail = thumbnail
    )
}
fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tags = tags.split(","),
        brand = brand,
        sku = sku,
        weight = weight,
        dimensions = Dimensions(width, height, depth),
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviews = reviews.split("|").map {
            val parts = it.split(":")
            Review(parts[0].toInt(), parts[1], parts[2], parts[3], parts[4])
        },
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        meta = Meta(createdAt, updatedAt, barcode, qrCode),
        images = images.split(","),
        thumbnail = thumbnail
    )
}
