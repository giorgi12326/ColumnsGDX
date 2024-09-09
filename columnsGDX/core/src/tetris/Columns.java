//package tetris;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class Columns {
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Tetris");
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(600, 600));
//
//        frame.add(panel);
//        frame.pack();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        Graphics2D graphics = (Graphics2D) panel.getGraphics();
//
//        Model model = new Model();
//
//        View view = new View();
//        view.gr = graphics;
//
//        Controller controller = new Controller();
//        controller.view = view;
//        controller.model = model;
//
//        model.initModel();
//        view.initView(graphics);
//        model.initMatrixes();
//        model.initMembers();
//        model.createNewFigure();
//
//        model.addListener(controller);
//        view.gr.setColor(Color.black);
//
//        controller.fieldUpdated(model.oldField);
//
//        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
//        timer.scheduleAtFixedRate(model::trySlideDown, 1, 1, TimeUnit.SECONDS);
//
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_LEFT: {
//                        controller.tryMoveLeft();
//                        break;
//                    }
//                    case KeyEvent.VK_RIGHT:
//                        controller.tryMoveRight();
//                        break;
//                    case KeyEvent.VK_UP:
//                        controller.rotateUp();
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        controller.rotateDown();
//                        break;
//                    case KeyEvent.VK_SPACE:
//                        controller.dropFigure();
//                        break;
//
//                    // TODO: HomeWork: move to a separate thread
//                    // case KeyEvent.VK_P:
//                    // case KeyEvent.VK_p:
//                    //     while (!keyPressed) {
//                    //         int oldX3 = model.Fig.x;
//                    //         view.hideFigure(oldX3, oldY);
//                    //         Delay(500);
//                    //         view.drawFigure(model.Fig);
//                    //         Delay(500);
//                    //     }
//                    //     lastTimeFigureMoved = System.currentTimeMillis();
//                    //     break;
//
//                    // TODO: HomeWork
//                    // case KeyEvent.VK_MINUS:
//                    //     if (model.level > 0)
//                    //         model.decreaseLevel();
//                    //     model.removedCellsCounter = 0;
//                    //     view.showLevel(model.level);
//                    //     break;
//                    // case KeyEvent.VK_PLUS:
//                    //     if (model.level < Model.MAX_LEVEL)
//                    //         model.increaseLevel();
//                    //     model.removedCellsCounter = 0;
//                    //     view.showLevel(model.level);
//                    //     break;
//                }
//            }
//        });
//
//
//
//    }
//    // Get graphics context after the panel is visible
//
//    static final int TimeShift = 250;
//    static final int MinTimeShift = 200;
//
//
//
//
////
////    @Override
////    public boolean keyDown(Event e, int k) {
////        processUserActions(e.key);
////        return true;
////    }
//
//
//
//}