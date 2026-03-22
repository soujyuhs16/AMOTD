package cn.mcobs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MOTDStyleFetcherTest {

    private static final String DEFAULT_BASE_URL = "https://motd.mcobs.cn/api/motd/";

    @Test
    public void testBuildApiUrl_withShortStyleCode() {
        String styleCode = "79f078a7";
        String expected = DEFAULT_BASE_URL + styleCode;
        assertEquals(expected, MOTDStyleFetcher.buildApiUrl(styleCode));
    }

    @Test
    public void testBuildApiUrl_withFullHttpUrl() {
        String styleCode = "http://localhost:3000/api/motd/79f078a7";
        assertEquals(styleCode, MOTDStyleFetcher.buildApiUrl(styleCode));
    }

    @Test
    public void testBuildApiUrl_withFullHttpsUrl() {
        String styleCode = "https://example.com/api/motd/abc123";
        assertEquals(styleCode, MOTDStyleFetcher.buildApiUrl(styleCode));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildApiUrl_withNullStyleCode() {
        MOTDStyleFetcher.buildApiUrl(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildApiUrl_withEmptyStyleCode() {
        MOTDStyleFetcher.buildApiUrl("");
    }
}
