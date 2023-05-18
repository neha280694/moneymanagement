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

import java.util.List;

public class AdapterCategory  extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {
    private List<Imagedetail> mArrayList;
    private Context context;
    private onRowClick listener;
    public AdapterCategory(Context context, List<Imagedetail> arrayList,onRowClick listener) {
        this.context = context;
        this.mArrayList = arrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public AdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_fm_category_list_dialog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategory.ViewHolder holder, int position) {
        holder.binding.img.setImageDrawable(mArrayList.get(position).getImage());
        holder.binding.card.setOnClickListener(View->listener.onclick(mArrayList.get(position)));

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public FragmentFmCategoryListDialogItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
    public interface onRowClick{
        public void onclick(Imagedetail details);

    }
}
