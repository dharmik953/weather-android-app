package com.dharmik953.weather;

public class WeatherReportModel {
    private int id;
    private String weatrher_state_name;
    private String  weatrher_state_abbr;
    private String  wind_direction_compass;
    private String created;
    private String applicable_date;
    private float min_temp;
    private float max_temp;
    private float the_temp;
    private float wind_speed;
    private float wind_direction;
    private int air_pressure;
    private int humidity;
    private float visibility;
    private int predictability;

    //constructors--------------------------------------------------------------------------------------------------------------------------->


    public WeatherReportModel() {
    }

    public WeatherReportModel(int id, String weatrher_state_name, String weatrher_state_abbr, String wind_direction_compass, String created, String applicable_date, float min_temp, float max_temp, float the_temp, float wind_speed, float wind_direction, int air_pressure, int humidity, float visibility, int predictability) {
        this.id = id;
        this.weatrher_state_name = weatrher_state_name;
        this.weatrher_state_abbr = weatrher_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }
    //to String------------------------------------------------------------------------------------------------------------------------------>

    @Override
    public String toString() {
        return
                ", weatrher_state_name='" + weatrher_state_name + '\'' +


                ", applicable_date='" + applicable_date + '\'' +
                " lo: " + min_temp +
                " hi: " + max_temp +
                "temp=" + the_temp +
                "wind speed: " + wind_speed +
                "air pressure: " + air_pressure +
                "humidity: " + humidity +
                "visibility: " + visibility;

    }


    //getters and settters------------------------------------------------------------------------------------------------------------------->


    public void setId(int id) {
        this.id = id;
    }

    public void setWeatrher_state_name(String weatrher_state_name) {
        this.weatrher_state_name = weatrher_state_name;
    }

    public void setWeatrher_state_abbr(String weatrher_state_abbr) {
        this.weatrher_state_abbr = weatrher_state_abbr;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public void setMax_temp(float max_temp) {
        this.max_temp = max_temp;
    }

    public void setThe_temp(float the_temp) {
        this.the_temp = the_temp;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public void setAir_pressure(int air_pressure) {
        this.air_pressure = air_pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }
}
