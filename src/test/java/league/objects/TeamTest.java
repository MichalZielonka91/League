package league.objects;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class TeamTest {
    private Team liverpool = new Team("Liverpool");
    private Player carragher = new Player("Jamie", "Carragher", liverpool);
    private Player gerrard = new Player("Steven", "Gerrard", liverpool);


    @Test
    public void forNullTeamNameThrowException() throws Exception {
        assertThatThrownBy(() -> new Team(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forNotNullTeamNameDontThrowException() throws Exception {
        new Team("");
    }

    @Test
    public void ifAddedPlayerIsNullThrowException() throws Exception {
        Team testTeam = new Team("Test Team");
        assertThatThrownBy(() -> testTeam.addPlayer(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void forTheSameAddingPlayersThrowException() throws Exception {
        liverpool.addPlayer(carragher);
        assertThatThrownBy(() -> liverpool.addPlayer(carragher)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isAddingPlayer() throws Exception {
        liverpool.addPlayer(gerrard);
        assertThat(liverpool.getPlayers()).contains(gerrard);
    }

    @Test
    public void isAddingTwoPlayers() throws Exception {
        liverpool.addPlayer(gerrard);
        liverpool.addPlayer(carragher);
        assertThat(liverpool.getPlayers()).contains(gerrard, carragher);
    }
}