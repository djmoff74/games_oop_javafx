package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

/**
 * Class LogicTest
 *
 * @author Eduard Lykov (djmoff74@gmail.com)
 * @version 1.0
 * @since 19.01.2020
 */
public class LogicTest {
    private Logic logic;
    private BishopBlack bishopBlack;

    @Before
    public void createStartActions() {
        logic = new Logic();
        bishopBlack = new BishopBlack(Cell.C8);
        logic.add(bishopBlack);
    }

    @Test
    public void whenMoveSuccess() {
        Assert.assertTrue(logic.move(Cell.C8, Cell.H3));
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoveIsBusy() {
        logic.add(new PawnBlack(Cell.D7));
        logic.move(Cell.C8, Cell.H3);
    }
}
