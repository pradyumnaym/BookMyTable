package com.example.bookmytable.FirebaseAPI;
import com.firebase.client.Firebase;

public class FireBase extends android.app.Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
