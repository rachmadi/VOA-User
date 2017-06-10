package id.ac.mdp.voa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import id.ac.mdp.voa.R;

public class OrderAdditionalDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_additional_driver);
        getSupportActionBar().setElevation(0);

        Spinner spinnerKcp = (Spinner)findViewById(R.id.sp_additional_driver_kcp);
        ArrayAdapter<CharSequence> adapterKcp = ArrayAdapter.createFromResource(this,R.array.kcp_list, android.R.layout.simple_spinner_item);
        adapterKcp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKcp.setAdapter(adapterKcp);

        Spinner spinnerKcu = (Spinner)findViewById(R.id.sp_additional_driver_kcu);
        ArrayAdapter<CharSequence> adapterKcu = ArrayAdapter.createFromResource(this,R.array.kcu_list, android.R.layout.simple_spinner_item);
        adapterKcu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKcu.setAdapter(adapterKcu);

        Spinner spinnerNopol = (Spinner)findViewById(R.id.sp_additional_driver_nopol);
        ArrayAdapter<CharSequence> adapterNopol = ArrayAdapter.createFromResource(this,R.array.nopol_list, android.R.layout.simple_spinner_item);
        adapterNopol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNopol.setAdapter(adapterNopol);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.order_additional_driver, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.order_additional_driver_submit) {
            // Start Activity
            //startActivity(new Intent(OrderDetailActivity.this, ActivityAddPin.class));
            finish();
            Toast.makeText(OrderAdditionalDriverActivity.this, "Order Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
