package com.ftpl.moneymanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ftpl.moneymanagement.Entity.expence;
import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.databinding.ActivityActIncomeBinding;

public class act_income extends AppCompatActivity {
    ActivityActIncomeBinding binding;
    private boolean checkvalidity;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_act_income);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_act_income);
        binding.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.txtdate.setText(Util.getTodayDateee());
        binding.lycalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.getDateTime(act_income.this,binding.txtdate);
            }
        });
        in=getIntent();
        binding.txtcat.setText(in.getStringExtra("text"));
        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean abc = checkValidation();
if(abc) {
    income exp = new income();
    exp.setAmount(binding.edtamount.getText().toString());
    exp.setCategory(binding.txtcat.getText().toString());
    exp.setDate(binding.txtdate.getText().toString());
    exp.setMode(binding.spmode.getSelectedItem().toString());
    exp.setDate(binding.txtdate.getText().toString());
    exp.save();
    Toast.makeText(act_income.this, "saved!", Toast.LENGTH_LONG).show();
    startActivity(new Intent(act_income.this, MainActivity.class));
}
            }
        });
        binding.txtcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                Fm_income bottomSheetFragmenttt = new Fm_income();
                //bottomSheetFragmentt = new Fm_category();
                bottomSheetFragmenttt.show(act_income.this.getSupportFragmentManager(), bottomSheetFragmenttt.getTag());


                // Fm_category bottomSheetFragmentt = new Fm_category();

                //bottomSheetFragmentt.show(act_Income.this.getSupportFragmentManager(), bottomSheetFragmentt.getTag());


            }
        });


    }
    private boolean checkValidation() {
        if (binding.txtcat.getText().toString()!=null&&binding.txtcat.getText().toString().length()>0) {

            if (binding.edtamount.getText().toString()!=null&&binding.edtamount.getText().toString().length()>0) {

                        checkvalidity = true;
                    } else {
                Toast.makeText(act_income.this, "amount cannot be blank", Toast.LENGTH_LONG).show();
                    }

                } else {
            Toast.makeText(act_income.this, "amount", Toast.LENGTH_LONG).show();
                }


        return checkvalidity;
    }
}
