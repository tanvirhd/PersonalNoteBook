package com.pdst.personalnotebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

import com.pdst.personalnotebook.R;
import com.pdst.personalnotebook.model.ModelNote;

import java.util.List;

public class AdapterNoteRecy extends RecyclerView.Adapter<AdapterNoteRecy.ViewHolderAdapterNoteRecy> {

    List<ModelNote> modelNoteList;
    Context context;

    public AdapterNoteRecy(List<ModelNote> modelNoteList, Context context) {
        this.modelNoteList = modelNoteList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterNoteRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_note,parent,false);
        ViewHolderAdapterNoteRecy viewHolderAdapterNoteRecy=new ViewHolderAdapterNoteRecy(view);

        return viewHolderAdapterNoteRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterNoteRecy holder, int position) {
        holder.tvNoteTitle.setText(modelNoteList.get(position).getNoteTitle());
        holder.tvNoteBody.setText(modelNoteList.get(position).getNoteBody());
        holder.tvNoteModifiedDate.setText(modelNoteList.get(position).getModifiedOn());
        holder.ivLock.setVisibility(View.GONE);

        if(modelNoteList.get(position).isProtected()){
            holder.lockedView.setVisibility(View.GONE);
            holder.ivLock.setVisibility(View.VISIBLE);
        }else {
            holder.lockedView.setVisibility(View.VISIBLE);
            holder.ivLock.setVisibility(View.GONE);
        }
        /*if(modelNoteList.get(position).isPinned()){
            holder.ivNotePin.setImageResource(R.drawable.icon_pin);
        }else{
            holder.ivNotePin.setVisibility(View.GONE);
        }

        if(!modelNoteList.get(position).isHasAttachment()){
            holder.tvNoteAttachment.setVisibility(View.GONE);
            holder.ivNoteAttachmentIcon.setVisibility(View.GONE);
        }
        if(modelNoteList.get(position).isProtected()){
            holder.tvNoteBody.setVisibility(View.GONE);
            holder.tvNoteAttachment.setVisibility(View.GONE);
            holder.tvNoteModifiedDate.setVisibility(View.GONE);
            holder.ivNoteAttachmentIcon.setVisibility(View.GONE);
            holder.ivLock.setImageResource(R.drawable.icon_lock);
            holder.ivLock.setVisibility(View.VISIBLE);
            holder.ivNotePin.setVisibility(View.GONE);
            holder.tvCategory.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        return modelNoteList.size();
    }

    public class ViewHolderAdapterNoteRecy extends RecyclerView.ViewHolder{
        TextView tvNoteTitle,tvNoteBody,tvNoteModifiedDate,tvNotePassword,tvNoteAttachment,tvCategory;
        ImageView ivNotePin,ivNoteAttachmentIcon,ivLock;
        Group lockedView;

        public ViewHolderAdapterNoteRecy(@NonNull View itemView) {
            super(itemView);

            tvNoteTitle=itemView.findViewById(R.id.tvNoteTitle);
            tvNoteBody=itemView.findViewById(R.id.tvNoteBody);
            tvNoteModifiedDate=itemView.findViewById(R.id.noteModified);
            tvNoteAttachment=itemView.findViewById(R.id.tvAttachment);
            tvCategory=itemView.findViewById(R.id.tvCategory);

            ivNotePin=itemView.findViewById(R.id.ivPin);
            ivNoteAttachmentIcon=itemView.findViewById(R.id.ivAttatchmentIcon);
            ivLock=itemView.findViewById(R.id.ivLockIcon);
            lockedView =itemView.findViewById(R.id.grouplockedView);
        }
    }
}
