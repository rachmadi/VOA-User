package id.ac.mdp.voa.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.adapters.ChatViewAdapter;

/**
 * Created by Tengku Kevin on 3/31/2017.
 */

public class ChatFragment extends Fragment {

    RecyclerView rvChatList;
    ChatViewAdapter adapterChat;

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


    public ChatFragment(){
        // Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);
        setHasOptionsMenu(true);

        rvChatList = (RecyclerView)view.findViewById(R.id.rc_chat);
        rvChatList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvChatList.setItemAnimator(new DefaultItemAnimator());

        adapterChat = new ChatViewAdapter(getContext(),username,address,time,profileImage);
        rvChatList.setAdapter(adapterChat);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.chat_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_add_new_chat){
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
//            alertDialogBuilder.setTitle("Pilih Kontak");
//            alertDialogBuilder.setMessage("Belum ada kontak");
//            alertDialogBuilder.show();
//        }
        return super.onOptionsItemSelected(item);
    }
}
