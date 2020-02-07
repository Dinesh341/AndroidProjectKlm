package com.klm.ViewModels


import DestinationDetatilBase
import DestinationRouteBase
import FlightStatusData
import TokenData
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klm.networkservice.RetrofitService
import com.my.klm.model.route.FlightRouteBase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FlightViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private var flightdata: MutableLiveData<FlightStatusData> = MutableLiveData()
    private var routeflightdata: MutableLiveData<FlightRouteBase> = MutableLiveData()
    private var tokenData: MutableLiveData<TokenData> = MutableLiveData()
    private var destinationData: MutableLiveData<DestinationRouteBase> = MutableLiveData()
    private var destinationDetailData: MutableLiveData<DestinationDetatilBase> = MutableLiveData()




    fun getFlightData(): MutableLiveData<FlightStatusData>? = flightdata
    fun getRouteFlightData(): MutableLiveData<FlightRouteBase>? = routeflightdata
    fun getDestinationData(): MutableLiveData<DestinationRouteBase>? = destinationData
    fun getDestinationDetatilData(): MutableLiveData<DestinationDetatilBase>? = destinationDetailData
    fun getTokenValue(): MutableLiveData<TokenData>? = tokenData
    val tokenBody: String = "client_credentials"


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
                result?.let {
                    flightdata.value = result
                }
            }, { error ->
                progress_circular.visibility = View.GONE
                error.printStackTrace()
            }
            )
        compositeDisposable.add(disposable)
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
                result?.let {
                    destinationData.value = result
                }
            }, { error ->
                progress_circular.visibility = View.GONE
                error.printStackTrace()
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
                result?.let {
                    destinationDetailData.value = result
                }
            }, { error ->
                progress_circular.visibility = View.GONE
                error.printStackTrace()
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
        val disposable = RetrofitService.create().getAllRouteFlight(origin, destination, startRange, endRange,token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                result?.let {
                    routeflightdata.value = result
                }
            }, { error ->
                progress_circular.visibility = View.GONE
                error.printStackTrace()
            }
            )
        compositeDisposable.add(disposable)
    }

    fun getToken() {
        val disposable = RetrofitService.create().getToken(tokenBody).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                result?.let {
                    tokenData.value = result
                }
            }, { error ->
                error.printStackTrace()
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
