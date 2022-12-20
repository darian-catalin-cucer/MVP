package cucerdariancatalin.mvp.data.api

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken

class AutoValueAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val rawType = type.rawType
        if (!rawType.isAnnotationPresent(AutoGson::class.java)) {
            return null
        }
        val packageName = rawType.getPackage()!!.name
        val className = rawType.name.substring(packageName.length + 1).replace('$', '_')
        val autoValueName = "$packageName.AutoValue_$className"
        return try {
            val autoValueType = Class.forName(autoValueName)
            gson.getAdapter(autoValueType) as TypeAdapter<T>
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("Could not load AutoValue type $autoValueName", e)
        }
    }
}