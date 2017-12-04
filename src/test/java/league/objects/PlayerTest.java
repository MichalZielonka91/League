package league.objects;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void forNullNameThrowException() throws Exception {
        assertThatThrownBy(() -> new Player(null, "", null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forNullSurnameThrowException() throws Exception {
        assertThatThrownBy(() -> new Player("", null, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forNullTeamThrowException() throws Exception {
        assertThatThrownBy(() -> new Player("", "", null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forExistingParametersDoNotThrowException() throws Exception {
        new Player("", "", new Team(""));
    }
}