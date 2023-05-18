package com.ftpl.moneymanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ftpl.moneymanagement.Imagedetail;
import com.ftpl.moneymanagement.R;
import com.ftpl.moneymanagement.databinding.FragmentFmCategoryListDialogItemBinding;
import com.ftpl.moneymanagement.databinding.FragmentFmIncomeListDialogItemBinding;
import com.ftpl.moneymanagement.incomecategory;

import java.util.List;

public class Adapterincomecaategory extends RecyclerView.Adapter<Adapterincomecaategory.ViewHolder> {
    private List<incomecategory> mArrayList;
    private Context context;
    private onRowClick listener;
    public Adapterincomecaategory(Context context, List<incomecategory> arrayList,onRowClick listener) {
        this.context = context;
        this.mArrayList = arrayList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public Adapterincomecaategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_fm_income_list_dialog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterincomecaategory.ViewHolder holder, int position) {
        holder.binding.txtname.setText(mArrayList.get(position).getName());
        holder.binding.card.setOnClickListener(View->listener.onclick(mArrayList.get(position)));

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public FragmentFmIncomeListDialogItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
    public interface onRowClick{
        public void onclick(incomecategory details);

    }
}
