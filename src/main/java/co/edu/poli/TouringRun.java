package co.edu.poli;

import co.edu.poli.model.*;

import java.util.Scanner;

public class TouringRun {
    public static void main(String[] args) {

        // Scanner object to capture user input from the console.
        var input = new Scanner(System.in);

        // Variable to control if the user wants to play again.
        String answerL;
        // Main game loop. It runs at least once and repeats if the user chooses "si" or "sí".
        for(boolean playAgain = true; playAgain; playAgain = answerL.equals("sí") || answerL.equals("si")){
            System.out.println("Nombre: ");
            String name = input.nextLine();
            // Create the Player object with the entered name.
            Player player = new Player(name);
            // Initialize the game at Level 1.
            Levels currentLevel = new Level1();
            // Counters to track questions per level and correct answers.
            int questionByLevel = 0;
            int correctQuestion = 0;
            System.out.printf("Hola %s, comencemos el juego.\n", player.getName());

            // Main game loop that runs as long as the player has lives.
            label:
            while(player.getLives() > 0){
                // Generate a new question for the current level.
                currentLevel.createQuestion();
                System.out.printf("Pregunta: %s\n", currentLevel.getOperation());
                int[] options = currentLevel.getOptionAnswer();

                // Display the answer options to the user.
                for(int i = 0; i < options.length; ++i){
                    System.out.printf("%d) %d\n", i + 1,options[i]);
                }

                // Option to exit the game.
                System.out.println("0. Salir del juego.");
                int optionTaken = -1;
                boolean validOption = false;

                // Loop to validate user input (must be a number between 0 and 3).
                while(!validOption){
                    System.out.println("Elige la opción correcta (1, 2, 3 o 0 para salir): ");
                    if(input.hasNextInt()){
                        optionTaken = input.nextInt();
                        if(optionTaken >= 0 && optionTaken <= 3){
                            validOption = true;
                        }else{
                            System.out.println("Por favor, ingresa un número valido (1, 2, 3 o 0 para salir).");
                        }
                    }else{
                        System.out.println("Entrada invalida, ingresa un número.");
                        // Clears the Scanner buffer to prevent infinite loops.
                        input.nextInt();
                    }
                }

                // If the user chooses option 0, they exit the game.
                if(optionTaken == 0){
                    System.out.println("Gracias por jugar.");
                    break;
                }
                // Evaluate if the user's answer is correct.
                // Uses a tolerance value for floating-point comparison, though not strictly
                // necessary here since answers are integers.
                if((double)Math.abs(options[optionTaken - 1] - currentLevel.getAnswer()) < 0.001) {
                    System.out.println("!Correcto¡");
                    player.addPoints(10);
                    ++correctQuestion;
                }else{
                    System.out.printf("Incorrecto. la respuesta correcta era: %d\n",currentLevel.getAnswer());
                    player.subtractLives();
                }

                // Display the player's current status.
                System.out.printf("Puntos: %d\n", player.getPoints());
                System.out.printf("Vidas restantes: %d\n", player.getLives());
                System.out.println(" ");
                // Increment the question counter for the current level.
                ++questionByLevel;
                // Check if the player has completed all 10 questions for the level.
                if(questionByLevel == 10){
                    System.out.println("Excelente, pasaste al siguiente nivel.");
                    // Award bonus points based on correct answers.
                    if(correctQuestion == 10){
                        System.out.println("Sacaste todas las respuestas correctas!!!");
                        player.addPoints(currentLevel.getPointsMaximum());
                        System.out.printf("Ganaste %d puntos de bonificación.\n", currentLevel.getPointsMaximum());
                        System.out.println(" ");
                    }else if(correctQuestion == 9){
                        System.out.println("Sacaste la mayoría de respuestas correctas!");
                        player.addPoints(currentLevel.getPointsMinimum());
                        System.out.printf("Ganaste %d puntos de bonificación\n", currentLevel.getPointsMinimum());
                        System.out.println(" ");
                    }
                    // Reset counters for the new level.
                    questionByLevel = 0;
                    correctQuestion = 0;
                    // Restore a life if possible (maximum 3).
                    player.increaseLivesPossible();
                    // Logic to switch to the next level using a switch on the instance.
                    switch (currentLevel) {
                        case Level1 level1:
                            currentLevel = new Level2();
                            System.out.println("Bienvenido al Nivel 2.");
                            break;
                        case Level2 level2:
                            currentLevel = new Level3();
                            System.out.println("Bienvenido al Nivel 3.");
                            break;
                        case Level3 level3:
                            currentLevel = new Level4();
                            System.out.println("Bienvenido al Nivel 4.");
                            break;
                        case Level4 level4:
                            currentLevel = new Level5();
                            System.out.println("Bienvenido al Nivel 5.");
                            break;
                        default:
                            // Final message upon completing all levels.
                            System.out.printf("¡¡¡FELICITACIONES ♣♣♣ %s ♣♣♣ HAS COMPLETADO TODOS LOS NIVELES.!!!\n", player.getName());
                            System.out.printf("TOTAL PUNTOS: ♠♠♠ %d ♠♠♠\n", player.getPoints());
                            BestPlayer.showBestPlayer();
                            // Exit the entire game loop.
                            break label;
                    }
                }
            }

            // Display final score upon game over.
            System.out.printf("Juego terminado, total puntos %d\n", player.getPoints());
            // Consume the remaining newline after reading a number.
            input.nextLine();
            // Show the list of top players.
            BestPlayer.showBestPlayer();
            System.out.println("¿Quieres reiniciar el juego para un nuevo jugador? (si/no): ");
            answerL = input.nextLine().trim().toLowerCase();
        }

        // Farewell message and close the Scanner.
        System.out.println("Gracias por jugar.");
        input.close();
    }
}