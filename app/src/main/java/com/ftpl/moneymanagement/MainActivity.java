package com.ftpl.moneymanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.activeandroid.query.Select;
import com.ftpl.moneymanagement.Entity.expence;
import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private List<income> productList = new ArrayList<>();
    private List<expence> productListt = new ArrayList<>();
    int a=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.txtdate.setText(Util.getTodayDate());
        setSupportActionBar(binding.toolbar);
        binding.lycalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.getDateTimeeEE(MainActivity.this,binding.txtdate);
            }
        });
        productList = new Select().from(income.class).limit(100).execute();
        //expence ex=new expence();
        if(productList!=null&&productList.size()>0) {
            Double income=0.0;
            for(int i=0;i<productList.size();i++) {
                income+=Double.parseDouble(productList.get(i).getAmount());

            }
            productListt=new Select().from(expence.class).limit(100).execute();
            Double expence=0.0; //Double.parseDouble(productList.get(0).getAmount());

                for(int j=0;j<productListt.size();j++) {
                    expence += Double.parseDouble(productListt.get(j).getAmount());
                }
                Double total=income-expence;
            binding.txtbalance.setText("Rs. " +total.toString());

            binding.txtamount.setText("Rs." +income.toString());
            binding.txtspend.setText("Rs." +expence.toString());
        }
        //in=getIntent();
        //binding.txtamount.setText(in.getStringExtra("balance"));

        binding.btnincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, act_income.class));

            }
        });
        binding.btnexpence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, act_expence.class));

            }
        });

        binding.imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("House");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgtoiletry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("TOILETRY");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("SPORTS");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("SHIRT");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imghealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("HEALTH");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgeatingout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("EATING OUT");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgentertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("ENTERTAINMENT");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgcommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("COMMUNICATION");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("CAR");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("FOOD");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });
        binding.imgtransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagedetail img=new Imagedetail();
                img.setName("TRANSPORT");
                Intent in = new Intent(MainActivity.this, act_expence.class);
                in.putExtra("text", img.getName());

                MainActivity.this.startActivity(in);
                // startActivity(new Intent(MainActivity.this, act_Income.class));

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.report) {
           // getemployeedetail();

             startActivity(new Intent(MainActivity.this, act_report.class));
        }

        return super.onOptionsItemSelected(item);
    }







}
