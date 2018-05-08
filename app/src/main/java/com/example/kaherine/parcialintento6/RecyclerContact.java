package com.example.kaherine.parcialintento6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerContact extends Fragment {
    private RecyclerView rv;
    private FloatingActionButton plus;
    private ContactAdapter adapter;
    private GridLayoutManager manager;
    private ArrayList<Contact> contactos;
    private int type;

    public static RecyclerContact newInstance(int type,ArrayList<Contact> contacts){
        RecyclerContact fragment = new RecyclerContact();
        fragment.type = type;
        fragment.contactos=contacts;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_contact, container, false);

        rv = v.findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        if(savedInstanceState!=null){
            contactos=savedInstanceState.getParcelableArrayList("CONTACT_ADAPTER");
            type=savedInstanceState.getInt("TYPE_RECYCLER");
        }
        adapter = new ContactAdapter(container.getContext(), type,contactos);

        manager = new GridLayoutManager(container.getContext(),3);

        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        plus = v.findViewById(R.id.AddRecycler);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(rv.getContext(),AddContact.class);
                i.putExtra("KEY", adapter.getListaContacto());
                v.getContext().startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("CONTACT_ADAPTER",contactos);
        outState.putInt("TYPE_RECYCLER",type);
    }
}