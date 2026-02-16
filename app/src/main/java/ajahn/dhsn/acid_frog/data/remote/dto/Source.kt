package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("fields")
    val fields: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Any>,
    @SerializedName("import_t")
    val importT: Int,
    @SerializedName("manufacturer")
    val manufacturer: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("source_licence")
    val sourceLicence: String,
    @SerializedName("source_licence_url")
    val sourceLicenceUrl: String,
    @SerializedName("url")
    val url: String
)