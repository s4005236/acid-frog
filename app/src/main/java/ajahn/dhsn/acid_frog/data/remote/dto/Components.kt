package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Components(
    @SerializedName("negative")
    val negative: List<Negative>,
    @SerializedName("positive")
    val positive: List<Positive>
)