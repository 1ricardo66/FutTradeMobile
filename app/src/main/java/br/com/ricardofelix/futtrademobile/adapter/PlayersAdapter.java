package br.com.ricardofelix.futtrademobile.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.ricardofelix.futtrademobile.R;
import br.com.ricardofelix.futtrademobile.model.Player;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {


    private List<Player> playersList;

    public PlayersAdapter(List<Player> player){
        this.playersList = player;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View playerList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.players_list,parent,false);

        return(new MyViewHolder(playerList));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = playersList.get(position).getName();
        int buyPrice = playersList.get(position).getBuyPrice();
        int sellPrice = playersList.get(position).getSellPrice();
        double profit = playersList.get(position).getProfit();


        holder.name.setText(name);
        holder.playerBuyPrice.setText(String.valueOf(buyPrice));
        holder.playerSellPrice.setText(String.valueOf(sellPrice));
        holder.playerProfit.setText(String.valueOf(profit));

    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView name,playerBuyPrice,playerSellPrice,playerProfit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.playerName);
            playerBuyPrice = itemView.findViewById(R.id.playerBuyPrice);
            playerSellPrice = itemView.findViewById(R.id.playerSellPrice);
            playerProfit = itemView.findViewById(R.id.playerProfit);

        }
    }
}
