package io.weatherapp.data

import io.realm.RealmList
import io.realm.RealmObject

open class TotalWeather(
    var lat: Float? = null
    , var lon: Float? = null
    , var timezone: String? = null
    , var timezoneOffset: Long? = null
    , var current: CurrentWeather? = null
    , var hourly: RealmList<HourlyWeather>? = null
    , var daily: RealmList<DailyWeather>? = null
) : RealmObject()

interface AbstractWeather {

    fun receiveWeather(): String

    fun receiveDateMillis(): Long

    fun receiveTemp(): String

    fun receiveHumidity(): String

    fun receiveWindSpeed(): String

    fun receiveWindDegrees(): Int


}

open class CurrentWeather(
    var date: Long? = null
    , var sunrise: Long? = null
    , var sunset: Long? = null
    , var temp: Float? = null
    , var feelsLike: Float? = null
    , var pressure: Int? = null
    , var humidity: Int? = null
    , var dewPoint: Float? = null
    , var uvi: Float? = null
    , var clouds: Int? = null
    , var visibility: Long? = null
    , var windSpeed: Float? = null
    , var windDegrees: Int? = null
    , var weather: RealmList<ItemWeather>? = null
    , var rain: SnowRainWeather? = null
    , var snow: SnowRainWeather? = null
) : RealmObject(), AbstractWeather {
    override fun receiveWeather(): String {
        return weather?.get(0)?.main ?: ""
    }

    override fun receiveDateMillis(): Long {
        return (date ?: 0L) * 1000L
    }

    override fun receiveTemp(): String {
        return temp.toString() + "°"
    }

    override fun receiveHumidity(): String {
        return (humidity ?: 0).toString() + "%"
    }

    override fun receiveWindSpeed(): String {
        return windSpeed.toString()
    }

    override fun receiveWindDegrees(): Int {
        return windDegrees ?: 0
    }
}

open class HourlyWeather(
    var date: Long? = null
    , var temp: Float? = null
    , var feelsLike: Float? = null
    , var pressure: Int? = null
    , var humidity: Int? = null
    , var dewPoint: Float? = null
    , var clouds: Int? = null
    , var visibility: Long? = null
    , var windSpeed: Float? = null
    , var windDegrees: Int? = null
    , var windGust: Float? = null
    , var pop: Float? = null
    , var weather: RealmList<ItemWeather>? = null
    , var rain: SnowRainWeather? = null
    , var snow: SnowRainWeather? = null
) : RealmObject()

open class DailyWeather(
    var date: Long? = null
    , var sunrise: Long? = null
    , var sunset: Long? = null
    , var temp: TemperatureWeather? = null
    , var feelsLike: TemperatureWeather? = null
    , var pressure: Int? = null
    , var humidity: Int? = null
    , var dewPoint: Float? = null
    , var clouds: Int? = null
    , var uvi: Float? = null
    , var visibility: Long? = null
    , var windSpeed: Float? = null
    , var windDegrees: Int? = null
    , var windGust: Float? = null
    , var pop: Float? = null
    , var weather: RealmList<ItemWeather>? = null
    , var rain: Float? = null
    , var snow: Float? = null
) : RealmObject(), AbstractWeather {

    override fun receiveWeather(): String {
        return weather?.get(0)?.main ?: ""
    }

    override fun receiveDateMillis(): Long {
        return (date ?: 0L) * 1000L
    }

    override fun receiveTemp(): String {
        return (temp?.max ?: 0f).toString() + "°/" + (temp?.min ?: 0f).toString() + "°"
    }

    override fun receiveHumidity(): String {
        return (humidity ?: 0).toString() + "%"
    }

    override fun receiveWindSpeed(): String {
        return windSpeed.toString()
    }

    override fun receiveWindDegrees(): Int {
        return windDegrees ?: 0
    }

}

open class ItemWeather(
    var id: Int? = null
    , var main: String? = null
    , var description: String? = null
    , var icon: String? = null
) : RealmObject()

/**rain or snow*/
open class SnowRainWeather(
    var h1: Float? = null
    , var h3: Float? = null
) : RealmObject()

open class TemperatureWeather(
    var day: Float? = null
    , var min: Float? = null
    , var max: Float? = null
    , var night: Float? = null
    , var eve: Float? = null
    , var morn: Float? = null
) : RealmObject()