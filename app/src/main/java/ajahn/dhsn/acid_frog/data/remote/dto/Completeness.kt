package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Completeness(
    @SerializedName("general_information")
    val generalInformation: String = "",
    @SerializedName("ingredients")
    val ingredients: String = "",
    @SerializedName("nutrition")
    val nutrition: String = "",
    @SerializedName("overall")
    val overall: String = "",
    @SerializedName("packaging")
    val packaging: String = ""
)