package co.edu.poli.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Manages and maintains a record of the system's top players.
 * <p>
 *     This static class is responsible for storing, sorting, and limiting a list
 *     of the 10 players with the highest scores.
 * </p>
 */
public class BestPlayer {

    /**
     * The static and private list that stores the top 10 players.
     * The list is ordered by points in descending order.
     * */
    private static final ArrayList<Player> bestPlayer = new ArrayList<>();

    /**
     * Saves a player to the top scores list.
     * <p>
     *     This method add the player to the list, sorts it by points in
     *     descending order, and if the list exceeds 10 players, it removes
     *     the player with the lowest score.
     * </p>
     * @param player The {@link Player} object to be saved.
     * */
    public static void savePlayer(Player player){
        bestPlayer.add(player);
        // '.sort' order the list, 'Comparator.comparingInt(::getPoints)' compare points, '.reversed()' reverse the order, player with the most points comes first
        bestPlayer.sort(Comparator.comparingInt(Player::getPoints).reversed());
        if (bestPlayer.size() > 10){
            bestPlayer.remove(10); // I'm eliminating the last position according to the score
        }
    }

    /**
     * Displays the list of the best players in the console.
     * It iterates through the list and displays the position, name, and score
     * of each player.
     */
    public static void showBestPlayer(){
        System.out.println("\n♣~~~~~~~~~~♣MEJORES JUGADORES♣~~~~~~~~~~♣");

        for(int index = 0; index < bestPlayer.size(); ++index){
            Player player = (Player)bestPlayer.get(index);
            System.out.printf("%d. %s ♣ %d puntos.",index + 1, player.getName(),player.getPoints());
        }
    }

    /**
     * Gets the list of the top players.
     * <p>
     *     This method is used to access the list from other parts of the code.
     * </p>
     * @return An {@link ArrayList} of {@link Player} objects containing the top 10 players.
     */
    public static ArrayList<Player> getListPlayer(){return bestPlayer;}
}