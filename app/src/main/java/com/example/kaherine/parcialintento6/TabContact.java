package com.example.kaherine.parcialintento6;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Tabcontact extends Fragment {
    private View v;

    private RecyclerView recyclerView;
    public Tabcontact(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_recycler_view, container, false);

        GridLayoutManager grid = new GridLayoutManager(getContext(),2);


        recyclerView = v.findViewById(R.id.rv_contacts);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        RecyclerView.LayoutManager layoutManager = grid;

        recyclerView.setLayoutManager(layoutManager);

        ContactAdapter adapter = new ContactAdapter(getContext(),getContacts());

        recyclerView.setAdapter(adapter);

        return v;
    }

    private List<Contact> getContacts(){

        List<Contact> list = new ArrayList<>();

        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null,null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        cursor.moveToFirst();

        while (cursor.moveToNext()){

            list.add(new Contact(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
        }

        return list;
    }
}
