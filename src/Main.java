import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       // boardGames();
       // customers();
       // lazy();
        files();

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
        games.stream().filter(g -> g.getRating() > 8)
                .filter(g -> g.getPrice().compareTo(new BigDecimal("200"))<0)
                .map(g -> g.getName()).forEach(System.out::println);

        // gra o najwyżeszej ocenie zawierająca literę a
        BoardGame boardGame = games.stream().filter(g ->g.getName().contains("a"))
                .max(Comparator.comparingDouble(g -> g.getRating())).get();
        System.out.println(boardGame);





    }

    private static void customers(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jan", "Kowalski", "Wrocław", 1970));
        customers.add(new Customer("Jan", "Nowak", "Poznan", 1980));
        customers.add(new Customer("Mateusz", "Lipnicki", "Wrocław", 1985));
        customers.add(new Customer("Anna", "Jankowska", "Warszawa", 1973));

        //Pobrać wszystkich klientów z Wrocławia i wyświetlić ich imiona i nazwiska dużymi literami

        //Klienci według miejscowości (grupowanie)
        Map<String, List<Customer>> customersByCity =
                customers.stream().collect(Collectors.groupingBy(c->c.getCity()));


        System.out.println(customersByCity);


    }

    private static void lazy(){
        IntStream numbersStream = IntStream.range(0, 8);
        System.out.println("Przed");
        numbersStream = numbersStream.filter(n -> n % 2 == 0);
        System.out.println("W trakcie 1");
        numbersStream = numbersStream.map(n -> {
            System.out.println("> " + n);
            return n;
        });
        System.out.println("W trakcie 2");
        numbersStream = numbersStream.limit(2);
        System.out.println("W trakcie 3");
        numbersStream.forEach(System.out::println);
        System.out.println("Po");
    }

    private static void files(){
        try(Stream<Path> paths = Files.walk(Paths.get("./pliki"))){
            List<String> files = paths.map(p ->p.toString())
                    .filter(p -> p.endsWith(".pdf"))
                    .collect(Collectors.toList());
            System.out.println(files);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}