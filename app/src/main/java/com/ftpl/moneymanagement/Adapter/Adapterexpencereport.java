package com.ftpl.moneymanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ftpl.moneymanagement.Entity.expence;
import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.R;
import com.ftpl.moneymanagement.databinding.ActExpenceListBinding;
import com.ftpl.moneymanagement.databinding.ActListItemParentBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adapterexpencereport  extends RecyclerView.Adapter<Adapterexpencereport.ViewHolder>{
    private List<expence> mArrayList;
    private List<expence> mArrayListt;
    private Context context;
    private onRowClick listener;
    public Adapterexpencereport(Context context, List<expence> arrayList,  List<expence> ArrayListt, onRowClick listener) {
        this.context = context;
        this.mArrayList = arrayList;
        this.mArrayListt = ArrayListt;
        this.listener = listener;

    }
    @NonNull
    @Override
    public Adapterexpencereport.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.act_expence_list, parent, false);
        return new ViewHolder(view);
    }
    public  Double sumOfTolalProduct(String Name) {
        Double temp=0.0;
         mArrayListt.contains("House");
        if (mArrayListt!=null)
        {
            for (int i=0; i<mArrayListt.size();i++)
            {
                if (mArrayListt.get(i).getCategory().equals(Name)){
                temp  +=Double.parseDouble(mArrayListt.get(i).getAmount());
                }
            }
        }
        return  temp;
    }
    @Override
    public void onBindViewHolder(@NonNull Adapterexpencereport.ViewHolder holder, int position) {
        holder.binding.txtname.setText(mArrayList.get(position).getCategory());
        if(mArrayListt!=null&&mArrayListt.size()>0) {
            for (Iterator iterator = mArrayListt.iterator(); iterator.hasNext();) {
                expence bean = (expence) iterator.next();
                if(mArrayListt.get(position).getCategory().equals(bean.getCategory())) {
                    holder.binding.txttotalamount.setText("Rs. " + sumOfTolalProduct(bean.getCategory()).toString());
                }
            }
        }
        holder.binding.lyparent.setOnClickListener(View->listener.onclickexpence(mArrayList.get(position),mArrayListt));




    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ActExpenceListBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    public interface onRowClick{
        public void onclickexpence(expence detail, List<expence> mArrayList);


    }
}
