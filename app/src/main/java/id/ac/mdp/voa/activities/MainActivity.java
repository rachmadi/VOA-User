package id.ac.mdp.voa.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.ac.mdp.voa.fragments.OrderFragment;
import id.ac.mdp.voa.fragments.ProfilFragment;
import id.ac.mdp.voa.fragments.ReimburseFragment;
import id.ac.mdp.voa.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FragmentTransaction ftBottomNavigation, ftOnCreate;

    // For Circular Image Menu


    private LinearLayout mRevealView;
    private boolean hidden = true;
    private ImageButton btnOrder1, btnOrder2, btnOrder3, btnOrder4, btnBantuan;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ftBottomNavigation = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_order:
                    ftBottomNavigation.replace(R.id.content, new OrderFragment(), "Fragment").commit();
                    setTitle(R.string.title_order);
                    return true;
                case R.id.navigation_profile:
                    ftBottomNavigation.replace(R.id.content, new ProfilFragment(), "Fragment").commit();
                    setTitle(R.string.title_profile);
                    return true;
                case R.id.navigation_message:
                    ftBottomNavigation.replace(R.id.content, new ReimburseFragment(), "Fragment").commit();
                    setTitle(R.string.title_reimburse);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        /* INITIALIZE */
        ftOnCreate = getSupportFragmentManager().beginTransaction();

        setTitle(R.string.title_order);
        ftOnCreate.replace(R.id.content, new OrderFragment(), "Fragment").commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}