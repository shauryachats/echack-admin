package com.nsuthack.echackadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nsuthack.echackadmin.model.RetroPeopleInLine;
import com.nsuthack.echackadmin.network.GetPeopleInLine;
import com.nsuthack.echackadmin.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText boothIDEt = (EditText) findViewById(R.id.editText);
        final EditText countsEt = (EditText) findViewById(R.id.editText2);
        Button submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer boothID = Integer.parseInt(boothIDEt.getText().toString().trim());
                Integer counts = Integer.parseInt(countsEt.getText().toString().trim());
                RetroPeopleInLine retroPeopleInLine = new RetroPeopleInLine(boothID, counts);

                GetPeopleInLine service = RetrofitClientInstance.getRetrofitInstance().create(GetPeopleInLine.class);
                Call<ResponseBody> call = service.pushPeopleCount(retroPeopleInLine);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
