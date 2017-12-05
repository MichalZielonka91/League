package league.importing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ImportTeamFromFileTest {
    private ImportTeamFromFile testReader = new ImportTeamFromFile();

    @Test
    public void forEmptyFileThrowException() throws Exception {
        ImportTeamFromFile testReader = new ImportTeamFromFile();
        String fileNameTest = "src/test/resources/emptyFile";
        assertThatThrownBy(() -> testReader.importTeam(fileNameTest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("File is empty");
    }

    @Test
    public void forCorrectPlayerThrowException() throws Exception {
        String fileNameTest = "src/test/resources/onlyCorrectPlayer";
        assertThatThrownBy(() -> testReader.importTeam(fileNameTest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("File is wrong, has only team name or player name");
    }

    @Test
    public void forOnlyIncorrectPlayerThrowException() throws Exception {
        String fileNameTest = "src/test/resources/onlyIncorrectPlayer";
        assertThatThrownBy(() -> testReader.importTeam(fileNameTest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("File is wrong, has only team name or player name");
    }

    @Test
    public void forOnlyTeamNameThrowException() throws Exception {
        String fileNameTest = "src/test/resources/onlyTeamName";
        assertThatThrownBy(() -> testReader.importTeam(fileNameTest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("File is wrong, has only team name or player name");
    }

    @Test
    public void forCorrectTeamAndPlayersDoNotThrowException() throws Exception {
        String fileNameTest = "src/test/resources/correctTeamAndPlayer";
        String teamName = testReader.importTeam(fileNameTest).getTeamName();
        String player = testReader.importTeam(fileNameTest).getPlayers().toString();
        assertThat(teamName.equals("Liverpool FC"));
        assertThat(player.equals("Daniel Sturridge"));
    }

    @Test
    public void forCorrectTeamAndIncorrectPlayerNameThrowException() throws Exception {
        String fileNameTest = "src/test/resources/correctTeamNameIncorrectPlayerName";
        assertThatThrownBy(() -> testReader.importTeam(fileNameTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Player format should be: Name Surname");
    }
}