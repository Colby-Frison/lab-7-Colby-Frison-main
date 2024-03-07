import java.util.Random;

public class RandomPlayer extends Player{

    Random generator;

    public RandomPlayer(String name) {
        super(name);

        this.generator = new Random();;
    }

    public int[] getMove(int[] pileSizes) {
        int index = generator.nextInt(pileSizes.length);
        while(pileSizes[index] == 0){
            index = generator.nextInt(pileSizes.length);
        }
        int num = generator.nextInt(pileSizes[index] - 1 + 1) + 1;

        int[] move = new int[2];

        move[0] = index;
        move[1] = num;

        return move;
    }
    
}
