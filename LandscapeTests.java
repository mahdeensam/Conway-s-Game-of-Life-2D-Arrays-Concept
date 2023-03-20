/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */


import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
            assert l1.getRows() == 2 : "Error in Landscape::getRows()";
            assert l1.getCols() == 4 : "Error in Landscape::getCols()";
            assert l2.getRows() == 10 : "Error in Landscape::getRows()";
            assert l2.getCols() == 10 : "Error in Landscape::getCols()";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.3);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            l1.reset();
            l2.reset();
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);
        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify

            // test
            assert l1.getRows() == 2 : "Error in Landscape::getRows()";
            assert l2.getRows() == 10 : "Error in Landscape::getRows()";
        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify

            // test
            assert l1.getCols() == 4 : "Error in Landscape::getCols()";
            assert l2.getCols() == 10 : "Error in Landscape::getCols()";
        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.3);

            // verify

            // test
            for (int i = 0; i < l1.getRows(); i++) {
                for (int j = 0; j < l1.getCols(); j++) {
                    assert l1.getCell(i, j) != null : "Error in Landscape::getCell(int, int)";
                }
            }
            for (int i = 0; i < l2.getRows(); i++) {
                for (int j = 0; j < l2.getCols(); j++) {
                    assert l2.getCell(i, j) != null : "Error in Landscape::getCell(int, int)";
                }
            }
        }

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l1 = new Landscape(3, 3, 0.5);

            // verify

            // test
            ArrayList<Cell> neighbors00 = l1.getNeighbors(0, 0);
            ArrayList<Cell> neighbors11 = l1.getNeighbors(1, 1);
            ArrayList<Cell> neighbors22 = l1.getNeighbors(2, 2);

            assert neighbors00.size() == 3 : "Error in Landscape::getNeighbors()";
            assert neighbors11.size() == 8 : "Error in Landscape::getNeighbors()";
            assert neighbors22.size() == 3 : "Error in Landscape::getNeighbors()";
        }

        // case 7: testing advance()
        {
            // set up
            Landscape l1 = new Landscape(3, 3, 0.0);
            l1.getCell(1, 0).setAlive(true);
            l1.getCell(1, 1).setAlive(true);
            l1.getCell(1, 2).setAlive(true);

            // verify
            System.out.println(l1);
            l1.advance();
            System.out.println(l1);

            // test
            assert l1.getCell(0, 1).getAlive() == true : "Error in Landscape::advance()";
            assert l1.getCell(1, 1).getAlive() == true : "Error in Landscape::advance()";
            assert l1.getCell(2, 1).getAlive() == true : "Error in Landscape::advance()";
        }

    }

    public static void main(String[] args) {
        landscapeTests();
    }
}