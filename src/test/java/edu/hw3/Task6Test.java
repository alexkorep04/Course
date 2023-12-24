package edu.hw3;

import edu.hw3.task6.Market;
import edu.hw3.task6.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task6Test {
    Market market;
    @BeforeEach
    public void createObject()
    {
        market = new Market();
    }
    @Test
    @DisplayName("Test the most valuable stock")
    public void testValuableStock()
    {
        market.add(new Stock("Sberbank", 265));
        market.add(new Stock("NorNikel", 15000));
        market.add(new Stock("Gazprom", 300));
        market.add(new Stock("Lukoil", 5000));

        Stock expected = new Stock("NorNikel", 15000);

        Stock response = market.mostValuableStock();

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test the most valuable stock after remove")
    public void testRemoveAndValuableStock()
    {
        market.add(new Stock("Sberbank", 265));
        market.add(new Stock("NorNikel", 15000));
        market.add(new Stock("Gazprom", 300));
        market.add(new Stock("Lukoil", 5000));
        market.remove(new Stock("NorNikel", 15000));
        market.remove(new Stock("Gazprom", 300));
        Stock expected = new Stock("Lukoil", 5000);

        Stock response = market.mostValuableStock();

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test the most valuable stock on market where only 1 stock")
    public void testValuableStockWhereOnlyOneStock()
    {
        market.add(new Stock("Sberbank", 265));

        Stock expected = new Stock("Sberbank", 265);

        Stock response = market.mostValuableStock();

        assertThat(response).isEqualTo(expected);
    }
}
