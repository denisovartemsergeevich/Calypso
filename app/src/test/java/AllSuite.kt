import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        graphics.PointTest::class,
        graphics.SizeTest::class,
        graphics.RectTest::class)
class FeatureTestSuite