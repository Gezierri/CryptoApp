package com.example.compose_01.data.remote.dto

import com.example.compose_01.domain.model.Coin
import com.example.compose_01.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val contract: String,
    val contracts: List<Contract>,
    val description: String,
    val development_status: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("isNew")
    val is_new: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    val parent: Parent,
    val platform: String,
    @SerializedName("proofType")
    val proof_type: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    @SerializedName("whitepaper")
    val whitePaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}

