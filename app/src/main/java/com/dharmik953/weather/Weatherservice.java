package com.dharmik953.weather;
import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Weatherservice {

    final private Context context;
    String cityId;
    public Weatherservice(Context context) {
        this.context = context;
    }
    public interface VollyResponseListener{

        void onError(String message);

        void onResponce(String cityId);
    }

    public static final String CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String WEATHER_CITY_ID = "https://www.metaweather.com/api/location/";
    public void getCityId(String cityname, final VollyResponseListener vollyResponseListener) {
        
        String url = CITY_ID + cityname;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //cityId = "";

                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityId = cityInfo.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(context, "city Id = " + cityId, Toast.LENGTH_SHORT).show();
                vollyResponseListener.onResponce(cityId);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                      //  Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                vollyResponseListener.onError("Something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
//********************************************************************************************************************************************************************************************************************************************************************************************************
    public interface ForecastByIdResponse{

        void onError(String message);

        void onResponce( List<WeatherReportModel> weatherReportModels);
    }

    public void getCityForecastById(String cityId, final ForecastByIdResponse forecastByIdResponse){
        final List<WeatherReportModel> weatherReportModels = new ArrayList<>();
        String url = WEATHER_CITY_ID + cityId ;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               //Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();

                try {
                    JSONArray consolidated_weather_list = response.getJSONArray("consolidated_weather");

                    for (int i = 0; i <consolidated_weather_list.length();i++) {
                        WeatherReportModel one_day = new WeatherReportModel();
                        JSONObject first_day_from_api = (JSONObject) consolidated_weather_list.get(i);
                        one_day.setId(first_day_from_api.getInt("id"));
                        one_day.setWeather_state_name(first_day_from_api.getString("weather_state_name"));
                        one_day.setWeather_state_abbr(first_day_from_api.getString("weather_state_abbr"));
                        one_day.setCreated(first_day_from_api.getString("created"));
                        one_day.setThe_temp(first_day_from_api.getLong("the_temp"));
                        one_day.setWind_speed(first_day_from_api.getLong("wind_speed"));
                        one_day.setVisibility(first_day_from_api.getLong("visibility"));
                        one_day.setPredictability(first_day_from_api.getInt("predictability"));
                        one_day.setAir_pressure(first_day_from_api.getInt("air_pressure"));
                        one_day.setHumidity(first_day_from_api.getInt("humidity"));
                        one_day.setWind_direction(first_day_from_api.getLong("wind_direction"));
                        one_day.setApplicable_date(first_day_from_api.getString("applicable_date"));
                        one_day.setWind_direction_compass(first_day_from_api.getString("wind_direction_compass"));
                        one_day.setMin_temp(first_day_from_api.getLong("min_temp"));
                        one_day.setMax_temp(first_day_from_api.getLong("max_temp"));
                        weatherReportModels.add(one_day);
                    }
                        forecastByIdResponse.onResponce(weatherReportModels);
                } catch (JSONException e) {
                    Toast.makeText(context, "error in catch on responce by id", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                //Toast.makeText(context, weatherReportModels.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                forecastByIdResponse.onError("Some thing went wrong");
            }
        });


        MySingleton.getInstance(context).addToRequestQueue(request);
    }
//*********************************************************************************************************************************************************************************************************************************************************************************************************

    public interface GetcutyFoecastByCallback{
        void onError(String message);

        void onRespose(List<WeatherReportModel> weatherReportModels);
    }
    public void getCityForcatsByName(String ciryName, final GetcutyFoecastByCallback getcutyFoecastByCallback){
        getCityId(ciryName, new VollyResponseListener() {
            @Override
            public void onError(String message) {
                getcutyFoecastByCallback.onError("Some thing went wrong");
            }

            @Override
            public void onResponce(String cityId) {
                getCityForecastById(cityId, new ForecastByIdResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponce(List<WeatherReportModel> weatherReportModels) {
                        getcutyFoecastByCallback.onRespose(weatherReportModels);
                    }
                });
            }
        });

    }
}
