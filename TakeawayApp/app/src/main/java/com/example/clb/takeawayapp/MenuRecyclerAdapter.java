package com.example.clb.takeawayapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final List<MenuOption> menuOptions;

    public MenuRecyclerAdapter(Context context, List<MenuOption> menuOptions) {
        this.context = context;
        this.menuOptions = menuOptions;
    }


    //creates the top level view for the recycler view by inflating the row layout and passing it back in a viewholder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View item = layoutInflater.inflate(R.layout.menu_row_layout, parent, false);

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MenuOption menuOption = this.menuOptions.get(position);

        holder.itemName.setText(menuOption.getName());
        String price = holder.itemPrice.getText() + menuOption.getPrice();
        holder.itemPrice.setText(price);
    }

    @Override
    public int getItemCount() {
        return menuOptions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //public so that the adapter class can access these fields
        public final TextView itemName;
        public final TextView itemPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}


