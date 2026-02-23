package ajahn.dhsn.acid_frog.domain.model

/**
 * Sealed class representing the result of an operation, either successful or failed.
 *
 * This class wraps the result of operations that can succeed or fail, providing a structured way
 * to handle success and error cases. It is typically used for API calls, database operations,
 * or any operation that may produce an error.
 *
 * @param T The type of data associated with the response.
 * @property data The data returned by the operation, if successful. `null` in case of error.
 * @property errorMessage The error message describing the failure, if any. `null` in case of success.
 */
sealed class ResponseWrapper<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    /**
     * Represents a successful operation.
     *
     * @property data The data returned by the successful operation.
     */
    class Success<T>(data: T) : ResponseWrapper<T>(data)

    /**
     * Represents a failed operation.
     *
     * @property errorMessage The error message describing the failure.
     * @property data Optional data that may still be available even in case of error.
     */
    class Error<T>(errorMessage: String, data: T? = null) : ResponseWrapper<T>(data, errorMessage)
}
