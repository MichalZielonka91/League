package league.importing;

import com.google.common.base.Preconditions;
import league.objects.Player;
import league.objects.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.google.common.base.Preconditions.*;

public class ImportTeamFromFile {

    public Team importTeam(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        checkState(lines.size() > 0, "File is empty");
        checkState(lines.size() > 1, "File is wrong, has only team name or player name");

        Team testTeam = new Team(lines.get(0));

        for (int i = 1; i < lines.size(); i++) {
            String[] stringArray = lines.get(i).split(" ");
            checkArgument(stringArray.length == 2, "Player format should be: Name Surname");
            testTeam.addPlayer(new Player(stringArray[0], stringArray[1], testTeam));

        }
        return testTeam;
    }
}
