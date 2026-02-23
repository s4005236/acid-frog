package ajahn.dhsn.acid_frog.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Utility class for converting between custom data types and Room-supported types.
 *
 * This class provides type converters to handle the serialization and deserialization
 * of [List<String>] to and from JSON strings, enabling Room to store complex data types.
 */
class TypeConversion {
    private val gson = Gson()

    /**
     * Converts a [List<String>] to a JSON string for storage in the database.
     *
     * @param list The list of strings to convert.
     * @return A JSON string representation of the list, or `null` if the input is `null`.
     */
    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        if (list == null) return null
        return gson.toJson(list)
    }

    /**
     * Converts a JSON string back to a [List<String>].
     *
     * @param data The JSON string to convert.
     * @return A list of strings parsed from the JSON, or `null` if the input is `null`.
     */
    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        if (data == null) return null
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }
}