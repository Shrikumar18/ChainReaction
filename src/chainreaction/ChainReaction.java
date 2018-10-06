/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.util.Scanner;

/**
 *
 * @author vignesh
 */
public class ChainReaction {
    static Scanner scan = new Scanner(System.in);
    static int count = 0;
    static String l;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[][] s = new String[5][5];
        int i,j=0;
        for(i=0;i<5;i++)
        {
            for(j=0;j<5;j++)
            {
                s[i][j] = "-";
            }
        }
        printMatrix(s);
        while(gameOver(s)!=1)
        {
            getInput(s);
        } 
        System.out.println("Game Over\n  Player "+s[0][0]+" won");
        }

    public static void printMatrix(String[][] s) {
         //To change body of generated methods, choose Tools | Templates.
       int i,j;
       for(i=0;i<5;i++)
       {
           for(j=0;j<5;j++)
           {
               System.out.print(s[i][j]+"  ");
           }
           System.out.println("");
       }
    }

    public static void getInput(String[][] s) {
        int a,b;
        System.out.println("\nEnter input for User 1:");
        a = scan.nextInt();
        b = scan.nextInt();
        if(s[a][b].charAt(0)=='2')
        {
            System.out.println("Choose some Other position. Occupied by User 2");
            a = scan.nextInt();
            b = scan.nextInt();
        }
        l = "1";
        doOperation(s,a,b,l);
        isExcited(s,l);
        printMatrix(s);
        System.out.println("\nEnter input for User 2:");
        a = scan.nextInt();
        b = scan.nextInt();
        if(s[a][b].charAt(0)=='1')
        {
            System.out.println("Choose some Other position. Occupied by User 1");
            a = scan.nextInt();
            b = scan.nextInt();
        }
        l = "2";
        doOperation(s,a,b,l);
        isExcited(s,l);
        printMatrix(s);
    }

    public static int gameOver(String[][] s) {
        char s1 = s[0][0].charAt(0);
        int i,j,flag = 0;
        for(i=0;i<5;i++)
        {
            for(j=0;j<5;j++)
            {
                if(s[i][j].charAt(0)!=s1)
                    flag = 1;
            }
        }
        if(flag==1)
            return 0;
        else if(s1=='-')
            return 0;
        else
            return 1;
    }

    private static void doOperation(String[][] s, int a, int b, String l) {
        char[] l1 = l.toCharArray();
        if(s[a][b]!="-")
        {
            if(a==0 && b==0)
            {
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                s[a][b] = "-";
            }
            else if(a==4 && b==4)
            {
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += l;
                else
                    s[a][b-1] = l;
                s[a][b] = "-";
            }
            else if(a==4&&b==0)
            {
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                s[a][b] = "-";
            }
            else if(a==0 && b==4)
            {
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += l;
                else
                    s[a][b-1] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                s[a][b] = "-";
            }
            else if( b==0 && digCount(s[a][b])>=2)
            {
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                s[a][b] = "-";
            }
            else if(b==4 && digCount(s[a][b])>=2)
            {
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += l;
                else
                    s[a][b-1] = l;
                s[a][b] = "-";
            }
            else if(a==0 && digCount(s[a][b])>=2)
            {
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += l;
                else
                    s[a][b-1] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                s[a][b] = "-";
            }
            else if(a==4 && digCount(s[a][b])>=2)
            {
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += l;
                else
                    s[a][b-1] = l;
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                s[a][b] = "-";
            }
            else if(digCount(s[a][b])>=3)
            {
                if(s[a-1][b].charAt(0)==l1[0])
                    s[a-1][b] += l;
                else
                    s[a-1][b] = l;
                if(s[a+1][b].charAt(0)==l1[0])
                    s[a+1][b] += l;
                else
                    s[a+1][b] = l;
                if(s[a][b-1].charAt(0)==l1[0])
                    s[a][b-1] += s[a][b];
                else
                    s[a][b-1] = l;
                if(s[a][b+1].charAt(0)==l1[0])
                    s[a][b+1] += l;
                else
                    s[a][b+1] = l;
                s[a][b] = "-";
            }
            else if((b==0 || b==4) && digCount(s[a][b])==1)
                s[a][b] += l;
            else if((a==0||a==4) && digCount(s[a][b])==1)
                s[a][b] += l;
            else if(digCount(s[a][b])<=3)
                s[a][b] += l;
        }
        else
        {
        s[a][b] = l;
        }
        //checkExcitation(s, a, b);
    }   
    
    public static int digCount(String string) {
        //To change body of generated methods, choose Tools | Templates.
        return string.length();
    }


    public static void isExcited(String[][] s,String l) {
      int i,j,flag=0;
      for(i=0;i<5;i++)
      {
          for(j=0;j<5;j++)
          {
              if((i==0 && j==0) || (i==4 && j==4) || (i==4 && j==0) || (i==0 && j==4))
              {
                  if(s[i][j]!="-" && s[i][j].length()>1)
                  {
                       flag=1;
                       doOperation(s,i,j,l);
                  }
              }
              if((i==0 && j>0 && j<4) || (j==0 && i>0 && i<4))
              {
                  if(s[i][j].length()>2)
                  {
                      flag = 1;
                      doOperation(s,i,j,l);
                  }
              }
              if((i==4 && j>0 && j<4) || (j==4 && i>0 && i<4))
              {
                  if(s[i][j].length()>2)
                  {
                      flag = 1;
                      doOperation(s,i,j,l);
                  }
              }
              if(i>0 && i <4 && j>0 && j<4)
              {
                  if(s[i][j].length()>3)
                  {
                      flag = 1;
                      doOperation(s,i,j,l);
                  }
              }
          }
      } 
      if(flag==1)
      {
          isExcited(s,l);
      }
    }
}
