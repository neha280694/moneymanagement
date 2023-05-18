package com.ftpl.moneymanagement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.ftpl.moneymanagement.databinding.FragmentFmCategoryListDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.ftpl.moneymanagement.Adapter.AdapterCategory;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     Fm_category.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class Fm_category extends BottomSheetDialogFragment implements AdapterCategory.onRowClick {
    List<Imagedetail> category = new ArrayList<>();
    FragmentFmCategoryListDialogBinding binding;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_fm_category_list_dialog, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fm_category_list_dialog, container, false);
        View view = binding.getRoot();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Imagedetail img = new Imagedetail();
            img.setImage(getActivity().getDrawable(R.drawable.ic_basket));
            img.setName("FOOD");
            category.add(img);
            Imagedetail img1 = new Imagedetail();
            img1.setImage(getActivity().getDrawable(R.drawable.ic_building));
            img1.setName("HOUSE");
            category.add(img1);
            Imagedetail img2 = new Imagedetail();
            img2.setImage(getActivity().getDrawable(R.drawable.ic_spoon));
            img2.setName("EATING OUT");
            category.add(img2);
            Imagedetail img3 = new Imagedetail();
            img3.setImage(getActivity().getDrawable(R.drawable.ic_shirt));
            img3.setName("CLOTHES");
            category.add(img3);
            Imagedetail img4 = new Imagedetail();
            img4.setImage(getActivity().getDrawable(R.drawable.ic_cvehical));
            img4.setName("CAR");
            category.add(img4);
            Imagedetail img5 = new Imagedetail();
            img5.setImage(getActivity().getDrawable(R.drawable.ic_bus));
            img5.setName("TRANSPORT");
            category.add(img5);
            Imagedetail img6 = new Imagedetail();
            img6.setImage(getActivity().getDrawable(R.drawable.ic_fever));
            img6.setName("HEALTH");
            category.add(img6);
            Imagedetail img7 = new Imagedetail();
            img7.setImage(getActivity().getDrawable(R.drawable.ic_glass));
            img7.setName("ENTERTAINMENT");
            category.add(img7);
            Imagedetail img8 = new Imagedetail();
            img8.setImage(getActivity().getDrawable(R.drawable.ic_mobile));
            img8.setName("COMMUNICATION");
            category.add(img8);
            Imagedetail img9 = new Imagedetail();
            img9.setImage(getActivity().getDrawable(R.drawable.ic_toiletries));
            img9.setName("TOILETRIES");
            category.add(img9);
            Imagedetail img10 = new Imagedetail();
            img10.setImage(getActivity().getDrawable(R.drawable.ic_soccer_player));
            img10.setName("SPORTS");
            category.add(img10);
        }


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = (RecyclerView) view.findViewById(R.id.list);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setHasFixedSize(true);

        AdapterCategory adapter = new AdapterCategory(getContext(), category, this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onclick(Imagedetail details) {
        if (details != null) {

            Intent in = new Intent(getContext(), act_expence.class);
            in.putExtra("text", details.getName());

            getContext().startActivity(in);
            dismiss();


        }
    }
}