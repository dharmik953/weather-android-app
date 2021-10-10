package com.dharmik953.weather;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = null;
    Button W_by_id;
    Button W_by_name;
    Button get_id;
    TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_id = findViewById(R.id.get_id);
        W_by_id = findViewById(R.id.W_by_Id);
        W_by_name = findViewById(R.id.W_by_name);
        textView = findViewById(R.id.plane_text);
        listView = findViewById(R.id.listview);



        final Weatherservice weatherservice = new Weatherservice(MainActivity.this);
//******************************************************************************************************************************************************************************************************************************************************************************************************
        get_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherservice.getCityId(textView.getText().toString(), new Weatherservice.VollyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponce(String cityId) {
                        Toast.makeText(MainActivity.this, "Returned Id: " + cityId, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

//*******************************************************************************************************************************************************************************************************************************************************************************************************
        W_by_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherservice.getCityForecastById(textView.getText().toString(), new Weatherservice.ForecastByIdResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<WeatherReportModel> weatherReportModels) {

                      ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weatherReportModels);
                       listView.setAdapter(arrayAdapter);
//                      Toast.makeText(MainActivity.this, weatherReportModels.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
//********************************************************************************************************************************************************************************************************************************************************************************************************
        W_by_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherservice.getCityForcatsByName(textView.getText().toString(), new Weatherservice.GetcityFoecastByCallback() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRespose(List<WeatherReportModel> weatherReportModels) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weatherReportModels);
                        listView.setAdapter(arrayAdapter);
                    }
                });
            }
        });
    }
}