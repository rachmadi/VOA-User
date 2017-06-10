package id.ac.mdp.voa.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import id.ac.mdp.voa.R;

public class RatingActivity extends AppCompatActivity {


    SmileRating smileRating;

    TextView tvDriverReview, tvVehicleReview, tvVendorReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        smileRating = (SmileRating) findViewById(R.id.smile_rating);
        tvDriverReview = (TextView) findViewById(R.id.tv_driver_review);
        tvVehicleReview = (TextView) findViewById(R.id.tv_vehicle_review);
        tvVendorReview = (TextView) findViewById(R.id.tv_vendor_review);

        smileRating.setNameForSmile(BaseRating.TERRIBLE, "Sangat Buruk");
        smileRating.setNameForSmile(BaseRating.BAD, "Buruk");
        smileRating.setNameForSmile(BaseRating.OKAY, "Biasa Saja");
        smileRating.setNameForSmile(BaseRating.GOOD, "Puas");
        smileRating.setNameForSmile(BaseRating.GREAT, "Sangat Puas");

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(RatingActivity.this, "Buruk", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(RatingActivity.this, "Puas", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(RatingActivity.this, "Sangat Puas", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(RatingActivity.this, "Biasa Saja", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(RatingActivity.this, "Sangat Buruk", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        tvDriverReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(RatingActivity.this);
                builder.setTitle("Title");

// Set up the input
                final EditText input = new EditText(RatingActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setHeight(150);
                input.setGravity(View.TEXT_ALIGNMENT_TEXT_START);
                input.setHint("Ulasan untuk driver (Opsional)");
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDriverReview.setText(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        tvVehicleReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(RatingActivity.this);
                builder.setTitle("Ulasan Kendaraan");

// Set up the input
                final EditText input = new EditText(RatingActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setHeight(150);
                input.setGravity(View.TEXT_ALIGNMENT_TEXT_START);
                input.setHint("Ulasan untuk Kendaraan (Opsional)");
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvVehicleReview.setText(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        tvVendorReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(RatingActivity.this);
                builder.setTitle("Ulasan Vendor");

// Set up the input
                final EditText input = new EditText(RatingActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                //input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setHeight(150);
                input.setGravity(View.TEXT_ALIGNMENT_TEXT_START);
                input.setHint("Ulasan untuk vendor (Opsional)");
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvVendorReview.setText(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.rating_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.rating_menu_send) {
            // Start Activity
            //startActivity(new Intent(OrderDetailActivity.this, ActivityAddPin.class));
            finish();
            Toast.makeText(RatingActivity.this, "Review telah dikirimkan", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
