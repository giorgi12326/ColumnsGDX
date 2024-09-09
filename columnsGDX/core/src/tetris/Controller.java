package tetris;

public class Controller implements ModelListener {

    public View view;
    Model model;
    public void tryMoveLeft(){
        model.tryMoveLeft();
    }
    public void tryMoveRight(){
        model.tryMoveRight();
    }
    public void rotateUp(){
        model.rotateUp();
    }
    public void rotateDown(){
        model.rotateDown();
    }
    public void dropFigure(){
        model.dropFigure(model.Fig);
    }
    public void trySlideDown(){
        model.trySlideDown();
    }
    public Controller(Model model, View view) {
        this.model = model;
        model.addListener(this);
        this.view = view;
    }
    @Override
    public void foundNeighboursAt(int a, int b, int c, int d, int i, int j) {

        view.highlightNeighbours(a, b, c, d, i, j);
    }

    @Override
    public void figureMovedFrom(int oldX, int oldY) {
        view.moveAndDrawFigure(model.Fig, oldX, oldY);
    }

    @Override
    public void figureUpdated(Figure fig) {
        view.drawFigure(fig);
    }

    @Override
    public void gameOver() {

        return;

    }

    @Override
    public void fieldUpdated(int[][] newField) {
        view.drawField(newField);
    }

    @Override
    public void scoreHasChanged(int score) {
        System.out.println("123456789");
        view.showScore(score);
    }

    @Override
    public void levelHasChanged(int level) {
        view.showLevel(level);
    }

}
