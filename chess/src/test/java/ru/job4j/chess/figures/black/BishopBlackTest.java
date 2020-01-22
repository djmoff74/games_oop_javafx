package ru.job4j.chess.figures.black;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;

/**
 * Class BishopBlackTest
 *
 * @author Eduard Lykov (djmoff74@gmail.com)
 * @version 1.0
 * @since 18.01.2020
 */
public class BishopBlackTest {
    private static BishopBlack bishopBlack;
    @BeforeClass
    public static void createStartBishopBlack() {
        bishopBlack = new BishopBlack(Cell.C1);
    }

    @Test
    public void positionCheckStartCell() {
        Assert.assertSame(Cell.C1, bishopBlack.position());
    }

    @Test
    public void copyCheckDestCell() {
        Assert.assertSame(Cell.H7, bishopBlack.copy(Cell.H7).position());
    }

    @Test
    public void wayCheckAvailableCells() {
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.C1, Cell.G5));
    }
    @Test
    public void wayCheckAvailableCellsMoveBack() {
        Cell[] expected = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        Assert.assertArrayEquals(expected, bishopBlack.way(Cell.G5, Cell.C1));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNotCorrectCells() {
        bishopBlack.way(Cell.C1, Cell.C4);
    }
}