package co.edu.poli;

import co.edu.poli.model.*;

import java.util.Scanner;

public class TouringRun {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        String answerL;
        for(boolean playAgain = true; playAgain; playAgain = answerL.equals("sí") || answerL.equals("si")){
            System.out.println("Nombre: ");
            String name = input.nextLine();
            Player player = new Player(name);
            Levels currentLevel = new Level1();
            int questionByLevel = 0;
            int correctQuestion = 0;
            System.out.printf("Hola %s, comencemos el juego.\n", player.getName());

            //
            label:
            while(player.getLives() > 0){
                currentLevel.createQuestion();
                System.out.printf("Pregunta: %s\n", currentLevel.getOperation());
                int[] options = currentLevel.getOptionAnswer();

                for(int i = 0; i < options.length; ++i){
                    System.out.printf("%d) %d\n", i + 1,options[i]);
                }

                //
                System.out.println("0. Salir del juego.");
                int optionTaken = -1;
                boolean validOption = false;

                //
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
                        input.nextInt();
                    }
                }
                //
                if(optionTaken == 0){
                    System.out.println("Gracias por jugar.");
                    break;
                }
                //
                if((double)Math.abs(options[optionTaken - 1] - currentLevel.getAnswer()) < 0.001) {
                    System.out.println("!Correcto¡");
                    player.addPoints(10);
                    ++correctQuestion;
                }else{
                    System.out.printf("Incorrecto. la respuesta correcta era: %d\n",currentLevel.getAnswer());
                    player.subtractLives();
                }
                //
                System.out.printf("Puntos: %d\n", player.getPoints());
                System.out.printf("Vidas restantes: %d\n", player.getLives());
                System.out.println(" ");
                ++questionByLevel;
                //
                if(questionByLevel == 10){
                    System.out.println("Excelente, pasaste al siguiente nivel.");
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
                    //
                    questionByLevel = 0;
                    correctQuestion = 0;
                    player.increaseLivesPossible();
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
                            System.out.printf("¡¡¡FELICITACIONES ♣♣♣ %s ♣♣♣ HAS COMPLETADO TODOS LOS NIVELES.!!!\n", player.getName());
                            System.out.printf("TOTAL PUNTOS: ♠♠♠ %d ♠♠♠\n", player.getPoints());
                            BestPlayer.showBestPlayer();
                            break label;
                    }
                }
            }
            //
            System.out.printf("Juego terminado, total puntos %d\n", player.getPoints());
            input.nextLine();
            BestPlayer.showBestPlayer();
            System.out.println("¿Quieres reiniciar el juego para un nuevo jugador? (si/no): ");
            answerL = input.nextLine().trim().toLowerCase();
        }
        //
        System.out.println("Gracias por jugar.");
        input.close();
    }
}
