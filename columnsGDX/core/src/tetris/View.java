package tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class View {

    final static public Color[] COLORS = new Color[]{Color.black, Color.cyan, Color.blue, Color.red, Color.green,
            Color.yellow, Color.pink, Color.magenta, Color.white};

    static final int BOX_SIZE = 30;
    static final int ORIGIN = 50;
    SpriteBatch batch = new SpriteBatch();
    BitmapFont font = new BitmapFont();

    private Graphics graphics;

    public View(Graphics graphics) {
        this.graphics = graphics;
    }

    public void drawField(int[][] field) {

        for (int i = 1; i <= Model.Depth; i++) {
            for (int j = 1; j <= Model.Width; j++) {
                drawBox(j, i, field[j][i]);
            }
        }
    }
    public void drawFigure(Figure f) {
        if (f == null) return;
        int[] c = f.getCells();
        drawBox(f.x, f.y, c[0]);
        drawBox(f.x, f.y + 1, c[1]);
        drawBox(f.x, f.y + 2, c[2]);
    }

    private void hideFigure(int x, int y) {
        drawBox(x, y, 0);
        drawBox(x, y + 1, 0);
        drawBox(x, y + 2, 0);
    }

    public void showHelp() {
//        batch.begin();
//        font.draw(batch, "Keys available:", 200 - LeftBorder, 102);
//        font.draw(batch, "Roll Box Up:", 200 - LeftBorder, 118);
//        font.draw(batch, "Roll Box Down:", 200 - LeftBorder, 128);
//        font.draw(batch, "Figure Left:", 200 - LeftBorder, 138);
//        font.draw(batch, "Figure Right:", 200 - LeftBorder, 148);
//        font.draw(batch, "Level High/Low: +/-", 200 - LeftBorder, 158);
//        font.draw(batch, "Drop Figure: space", 200 - LeftBorder, 168);
//        font.draw(batch, "Pause: P", 200 - LeftBorder, 180);
//        font.draw(batch, "Quit: Esc or Q", 200 - LeftBorder, 190);
//        batch.end();
    }

    public void showLevel(int level) {
        System.out.println("asd21");
        batch.begin();
        font.setColor(com.badlogic.gdx.graphics.Color.RED);
        font.draw(batch, "Level: " + level,  100, 400);
        batch.end();
    }

    public void showScore(int score) {
        batch = new SpriteBatch();


        font.setColor(com.badlogic.gdx.graphics.Color.RED);
        batch.begin();

        font.draw(batch, "Score: " + score, 50, 40);
        batch.end();

    }
    public void dispose() {
        batch.dispose();
        font.dispose();
    }



    public void moveAndDrawFigure(Figure fig, int oldX, int oldY) {
        hideFigure(oldX, oldY);
        drawFigure(fig);
    }

    public void highlightNeighbours(int a, int b, int c, int d, int i, int j) {
        System.out.println("highlight");
        drawBox(a, b, 8);
        drawBox(j, i, 8);
        drawBox(c, d, 8);

        //qen
    }

    public void draw(Model model) {
        drawField(model.newField);
        drawFigure(model.Fig);
        showScore(model.Score);

    }

    public void drawBox(int row, int col, int value) {
        graphics.drawBoxAt(ORIGIN + row * BOX_SIZE, ORIGIN + col * BOX_SIZE, BOX_SIZE, value);

    }




}