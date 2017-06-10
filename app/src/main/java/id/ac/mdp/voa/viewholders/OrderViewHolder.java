package id.ac.mdp.voa.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.mdp.voa.utils.ItemClickListener;
import id.ac.mdp.voa.R;

/*
 * Created by Tengku Kevin on 3/26/2017.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView ivUserProfile;
    public TextView tvUserName;
    public TextView tvAddress;
    public TextView tvTime;
    public TextView tvOrderType;
    public TextView tvOrderStatus;
    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView){
        super(itemView);

        ivUserProfile = (ImageView)itemView.findViewById(R.id.img_cardview_order_usr_profile);
        tvUserName = (TextView)itemView.findViewById(R.id.tv_cardview_order_username);
        tvAddress = (TextView)itemView.findViewById(R.id.tv_cardview_order_address);
        tvTime = (TextView)itemView.findViewById(R.id.tv_cardview_order_time);
        tvOrderType = (TextView) itemView.findViewById(R.id.tv_cardview_order_type);
        tvOrderStatus = (TextView) itemView.findViewById(R.id.tv_cardview_order_status);

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
