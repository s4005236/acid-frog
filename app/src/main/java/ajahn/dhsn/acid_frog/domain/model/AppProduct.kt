package ajahn.dhsn.acid_frog.domain.model

/**
 * Data class representing a product in the application.
 *
 * This class holds product details such as code, status, name, and ingredients.
 * It is used to encapsulate product information for use within the application.
 *
 * @property code The unique identifier or barcode of the product.
 * @property status The status code associated with the product (e.g., API response status).
 * @property status_verbose A human-readable description of the product's status.
 * @property name The name or description of the product.
 * @property ingredients A list of ingredients or allergens associated with the product.
 */
data class AppProduct(
    val code: String = "",
    val status: Int = -1,
    val status_verbose: String = "",
    val name: String = "",
    val ingredients: List<String> = emptyList()
)
