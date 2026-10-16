package ad.cfp.viatges

data class Viatge(
    val id: Int,
    val destinacio: String,
    val dataSortida: String,
    val dataTornada: String,
    val preu: Double,
    val imatge: String
)
