import java.math.BigDecimal;

public class BoardGame {
    private final String name;
    private final double rating;
    private final BigDecimal price;
    private final int minPlayers;
    private final int maxPlayers;

    public BoardGame(String name, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                '}';
    }
}
