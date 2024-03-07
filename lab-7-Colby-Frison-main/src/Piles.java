import java.util.Arrays;

public class Piles {
    
    private int[] size;

    Piles(int... initSizes){
        boolean temp = true;
        if(initSizes == null || initSizes.length == 0){
            throw new IllegalArgumentException();
        }
        if(temp){
            for(int i = 0; i < initSizes.length ; i++){
                if(initSizes[i] <= 0){
                    throw new IllegalArgumentException();
                }
            }
        }

        size = Arrays.copyOf(initSizes, initSizes.length);
    }

    public int[] getSizes(){
        return Arrays.copyOf(size, size.length);
    }

    public void removeObjects(int[] move) throws IllegalMoveException{
        if(move == null){
            throw new IllegalMoveException("null move");
        }
        else if(move.length != 2){
            throw new IllegalMoveException("Invalid length: " + move.length);
        }
        else if(move[0] > size.length - 1|| move[0] < 0){
            throw new IllegalMoveException("Index out of bounds: " + move[0]);
        }
        else if(size[move[0]] == 0){
            throw new IllegalMoveException("Pile " + move[0] + " is empty.");
        }
        else if(move[1] <= 0){
            throw new IllegalMoveException("Nonpositive object number: " + move[1]);
        }
        else if(move[1] > size[move[0]]){
            throw new IllegalMoveException("Object number greater than pile size: " + move[1] + " > " + size[move[0]]);
        }
        else{
            size[move[0]] -= move[1];
        }

    }

    public boolean isEmpty(){
        boolean temp = true;

        for(int i = 0 ; i < size.length ; i++){
            if(size[i] != 0){
                temp = false;
            }
        }

        return temp;
    }

}
