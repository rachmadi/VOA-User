package id.ac.mdp.voa.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.mdp.voa.utils.ItemClickListener;
import id.ac.mdp.voa.R;

/**
 * Created by Tengku Kevin on 09/05/2017.
 */

public class OrderHistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView ivOrderHistoryUserProfile;
    public TextView tvOrderHistoryUserName;
    public TextView tvOrderHistoryAddress;
    public TextView tvOrderHistoryTime;
    public TextView tvOrderHistoryType;
    public TextView tvOrderHistoryStatus;
    private ItemClickListener itemClickListener;

    public OrderHistoryViewHolder(View itemView){
        super(itemView);

        ivOrderHistoryUserProfile = (ImageView)itemView.findViewById(R.id.img_cardview_order_history_usr_profile);
        tvOrderHistoryUserName = (TextView)itemView.findViewById(R.id.tv_cardview_order_history_username);
        tvOrderHistoryAddress = (TextView)itemView.findViewById(R.id.tv_cardview_order_history_address);
        tvOrderHistoryTime = (TextView)itemView.findViewById(R.id.tv_cardview_order_history_time);
        tvOrderHistoryType = (TextView)itemView.findViewById(R.id.tv_cardview_order_history_type);
        tvOrderHistoryStatus = (TextView)itemView.findViewById(R.id.tv_cardview_order_history_status);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}