package id.ac.mdp.voa.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.adapters.OrderHistoryViewAdapter;

public class OrderHistoryActivity extends AppCompatActivity {


    RecyclerView rvOrderHistoryList;
    OrderHistoryViewAdapter orderHistoryViewAdapter;


    //Dummy Data

    String[] username = {"John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White","John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White"};
    String[] time = {
            "12/05/17\n12:10",
            "12/05/17\n12:46",
            "12/05/17\n14:21",
            "12/05/17\n18:24",
            "13/05/17\n09:22",
            "14/05/17\n21:14",
            "15/05/17\n09:49",
            "15/05/17\n15:14",
            "16/05/17\n15:34",
            "16/05/17\n17:32",
            "16/05/17\n20:56",
            "17/05/17\n10:39",
            "17/05/17\n14:26",
            "17/05/17\n17:14"};
    String[] address = {"Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",};
    String[] statusOrder = {"Selesai","Sedang Dalam Perjalanan","Menunggu","Dibatalkan","Selesai","Sedang Dalam Perjalanan","Menunggu","Dibatalkan","Selesai","Sedang Dalam Perjalanan","Menunggu","Dibatalkan","Sedang Dalam Perjalanan","Menunggu"};
    int[] profileImage = {R.drawable.avatar,R.drawable.profil,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.avatar};

    String [] orderType = {
            "Hourly",
            "Daily",
            "Daily",
            "Hourly",
            "Daily",
            "Hourly",
            "Hourly",
            "Daily",
            "Daily",
            "Hourly",
            "Add Driver",
            "Add Driver",
            "Add Driver",
            "Add Driver"};
    String [] orderStatus = {
            "Order closed",
            "Order closed",
            "Full Occupied",
            "Cancel by Dispatcher",
            "Cancel by Dispatcher",
            "Cancel by Dispatcher",
            "Full Occupied",
            "Cancel by User",
            "Cancel by User",
            "Cancel by Dispatcher",
            "Full Occupied",
            "Cancel by User",
            "Full Occupied",
            "Full Occupied"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        rvOrderHistoryList = (RecyclerView)findViewById(R.id.rc_order_history);
        rvOrderHistoryList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderHistoryList.setItemAnimator(new DefaultItemAnimator());

        orderHistoryViewAdapter = new OrderHistoryViewAdapter(OrderHistoryActivity.this,username,address,time,orderType,orderStatus,profileImage);
        rvOrderHistoryList.setAdapter(orderHistoryViewAdapter);

    }
}
