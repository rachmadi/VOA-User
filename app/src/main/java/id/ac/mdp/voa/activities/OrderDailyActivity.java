package id.ac.mdp.voa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import id.ac.mdp.voa.R;

public class OrderDailyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_daily);
        getSupportActionBar().setElevation(0);

        Spinner spinner = (Spinner)findViewById(R.id.sp_order_daily_activity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.activity_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinnerCar = (Spinner)findViewById(R.id.sp_order_car_type_daily_activity);
        ArrayAdapter<CharSequence> adapterCar = ArrayAdapter.createFromResource(this,R.array.car_type_list, android.R.layout.simple_spinner_item);
        adapterCar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCar.setAdapter(adapterCar);

        Spinner spinnerPic = (Spinner)findViewById(R.id.sp_order_pic_daily);
        ArrayAdapter<CharSequence> adapterPic = ArrayAdapter.createFromResource(this,R.array.user_name, R.layout.item_spinner_style);
        adapterPic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPic.setAdapter(adapterPic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.order_hourly, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.order_daily_submit) {
            // Start Activity
            //startActivity(new Intent(OrderDetailActivity.this, ActivityAddPin.class));
            finish();
            Toast.makeText(OrderDailyActivity.this, "Order Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
