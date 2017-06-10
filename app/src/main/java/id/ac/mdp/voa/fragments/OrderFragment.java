package id.ac.mdp.voa.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.adapters.OrderViewAdapter;
import id.ac.mdp.voa.activities.OrderAdditionalDriverActivity;
import id.ac.mdp.voa.activities.OrderDailyActivity;
import id.ac.mdp.voa.activities.OrderHistoryActivity;
import id.ac.mdp.voa.activities.OrderHourlyActivity;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/*
 * Created by Tengku Kevin on 3/24/2017.
 */

public class OrderFragment extends Fragment {
    RecyclerView rvOrderList;
    OrderViewAdapter orderViewAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    FragmentTransaction ft;
    LinearLayout orderHourly, orderDaily, orderAddDriver;



    /* ------------------DUMMY DATA [START]------------------ */

    String[] username = {"John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White","John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White"};
    /*String[] time = {"12 Mei 2017, 12:10PM",
            "12 Mei 2017, 12:46PM",
            "12 Mei 2017, 14:21PM",
            "12 Mei 2017, 18:24PM",
            "13 Mei 2017, 09:22PM",
            "14 Mei 2017, 21:14PM",
            "15 Mei 2017, 09:49PM",
            "15 Mei 2017, 15:14PM",
            "16 Mei 2017, 15:34PM",
            "16 Mei 2017, 17:32PM",
            "16 Mei 2017, 20:56PM",
            "17 Mei 2017, 10:39PM",
            "17 Mei 2017, 14:26PM",
            "17 Mei 2017, 17:14PM"};*/

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
            "Passenger in",
            "On location",
            "Order processed",
            "On the way",
            "Approved",
            "Approved",
            "Approved",
            "On the way",
            "Order processed",
            "Order processed",
            "Approved",
            "On the way",
            "Approved",
            "Approved"};
    /* ------------------DUMMY DATA [END]------------------ */

    public OrderFragment(){
        // Constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        setHasOptionsMenu(true);

        orderHourly = (LinearLayout)view.findViewById(R.id.orderHourly);
        orderHourly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderHourlyActivity.class));
            }
        });

        orderDaily = (LinearLayout)view.findViewById(R.id.orderDaily);
        orderDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderDailyActivity.class));
            }
        });

        orderAddDriver = (LinearLayout)view.findViewById(R.id.orderAddDriver);
        orderAddDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderAdditionalDriverActivity.class));
            }
        });
        //swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swpOrder);
        rvOrderList = (RecyclerView)view.findViewById(R.id.rc_order);
        rvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvOrderList.setItemAnimator(new DefaultItemAnimator());

        orderViewAdapter = new OrderViewAdapter(getContext(),username,address,time,orderType,orderStatus,profileImage);
        rvOrderList.setAdapter(orderViewAdapter);


//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.order, menu);
        super.onCreateOptionsMenu(menu, inflater);

        ft = getFragmentManager().beginTransaction();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_notification) {
            ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            ft.replace(R.id.content, new NotificationFragment(), "Fragment").commit();
            return true;
        }else if(id == R.id.action_help){
            OrderType();
            return true;
        }else if(id == R.id.action_history){
            startActivity(new Intent(getContext(), OrderHistoryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void OrderType(){
        final CharSequence[] options = { "Cara Order", "Ubah Profil", "Membatalkan Order" };

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Bantuan");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Cara Order"))
                {
                    Toast.makeText(getContext(), "Cara Order", Toast.LENGTH_SHORT).show();
                }
                else if (options[item].equals("Ubah Profil"))
                {
                    Toast.makeText(getContext(), "Ubah Profil", Toast.LENGTH_SHORT).show();
                }
                else if (options[item].equals("Membatalkan Order"))
                {
                    Toast.makeText(getContext(), "Membatalkan Order", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
    }

    protected void tutor(){
        new MaterialTapTargetPrompt.Builder(getActivity())
                .setTarget(getActivity().findViewById(R.id.action_help))
                .setPrimaryText("Buat Postingan Baru")
                .setSecondaryText("Tekan tombol pensil untuk membuat postingan baru")
                .setBackgroundColour(ContextCompat.getColor(getActivity(), R.color.colorPrimary))
                .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                    @Override
                    public void onHidePrompt(MotionEvent event, boolean tappedTarget) {

                    }

                    @Override
                    public void onHidePromptComplete() {

                    }
                }).show();
    }
}
