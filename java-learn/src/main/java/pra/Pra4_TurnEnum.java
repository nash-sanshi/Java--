package src.main.java.pra;

public class Pra4_TurnEnum {
    public static void main(String[] args) {
        Do(Turn.TURN_LEFT);
        Do(Turn.TURN_RIGHT);
        Do(Turn.STOP);
    }

    public static void Do(Turn turn){
        switch (turn){
            case TURN_LEFT:
                System.out.println("×ó×ª");
                break;
            case TURN_RIGHT:
                System.out.println("ÓÒ×ª");
                break;
            case STOP:
                System.out.println("Í£Ö¹");
                break;
        }
    }

    public enum Turn{
        TURN_LEFT,TURN_RIGHT,STOP
    }
}
