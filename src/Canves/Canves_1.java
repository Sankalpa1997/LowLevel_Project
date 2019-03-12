package Canves;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.StringItem;

public class Canves_1 extends Canvas implements CommandListener {

    private Command change, all;
    private static boolean isAll = false;

    public Canves_1() {
        init();
    }

    private void init() {
        change = new Command("Change", Command.OK, 1);
        addCommand(change);
        all = new Command("All", Command.OK, 0);
        addCommand(all);
        setCommandListener(this);

    }

    protected void paint(Graphics g) {

        System.out.println(getWidth());
        System.out.println(getHeight());

        g.setColor(118, 123, 130);
        g.fillRect(0, 0, getWidth(), getHeight());

//        g.setColor(227, 125, 105);
//        g.drawString("eAzY PuZzLe", 65, 10, 0);
//        g.setColor(46, 48, 66);
//        g.fillRoundRect(10, 50, getWidth() - 20, getHeight() - 60, 15, 15);
      
//        drawPuzzle(8, 6, 20, 20, 30, 30, 5, g);
       
        
        if (!isAll) {

            showString(g, getSaltString(4));//ABCDEFGHIJKLMNO
        } else {
            showString(g, "ABCDEFGHIJKLMNO");
        }

    }

    public void commandAction(Command c, Displayable d) {

        if (c == change) {
            System.out.println("changed!");
            isAll = false;
            Midlet.Midlet.display.setCurrent(new Canves_1());
        } else if (c == all) {
            System.out.println("changed all!");
            isAll = true;
            Midlet.Midlet.display.setCurrent(new Canves_1());

        }
    }

    public static String getSaltString(int len) {
        String salt = "ABCDEFGHIJKLMNO";
        String result = "";
        Random rnd = new Random();
        while (result.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * salt.length());
            result += salt.charAt(index);
        }
        return result;

    }

    private void drawPuzzle(int rows, int cols, int x, int y, int width, int height, int gap, Graphics g) {

        int y_ = y;

        for (int i = 1; i <= rows; i++) {
            int x_ = x;
            if (i != 1) {
                y_ += height + gap;
            }
            for (int j = 1; j <= cols; j++) {
                if (j != 1) {
                    x_ += width + gap;//30+20
                }

                if (i % 2 != 0) {
                    if (j % 2 != 0) {

                        g.setColor(0, 0, 0);
                    } else {

                        g.setColor(255, 255, 255);
                    }

                } else if (i % 2 == 0) {

                    if (j % 2 == 0) {

                        g.setColor(0, 0, 0);
                    } else {
                        g.setColor(255, 255, 255);
                    }
                }

                g.fillRect(x_, y_, width, height);

                g.setColor(255, 255, 255);
                g.drawString(j + "", x_, 2, 0);
            }

            g.setColor(255, 255, 255);
            g.drawString(i + "", 2, y_, 0);
        }
    }

    private void showString(Graphics g, String txt) {

        int rows = 25;
        int cols = 18;
        int x = 18;
        int y = 18;
        int width = 10;
        int height = 10;
        int gap = 2;
        int y_ = y;

        for (int i = 1; i <= rows; i++) {
            int x_ = x;
            if (i != 1) {
                y_ += height + gap;
            }
            for (int j = 1; j <= cols; j++) {
                if (j != 1) {
                    x_ += width + gap;//30+20
                }
                g.setColor(70, 67, 61);
                if (txt != "") {

                    char[] c = txt.toCharArray();
                    for (int k = 0; k < c.length; k++) {

                        if (c[k] == 'A') {
                            if ((i == 1 && j == 1) || (i == 1 && j == 2) || (i == 1 && j == 3)
                                    || (i == 2 && j == 1) || (i == 2 && j == 3)
                                    || (i == 3 && j == 1) || (i == 3 && j == 2) || (i == 3 && j == 3)
                                    || (i == 4 && j == 1) || (i == 4 && j == 3)
                                    || (i == 5 && j == 1) || (i == 5 && j == 3)) {

                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'B') {
                            if ((i == 1 && j == 5) || (i == 1 && j == 6) || (i == 1 && j == 7)
                                    || (i == 2 && j == 5) || (i == 2 && j == 7)
                                    || (i == 3 && j == 5) || (i == 3 && j == 6) || (i == 3 && j == 7)
                                    || (i == 4 && j == 5) || (i == 4 && j == 7)
                                    || (i == 5 && j == 5) || (i == 5 && j == 6) || (i == 5 && j == 7)) {

                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'C') {
                            if ((i == 1 && j == 9) || (i == 1 && j == 10) || (i == 1 && j == 11)
                                    || (i == 2 && j == 9)
                                    || (i == 3 && j == 9)
                                    || (i == 4 && j == 9)
                                    || (i == 5 && j == 9) || (i == 5 && j == 10) || (i == 5 && j == 11)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'D') {
                            if ((i == 1 && j == 13) || (i == 1 && j == 14) || (i == 1 && j == 15)
                                    || (i == 2 && j == 13) || (i == 2 && j == 15)
                                    || (i == 3 && j == 13) || (i == 3 && j == 15)
                                    || (i == 4 && j == 13) || (i == 4 && j == 15)
                                    || (i == 5 && j == 13) || (i == 5 && j == 14) || (i == 5 && j == 15)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'E') {
                            if ((i == 7 && j == 1) || (i == 7 && j == 2) || (i == 7 && j == 3)
                                    || (i == 8 && j == 1)
                                    || (i == 9 && j == 1) || (i == 9 && j == 2) || (i == 9 && j == 3)
                                    || (i == 10 && j == 1)
                                    || (i == 11 && j == 1) || (i == 11 && j == 2) || (i == 11 && j == 3)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'F') {
                            if ((i == 7 && j == 5) || (i == 7 && j == 6) || (i == 7 && j == 7)
                                    || (i == 8 && j == 5)
                                    || (i == 9 && j == 5) || (i == 9 && j == 6) || (i == 9 && j == 7)
                                    || (i == 10 && j == 5)
                                    || (i == 11 && j == 5)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'G') {
                            if ((i == 7 && j == 9) || (i == 7 && j == 10) || (i == 7 && j == 11)
                                    || (i == 8 && j == 9)
                                    || (i == 9 && j == 9) || (i == 9 && j == 11)
                                    || (i == 10 && j == 9) || (i == 10 && j == 11)
                                    || (i == 11 && j == 9) || (i == 11 && j == 10) || (i == 11 && j == 11)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'H') {
                            if ((i == 7 && j == 13) || (i == 7 && j == 15)
                                    || (i == 8 && j == 13) || (i == 8 && j == 15)
                                    || (i == 9 && j == 13) || (i == 9 && j == 14) || (i == 9 && j == 15)
                                    || (i == 10 && j == 13) || (i == 10 && j == 15)
                                    || (i == 11 && j == 13) || (i == 11 && j == 15)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'I') {
                            if ((i == 13 && j == 1) || (i == 13 && j == 2) || (i == 13 && j == 3)
                                    || (i == 14 && j == 2)
                                    || (i == 15 && j == 2)
                                    || (i == 16 && j == 2)
                                    || (i == 17 && j == 1) || (i == 17 && j == 2) || (i == 17 && j == 3)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'J') {
                            if ((i == 13 && j == 5) || (i == 13 && j == 6) || (i == 13 && j == 7)
                                    || (i == 14 && j == 6)
                                    || (i == 15 && j == 6)
                                    || (i == 16 && j == 6)
                                    || (i == 17 && j == 5) || (i == 17 && j == 6)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'K') {
                            if ((i == 13 && j == 9) || (i == 13 && j == 11)
                                    || (i == 14 && j == 9) || (i == 14 && j == 10)
                                    || (i == 15 && j == 9)
                                    || (i == 16 && j == 9) || (i == 16 && j == 10)
                                    || (i == 17 && j == 9) || (i == 17 && j == 11)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'L') {
                            if ((i == 13 && j == 13)
                                    || (i == 14 && j == 13)
                                    || (i == 15 && j == 13)
                                    || (i == 16 && j == 13)
                                    || (i == 17 && j == 13) || (i == 17 && j == 14) || (i == 17 && j == 15)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'M') {
                            if ((i == 19 && j == 1) || (i == 19 && j == 2) || (i == 19 && j == 3) || (i == 19 && j == 4) || (i == 19 && j == 5)
                                    || (i == 20 && j == 1) || (i == 20 && j == 3) || (i == 20 && j == 5)
                                    || (i == 21 && j == 1) || (i == 21 && j == 3) || (i == 21 && j == 5)
                                    || (i == 22 && j == 1) || (i == 22 && j == 5)
                                    || (i == 23 && j == 1) || (i == 23 && j == 5)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'N') {
                            if ((i == 19 && j == 7) || (i == 19 && j == 11)
                                    || (i == 20 && j == 7) || (i == 20 && j == 8) || (i == 20 && j == 11)
                                    || (i == 21 && j == 7) || (i == 21 && j == 9) || (i == 21 && j == 11)
                                    || (i == 22 && j == 7) || (i == 22 && j == 10) || (i == 22 && j == 11)
                                    || (i == 23 && j == 7) || (i == 23 && j == 11)) {
                                g.setColor(23, 160, 93);
                            }
                        } else if (c[k] == 'O') {
                            if ((i == 19 && j == 13) || (i == 19 && j == 14) || (i == 19 && j == 15)
                                    || (i == 20 && j == 13) || (i == 20 && j == 15)
                                    || (i == 21 && j == 13) || (i == 21 && j == 15)
                                    || (i == 22 && j == 13) || (i == 22 && j == 15)
                                    || (i == 23 && j == 13) || (i == 23 && j == 14) || (i == 23 && j == 15)) {
                                g.setColor(23, 160, 93);
                            }
                        }
                    }

                }

                g.fillRect(x_, y_, width, height);

                g.setColor(255, 255, 255);
                g.drawString(j + "", x_, 2, 0);
            }

            g.setColor(255, 255, 255);
            g.drawString(i + "", 2, y_, 0);
        }
    }

}
