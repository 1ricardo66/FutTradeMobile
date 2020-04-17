package br.com.ricardofelix.futtrademobile.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ricardofelix.futtrademobile.model.Player;

public class PlayerDAO implements IPlayerDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public PlayerDAO(Context context) {
        DbHelper db = new DbHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean savePlayer(Player player) {

        ContentValues cv = new ContentValues();

        cv.put("name",player.getName());
        cv.put("buyPrice",player.getBuyPrice());
        cv.put("sellPrice",player.getSellPrice());
        cv.put("profit",player.getProfit());

        try{
            write.insert(DbHelper.Player_Table,null,cv);
            Log.i("DB","Jogador Salvo com sucesso!!!!!!!");

        }catch (Exception e){
            Log.d("ERROR-INSERT",e.getMessage());
            return false;
        }


        return true;
    }

    @Override
    public boolean updatePlayer(Player player) {
        return false;
    }

    @Override
    public boolean deletePlayer(Player player) {
        return false;
    }

    @Override
    public List<Player> listPlayer() {
        List <Player> players = new ArrayList<>();
        String sql = "SELECT * FROM "+DbHelper.Player_Table+" ;";
        Cursor c = write.rawQuery(sql,null);

        while(c.moveToNext()){
            Player player = new Player();

            Long id = c.getLong(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int buyPrice = c.getInt(c.getColumnIndex("buyPrice"));
            int sellPrice = c.getInt(c.getColumnIndex("sellPrice"));
            double profit = c.getDouble(c.getColumnIndex("profit"));


            player.setId(id);
            player.setName(name);
            player.setBuyPrice(buyPrice);
            player.setSellPrice(sellPrice);
            player.setProfit(profit);

            players.add(player);

        }
        return players;
    }
}
