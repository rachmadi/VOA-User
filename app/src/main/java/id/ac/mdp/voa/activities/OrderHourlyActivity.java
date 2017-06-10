package id.ac.mdp.voa.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import id.ac.mdp.voa.R;

public class OrderHourlyActivity extends AppCompatActivity{

    int PLACE_PICKER_REQUEST_FROM_POSITION = 1;
    int PLACE_PICKER_REQUEST_TO_POSITION = 2;
    TextView tvFromPosition, tvToPosition, tvOrderDate, tvUntilTitle;
    LinearLayout llUntilContainer;
    ImageView mapPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_hourly);

        tvFromPosition = (TextView)findViewById(R.id.fromPosition);
        tvToPosition = (TextView)findViewById(R.id.toPosition);
        mapPreview = (ImageView)findViewById(R.id.mapPreview);
        llUntilContainer = (LinearLayout) findViewById(R.id.ll_until_container);
        tvUntilTitle = (TextView) findViewById(R.id.tvUntilTitle);
        getSupportActionBar().setElevation(0);

        tvOrderDate = (TextView) findViewById(R.id.tvOrderHourlyDate);

        tvFromPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(OrderHourlyActivity.this), PLACE_PICKER_REQUEST_FROM_POSITION);
                }catch (GooglePlayServicesRepairableException e){
                    e.printStackTrace();
                }catch (GooglePlayServicesNotAvailableException e){
                    e.printStackTrace();
                }
            }
        });

        tvToPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(OrderHourlyActivity.this), PLACE_PICKER_REQUEST_TO_POSITION);
                }catch (GooglePlayServicesRepairableException e){
                    e.printStackTrace();
                }catch (GooglePlayServicesNotAvailableException e){
                    e.printStackTrace();
                }
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.sp_order_hourly_activity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.activity_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinnerDuration = (Spinner)findViewById(R.id.sp_order_duration_hourly_activity);
        ArrayAdapter<CharSequence> adapterDuration = ArrayAdapter.createFromResource(this,R.array.order_duration, android.R.layout.simple_spinner_item);
        adapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDuration.setAdapter(adapterDuration);

        Spinner spinnerPic = (Spinner)findViewById(R.id.sp_order_pic_hourly);
        ArrayAdapter<CharSequence> adapterPic = ArrayAdapter.createFromResource(this,R.array.user_name, R.layout.item_spinner_style);
        adapterPic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPic.setAdapter(adapterPic);

        final SwitchCompat switchCompat = (SwitchCompat)findViewById(R.id.sw_order_hourly_repeat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(OrderHourlyActivity.this);
                alert.setMessage("Order akan dilakukan secara otomatis sampai tanggal 07/04/2017.");
                alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        llUntilContainer.setVisibility(View.VISIBLE);
                        tvUntilTitle.setVisibility(View.VISIBLE);
                    }
                });
                alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        llUntilContainer.setVisibility(View.GONE);
                        tvUntilTitle.setVisibility(View.GONE);
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST_FROM_POSITION) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("%s", place.getAddress());
                tvFromPosition.setText(toastMsg);
                Double lat = place.getLatLng().latitude;
                Double lng = place.getLatLng().longitude;
                String url = "http://maps.google.com/maps/api/staticmap?center=" + lat + "," + lng + "&zoom=16&size=500x300&markers=color:0xff0000%7Clabel:%7C" + lat + "," + lng + "&key=AIzaSyD0Sntn9DyXQmvJH5xr9xRfClQlLtqhuIg";
                Glide.with(this).load(url).into(mapPreview);
            }
        }

        if (requestCode == PLACE_PICKER_REQUEST_TO_POSITION) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("%s", place.getAddress());
                tvToPosition.setText(toastMsg);
                Double lat = place.getLatLng().latitude;
                Double lng = place.getLatLng().longitude;
                String url = "http://maps.google.com/maps/api/staticmap?center=" + lat + "," + lng + "&zoom=16&size=500x300&markers=color:0xff0000%7Clabel:%7C" + lat + "," + lng + "&key=AIzaSyD0Sntn9DyXQmvJH5xr9xRfClQlLtqhuIg";
                Glide.with(this).load(url).into(mapPreview);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.order_hourly, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.order_hourly_submit) {
            // Start Activity
            //startActivity(new Intent(ActivityOrderDetail.this, ActivityAddPin.class));
            finish();
            Toast.makeText(OrderHourlyActivity.this, "Order Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
