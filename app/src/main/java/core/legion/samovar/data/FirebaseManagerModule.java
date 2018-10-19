package core.legion.samovar.data;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.FirebaseFirestore;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class FirebaseManagerModule {

    @Provides
    static FirebaseOptions firebaseOptions(Context context) {
        return FirebaseOptions.fromResource(context);
    }

    @Provides
    static FirebaseApp firebaseApp(Context context, FirebaseOptions firebaseOptions) {
        return FirebaseApp.getInstance();
//        return FirebaseApp.initializeApp(context, firebaseOptions);
    }

    @Provides
    static FirebaseFirestore firebaseFirestore(FirebaseApp firebaseApp) {
        return FirebaseFirestore.getInstance(firebaseApp);
    }

    @Binds
    abstract DBManager firebaseManager(FirebaseManager manager);
}
