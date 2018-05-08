package com.example.kaherine.parcialintento6;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {
    private Context mContext;
    private ArrayList<Contact> ListaContacto=new ArrayList<>();
    private int type;

    public ContactAdapter(Context mContext, int tipo, ArrayList<Contact> contactos)  {
        this.mContext = mContext;
        type = tipo;

        switch (type) {
            case 0:
                for (Contact C : contactos) {
                    if(C.isSearched())
                        ListaContacto.add(C);
                }
                break;
            case 1:
                for (Contact C : contactos) {
                    if (C.isFav() && C.isSearched())
                        ListaContacto.add(C);
                }
                break;

        }

    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, final int position) {
        holder.favoriteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact C = ListaContacto.get(holder.getAdapterPosition());
                if (!C.isFav()) {
                    C.setFav(true);
                    notifyDataSetChanged();
                }else{
                    C.setFav(false);
                    notifyDataSetChanged();
                }
            }
        });

        holder.CardContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
                    Intent i = new Intent(v.getContext(),ClickContact.class);
                    Bundle arguments = new Bundle();
                    arguments.putParcelable( "KEY", ListaContacto.get(position));
                    i.putExtras(arguments);
                    mContext.startActivity(i);

                }
                else{
                    Bundle arguments = new Bundle();
                    Fragment_ContactClick newClick = new Fragment_ContactClick();
                    arguments.putParcelable( "KEY", ListaContacto.get(position));
                    newClick.setArguments(arguments);
                    FragmentManager fragmentManager = ((FragmentActivity)mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.commit();

                }
            }
        });
        holder.nameTextView.setText(ListaContacto.get(position).getName());

        if(ListaContacto.get(position).getImageUri()==null)
            holder.imgImageView.setImageResource(R.drawable.ic_account_circle);
        else
            holder.imgImageView.setImageURI(Uri.parse(ListaContacto.get(position).getImageUri()));

        if(ListaContacto.get(position).isFav()) holder.favoriteImageButton.setImageResource(R.drawable.ic_star_on);
        else holder.favoriteImageButton.setImageResource(R.drawable.ic_star_off);



    }

    @Override
    public int getItemCount() {
        return ListaContacto.size();
    }

    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.cardview_contact, parent, false);

        return new ContactViewHolder(v);
    }
    protected class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        ImageView imgImageView;
        ImageButton favoriteImageButton;
        CardView CardContact;

        public ContactViewHolder(View itemView) {
            super(itemView);
            CardContact = itemView.findViewById(R.id.CardContacto);
            nameTextView = itemView.findViewById(R.id.nameCard);
            imgImageView = itemView.findViewById(R.id.profilePicture);
            favoriteImageButton = itemView.findViewById(R.id.favoriteButton);
        }
    }
    public void SetItems(ArrayList<Contact> items){
        ListaContacto = items;
    }

    public ArrayList<Contact> getListaContacto() {
        return ListaContacto;
    }
}