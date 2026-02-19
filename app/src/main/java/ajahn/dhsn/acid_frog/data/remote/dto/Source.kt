package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("fields")
    val fields: List<String> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("images")
    val images: List<Any> = listOf(),
    @SerializedName("import_t")
    val importT: Int = 0,
    @SerializedName("manufacturer")
    val manufacturer: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("source_licence")
    val sourceLicence: String = "",
    @SerializedName("source_licence_url")
    val sourceLicenceUrl: String = "",
    @SerializedName("url")
    val url: String = ""
)