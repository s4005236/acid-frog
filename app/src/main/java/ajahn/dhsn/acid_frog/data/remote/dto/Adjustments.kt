package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Adjustments(
    @SerializedName("origins_of_ingredients")
    val originsOfIngredients: OriginsOfIngredients = OriginsOfIngredients(),
    @SerializedName("packaging")
    val packaging: Packaging = Packaging(),
    @SerializedName("production_system")
    val productionSystem: ProductionSystem = ProductionSystem(),
    @SerializedName("threatened_species")
    val threatenedSpecies: ThreatenedSpecies = ThreatenedSpecies()
)