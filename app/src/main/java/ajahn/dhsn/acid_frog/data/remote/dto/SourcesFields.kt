package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SourcesFields(
    @SerializedName("org-gs1")
    val orgGs1: OrgGs1
)