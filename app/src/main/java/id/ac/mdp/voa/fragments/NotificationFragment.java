package id.ac.mdp.voa.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.adapters.NotificationViewAdapter;
import id.ac.mdp.voa.activities.OrderHistoryActivity;

/**
 * Created by Tengku Kevin on 4/21/2017.
 */

public class NotificationFragment extends Fragment {

    String[] username = {"John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White","John Mickley","John Connor","Mary Blaster","Kennan Lee","Rock Boy","Regent Key","Ken White"};
    String[] time = {"12:10","14:20","23:11","14:22","08:21","02:09","17:30","12:10","14:20","23:11","14:22","08:21","02:09","17:30"};
    String[] address = {"Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Those pilots elected Bill captain of our team, Alfred niece keeps the room warm.",
            "I called him 'the science teacher.'",
            "Those flight attendants had him drive.",
            "Those flight attendants had him drive.",
            "Jalan Srijaya Negara, Lrg. Jaya Sempurna, No.43, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Putri Rambut Selako, Padang Selasa, Bukit Besar, Palembang, Sumatera Selatan",
            "Jalan Rajawali, No.12, Palembang, Sumatera Selatan.",
            "Those pilots elected Bill captain of our team, Alfred niece keeps the room warm.",
            "I called him 'the science teacher.'",
            "Those flight attendants had him drive.",
            "Those flight attendants had him drive."};
    int[] profileImage = {R.drawable.avatar,R.drawable.profil,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.profil,R.drawable.avatar,R.drawable.avatar,R.drawable.profil,R.drawable.avatar};

    RecyclerView rvNotifList;
    NotificationViewAdapter notificationViewAdapter;
    FragmentTransaction ft;

    public NotificationFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        getActivity().setTitle("Notifikasi");
        setHasOptionsMenu(true);
        ft = getFragmentManager().beginTransaction();

        rvNotifList = (RecyclerView)view.findViewById(R.id.rc_notification);
        rvNotifList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNotifList.setItemAnimator(new DefaultItemAnimator());

        notificationViewAdapter = new NotificationViewAdapter(getContext(),username,address,time,profileImage);
        rvNotifList.setAdapter(notificationViewAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_notification_back){
            //startActivity(new Intent(getContext(), ActivityEditProfil.class));\
            ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            ft.replace(R.id.content, new OrderFragment(), "Fragment").commit();
            getActivity().setTitle("Order");
        }else if(id == R.id.action_help_on_navigation){
            OrderType();
        }else if(id == R.id.action_notification_history){
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
}
