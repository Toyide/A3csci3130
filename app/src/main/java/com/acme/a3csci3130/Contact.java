package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String email;
    public  String bnumber;
    public  String address;
    public  String brole;
    public  String province;
    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String email,String bnu,String addr,String bro, String prov){
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.bnumber = bnu;
        this.address = addr;
        this.brole=bro;
        this.province=prov;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("Bnum",bnumber);
        result.put("address",address);
        result.put("Brole",brole);
        result.put("province",province);

        return result;
    }
}
