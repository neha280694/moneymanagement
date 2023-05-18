package com.ftpl.moneymanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.R;
import com.ftpl.moneymanagement.databinding.ActListItemParentBinding;
import com.ftpl.moneymanagement.databinding.ActivityActListItemChildBinding;

import java.util.List;

public class Adapterincomechild extends RecyclerView.Adapter<Adapterincomechild.ViewHolder>{
    private List<income> mArrayList;
    private Context context;
    public Adapterincomechild(Context context, List<income> arrayList ) {
        this.context = context;
        this.mArrayList = arrayList;


    }

    @NonNull
    @Override
    public Adapterincomechild.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_act_list_item_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterincomechild.ViewHolder holder, int position) {

            holder.binding.txtamount.setText("Rs. " + mArrayList.get(position).getAmount());
            holder.binding.txtdate.setText(mArrayList.get(position).getDate());

        }


        @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ActivityActListItemChildBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
