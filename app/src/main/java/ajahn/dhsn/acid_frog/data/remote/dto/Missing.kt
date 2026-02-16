package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Missing(
    @SerializedName("labels")
    val labels: Int
)