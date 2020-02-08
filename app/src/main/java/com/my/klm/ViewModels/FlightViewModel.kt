package com.my.klm.viewmodels

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.klm.networkservice.RetrofitService
import com.my.klm.KlmApplication
import com.my.klm.R
import com.my.klm.model.FlightStatusData
import com.my.klm.model.destination.DestinationRouteBase
import com.my.klm.model.destinationdetail.DestinationDetatilBase
import com.my.klm.model.error.ErrorBase
import com.my.klm.model.route.FlightRouteBase
import com.my.klm.model.token.TokenData
import com.my.klm.utils.PrefUtils.showErrorMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import java.lang.Exception


private const val tokenBody = "client_credentials"

class FlightViewModel : ViewModel() {
    private val classNameTag: String = FlightViewModel::class.java.simpleName
    private val compositeDisposable = CompositeDisposable()
    private var flightdata: MutableLiveData<FlightStatusData> = MutableLiveData()
    private var routeflightdata: MutableLiveData<FlightRouteBase> = MutableLiveData()
    private var tokenData: MutableLiveData<TokenData> = MutableLiveData()
    private var destinationData: MutableLiveData<DestinationRouteBase> = MutableLiveData()
    private var destinationDetailData: MutableLiveData<DestinationDetatilBase> = MutableLiveData()
    fun getFlightData(): MutableLiveData<FlightStatusData>? = flightdata
    fun getRouteFlightData(): MutableLiveData<FlightRouteBase>? = routeflightdata
    fun getDestinationData(): MutableLiveData<DestinationRouteBase>? = destinationData
    fun getDestinationDetatilData(): MutableLiveData<DestinationDetatilBase>? =
        destinationDetailData

    fun getTokenValue(): MutableLiveData<TokenData>? = tokenData

    fun getFlightList(
        progress_circular: ProgressBar,
        url: String,
        origin: String,
        expand: String,
        token: String
    ) {
        val disposable = RetrofitService.create().getFlightStatus(url, origin, expand, token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                flightdata.value = result
            }, { error ->
                progress_circular.visibility = View.GONE
                displayError(error)
                Log.e(classNameTag, error.message)
            }
            )
        compositeDisposable.add(disposable)
    }

    private fun displayError(error: Throwable) {
        try {
            if (error is HttpException) {
                val response = error.response()
                if (response.code() == 404) {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    val student = Gson().fromJson(jObjError.toString(), ErrorBase::class.java)
                    showErrorMessage(KlmApplication.ctx, student.errors[0].name)
                } else if (response.code() == 401) {
                    val errorMessage = KlmApplication.ctx?.getString(R.string.not_authorized)
                    showErrorMessage(KlmApplication.ctx, errorMessage.toString())
                }
            }
        } catch (ex: Exception) {
            Log.e(classNameTag, ex.message)
        }

    }

    fun getDestinationData(
        progress_circular: ProgressBar,
        cities: String,
        token: String
    ) {
        val disposable = RetrofitService.create().getDestinationData(cities, token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                destinationData.value = result
            }, { error ->
                progress_circular.visibility = View.GONE
                displayError(error)
                Log.e(classNameTag, error.message)
            }
            )
        compositeDisposable.add(disposable)
    }

    fun getDestinationDetailData(
        progress_circular: ProgressBar,
        cities: String,
        token: String
    ) {
        val disposable = RetrofitService.create().getDestinationDetail(cities, token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                destinationDetailData.value = result
            }, { error ->
                progress_circular.visibility = View.GONE
                displayError(error)
                Log.e(classNameTag, error.message)
            }
            )
        compositeDisposable.add(disposable)
    }

    fun getAllRouteFlightList(
        progress_circular: ProgressBar,
        origin: String,
        destination: String,
        startRange: String,
        endRange: String,
        token: String
    ) {
        val disposable = RetrofitService.create()
            .getAllRouteFlight(origin, destination, startRange, endRange, token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                routeflightdata.value = result
            }, { error ->
                progress_circular.visibility = View.GONE
                displayError(error)
                Log.e(classNameTag, error.message)
            }
            )
        compositeDisposable.add(disposable)
    }

    fun getToken() {
        val disposable =
            RetrofitService.create().getToken(tokenBody).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    tokenData.value = result
                }, { error ->
                    Log.e(classNameTag, error.message)
                }
                )
        compositeDisposable.add(disposable)
    }

    // This is called by the Android Activity when the activity is destroyed
    public override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
