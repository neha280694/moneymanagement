package com.ftpl.moneymanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.ftpl.moneymanagement.Adapter.Adapterexpencelist;
import com.ftpl.moneymanagement.Adapter.Adapterexpencereport;
import com.ftpl.moneymanagement.Adapter.Adapterincome;
import com.ftpl.moneymanagement.Adapter.Adapterincomecaategory;
import com.ftpl.moneymanagement.Adapter.Adapterincomechild;
import com.ftpl.moneymanagement.Entity.expence;
import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.databinding.ActivityActIncomeBinding;
import com.ftpl.moneymanagement.databinding.ActivityActReportBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class act_report extends AppCompatActivity implements Adapterexpencereport.onRowClick{
    ActivityActReportBinding binding;
    List<income> category = new ArrayList<>();
    List<income> name = new ArrayList<>();
    List<income> nameitem = new ArrayList<>();
    List<income> list = new ArrayList<>();
    String listitem = "";
    List<income> listall = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<expence> categoryy = new ArrayList<>();
    List<expence> namee = new ArrayList<>();
    List<expence> nameitemm = new ArrayList<>();
    List<expence> listt = new ArrayList<>();
    List<expence> listalll = new ArrayList<>();
    List<String> namess = new ArrayList<>();
    List<incomecategory> categoryname = new ArrayList<>();
     List<Boolean> mArrayListint=new ArrayList<>();
     RecyclerView recyclerView;
    RecyclerView recyclerViews;
    income n = new income();
    private String selectedTimeSlot = "05:00PM";
    private int alreadySelectedIndex = 0;
    private boolean timeSlotPicked = false;
    private ArrayList<Boolean> timeSlotsSelected = new ArrayList<>();
    private  Adapterincome adapterincome;
    List<income> listDayVal = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_act_report);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_act_report);
       binding.toolbar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
        category = new Select().from(income.class).limit(100).execute();
        categoryy = new Select().from(expence.class).limit(100).execute();


        // Traverse through the first list
        int temp = 0;
        for (income element : category) {


            // If this element is not present in newList
            // then add it
            if (names.contains(element.getCategory())) {
                name.add(element);

                //timeSlotsSelected.add(false);
            } else {
                names.add(element.getCategory());
                listall.add(element);

              /*  if (temp == 0) {
                    timeSlotsSelected.add(true);
                    temp++;
                } else {
                    timeSlotsSelected.add(false);
                }*/

            }
            nameitem.add(element);


        }
        for (expence elements : categoryy) {

            // If this element is not present in newList
            // then add it
            if (namess.contains(elements.getCategory())) {
                namee.add(elements);
                //timeSlotsSelected.add(false);
            } else {
                namess.add(elements.getCategory());

                listalll.add(elements);
            }
            nameitemm.add(elements);

        }



        recyclerView = (RecyclerView) findViewById(R.id.listitem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
               // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Adapterincome adapter = new Adapterincome(act_report.this, listall, nameitem,listDayVal);
        recyclerView.setAdapter(adapter);
        recyclerViews = (RecyclerView) findViewById(R.id.listexpance);
        recyclerViews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViews.setHasFixedSize(true);
        Adapterexpencereport adapterr = new Adapterexpencereport(act_report.this, listalll, nameitemm, this);
        recyclerViews.setAdapter(adapterr);
      /*  binding.listitem.addOnItemTouchListener(new RecyclerItemClickListener(act_report.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                timeSlotPicked = true;
                selectedTimeSlot = listall.get(position).getCategory();
                selectedTimeSlot=listall.get(position).getAmount();
                //selectedTimeSlot = listDetails.get(position).getDays();


                boolean alreadySelected = timeSlotsSelected.contains(true);
                if (alreadySelected && alreadySelectedIndex != -1 && alreadySelectedIndex != position) {
                    View alreadySelectedView = binding.listitem.getLayoutManager().findViewByPosition(alreadySelectedIndex);
                    if (alreadySelectedView != null) {
                        CardView oldSlotButton = (CardView) alreadySelectedView.findViewById(R.id.cardd);
                        TextView oldSlotButtonn = (TextView) alreadySelectedView.findViewById(R.id.txtnamee);
                        TextView oldSlotButtont = (TextView) alreadySelectedView.findViewById(R.id.txttotalamountt);

                        oldSlotButton.setCardBackgroundColor(R.drawable.bdrouter);
                        oldSlotButtonn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        oldSlotButtont.setTextColor(getResources().getColor(R.color.white));
                        timeSlotsSelected.set(alreadySelectedIndex, false);
                    } else {
                        timeSlotsSelected.set(alreadySelectedIndex, false);
                        adapterincome.notifyItemChanged(alreadySelectedIndex);
                        //adapterMenutTimecategory.notifyItemChanged(alreadySelectedIndex);

                    }
                }
                CardView timeSlotButton = (CardView) view.findViewById(R.id.cardd);
                TextView timeSlotButtonn = (TextView) view.findViewById(R.id.txtnamee);
                TextView timeSlotButtont = (TextView) view.findViewById(R.id.txttotalamountt);
                if (!timeSlotsSelected.get(position)) {
                    timeSlotButton.setCardBackgroundColor(R.drawable.bdrorange);
                    timeSlotButtonn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    timeSlotButtont.setTextColor(getResources().getColor(R.color.white));

                    timeSlotsSelected.set(position, true);
                    alreadySelectedIndex = position;
                }
            }
        }));
*/
    }


   /* @Override
    public void onclickparent(income detail, List<income> mArrayList) {


        //listDayVal=null;
        if (mArrayList != null && mArrayList.size() > 0) {
            binding.listchild.setVisibility(View.VISIBLE);

           listDayVal=null;
            for (income obj : mArrayList) {
                if (obj.getCategory().equals(detail.getCategory())) {
                    listDayVal.add(obj);
                }
            }
           *//* Adapterincome adapterr = new Adapterincome(act_report.this, listall, nameitem,listDayVal,this);
            binding.listitem.setHasFixedSize(true);
            binding.listitem.setLayoutManager(new LinearLayoutManager(this));
            binding.listitem.setAdapter(adapterr);
*//*
        }
    }*/
    @Override
    public void onclickexpence(expence detail, List<expence> mArrayList) {
        if (mArrayList != null && mArrayList.size() > 0) {
            binding.listclick.setVisibility(View.VISIBLE);
            List<expence> listDayVall = new ArrayList();
            // listDayVal=null;
            for (expence obj : mArrayList) {
                if (obj.getCategory().equals(detail.getCategory())) {
                    listDayVall.add(obj);
                }
            }
            Adapterexpencelist adapterrr = new Adapterexpencelist(act_report.this, listDayVall);
            binding.listclick.setHasFixedSize(true);
            binding.listclick.setLayoutManager(new LinearLayoutManager(this));
            binding.listclick.setAdapter(adapterrr);

        }

    }

}


