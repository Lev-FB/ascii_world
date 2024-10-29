import java.util.*;
public class Program {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);

        int[][] map = new int[][] {
            {2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

        };
        render(map);
        while (true) {
            String to = in.nextLine();
            move_person(map, to);
        }
    }


    static void move_person (int[][] map,String to){
        outer :for (int i = 0 ; i<map.length; i++) {
            
            for(int j = 0 ; j<map[i].length;j++) {
                 if(map[i][j]==1) {
                    int newI =i;
                    int newJ = j;
                    switch(to){
                        case "w":
                            newI--;
                        break;
                        case "s":
                            newI++; 
                        break;
                        case "a":
                            newJ --;
                        break;
                        case "d":
                            newJ++;
                        break;       
                    }

                    if(newI<=map.length-1&&newJ<=map[0].length-1&&newI>=0&&newJ>=0 &&map[newI][newJ]!=2) {
                        map[i][j] = 0;
                        map[newI][newJ] = 1;
                    }

                    break outer;
                 }
                 
             }
        };
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        render(map);
    }
    static void render (int[][] map ) {
        for (int i = 0 ; i<map.length ; i++) {
            for(int j = 0 ; j<map[i].length;j++) {
                 if(map[i][j]==0) {
                    System.out.printf(" . ");
                 }else if (map[i][j]==1){
                   if(i==3&&j==5) {
                        
                        System.out.printf("/| ");
                        TimerTask task = new TimerTask() {
                            public void run() {
                                System.out.println( Math.random()>0.5?"Вы поймали рыбу":"Сегодня удача не на вашей стороне:(");
                            }
                        };
                        
                        Timer timer = new Timer("Timer");
                        
                        long delay = 3000L;
                        timer.schedule(task, delay);
                    }else {
                        System.out.printf(" + ");
                    }
                     
                 }else if(map[i][j]==2) {
                    System.out.printf(" W ");
                 }
             }
             System.out.println(' ');
        };
    }
}
