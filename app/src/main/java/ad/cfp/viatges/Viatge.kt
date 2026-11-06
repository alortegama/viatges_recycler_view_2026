package ad.cfp.viatges

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Viatge(
    val id: Int,
    val destinacio: String,
    val dataSortida: String,
    val dataTornada: String,
    val preu: Double,
    val imatge: String
): Parcelable