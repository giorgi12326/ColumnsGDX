//package tetris;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class ModelTest {
//    public Model model;
//
//    @BeforeEach
//    void setUp() {
//        model = new Model();
//    }
//
//    @Test
//    void testInitialModelState() {
//        assertEquals(0, model.level);
//        assertEquals(0, model.Score);
//        assertEquals(0, model.removedCellsCounter);
//        assertNotNull(model.Fig);
//        assertNotNull(model.newField);
//        assertNotNull(model.oldField);
//    }
//
//    @Test
//    void testDropFigureUpdatesField() {
//        Figure fig = model.Fig;
//        fig.y = 5; // Set y position to 5
//        model.dropFigure(fig);
//
//        assertEquals(Model.Depth - 2, fig.y);
//    }
//
//    @Test
//    void testTrySlideDownSlidesFigure() {
//        Figure fig = model.Fig;
//        fig.y = 1;
//        model.trySlideDown();
//
//        assertEquals(2, fig.y);
//    }
//
//    @Test
//    void testRemoveSimilarNeighboringCells() {
//        model.newField[1][1] = 1;
//        model.newField[1][2] = 1;
//        model.newField[1][3] = 1;
//
//        model.removeSimilarNeighboringCells();
//
//        assertEquals(0, model.newField[1][1]);
//        assertEquals(0, model.newField[1][2]);
//        assertEquals(0, model.newField[1][3]);
//
//        assertTrue(model.Score > 0);
//    }
//
//    @Test
//    void testCheckIfFieldIsFullGameOver() {
//        for (int i = 1; i <= Model.Width; i++) {
//            model.newField[i][3] = 1;
//        }
//
//        model.checkIfFieldIsFull();
//
//        assertNotNull(model.Fig);
//    }
//
//    @Test
//    void testIncreaseLevel() {
//        model.increaseLevel();
//        assertEquals(1, model.level);
//    }
//
//    @Test
//    void testDecreaseLevel() {
//        model.increaseLevel();
//        model.descreaseLevel();
//        assertEquals(0, model.level);
//    }
//
//
//
//}
