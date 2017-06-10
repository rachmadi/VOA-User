package id.ac.mdp.voa.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.mdp.voa.fragments.MapFragment;
import id.ac.mdp.voa.R;

public class OrderDetailActivity extends AppCompatActivity {

    TextView mTextMessage, tvOrderAddress, tvOrderTime, tvOrderType, tvOrderStatus, tvMapDetail;
    Bundle bundle;
    CircleImageView ivUserProfile;
    AlertDialog alertDialog;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_call:
                    //startActivity(new Intent(OrderDetailActivity.this, ActivityMaps.class));
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:0377778888"));

                    if (ActivityCompat.checkSelfPermission(OrderDetailActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    }
                    startActivity(callIntent);
                return true;
                case R.id.navigation_send_message:
                    startActivity(new Intent(OrderDetailActivity.this, ChatActivity.class));
                    return true;
                case R.id.navigation_cancel_order:
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderDetailActivity.this);
                    alertDialogBuilder.setTitle("Membatalkan Order.");
                    alertDialogBuilder.setMessage("Batalkan order yang berlangsung?");
                    alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(OrderDetailActivity.this, "Order Dibatalkan", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                    alertDialogBuilder.show();
                    return true;
                /*
                case R.id.navigation_cancel_order:
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderDetailActivity.this);
                    alertDialogBuilder.setTitle("Membatalkan Order.");
                    alertDialogBuilder.setMessage("Dengan membatalkan order bla bla bla");
                    alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    alertDialogBuilder.show();
                    return true;
                    */
                /*
                case R.id.navigation_cancel:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                    */
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
                Color.GRAY,
                Color.RED,
                Color.GREEN,
                Color.BLUE
        };


        mTextMessage = (TextView) findViewById(R.id.tvOrderUsername);
        tvOrderAddress = (TextView) findViewById(R.id.tvOrderAddress);
        tvOrderTime = (TextView) findViewById(R.id.tvOrderTime);
        ivUserProfile = (CircleImageView) findViewById(R.id.ivUserProfile);
        tvOrderType = (TextView) findViewById(R.id.tv_detail_order_type);
        tvOrderStatus = (TextView) findViewById(R.id.tv_detail_order_status);
        tvMapDetail = (TextView)findViewById(R.id.tv_view_map_detail);


        tvMapDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailActivity.this, MapsActivity.class));
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_order_detail);

        navigation.setItemIconTintList(new ColorStateList(states,colors));
        navigation.setItemTextColor(new ColorStateList(states,colors));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bundle = getIntent().getExtras();
        String username = bundle.getString("orderUserName");
        String address = bundle.getString("orderAddress");
        String time = bundle.getString("orderTime");
        int image = (int)bundle.get("orderProfil");
        String orderType = bundle.getString("orderType");
        String orderStatus = bundle.getString("orderStatus");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mapContainer, new MapFragment(), "Fragment").commit();

        mTextMessage.setText(username);
        tvOrderAddress.setText(address);
        tvOrderTime.setText(time);
        tvOrderType.setText(orderType);
        tvOrderStatus.setText(orderStatus);

        if (orderType.equals("Hourly")){
            tvOrderType.setTextColor(Color.rgb(25,118,210));
        }else if (orderType.equals("Daily")){
            tvOrderType.setTextColor(Color.rgb(2,136,209));
        }else if (orderType.equals("Add Driver")){
            tvOrderType.setTextColor(Color.rgb(0,151,167));
        }

        if (orderStatus.equals("Order processed")){
            tvOrderStatus.setTextColor(Color.rgb(255,152,0));
        }else if (orderStatus.equals("Approved")){
            tvOrderStatus.setTextColor(Color.rgb(76,175,80));
        }else if (orderStatus.equals("On the way")){
            tvOrderStatus.setTextColor(Color.rgb(0,150,136));
        }else if (orderStatus.equals("On location")){
            tvOrderStatus.setTextColor(Color.rgb(33,150,243));
        }else if (orderStatus.equals("Passenger in")){
            tvOrderStatus.setTextColor(Color.rgb(76,175,80));
        }else if (orderStatus.equals("Order closed")){
            tvOrderStatus.setTextColor(Color.rgb(96,125,139));
        }else if (orderStatus.equals("Cancel by User")){
            tvOrderStatus.setTextColor(Color.rgb(244,67,54));
        }else if (orderStatus.equals("Cancel by Dispatcher")){
            tvOrderStatus.setTextColor(Color.rgb(244,67,54));
        }else if (orderStatus.equals("Full Occupied")){
            tvOrderStatus.setTextColor(Color.rgb(103,58,183));
        }

        Glide.clear(ivUserProfile);
        Glide.with(this)
                .load(image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivUserProfile);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.order_detail_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_insert_key) {
            // Start Activity
            //startActivity(new Intent(OrderDetailActivity.this, ActivityAddPin.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        finish();
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.order_detail_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {int id = item.getItemId();

        if (id == R.id.navigation_cancel_order) {
            Toast.makeText(this, "Order Dibatalkan", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }*/
}
