package mandar.gaikwad.arkids_version_1;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyFirebaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Questions");
        myRef.keepSynced(true);
    }
}



