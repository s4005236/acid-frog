package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Nutriscore(
    @SerializedName("2021")
    val x2021: X2021 = X2021(),
    @SerializedName("2023")
    val x2023: X2023 = X2023()
)