import BotPackage.Const;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by C17050 on 12/19/2017.
 */
public class UnitTests {
    @Test
    public void confirmMemeDirectoryExists(){
        Assert.assertTrue("meme directory: " + Const.memeDirectory.getAbsolutePath() + " does not exist. it must be created and populated with meme images.", Const.memeDirectory.exists());
    }

}
