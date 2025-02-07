package talabattest.route;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import talabat.route.Solution;

class SolutionTest {

    @Test
    void shouldPassWithExample1() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"},
                {"JPN", "CAI"},
                {"BRA", "UAE"},
                {"UAE", "JPN"}
        };
        String expected = "USA, BRA, UAE, JPN, CAI";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample1OneMore() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"},
                {"JPN", "CAI"},
                {"BRA", "UAE"},
                {"UAE", "JPN"},
                {"CAI", "KAT"}
        };
        String expected = "USA, BRA, UAE, JPN, CAI, KAT";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Winnipeg", "Seattle"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2Suffled() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Winnipeg", "Seattle"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithASingleInput() {
        Solution solution = new Solution();
        String[][] itineraries = {
                {"USA", "BRA"}
        };
        String expected = "USA, BRA";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }

    @Test
    void shouldPassWithExample2AddOne() {

        Solution solution = new Solution();
        String[][] itineraries = {
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Winnipeg", "Seattle"},
                {"Seattle", "Boston"}
        };
        String expected = "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle, Boston";
        Assertions.assertEquals(expected, solution.trackRoute(itineraries));
    }
}
