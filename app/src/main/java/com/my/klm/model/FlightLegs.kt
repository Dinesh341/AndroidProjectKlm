import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

@Parcelize
data class FlightLegs (

	@SerializedName("status") val status : String,
	@SerializedName("statusName") val statusName : String,
	@SerializedName("publishedStatus") val publishedStatus : String,
	@SerializedName("departureInformation") val departureInformation : DepartureInformation?,
	@SerializedName("arrivalInformation") val arrivalInformation : ArrivalInformation?,
	@SerializedName("legStatusPublic") val legStatusPublic : String,
	@SerializedName("legStatusPublicLangTransl") val legStatusPublicLangTransl : String,
	@SerializedName("passengerCustomsStatus") val passengerCustomsStatus : String,
	@SerializedName("serviceType") val serviceType : String,
	@SerializedName("serviceTypeName") val serviceTypeName : String,
	@SerializedName("scheduledFlightDuration") val scheduledFlightDuration : String,
	@SerializedName("completionPercentage") val completionPercentage : Int,
	@SerializedName("timeZoneDifference") val timeZoneDifference : Int,
	@SerializedName("aircraft") val aircraft : Aircraft?,
	@SerializedName("irregularity") val irregularity : Irregularity?,
	@SerializedName("internalLegStatusArrFocus") val internalLegStatusArrFocus : Boolean
)  : Parcelable