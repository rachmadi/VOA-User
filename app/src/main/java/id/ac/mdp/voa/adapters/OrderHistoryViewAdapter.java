package id.ac.mdp.voa.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import id.ac.mdp.voa.R;
import id.ac.mdp.voa.viewholders.OrderHistoryViewHolder;
import id.ac.mdp.voa.activities.OrderDetailActivity;

/**
 * Created by Tengku Kevin on 09/05/2017.
 */

public class OrderHistoryViewAdapter extends RecyclerView.Adapter<OrderHistoryViewHolder>{

    private Context context;
    private String[] username, address, time, order_type, order_status;
    private int[] profileImage;

    public OrderHistoryViewAdapter(Context context, String[] username, String[] address, String[] time,String[] order_type,String[] order_status, int[] profileImage){
        this.context = context;
        this.username = username;
        this.address = address;
        this.time = time;
        this.order_type = order_type;
        this.order_status = order_status;
        this.profileImage = profileImage;
    }

    @Override
    public OrderHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_history, null);
        OrderHistoryViewHolder holder = new OrderHistoryViewHolder(view);

        return holder;
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_history, null);
//        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderHistoryViewHolder holder, final int position) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_order_history, null);

        holder.tvOrderHistoryUserName.setText(username[position]);
        holder.tvOrderHistoryAddress.setText(address[position]);
        holder.tvOrderHistoryTime.setText(time[position]);
        holder.tvOrderHistoryType.setText(order_type[position]);
        holder.tvOrderHistoryStatus.setText(order_status[position]);


        String orderStatus = order_status[position].toString();
        final String orderType = order_type[position].toString();

        if (orderType.equals("Hourly")){
            holder.tvOrderHistoryType.setTextColor(Color.rgb(25,118,210));
        }else if (orderType.equals("Daily")){
            holder.tvOrderHistoryType.setTextColor(Color.rgb(2,136,209));
        }else if (orderType.equals("Add Driver")){
            holder.tvOrderHistoryType.setTextColor(Color.rgb(0,151,167));
        }

        if (orderStatus.equals("Order processed")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(255,152,0));
        }else if (orderStatus.equals("Approved")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(76,175,80));
        }else if (orderStatus.equals("On the way")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(0,150,136));
        }else if (orderStatus.equals("On location")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(33,150,243));
        }else if (orderStatus.equals("Passenger in")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(76,175,80));
        }else if (orderStatus.equals("Order closed")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(96,125,139));
        }else if (orderStatus.equals("Cancel by User")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(244,67,54));
        }else if (orderStatus.equals("Cancel by Dispatcher")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(244,67,54));
        }else if (orderStatus.equals("Full Occupied")){
            holder.tvOrderHistoryStatus.setTextColor(Color.rgb(103,58,183));
        }

        //Glide.clear(holder.ivUserProfile);
        Glide.with(context)
                .load(profileImage[position])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivOrderHistoryUserProfile);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("orderUserName", username[position]);
                intent.putExtra("orderAddress", address[position]);
                intent.putExtra("orderTime", time[position]);
                intent.putExtra("orderProfil", profileImage[position]);
                intent.putExtra("orderType", order_type[position]);
                intent.putExtra("orderStatus", order_status[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return username.length;
    }
}