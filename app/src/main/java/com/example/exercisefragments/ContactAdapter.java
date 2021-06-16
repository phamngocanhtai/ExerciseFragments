package com.example.exercisefragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {

    ArrayList<Contact> contactArrayList;
    OnItemClickListener onItemClickListener;

    public ContactAdapter(ArrayList<Contact> contactArrayList, OnItemClickListener onItemClickListener) {
        this.contactArrayList = contactArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void setOnUserClickListener(Contact onUserClickListener);
    }

    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_layout, parent, false);

        ContactVH contactVH = new ContactVH(view);
        return contactVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactVH holder, int position) {

        Contact contact = contactArrayList.get(position);

        holder.txtName.setText(contact.name);
        switch (contact.avatar)
        {
            case 0: holder.imgAvatar.setImageResource(R.drawable.icon_female1); break;
            case 1: holder.imgAvatar.setImageResource(R.drawable.icon_female2); break;
            case 2: holder.imgAvatar.setImageResource(R.drawable.icon_male1); break;
            case 3: holder.imgAvatar.setImageResource(R.drawable.icon_male2); break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.setOnUserClickListener(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    class ContactVH extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgAvatar;

        public ContactVH(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
