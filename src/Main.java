import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        boardGames();
    }

    private static void boardGames(){
        List<BoardGame> games = Arrays.asList(
                new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
                new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
                new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
                new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
                new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
                new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
                new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
                new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
                new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
                new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
        );

        // Podaj gry, które mają ocenę powyżej 8 i mogą w nią grać  3 osoby
        List<BoardGame> results = new ArrayList<>();
        for(BoardGame g: games){
            if(g.getRating() > 8.0 && g.getMaxPlayers() >= 3 && g.getMinPlayers() <= 3){
                results.add(g);
            }
        }
        System.out.println(results);

        Stream<BoardGame> gameStream = games.stream();
        List<BoardGame> result = gameStream.filter(g -> g.getRating() > 8.0)
                .filter(g -> g.getMaxPlayers() >= 3).filter(g -> g.getMinPlayers() <= 3)
                .toList();
        System.out.println(result);

        // gra dla 5 osób z oceną większą niż 8 i ceną mniejszą niż 200




    }
}