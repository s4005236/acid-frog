package ajahn.dhsn.acid_frog.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConversion {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        if (list == null) return null
        return gson.toJson(list)
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        if (data == null) return null
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }
}