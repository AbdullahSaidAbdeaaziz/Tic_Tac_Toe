package com.company.Tic_Tac_Toe;

import java.util.*;
public class Main {
    static String cells ="         ";
    static char xOry = 'X';
    public static final Scanner scan = new Scanner(System.in);
    static boolean choice = false;
    static String heads ;
    public static int no = 3 ;

    public static boolean  checkX( String cell) {
        return (cell.charAt(0) == 'X' & cell.charAt(1) == 'X' & cell.charAt(2) == 'X') |
                (cell.charAt(3) == 'X' & cell.charAt(4) == 'X' & cell.charAt(5) == 'X') |
                (cell.charAt(6) == 'X' & cell.charAt(7) == 'X' & cell.charAt(8) == 'X') |
                (cell.charAt(0) == 'X' & cell.charAt(4) == 'X' & cell.charAt(8) == 'X') |
                (cell.charAt(2) == 'X' & cell.charAt(4) == 'X' & cell.charAt(6) == 'X') |
                (cell.charAt(0) == 'X' & cell.charAt(3) == 'X' & cell.charAt(6) == 'X') |
                (cell.charAt(1) == 'X' & cell.charAt(4) == 'X' & cell.charAt(7) == 'X') |
                (cell.charAt(2) == 'X' & cell.charAt(5) == 'X' & cell.charAt(8) == 'X');
    }
    public static boolean  checkO( String cell) {
        return (cell.charAt(0) == 'O' & cell.charAt(1) == 'O' & cell.charAt(2) == 'O') |
                (cell.charAt(3) == 'O' & cell.charAt(4) == 'O' & cell.charAt(5) == 'O') |
                (cell.charAt(6) == 'O' & cell.charAt(7) == 'O' & cell.charAt(8) == 'O') |
                (cell.charAt(0) == 'O' & cell.charAt(4) == 'O' & cell.charAt(8) == 'O') |
                (cell.charAt(2) == 'O' & cell.charAt(4) == 'O' & cell.charAt(6) == 'O') |
                (cell.charAt(0) == 'O' & cell.charAt(3) == 'O' & cell.charAt(6) == 'O') |
                (cell.charAt(1) == 'O' & cell.charAt(4) == 'O' & cell.charAt(7) == 'O') |
                (cell.charAt(2) == 'O' & cell.charAt(5) == 'O' & cell.charAt(8) == 'O');
    }
    public static char whoWin(String cell) {
        if (checkX(cell)) {
            return 'X';
        } else if (checkO(cell)) {
            return 'O';
        }
        return 'D';
    }
    public static void whoWin2() {
        char winner = whoWin(cells);
        if (winner == 'X') {
            draw();
            System.out.println("X wins");
            choice = true;
        } else if (winner == 'O') {
            draw();
            System.out.println("O wins");
            choice = true;

        }else {
            if (cells.contains(" ")) {
                return;
            }
            draw();
            System.out.println("Draw");
            choice = true;
        }
    }
    public static void draw(){
        System.out.println("---------");
        int v = 0;
        for(int i = 0 ; i < no ; i++)
        {
            System.out.print("| ");
            int j;
            for(j = v ; j < no*(i+1); j++)
            {
                System.out.print(cells.charAt(j)+ " ");
            }
            v = j;
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void checkCoordinates() {

        boolean trueFalse = false ;
        do {
            System.out.print("Enter the coordinates: ");
            heads = scan.nextLine();
            if (!Character.isDigit(heads.charAt(0))) {
                System.out.println("You should enter numbers!");
                trueFalse = true;
            } else if (heads.charAt(0)-'0' > 3 | heads.charAt(2)-'0' > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                trueFalse = true;
            } else if (heads.charAt(0)-'0' == 1) {
                if(cells.charAt(heads.charAt(2)-'1') == 'X' | cells.charAt(heads.charAt(2)-'1') == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    trueFalse = true;
                } else {
                    char[] newCells = cells.toCharArray();
                    newCells[heads.charAt(2)-'1'] = xOry;
                    cells = String.valueOf(newCells);
                    trueFalse = false ;
                }
            } else if (heads.charAt(0)-'0' == 2) {
                if(cells.charAt(heads.charAt(2)-'1' + no) == 'X' | cells.charAt(heads.charAt(2)-'1' + no) == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    trueFalse = true;
                } else {
                    char[] newCells = cells.toCharArray();
                    newCells[heads.charAt(2)-'1' + no] = xOry;
                    cells = String.valueOf(newCells);
                    trueFalse = false ;

                }
            } else if (heads.charAt(0)-'0' == 3) {
                if(cells.charAt(heads.charAt(2)-'1' + no * 2) == 'X' | cells.charAt(heads.charAt(2)-'1' + no * 2) == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    trueFalse = true;
                } else {
                    char[] newCells = cells.toCharArray();
                    newCells[heads.charAt(2)-'1' + no * 2] = xOry;
                    cells = String.valueOf(newCells);
                    trueFalse = false ;
                }
            }
        }while(trueFalse);
        if(xOry == 'X') {
            xOry = 'O';
        } else {
            xOry = 'X';
        }
    }
    public static void main(String[] args) {
        // write your code here
        while (!choice) {
            draw();
            checkCoordinates();
            whoWin2();

        }
    }
}

