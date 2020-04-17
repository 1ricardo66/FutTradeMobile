package br.com.ricardofelix.futtrademobile.Helper;

import java.util.List;

import br.com.ricardofelix.futtrademobile.model.Player;

public interface IPlayerDAO {

    boolean savePlayer(Player player);
    boolean updatePlayer (Player player);
    boolean deletePlayer (Player player);
    List<Player> listPlayer();

}
