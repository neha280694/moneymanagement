package com.ftpl.moneymanagement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.ftpl.moneymanagement.Adapter.AdapterCategory;
import com.ftpl.moneymanagement.Adapter.Adapterincomecaategory;
import com.ftpl.moneymanagement.databinding.FragmentFmCategoryListDialogBinding;
import com.ftpl.moneymanagement.databinding.FragmentFmIncomeListDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Fm_income extends BottomSheetDialogFragment implements Adapterincomecaategory.onRowClick {
    List<incomecategory> income = new ArrayList<>();
    FragmentFmIncomeListDialogBinding binding;
    RecyclerView recyclerView;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fm_income_list_dialog, container, false);
        View view = binding.getRoot();

            incomecategory img = new incomecategory();
            img.setName("salary");
            income.add(img);

        incomecategory img1 = new incomecategory();
        img1.setName("savings");
        income.add(img1);



        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listt);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setHasFixedSize(true);

        Adapterincomecaategory adapter = new Adapterincomecaategory(getContext(), income, this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onclick(incomecategory details) {
        if (details != null) {

            Intent in = new Intent(getContext(), act_income.class);
            in.putExtra("text", details.getName());

            getContext().startActivity(in);
            dismiss();


        }
    }
}
