import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Times (

	@SerializedName("scheduled") val scheduled : String,
	@SerializedName("latestPublished") val latestPublished : String,
	@SerializedName("estimated") val estimated : Estimated?
): Parcelable