package com.example.kaherine.parcialintento6;


public class Contact {
    private String name, number, mail, address, uriimage;
    private boolean favs, searched;



    public Contact(String name, String number, String uriimage,String email,boolean fav){
                this.name = name;
                this.number = number;
                this.uriimage = uriimage;
                this.mail = email;
                this.favs=favs;
                searched=false;

        }

public String getName(){
        return name;
        }

public void setName(String name){
        this.name = name;
        }


public String getMail() {
        return mail;
        }

public void setMail(String mail) {
        this.mail= mail;
        }

public String getAddress(){
        return address;
        }

public void setAddress(String address){
        this.address=address;
        }

public String getUriimage(){
        return uriimage;
        }

public void setUriimage(String uriimage){
        this.uriimage=uriimage;
        }

public String getNumber(){ return number;}

public void setNumber(String number) { this.number=number;}


public boolean isFavs(){
        return favs;
        }

public void setFavs(boolean favs) {
        this.favs = favs;
        }

public boolean isSearched(){
        return searched;
        }

public void setSearched(boolean searched) {
        this.searched = searched;
        }



        }

