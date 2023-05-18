package com.ftpl.moneymanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ftpl.moneymanagement.Entity.income;
import com.ftpl.moneymanagement.R;
import com.ftpl.moneymanagement.databinding.ActListItemParentBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adapterincome  extends RecyclerView.Adapter<Adapterincome.ViewHolder> {
    private static final String TAG = "Adapterincome";
    private List<income> mArrayList;
    private List<income> mArrayListt;
    private List<income> timeSlotsSelected;

    private Context context;

    private static int currentPosition = 0;


    public Adapterincome(Context context, List<income> arrayList,  List<income> ArrayListt,List<income> timeSlotsSelected) {
        this.context = context;
        this.mArrayList = arrayList;
        this.mArrayListt = ArrayListt;

        this.timeSlotsSelected = timeSlotsSelected;


    }




    @NonNull
    @Override
    public Adapterincome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.act_list_item_parent, parent, false);
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
    public void onBindViewHolder(@NonNull Adapterincome.ViewHolder holder, int position) {


        holder.binding.txtnamepar.setText(mArrayList.get(position).getCategory());

        if(mArrayListt!=null&&mArrayListt.size()>0) {
            for (Iterator iterator = mArrayListt.iterator(); iterator.hasNext();) {
                income bean = (income) iterator.next();
                if(mArrayListt.get(position).getCategory().equals(bean.getCategory())) {
                    holder.binding.txttotalamount.setText("Rs. " + sumOfTolalProduct(bean.getCategory()).toString());
                }
            }
        }
        holder.binding.txtamount.setText(mArrayListt.get(position).getAmount());
        holder.binding.txtdate.setText(mArrayListt.get(position).getDate());
       // holder.binding.lypa.setVisibility(View.VISIBLE);
       // boolean isExpanded = mArrayListt.get(position).isExpanded();
        //holder.binding.lypa.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

            //creating an animation

            //toggling visibility


        holder.binding.lyparentt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // holder.binding.lypa.setVisibility(View.INVISIBLE);

                //getting the position of the item to expand it
                //currentPosition = position;


if(holder.binding.lypa.getVisibility()==View.INVISIBLE) {
    currentPosition = position;
    holder.binding.lypa.setVisibility(View.VISIBLE);
    Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
    //adding sliding effect
    holder.binding.lypa.startAnimation(slideDown);
}else {
    holder.binding.lypa.setVisibility(View.INVISIBLE);
}

                //reloding the list

            }

        });



       // holder.binding.lyparent.setOnClickListener(View->listener.onclickparent(mArrayList.get(position),mArrayListt));


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ActListItemParentBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
          /*  expandableLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    income movie = mArrayListt.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });*/

        }

    }

  /*  public interface onRowClick{
        public void onclickparent(income detail, List<income> mArrayList);



    }
*/



}
