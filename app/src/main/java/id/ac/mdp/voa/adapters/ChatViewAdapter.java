package id.ac.mdp.voa.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.viewholders.ChatViewHolder;
import id.ac.mdp.voa.activities.ChatActivity;

/**
 * Created by Tengku Kevin on 3/31/2017.
 */

public class ChatViewAdapter extends RecyclerView.Adapter<ChatViewHolder>{

    private Context context;
    private String[] username, address, time;
    private int[] profileImage;

    public ChatViewAdapter(Context context, String[] username, String[] address, String[] time, int[] profileImage){
        this.context = context;
        this.username = username;
        this.address = address;
        this.time = time;
        this.profileImage = profileImage;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChatViewHolder holder, final int position) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_chat, null);

        holder.tvChatUserName.setText(username[position]);
        holder.tvChatText.setText(address[position]);
        holder.tvChatTime.setText(time[position]);
        //Glide.clear(holder.ivChatUserProfile);
        Glide.with(context)
                .load(profileImage[position])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivChatUserProfile);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("orderUserName", username[position]);
                intent.putExtra("orderAddress", address[position]);
                intent.putExtra("orderTime", time[position]);
                intent.putExtra("orderProfil", profileImage[position]);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(holder.itemView.getContext());
                alertDialogBuilder.setMessage("Hapus Pesan?");
                alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });

                alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialogBuilder.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return username.length;
    }
}

