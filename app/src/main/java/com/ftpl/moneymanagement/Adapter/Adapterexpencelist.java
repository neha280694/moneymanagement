package com.ftpl.moneymanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ftpl.moneymanagement.Entity.expence;
import com.ftpl.moneymanagement.R;
import com.ftpl.moneymanagement.databinding.ActExpenceListItemBinding;
import com.ftpl.moneymanagement.databinding.ActivityActListItemChildBinding;

import java.util.List;

public class Adapterexpencelist extends RecyclerView.Adapter<Adapterexpencelist.ViewHolder> {
    private List<expence> mArrayList;

    private Context context;

    public Adapterexpencelist(Context context, List<expence> arrayList ) {
        this.context = context;
        this.mArrayList = arrayList;

    }
    @NonNull
    @Override
    public Adapterexpencelist.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.act_expence_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterexpencelist.ViewHolder holder, int position) {
        holder.binding.txtamount.setText("Rs. " + mArrayList.get(position).getAmount());
        holder.binding.txtdate.setText(mArrayList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ActExpenceListItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
