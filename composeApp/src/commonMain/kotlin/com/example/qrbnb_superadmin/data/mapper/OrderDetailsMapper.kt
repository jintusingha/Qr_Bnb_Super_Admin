package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.ClientDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.CustomerDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.ItemDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.MetadataDto

import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.OrderDetailsDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.SummaryDto
import com.example.qrbnb_superadmin.data.remote.model.orderdetailsdto.TimelineDto
import com.example.qrbnb_superadmin.domain.entity.*

fun OrderDetailsDto.toDomain() = OrderDetails(
    orderId = orderId,
    createdAt = createdAt,
    customer = customer.toDomain(),
    items = items.map { it.toDomain() },
    summary = summary.toDomain(),
    timeline = timeline.map { it.toDomain() },
)

fun ClientDto.toDomain(): ClientOrderDetails =
    ClientOrderDetails(
        name = name,
        address = address
    )

fun CustomerDto.toDomain() = Customer(
    name = name,
    phone = phone,
    seatingName = seatingArea.name
)


fun ItemDto.toDomain(): Item =
    Item(
        name = name,
        quantity = quantity,
        priceEach = priceEach,
        notes = notes,
        subtotal = subtotal
    )

fun SummaryDto.toDomain(): SummaryDomain =
    SummaryDomain(
        subtotal = subtotal,
        taxes = taxes,
        total = total
    )

fun TimelineDto.toDomain(): TimelineEventOrderDetails =
    TimelineEventOrderDetails(
        status = status,
        time = time
    )

fun MetadataDto.toDomain(): Metadata =
    Metadata(
        creator = creator,
        paymentMethod = paymentMethod,
        platform = platform
    )
