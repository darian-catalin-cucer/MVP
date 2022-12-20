package cucerdariancatalin.mvp.model

class SourceResponse(val status: String, val sources: List<Sources>) {

    inner class Sources(val id: String, val name: String, val description: String?,
                        val url: String, val category: String, val language: String,
                        val country: String)
}