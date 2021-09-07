package com.pdst.personalnotebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdst.personalnotebook.R;
import com.pdst.personalnotebook.model.ModelCategory;

import java.util.List;

public class AdapterNoteCategoryRecy extends RecyclerView.Adapter<AdapterNoteCategoryRecy.ViewHolderAdapterNoteCategoryRecy> {

    List<ModelCategory> categoryList;
    Context context;

    public AdapterNoteCategoryRecy(List<ModelCategory> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterNoteCategoryRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_category,parent,false);
        ViewHolderAdapterNoteCategoryRecy viewHolderAdapterNoteCategoryRecy=new ViewHolderAdapterNoteCategoryRecy(view);

        return viewHolderAdapterNoteCategoryRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterNoteCategoryRecy holder, int position) {
        holder.tvCategoryName.setText(categoryList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolderAdapterNoteCategoryRecy extends RecyclerView.ViewHolder{
        TextView tvCategoryName;
        public ViewHolderAdapterNoteCategoryRecy(@NonNull View itemView) {
            super(itemView);
            tvCategoryName=itemView.findViewById(R.id.tvNoteCategory);
        }
    }
}
