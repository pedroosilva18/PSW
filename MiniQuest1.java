import java.util.Random;
import java.util.Scanner;

public class MiniQuest1
{
    public static void main(String[] args)

    {
        int size_x = 10, size_y = 10;
        int position_x = 1, position_y = 1;
        int position_x_d = 3, position_y_d = 1;
        int position_x_d_new, position_y_d_new;
        int i, j;
        char input;
        char[][] matrix = new char[size_x][size_y];
        int haveKey=0, win = 0;
        int counterDragonMoves = 0;
        int newPosition=0;
        Random rand = new Random();
        Scanner read = new Scanner(System.in);

        //iniciar matriz vazia
        for (i=0; i!=size_x; i++)
            for (j=0; j!= size_y; j++)
                matrix[i][j] = ' ';
      
        //preencher X na matriz
        for (i=0; i!=size_x; i++)
        {
            matrix[i][0] = 'X';
            matrix[i][size_y-1] = 'X';
        }

        for (j=0; j!=size_y; j++)
        {
            matrix[0][j] = 'X';
            matrix[size_x-1][j] = 'X';
        }

        matrix[2][2]='X';
    matrix[3][2]='X';
    matrix[4][2]='X';
    
    matrix[2][3]='X';
    matrix[3][3]='X';
    matrix[4][3]='X';    
    
    matrix[2][5]='X';
    matrix[3][5]='X';
    matrix[4][5]='X';

    matrix[2][7]='X';
    matrix[3][7]='X';
    matrix[4][7]='X';

    matrix[6][2]='X';
    matrix[7][2]='X';
    matrix[8][2]='X';
    
    matrix[6][3]='X';
    matrix[7][3]='X';
    matrix[8][3]='X';    

    matrix[6][5]='X';
    matrix[7][5]='X';

    matrix[5][7]='X';
    matrix[6][7]='X';
    matrix[7][7]='X';

    //characters
    matrix[position_x][position_y] = 'H';
    matrix[8][1] = 'K';
    matrix[position_x_d][position_y_d] = 'D';
    matrix[5][9] = 'E';
        
    //printBoard(matrix);

    //the game itself

    while(win == 0)
    {
        if (counterDragonMoves == 2)
        {
            counterDragonMoves = 0;
            while(newPosition == 0)
            {
                position_x_d_new = rand.nextInt(10);
                position_y_d_new = rand.nextInt(10);
                if (matrix[position_x_d_new][position_y_d_new] == ' ')
                {
                    if(Math.abs(position_x-position_x_d_new)+Math.abs(position_y-position_y_d_new) != 1)
                    {
                        matrix[position_x_d][position_y_d] = ' ';
                        matrix[position_x_d_new][position_y_d_new]='D';  
                        position_x_d=position_x_d_new;
                        position_y_d=position_y_d_new;   
                        newPosition=1;
                    }
                }
            }
            newPosition = 0;
        }

        printBoard(matrix);

        if ((Math.abs(position_x-position_x_d) + Math.abs(position_y-position_y_d)) ==  1)
        {
            System.out.println("The hero was killed by the dragon!");
            return;
        }

        input = read.next().charAt(0);
        //System.out.println(input);

        switch(input)
        {
            case 'W':
            if(position_x!=0)
            {
                if( matrix[position_x-1][position_y]==' ')
                {
                    matrix[position_x][position_y]=' ';
                    matrix[position_x-1][position_y]='H';    
                    position_x--;  
                    counterDragonMoves++;              
                }
            }
            break;
            case 'A':
            if(position_y!=0)
            {
                if( matrix[position_x][position_y-1]==' ')
                {
                    matrix[position_x][position_y]=' ';
                    matrix[position_x][position_y-1]='H';    
                    position_y--; 
                    counterDragonMoves++;                    
                }
            }
            break;          
            case 'S':
            if(position_x!=size_x-1)
            {
                if( matrix[position_x+1][position_y]==' ')
                {
                    matrix[position_x][position_y]=' ';
                    matrix[position_x+1][position_y]='H';    
                    position_x++;  
                    counterDragonMoves++;                
                }
                else if( matrix[position_x+1][position_y]=='K')
                {
                    matrix[position_x][position_y]=' ';
                    matrix[position_x+1][position_y]='H';    
                    position_x++;    
                    counterDragonMoves++;              
                    haveKey = 1;
                }
            }
            break;
            case 'D':
            if(position_y!=size_y-1)
            {
                if( matrix[position_x][position_y+1]==' ')
                {
                    matrix[position_x][position_y]=' ';
                    matrix[position_x][position_y+1]='H';    
                    position_y++;       
                    counterDragonMoves++;           
                }
            
                else if( matrix[position_x][position_y+1]=='E')
                {

                    if (haveKey == 1){
                        matrix[position_x][position_y]=' ';
                        matrix[position_x][position_y+1]='H';    
                        position_x++;  
                        counterDragonMoves++;                
                        win = 1;
                    }
                    else System.out.println(haveKey);
                }
            }
            break;
        }
    }
    System.out.println("YOU ARE VICTORIOUS");

    }

    public static void printBoard(char matrix[][])
    {
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[i].length; j++) 
                System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }   
    }
}