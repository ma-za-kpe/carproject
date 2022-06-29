package com.ryggs.cars.core.data.cache.convertor

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.allcars.Stats
import com.ryggs.cars.core.data.cache.models.cardetails.*
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.popularmakes.Make

class CarConvertor {

    var gson = Gson()

    @TypeConverter
    fun resultToString(intList: List<Result>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToResult(data: String): List<Result>{
        val listType = object: TypeToken<List<Result>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun statsToString(intList: Stats?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToIntStats(data: String): Stats{
        val listType = object: TypeToken<Stats>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun carDetailToString(intList: List<CarDetailResponse>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToIntCarDetailResponse(data: String): List<CarDetailResponse>{
        val listType = object: TypeToken<List<CarDetailResponse>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun iIToString(intList: List<InspectionItem>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToIi(data: String): List<InspectionItem>{
        val listType = object: TypeToken<List<InspectionItem>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun lcToString(intList: LoanCalculator?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringTolc(data: String): LoanCalculator{
        val listType = object: TypeToken<LoanCalculator>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun dfToString(intList: DefaultValues?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToDf(data: String): DefaultValues{
        val listType = object: TypeToken<DefaultValues>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun rangesToString(intList: Ranges?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToRanges(data: String): Ranges{
        val listType = object: TypeToken<Ranges>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun iMToString(intList: List<InspectedMake>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToIm(data: String): List<InspectedMake>{
        val listType = object: TypeToken<List<InspectedMake>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun bodyTypeToString(intList: BodyType?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToBodyType(data: String): BodyType{
        val listType = object: TypeToken<BodyType>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun dmToString(intList: List<DamageMedia>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringTodm(data: String): List<DamageMedia>{
        val listType = object: TypeToken<List<DamageMedia>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fsToString(fs: FinancingSettings?): String{
        return gson.toJson(fs)
    }
    @TypeConverter
    fun stringToFs(data: String): FinancingSettings{
        val listType = object: TypeToken<FinancingSettings>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun idToString(intList: InspectorDetails?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToId(data: String): InspectorDetails{
        val listType = object: TypeToken<InspectorDetails>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun mToString(intList: Model?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToM(data: String): Model{
        val listType = object: TypeToken<Model>(){}.type
        return gson.fromJson(data, listType)
    }

    // TODO: find better way to handle this. saving empty field in the db...
    @TypeConverter
    fun anyToString(intList: List<Any>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToAny(data: String): List<Any>{
        val listType = object: TypeToken<List<Any>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun carMediaToString(intList: List<CarMedia>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToCarMedia(data: String): List<CarMedia>{
        val listType = object: TypeToken<List<CarMedia>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun makeToString(intList: List<Make>?): String{
        return gson.toJson(intList)
    }
    @TypeConverter
    fun stringToMake(data: String): List<Make>{
        val listType = object: TypeToken<List<Make>>(){}.type
        return gson.fromJson(data, listType)
    }
}