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
import com.ftpl.moneymanagement.databinding.ActivityActExpenceBinding;
import com.ftpl.moneymanagement.databinding.ActivityActIncomeBinding;

public class act_expence extends AppCompatActivity {
    ActivityActExpenceBinding binding;
    private boolean checkvalidity;
    Intent in;
    Intent intt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_act__expence);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_act__expence);
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
                Util.getDateTime(act_expence.this,binding.txtdate);
            }
        });
        binding.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean abc = checkValidation();
                if(abc) {
                    expence exp = new expence();
                    exp.setAmount(binding.edtamount.getText().toString());
                    exp.setCategory(binding.txtcat.getText().toString());
                    exp.setDate(binding.txtdate.getText().toString());
                    exp.setMode(binding.spmode.getSelectedItem().toString());
                    exp.setDate(binding.txtdate.getText().toString());
                    exp.save();
                    Toast.makeText(act_expence.this, "saved!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(act_expence.this, MainActivity.class));
                }

            }
        });


        intt=getIntent();
        in=getIntent();
       // binding.txtcat.setText(in.getStringExtra("text"));


        binding.txtcat.setText(intt.getStringExtra("text"));


        binding.txtcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                Fm_category bottomSheetFragmentt = new Fm_category();
                //bottomSheetFragmentt = new Fm_category();
                bottomSheetFragmentt.show(act_expence.this.getSupportFragmentManager(), bottomSheetFragmentt.getTag());
                binding.txtcat.setText(in.getStringExtra("text"));




            }
        });
    }
    private boolean checkValidation() {
        if (binding.txtcat.getText().toString()!=null&&binding.txtcat.getText().toString().length()>0) {

            if (binding.edtamount.getText().toString()!=null&&binding.edtamount.getText().toString().length()>0) {

                checkvalidity = true;
            } else {
                Toast.makeText(act_expence.this, "amount cannot be blank", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(act_expence.this, "choose category", Toast.LENGTH_LONG).show();
        }


        return checkvalidity;
    }
}
