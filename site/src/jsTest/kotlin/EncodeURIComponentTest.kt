import net.freshplatform.alrayada_web.js.encodeURIComponent
import kotlin.test.Test
import kotlin.test.assertEquals

class EncodeURIComponentTest {
    @Test
    fun encodesSpacesAsPercent20() {
        assertEquals(
            expected = "Hello%20World",
            actual = encodeURIComponent("Hello World"),
        )
    }
    @Test
    fun encodesSpecialCharactersCorrectly() {
        assertEquals(
            expected = "a%2Fb%3Fc%3Dd%26e%3Df",
            actual = encodeURIComponent("a/b?c=d&e=f"),
        )
    }
}
