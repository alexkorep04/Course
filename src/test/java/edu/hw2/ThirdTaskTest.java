package edu.hw2;

import edu.hw2.third.Connection;
import edu.hw2.third.DefaultConnectionManager;
import edu.hw2.third.FaultyConnection;
import edu.hw2.third.FaultyConnectionManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ThirdTaskTest {
    static DefaultConnectionManager  defaultConnectionManager;
    static FaultyConnectionManager faultyConnectionManager;
    @BeforeAll
    public static void createObjects()
    {
        defaultConnectionManager = new DefaultConnectionManager();
        faultyConnectionManager = new FaultyConnectionManager();
    }

    @Test
    @DisplayName("Check that FaultyConnectionManager can return only faulty connection")
    public void testFaultyConnectionManager()
    {
        var expected = FaultyConnection.class;

        Connection response = faultyConnectionManager.getConnection();

        assertThat(response).isInstanceOf(expected);
    }

    @Test
    @DisplayName("Check that DefaultConnectionManager can return faulty or stable connection")
    public void testDefaultConnectionManager()
    {
        var expected = Connection.class;

        Connection response = defaultConnectionManager.getConnection();

        assertThat(response).isInstanceOf(expected);
    }


}
