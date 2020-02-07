import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Airline(

    val code: String?,
    val name: String?
) : Parcelable