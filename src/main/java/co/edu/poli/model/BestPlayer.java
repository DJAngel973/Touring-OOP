package co.edu.poli.model;

import java.util.ArrayList;
import java.util.Comparator;

public class BestPlayer {

    // I declare a static and private list to take the 10 best players
    private static final ArrayList<Player> bestPlayer = new ArrayList<>();

    // Method save player to 'bestPlayer' list
    public static void savePlayer(Player player){
        bestPlayer.add(player);
        // '.sort' order the list, 'Comparator.comparingInt(::getPoints)' compare points, '.reversed()' reverse the order, player with the most points comes first
        bestPlayer.sort(Comparator.comparingInt(Player::getPoints).reversed());
        if (bestPlayer.size() > 10){
            bestPlayer.remove(10); // I'm eliminating the last position according to the score
        }
    }
    // Method for show list best player
    public static void showBestPlayer(){
        System.out.println("\n♣~~~~~~~~~~♣MEJORES JUGADORES♣~~~~~~~~~~♣");

        for(int index = 0; index < bestPlayer.size(); ++index){
            Player player = (Player)bestPlayer.get(index);
            System.out.printf("%d. %s ♣ %d puntos.",index + 1, player.getName(),player.getPoints());
        }
    }
    // Show the list outside BestPlayer
    public static ArrayList<Player> getListPlayer(){return bestPlayer;}
}
