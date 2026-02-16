package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Accuracy(
    @SerializedName("overall")
    val overall: String
)