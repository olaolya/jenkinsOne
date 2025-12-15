package testproject;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AggregatorTest {

    @Test
    public void testInitialState() {
        Aggregator agr = new Aggregator();
        assertThat(agr.getSum()).isZero();
    }

    @Test
    public void testSingleAddition() {
        Aggregator agr = new Aggregator();
        double val = 20;
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val);
    }

    @Test
    public void testMultipleAdditions() {
        Aggregator agr = new Aggregator();
        double val = 15;
        agr.addValue(val);
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val * 2);
    }

    @Test
    public void testReset() {
        Aggregator agr = new Aggregator();
        agr.addValue(5.0);
        agr.addValue(3.0);
        assertThat(agr.getSum()).isEqualTo(8.0);

        agr.reset();
        assertThat(agr.getSum()).isZero();
    }

    @Test
    public void testResetIdempotent() {
        Aggregator agr = new Aggregator();
        agr.addValue(6.0);
        agr.reset();
        agr.reset();
        assertThat(agr.getSum()).isZero();
    }
}


