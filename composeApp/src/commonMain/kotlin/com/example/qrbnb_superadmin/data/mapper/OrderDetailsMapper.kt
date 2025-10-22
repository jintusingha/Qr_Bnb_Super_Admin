package com.example.qrbnb_superadmin.data.mapper

import com.example.qrbnb_superadmin.data.remote.orderdetailsdto.OrderDetailsData
import com.example.qrbnb_superadmin.domain.entity.*

fun OrderDetailsData.toDomain(): OrderDetails =
    OrderDetails(
        id = order.orderId,
        date = order.createdAtFormatted,
        status = order.status,
        restaurant =
            Restaurant(
                name = restaurant.name,
                address = restaurant.address,
                logoUrl = restaurant.logoUrl,
            ),
        customer =
            Customer(
                name = customer.name,
                phone = customer.phone,
                tableInfo = customer.tableInfo,
            ),
        items =
            items.map { itemDto ->
                Item(
                    name = itemDto.name,
                    quantity = itemDto.quantity,
                    unitPrice = itemDto.priceEach,
                    itemTotal = itemDto.total,
                    notes = itemDto.notes,
                )
            },
        subtotal = totals.subtotal,
        total = totals.total,
        tax = totals.tax,
        currency = totals.currency,
        timeline =
            timeline.map { eventDto ->
                OrderTimelineEvent(
                    status = eventDto.status,
                    time = eventDto.timeFormatted,
                    timestamp = eventDto.timestamp,
                )
            },
        metadata =
            metadata.map { metaDto ->
                MetadataPair(
                    label = metaDto.label,
                    value = metaDto.value,
                )
            },
        actions =
            actions
                .filter { it.enabled }
                .map { actionDto ->
                    OrderActionDetails(
                        id = actionDto.id,
                        label = actionDto.label,
                        endpoint = actionDto.endpoint,
                    )
                },
    )
