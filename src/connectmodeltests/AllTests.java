package connectmodeltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGameBoard1x1.class, TestGameBoard2x2.class, TestGameBoard6x7.class, TestGameEngine.class,
		TestPlayer.class })
public class AllTests {

}
