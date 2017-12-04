package league.objects;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.*;

public class Team {
    private final String teamName;
    private final Set<Player> players = new HashSet<>();

    public Team(String teamName) {
        this.teamName = checkNotNull(teamName, "Team name is not existing");
    }

    public String getTeamName() {
        return teamName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        checkNotNull(player, "Player doesn't exist");
        checkArgument(!players.contains(player), "This player already plays in this team");

        players.add(player);
    }

    @Override
    public String toString() {
        return teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return teamName != null ? teamName.equals(team.teamName) : team.teamName == null;
    }

    @Override
    public int hashCode() {
        return teamName != null ? teamName.hashCode() : 0;
    }
}
